package com.pianostudy.listener;
import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.pianostudy.util.ButtonClickUtil;
import com.pianostudy.util.MidiCreateUtil;
import com.pianostudy.util.MidiPlayer;

/**
 * 竖琴的按钮监听器
 * @Description TODO
 * @author lizhao
 * @date 2015-11-8 上午12:28:25
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
		System.out.println("哈哈，我被点击了");		
		try {
			MidiCreateUtil.write(context, "key", i);//写入文件
			Thread.sleep(100);//睡100ms，避免连续点击导致破音
			MidiPlayer.play(context, "key");//播放
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
