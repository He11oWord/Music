package com.pianostudy.listener;
import android.content.Context;
import android.view.View;
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

	Context context;
	int  i;
	public ProtraitButtonOnTouchListener(Context context,int i){
		this.context = context;
		this.i = i;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		System.out.println("�������ұ������");		
		try {
			MidiCreateUtil.write(context, "key", i);//д���ļ�
			Thread.sleep(100);//˯100ms���������������������
			MidiPlayer.play(context, "key");//����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
