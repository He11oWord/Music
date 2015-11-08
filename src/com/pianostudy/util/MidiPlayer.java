package com.pianostudy.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/**
 * 用于播放midi的类
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-8 上午12:48:17
 */
public class MidiPlayer {

	/**
	 * 播放钢琴键的声音
	 * 
	 * @param context
	 *            上下文
	 * @param fileName
	 *            文件名字
	 */
	public static void play(Context context, String fileName) throws Exception {

		final MediaPlayer audioPlayer = new MediaPlayer();

		String path = context.getFilesDir().getPath() + "/" + fileName + ".mid";
		audioPlayer.setDataSource(path);
		audioPlayer.prepare();
		audioPlayer.start();
		audioPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				audioPlayer.release();
			}
		});
	}
}
