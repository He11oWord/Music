package com.pianostudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);

		RelativeLayout relative = (RelativeLayout) findViewById(R.id.splash_relative);
		startAnimation(relative);
	}
	/**
	 * 播放动画 旋转/缩放/渐变
	 * 
	 * @param relative
	 */
	private void startAnimation(RelativeLayout relative) {
		// 装动画的容器
		AnimationSet set = new AnimationSet(false);

		// 旋转的动画
		RotateAnimation rotate = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		rotate.setDuration(1000);// 时间
		rotate.setFillAfter(true);// 是否保持动画

		// 缩放的动画
		ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
				Animation.RELATIVE_TO_SELF, 0.3f, Animation.RELATIVE_TO_SELF,
				0.3f);
		scale.setDuration(1000);// 时间
		scale.setFillAfter(true);// 是否保持动画

		// 渐变的动画
		AlphaAnimation alphe = new AlphaAnimation(0, 1);
		alphe.setDuration(1500);// 时间
		alphe.setFillAfter(true);// 是否保持动画

		set.addAnimation(rotate);
		set.addAnimation(scale);
		set.addAnimation(alphe);

		set.setAnimationListener(new AnimationListener() {

			// 动画开始的时候
			@Override
			public void onAnimationStart(Animation animation) {
			}

			// 播放的时候
			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			// 动画结束
			@Override
			public void onAnimationEnd(Animation animation) {
				// 进入引导页面或者主页面
				Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
				startActivity(intent);
				finish();
			}

		});
		relative.startAnimation(set);
	}

	
}
