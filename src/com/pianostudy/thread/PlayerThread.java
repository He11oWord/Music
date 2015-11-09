package com.pianostudy.thread;

import android.content.Context;
import android.util.Log;

import com.pianostudy.info.ItemInfo;
import com.pianostudy.manager.MidiBaseManager;
import com.pianostudy.util.MidiCreateUtil;
import com.pianostudy.util.MidiPlayer;

/**
 * һ���µ��̣߳����Ʋ���
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-8 ����3:49:37
 */
public class PlayerThread {
	public MidiBaseManager midiBaseManager = new MidiBaseManager();
	// ���췽��
	Context context;

	public PlayerThread(Context context,int itemMode, int itemType) {
		this.context = context;
		midiBaseManager.init(itemMode, itemType, 0, 0);
		// this.start();
	}

	/**
	 * ��flag�����Ƿ񲥷�
	 */
	boolean flag = false;
	/**
	 * ���ڵ��Դ�ӡ
	 */
	private String tag = "PlayerThread";

	/**
	 * ���߳������� ������ټ���ʱ�򣬾ͻ�����
	 */
	public void run() {
	}

	/**
	 * ��ò��ŵļ�ֵ �޲������� �Զ�����ʱ����
	 * 
	 * @param itemType
	 * @param itemMode
	 * @return ���ŵİ���
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
	 * ������Ŀ�ܼң�������һ�⣬��������Ŀ�ĵȼ�
	 * 
	 * @param dir
	 * @return ��Ŀ�ĵȼ�
	 */
	public String setnext(int dir) {
//		midiBaseManager.init(itemMode, itemType, 0, 0);
		midiBaseManager.setnext(dir);
		return getnext();
	}

	/**
	 * �����һ��
	 * 
	 * @return ���ص��ǵȼ�����Ŀ
	 */
	public String getnext() {
		return "�ȼ�:" + (midiBaseManager.getLevel() + 1) + " �ؿ�:"
				+ (midiBaseManager.getLastitem() + 1);
	}
}
