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
public class PlayerThread {
	public MidiBaseManager midiBaseManager = new MidiBaseManager();
	// 构造方法
	Context context;

	public PlayerThread(Context context,int itemMode, int itemType) {
		this.context = context;
		midiBaseManager.init(itemMode, itemType, 0, 0);
		// this.start();
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
	}

	/**
	 * 获得播放的键值 无参数传入 自动播放时调用
	 * 
	 * @param itemType
	 * @param itemMode
	 * @return 播放的按键
	 */
	public String play() {
		flag = true;
		
		ItemInfo t = midiBaseManager.getTest();
		MidiCreateUtil.writeSelect(context, "play", t);
		try {
			Thread.sleep(1000);
			MidiPlayer.play(context, "play");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t.toStr();
	}

	/**
	 * 调用题目管家，进行下一题，并返回题目的等级
	 * 
	 * @param dir
	 * @return 题目的等级
	 */
	public String setnext(int dir) {
//		midiBaseManager.init(itemMode, itemType, 0, 0);
		midiBaseManager.setnext(dir);
		return getnext();
	}

	/**
	 * 获得下一个
	 * 
	 * @return 返回的是等级和题目
	 */
	public String getnext() {
		return "等级:" + (midiBaseManager.getLevel() + 1) + " 关卡:"
				+ (midiBaseManager.getLastitem() + 1);
	}
}
