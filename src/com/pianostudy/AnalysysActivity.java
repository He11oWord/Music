package com.pianostudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * 音高的页面
 * @Description TODO
 * @author lizhao
 * @date 2015-11-5 下午10:06:57
 */
public class AnalysysActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_analysys);
	}
}
