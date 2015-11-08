package com.pianostudy;

import java.util.ArrayList;

import com.pianostudy.listener.ProtraitButtonOnTouchListener;
import com.pianostudy.thread.PlayerThread;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * ���ټ����ŵĽ���
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-7 ����10:22:03
 */
public class PortraitButtonActivity extends Activity implements OnClickListener {

	/**
	 * ʮ�����׼�
	 */
	private CheckBox w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13,
			w14, w15, w16;
	/**
	 * ʮ���ڼ�
	 */
	private CheckBox b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
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

	private PlayerThread playerThread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_portraitbutton);
		playerThread = new PlayerThread(this);
		initView();
		resetKey();
		initEvent();
		initButtonEvent();
	}

	/**
	 * ��ʼ������ ʵ���������checkBox
	 */
	public void initView() {
		allCheckBoxList = new ArrayList<CheckBox>();
		w1 = (CheckBox) findViewById(R.id.w1);
		w2 = (CheckBox) findViewById(R.id.w2);
		w3 = (CheckBox) findViewById(R.id.w3);
		w4 = (CheckBox) findViewById(R.id.w4);
		w5 = (CheckBox) findViewById(R.id.w5);
		w6 = (CheckBox) findViewById(R.id.w6);
		w7 = (CheckBox) findViewById(R.id.w7);
		w8 = (CheckBox) findViewById(R.id.w8);
		w9 = (CheckBox) findViewById(R.id.w9);
		w10 = (CheckBox) findViewById(R.id.w10);
		w11 = (CheckBox) findViewById(R.id.w11);
		w12 = (CheckBox) findViewById(R.id.w12);
		w13 = (CheckBox) findViewById(R.id.w13);
		w14 = (CheckBox) findViewById(R.id.w14);
		w15 = (CheckBox) findViewById(R.id.w15);
		w16 = (CheckBox) findViewById(R.id.w16);
		b1 = (CheckBox) findViewById(R.id.b1);
		b2 = (CheckBox) findViewById(R.id.b2);
		b3 = (CheckBox) findViewById(R.id.b3);
		b4 = (CheckBox) findViewById(R.id.b4);
		b5 = (CheckBox) findViewById(R.id.b5);
		b6 = (CheckBox) findViewById(R.id.b6);
		b7 = (CheckBox) findViewById(R.id.b7);
		b8 = (CheckBox) findViewById(R.id.b8);
		b9 = (CheckBox) findViewById(R.id.b9);
		b10 = (CheckBox) findViewById(R.id.b10);
		// ������ֵ��С�����ټ������allCheckBoxList����֮��
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

		// allCheckBoxList.add(w1);����һ�����Ͳ�����������
		allCheckBoxList.add(b1);
		allCheckBoxList.add(w2);
		allCheckBoxList.add(b2);
		allCheckBoxList.add(w3);
		allCheckBoxList.add(b3);
		allCheckBoxList.add(w4);

		allCheckBoxList.add(w5);
		allCheckBoxList.add(b4);
		allCheckBoxList.add(w6);
		allCheckBoxList.add(b5);
		allCheckBoxList.add(w7);
		allCheckBoxList.add(w8);

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
	 * ��ʼ�����ټ���ѡ���¼�
	 * ���������ѡ��仯�¼�
	 */
	public void initEvent() {
		// ���ü��ĵ���¼�
		w1.setOnCheckedChangeListener(new ProtraitButtonOnTouchListener(this,
				12));
		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setOnCheckedChangeListener(
					new ProtraitButtonOnTouchListener(this, i));
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
			Log.d(tag, "ok");
			break;
		case R.id.next_item:
			Log.d(tag, "next_item");
			break;
		case R.id.next_level:
			Log.d(tag, "next_level");
			break;
		case R.id.last_item:
			Log.d(tag, "last_item");
			break;
		case R.id.last_level:
			Log.d(tag, "last_level");
			break;
		default:
			break;
		}
	}

	/**
	 * �������а���
	 */
	public void resetKey() {
		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setOnCheckedChangeListener(null);
			allCheckBoxList.get(i).setChecked(false);
		}
	}

	/**
	 * ���play��Ӧ���¼�
	 */
	private void playEvent() {
		resetKey();
		initEvent();
		playerThread.play();
		tv_reminder.setText("�������������'Ok'��������");
	}

	/**
	 * һЩ��ʱû���õ���Ϣ
	 */
	private void unless() {
		/**
		 * ���ڴ�ŵ�����ɫcheckBox������
		 */
		ArrayList<CheckBox> lowBlackCheckBoxList;
		/**
		 * ���ڴ�ŵ�����ɫcheckBox������
		 */
		ArrayList<CheckBox> lowWhiteCheckBoxList;
		/**
		 * ���ڴ�Ÿ�����ɫcheckBox������
		 */
		ArrayList<CheckBox> highBlackCheckBoxList;
		/**
		 * ���ڴ�Ÿ�����ɫcheckBox������
		 */
		ArrayList<CheckBox> highWhiteCheckBoxList;
		lowBlackCheckBoxList = new ArrayList<CheckBox>();
		lowWhiteCheckBoxList = new ArrayList<CheckBox>();
		highBlackCheckBoxList = new ArrayList<CheckBox>();
		highWhiteCheckBoxList = new ArrayList<CheckBox>();
		highBlackCheckBoxList.add(b1);
		highBlackCheckBoxList.add(b2);
		highBlackCheckBoxList.add(b3);
		highBlackCheckBoxList.add(b4);
		highBlackCheckBoxList.add(b5);

		lowBlackCheckBoxList.add(b6);
		lowBlackCheckBoxList.add(b7);
		lowBlackCheckBoxList.add(b8);
		lowBlackCheckBoxList.add(b9);
		lowBlackCheckBoxList.add(b10);

		highWhiteCheckBoxList.add(w1);
		highWhiteCheckBoxList.add(w2);
		highWhiteCheckBoxList.add(w3);
		highWhiteCheckBoxList.add(w4);
		highWhiteCheckBoxList.add(w5);
		highWhiteCheckBoxList.add(w6);
		highWhiteCheckBoxList.add(w7);
		highWhiteCheckBoxList.add(w8);

		lowWhiteCheckBoxList.add(w9);
		lowWhiteCheckBoxList.add(w10);
		lowWhiteCheckBoxList.add(w11);
		lowWhiteCheckBoxList.add(w12);
		lowWhiteCheckBoxList.add(w13);
		lowWhiteCheckBoxList.add(w14);
		lowWhiteCheckBoxList.add(w15);
		lowWhiteCheckBoxList.add(w16);

	}

}
