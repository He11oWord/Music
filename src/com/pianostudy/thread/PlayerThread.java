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
public class PlayerThread extends Thread {
	public MidiBaseManager midiBaseManager = new MidiBaseManager();
	// ���췽��
	Context context;
	public PlayerThread(Context context) {
		this.context = context;
		this.start();
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

		while (true) {
			if (flag) {
				Log.d(tag, "�ұ�����������");
				flag = false;
			}

		}
	}

	/**
	 * ��ò��ŵļ�ֵ �޲������� �Զ�����ʱ����
	 * 
	 * @return ���ŵİ���
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
