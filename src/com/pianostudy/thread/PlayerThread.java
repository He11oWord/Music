package com.pianostudy.thread;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.widget.CheckBox;

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

	public PlayerThread(Context context, int itemMode, int itemType) {
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
			Thread.sleep(100);
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
		// midiBaseManager.init(itemMode, itemType, 0, 0);
		midiBaseManager.setnext(dir);
		return getnext();
	}

	/**
	 * �����һ��
	 * 
	 * @return ���ص��ǵȼ�����Ŀ
	 */
	public String getnext() {
		return "�ȼ� : " + (midiBaseManager.getLevel() + 1) + ",��Ŀ :"
				+ (midiBaseManager.getLastitem() + 1);
	}

	/**
	 * ��okEvent���ã��ж��Ƿ���ȷ
	 * 
	 * @param isKeyOn
	 *            ���а����Ƿ񱻵��������
	 * @return �Ƿ���ȷ
	 */
	public boolean ok(ArrayList<CheckBox> cbList) {
		

		//���������ĸ���Ϊ0������false
		ItemInfo t = midiBaseManager.getTest();//��õ�ǰ����Ŀ
		if(cbList.size() == 0){
			return false;
		}else if(cbList.size() != t.num){
			return false;
		}
		String noteName  = t.toStringNoteName();
		Log.d(tag, noteName);
		String editName = null;
		for(int i = 0; i<cbList.size();i++){
			if(i == 0){
				editName = cbList.get(i).getText().toString();
			}else{
				editName = editName+":"+cbList.get(i).getText().toString();
			}
		}
		Log.d(tag, editName);
		if(!noteName.equals(editName)){
			return false;
		}
		return true;
	}
	/**
	 * ��okEvent���ã��ж��Ƿ���ȷ
	 * 
	 * @param isKeyOn
	 *            ���а����Ƿ񱻵��������
	 * @return �Ƿ���ȷ
	 */
	public boolean okAna(ArrayList<CheckBox> cbList) {
		

		//���������ĸ���Ϊ0������false
		ItemInfo t = midiBaseManager.getTest();//��õ�ǰ����Ŀ
		if(cbList.size() == 0){
			return false;
		}else if(cbList.size() != t.num){
			return false;
		}
		String noteName  = t.toStringNoteName();
		Log.d(tag, noteName);
		String editName = null;
		for(int i = 0; i<cbList.size();i++){
			if(i == 0){
				editName = cbList.get(i).getText().toString();
			}else{
				editName = editName+":"+cbList.get(i).getText().toString();
			}
		}
		Log.d(tag, editName);
		String b =  noteName.replaceAll("#", "");
		if(!b.equals(editName)){
			return false;
		}
		return true;
	}
}
