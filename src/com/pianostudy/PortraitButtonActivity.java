package com.pianostudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * ¸ÖÇÙ¼üÊúÅÅ
 * @Description TODO
 * @author lizhao
 * @date 2015-11-7 ÏÂÎç10:22:03
 */
public class PortraitButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_portraitbutton);
	}
}
