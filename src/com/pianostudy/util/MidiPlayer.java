package com.pianostudy.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/**
 * ���ڲ���midi����
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-8 ����12:48:17
 */
public class MidiPlayer {

	private static MediaPlayer audioPlayer;

	/**
	 * ���Ÿ��ټ�������
	 * 
	 * @param context
	 *            ������
	 * @param fileName
	 *            �ļ�����
	 */
	public static void play(Context context, String fileName) throws Exception {

		if (audioPlayer != null) {
			audioPlayer.release();
		}
		audioPlayer = new MediaPlayer();

		String path = context.getFilesDir().getPath() + "/" + fileName + ".mid";
		System.out.println(path);
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
