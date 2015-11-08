package com.pianostudy.thread;

import android.content.Context;
import android.util.Log;

import com.pianostudy.info.ItemInfo;
import com.pianostudy.manager.MidiBaseManager;
import com.pianostudy.util.MidiCreateUtil;
import com.pianostudy.util.MidiPlayer;

/**
 * 一个新的线程，控制播放
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-8 下午3:49:37
 */
public class PlayerThread extends Thread {
	public MidiBaseManager midiBaseManager = new MidiBaseManager();
	// 构造方法
	Context context;
	public PlayerThread(Context context) {
		this.context = context;
		this.start();
	}

	/**
	 * 用flag控制是否播放
	 */
	boolean flag = false;
	/**
	 * 用于调试打印
	 */
	private String tag = "PlayerThread";

	/**
	 * 子线程中运行 当点击琴键的时候，就会运行
	 */
	public void run() {

		while (true) {
			if (flag) {
				Log.d(tag, "我被创建出来了");
				flag = false;
			}

		}
	}

	/**
	 * 获得播放的键值 无参数传入 自动播放时调用
	 * 
	 * @return 播放的按键
	 */
	public String play() {
		flag = true;
		midiBaseManager.init(0,4, 2, 2);
		ItemInfo t = midiBaseManager.getTest();
		MidiCreateUtil.write(context, "play", t);
		try {
			MidiPlayer.play(context, "play");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
