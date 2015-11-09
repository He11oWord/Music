package com.pianostudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

/**
 * 音高的页面
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-5 下午10:06:57
 */
public class PitchActivity extends Activity implements OnClickListener {
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	private Button b6;
	private Button b7;
	private Button b8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pitch);
		initView();
	}

	/**
	 * 初始化
	 */
	private void initView() {
		b1 = (Button) findViewById(R.id.volume_1);
		b2 = (Button) findViewById(R.id.volume_2);
		b3 = (Button) findViewById(R.id.volume_3);
		b4 = (Button) findViewById(R.id.volume_4);
		b5 = (Button) findViewById(R.id.volume_5);
		b6 = (Button) findViewById(R.id.volume_6);
		b7 = (Button) findViewById(R.id.volume_7);
		b8 = (Button) findViewById(R.id.volume_8);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
	}

	/**
	 * 重写点击事件
	 */
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, PitchPortraitButtonActivity.class);
		switch (v.getId()) {
		case R.id.volume_1:
			intent.putExtra("itemType", 0);
			startActivity(intent);
			break;
		case R.id.volume_2:
			intent.putExtra("itemType", 1);
			startActivity(intent);
			break;
		case R.id.volume_3:
			intent.putExtra("itemType", 2);
			startActivity(intent);
			break;
		case R.id.volume_4:
			intent.putExtra("itemType", 3);
			startActivity(intent);
			break;
		case R.id.volume_5:
			intent.putExtra("itemType", 4);
			startActivity(intent);
			break;
		case R.id.volume_6:
			intent.putExtra("itemType", 5);
			startActivity(intent);
			break;
		case R.id.volume_7:
			intent.putExtra("itemType", 6);
			startActivity(intent);
			break;
		case R.id.volume_8:
			intent.putExtra("itemType", 7);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
