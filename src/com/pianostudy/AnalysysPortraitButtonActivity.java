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
 * 分析页面显示的键盘
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-10 上午1:13:47
 */
public class AnalysysPortraitButtonActivity extends Activity implements
		OnClickListener {

	/**
	 * 十六个白键
	 */
	private CheckBox w9, w10, w11, w12, w13, w14, w15, w16;
	/**
	 * 十个黑键
	 */
	private CheckBox b6, b7, b8, b9, b10;
	/**
	 * 所有的钢琴键
	 */
	public ArrayList<CheckBox> allCheckBoxList;
	/**
	 * 上一等级
	 */
	private Button lastLevelButton;
	/**
	 * 上一关卡
	 */
	private Button lastItemButton;
	/**
	 * 下一等级
	 */
	private Button nextLevelButton;
	/**
	 * 下一关卡
	 */
	private Button nextItemButton;
	/**
	 * 确认按钮
	 */
	private Button okButton;
	/**
	 * play按钮
	 */
	private Button playButton;
	/**
	 * 提示信息，TextView
	 */
	private TextView tv_reminder;
	/**
	 * 当前等级关卡信息，TextView
	 */
	private TextView tv_itemInfo;

	/**
	 * 用于打印log
	 */
	private String tag = "PortraitButtonActivity";

	/**
	 * 是否是play模式
	 */
	private boolean isPlay;
	/**
	 * 玩的模式
	 */
	private int itemMode;
	/**
	 * 玩的类型
	 */
	private int itemType;
	/**
	 * 题目管理类
	 */
	public MidiBaseManager midiBaseManager;

	/**
	 * 新开线程用于播放
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
	 * 实例化所有的钢琴键
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

		// 按音符值大小将钢琴键添加至allCheckBoxList数组之中
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
	 * 设置当前的题目数据
	 */
	private void initData() {
		itemType = getIntent().getIntExtra("itemType", 0);
		itemMode = TestType.ITEM_MODE_ANALYSY;
		// midiBaseManager = new MidiBaseManager();
		// midiBaseManager.init(itemMode, itemType, 0, 0);
		// Log.d(tag, "itemMode"+itemMode + "itemType:"+itemType);

	}

	/**
	 * 初始化钢琴键的选择事件 给他们添加选择变化事件
	 */
	public void initEvent() {

		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setOnCheckedChangeListener(
					new ProtraitButtonOnTouchListener(this, i,cbList));
		}
		
	}

	/**
	 * 设置下面的菜单项按钮的点击事件
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
	 * 设置钢琴键的名字
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
	 * 改变文本
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
	 * 实现OnClickListener中的onClick()方法
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
	 * 点击play响应的事件
	 */
	private void playEvent() {
		isPlay = true;
		resetKey();
		initEvent();
		String s = playerThread.play();
		tv_reminder.setText("请点击音符键后点'Ok'键！！！" + s);
	}

	/**
	 * 点击4个移动键各代表的事件
	 * 
	 * @param dir
	 */
	public void moveevent(int dir) {
		String str;
		resetKey();
		initEvent();
		// play.setText("Play");
		tv_reminder.setText("请点击'Play键听音'！！！");
		isPlay = false;
		str = playerThread.setnext(dir);
		tv_itemInfo.setText(str);
	}

	/**
	 * 重置所有按键
	 */
	public void resetKey() {
		for (int i = 0; i < allCheckBoxList.size(); i++) {
			allCheckBoxList.get(i).setOnCheckedChangeListener(null);
			allCheckBoxList.get(i).setChecked(false);
		}
		cbList.clear();
	}
	
	/**
	 * 点击ok键响应的事件
	 */
	public void okevent() {
		String str;
		if (!isPlay) {
		} else {
			//boolean r = playerThread.okAna(cbList);
			boolean r = playerThread.ok(cbList);
			resetKey();
			initEvent();
			// 进行判断，如果正确，进行下一题
			if (r) {
				tv_reminder.setText("恭喜你，答对了:请点击'Play键听音'！！！");
				isPlay = false;// 设置不是play模式
				str = playerThread.setnext(1);// 下一题，并返回
				tv_itemInfo.setText(str);
			} else {
				isPlay = true;
				tv_reminder.setText("不好意思，答错了:请点击音符键后点确认键！！！");
			}
		}
	}
}
