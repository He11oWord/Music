package com.pianostudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * ��ҳ��
 * @Description TODO
 * @author lizhao
 * @date 2015-11-5 ����9:46:01
 */
public class HomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
	}
	
	//������ټ���ҳ��
	public void enterButton(View view ){
		Intent intent = new Intent(this,ButtonActivity.class);
		startActivity(intent);
	}
	
	//���������ҳ��
	public void enterAnalysys(View view ){
		Intent intent = new Intent(this,AnalysysActivity.class);
		startActivity(intent);
	}
	
	//�������ߵ�ҳ��
	public void enterPitch(View view ){
		Intent intent = new Intent(this,PitchActivity.class);
		startActivity(intent);
	}
	
}
