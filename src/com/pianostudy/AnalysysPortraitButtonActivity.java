package com.pianostudy;

import java.util.ArrayList;

import com.pianostudy.info.TestType;
import com.pianostudy.listener.ProtraitButtonOnTouchListener;
import com.pianostudy.manager.MidiBaseManager;
import com.pianostudy.thread.PlayerThread;
import com.pianostudy.util.MidiCreateUtil;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * ����ҳ����ʾ�ļ���
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-10 ����1:13:47
 */
public class AnalysysPortraitButtonActivity extends Activity implements
		OnClickListener {

	/**
	 * ʮ�����׼�
	 */
	private CheckBox w9, w10, w11, w12, w13, w14, w15, w16;
	/**
	 * ʮ���ڼ�
	 */
	private CheckBox b6, b7, b8, b9, b10;
	/**
	 * ���еĸ��ټ�
	 */
	public ArrayList<CheckBox> allCheckBoxList;
	/**
	 * ��һ�ȼ�
	 */
	private Button lastLevelButton;
	/**
	 * ��һ�ؿ�
	 */
	private Button lastItemButton;
	/**
	 * ��һ�ȼ�
	 */
	private Button nextLevelButton;
	/**
	 * ��һ�ؿ�
	 */
	private Button nextItemButton;
	/**
	 * ȷ�ϰ�ť
	 */
	private Button okButton;
	/**
	 * play��ť
	 */
	private Button playButton;
	/**
	 * ��ʾ��Ϣ��TextView
	 */
	private TextView tv_reminder;
	/**
	 * ��ǰ�ȼ��ؿ���Ϣ��TextView
	 */
	private TextView tv_itemInfo;

	/**
	 * ���ڴ�ӡlog
	 */
	private String tag = "PortraitButtonActivity";

	/**
	 * �Ƿ���playģʽ
	 */
	private boolean isPlay;
	/**
	 * ���ģʽ
	 */
	private int itemMode;
	/**
	 * �������
	 */
	private int itemType;
	/**
	 * ��Ŀ������
	 */
	public MidiBaseManager midiBaseManager;

	/**
	 * �¿��߳����ڲ���
	 */
	private PlayerThread playerThread;
	private Button button_note_name;
	private ArrayList<CheckBox> cbList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_analysysportraitbutton);
		cbList = new ArrayList<CheckBox>();
		initData();
		initView();
		resetKey();
		initEvent();
		initButtonEvent();
		initText();
		playerThread = new PlayerThread(this, itemMode, itemType);
	}

	/**
	 * ʵ�������еĸ��ټ�
	 */
	private void initView() {
		button_note_name = (Button) findViewById(R.id.button_note_name);
		b6 = (CheckBox) findViewById(R.id.b6);
		b7 = (CheckBox) findViewById(R.id.b7);
		b8 = (CheckBox) findViewById(R.id.b8);
		b9 = (CheckBox) findViewById(R.id.b9);
		b10 = (CheckBox) findViewById(R.id.b10);
		w9 = (CheckBox) findViewById(R.id.w9);
		w10 = (CheckBox) findViewById(R.id.w10);
		w11 = (CheckBox) findViewById(R.id.w11);
		w12 = (CheckBox) findViewById(R.id.w12);
		w13 = (CheckBox) findViewById(R.id.w13);
		w14 = (CheckBox) findViewById(R.id.w14);
		w15 = (CheckBox) findViewById(R.id.w15);
		w16 = (CheckBox) findViewById(R.id.w16);

		// ������ֵ��С�����ټ������allCheckBoxList����֮��
		allCheckBoxList = new ArrayList<CheckBox>();
		allCheckBoxList.add(w9);
		allCheckBoxList.add(b6);
		allCheckBoxList.add(w10);
		allCheckBoxList.add(b7);
		allCheckBoxList.add(w11);
		allCheckBoxList.add(b8);
		allCheckBoxList.add(w12);

		allCheckBoxList.add(w13);
		allCheckBoxList.add(b9);
		allCheckBoxList.add(w14);
		allCheckBoxList.add(b10);
		allCheckBoxList.add(w15);
		allCheckBoxList.add(w16);

		tv_itemInfo = (TextView) findViewById(R.id.tv_item_info);
		tv_reminder = (TextView) findViewById(R.id.tv_reminder);
		playButton = (Button) findViewById(R.id.play);
		okButton = (Button) findViewById(R.id.ok);
		nextItemButton = (Button) findViewById(R.id.next_item);
		nextLevelButton = (Button) findViewById(R.id.next_level);
		lastItemButton = (Button) findViewById(R.id.last_item);
		lastLevelButton = (Button) findViewById(R.id.last_level);

	}

	/**
	 * ���õ�ǰ����Ŀ����
	 */
	private void initData() {
		itemType = getIntent().getIntExtra("itemType", 0);
		itemMode = TestType.ITEM_MODE_ANALYSY;
		// midiBaseManager = new MidiBaseManager();
		// midiBaseManager.init(itemMode, itemType, 0, 0);
		// Log.d(tag, "itemMode"+itemMode + "itemType:"+itemType);

	}

	/**
	 * ��ʼ�����ټ���ѡ���¼� ���������ѡ��仯�¼�
	 */
	public void initEvent() {

		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setOnCheckedChangeListener(
					new ProtraitButtonOnTouchListener(this, i,cbList));
		}
		
	}

	/**
	 * ��������Ĳ˵��ť�ĵ���¼�
	 */
	public void initButtonEvent() {
		playButton.setOnClickListener(this);
		okButton.setOnClickListener(this);
		nextItemButton.setOnClickListener(this);
		nextLevelButton.setOnClickListener(this);
		lastItemButton.setOnClickListener(this);
		lastLevelButton.setOnClickListener(this);
		button_note_name.setOnClickListener(this);
	}

	/**
	 * ���ø��ټ�������
	 */
	private void initText() {

		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setText(MidiCreateUtil.notename[i]);
			allCheckBoxList.get(i).setTextSize(10);
		}
		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setTextColor(Color.TRANSPARENT);
		}
	}

	private boolean isShowName = false;

	/**
	 * �ı��ı�
	 */
	private void changeText() {
		if (isShowName) {
			isShowName = false;
			for (int i = 0; i < allCheckBoxList.size(); i++) {
				allCheckBoxList.get(i).setTextColor(Color.TRANSPARENT);
			}
		} else {
			isShowName = true;
			for (int i = 0; i < allCheckBoxList.size(); i++) {
				allCheckBoxList.get(i).setTextColor(Color.BLACK);
			}
		}
	}

	@Override
	/**
	 * ʵ��OnClickListener�е�onClick()����
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			Log.d(tag, "play");
			playEvent();
			break;
		case R.id.ok:
			okevent();
			Log.d(tag, "ok");
			break;
		case R.id.next_item:
			moveevent(1);
			Log.d(tag, "next_item");
			break;
		case R.id.next_level:
			moveevent(2);
			Log.d(tag, "next_level");
			break;
		case R.id.last_item:
			moveevent(-1);
			Log.d(tag, "last_item");
			break;
		case R.id.last_level:
			moveevent(-2);
			Log.d(tag, "last_level");
			break;
		case R.id.button_note_name:
			changeText();
			Log.d(tag, "button_note_name");
			break;
		default:
			break;
		}
	}

	/**
	 * ���play��Ӧ���¼�
	 */
	private void playEvent() {
		isPlay = true;
		resetKey();
		initEvent();
		String s = playerThread.play();
		tv_reminder.setText("�������������'Ok'��������" + s);
	}

	/**
	 * ���4���ƶ�����������¼�
	 * 
	 * @param dir
	 */
	public void moveevent(int dir) {
		String str;
		resetKey();
		initEvent();
		// play.setText("Play");
		tv_reminder.setText("����'Play������'������");
		isPlay = false;
		str = playerThread.setnext(dir);
		tv_itemInfo.setText(str);
	}

	/**
	 * �������а���
	 */
	public void resetKey() {
		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setOnCheckedChangeListener(null);
			allCheckBoxList.get(i).setChecked(false);
		}
		cbList.clear();
	}
	
	/**
	 * ���ok����Ӧ���¼�
	 */
	public void okevent() {
		String str;
		if (!isPlay) {
		} else {
			//boolean r = playerThread.okAna(cbList);
			boolean r = playerThread.ok(cbList);
			resetKey();
			initEvent();
			// �����жϣ������ȷ��������һ��
			if (r) {
				tv_reminder.setText("��ϲ�㣬�����:����'Play������'������");
				isPlay = false;// ���ò���playģʽ
				str = playerThread.setnext(1);// ��һ�⣬������
				tv_itemInfo.setText(str);
			} else {
				isPlay = true;
				tv_reminder.setText("������˼�������:�������������ȷ�ϼ�������");
			}
		}
	}
}
