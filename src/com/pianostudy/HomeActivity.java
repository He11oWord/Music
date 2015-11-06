package com.pianostudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * 主页面
 * @Description TODO
 * @author lizhao
 * @date 2015-11-5 下午9:46:01
 */
public class HomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
	}
	
	//进入钢琴键的页面
	public void enterButton(View view ){
		Intent intent = new Intent(this,ButtonActivity.class);
		startActivity(intent);
	}
	
	//进入分析的页面
	public void enterAnalysys(View view ){
		Intent intent = new Intent(this,AnalysysActivity.class);
		startActivity(intent);
	}
	
	//进入音高的页面
	public void enterPitch(View view ){
		Intent intent = new Intent(this,PitchActivity.class);
		startActivity(intent);
	}
	
}
