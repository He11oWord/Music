package com.pianostudy.listener;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.pianostudy.ButtonActivity;

/**
 * �����ķ����ӿ�
 */
public class ButtonTouchListener implements OnTouchListener {
	private ButtonActivity ba;
	private int i;
	private String TAG = "ButtonTouchListener";

	public ButtonTouchListener(ButtonActivity ba, int i) {
		this.ba = ba;
		this.i = i;
	}

	public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
		if (paramMotionEvent.getAction() == 0) {// ����
			Log.d(TAG, i + "");
			ba.soundPool.play(ba.soundMap.get(i), 1.0F, 1.0F, 1, 0, 1.0F);
		}
		return false;
	}
}
