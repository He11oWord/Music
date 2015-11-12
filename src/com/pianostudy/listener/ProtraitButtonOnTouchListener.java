package com.pianostudy.listener;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.pianostudy.util.ButtonClickUtil;
import com.pianostudy.util.MidiCreateUtil;
import com.pianostudy.util.MidiPlayer;

/**
 * ���ٵİ�ť������
 * @Description TODO
 * @author lizhao
 * @date 2015-11-8 ����12:28:25
 */
public class ProtraitButtonOnTouchListener implements OnCheckedChangeListener{
	ArrayList<CheckBox> cbList;
	Context context;
	int  i;
	public ProtraitButtonOnTouchListener(Context context,int i,ArrayList<CheckBox> cbList){
		this.context = context;
		this.i = i;
		this.cbList =cbList;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		System.out.println("�������ұ������");
		if(isChecked){
			cbList.add((CheckBox) buttonView);
			Log.d("ProtraitButtonOnTouchListener", "�ұ����뵽����������");
		}else{
			cbList.remove((CheckBox) buttonView);
			Log.d("ProtraitButtonOnTouchListener", "�ұ��Ƴ�������");
		}
		try {
			MidiCreateUtil.write(context, "key", i);//д���ļ�
			Thread.sleep(200);//˯100ms���������������������
			MidiPlayer.play(context, "key");//����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
