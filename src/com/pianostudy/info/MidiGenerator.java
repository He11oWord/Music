package com.pianostudy.info;

import android.media.MediaPlayer;


/**
 * 将要播放的音频码的提供类
 * 
 * @Description TODO
 * @author lizhao
 * @date 2015-11-5 下午11:44:56
 */
public class MidiGenerator {
	/**
	 * 钢琴键的名字
	 */
	public static String notename[] = { "F3", "#F3", "G3", "#G3", "A3", "#A3",
			"B3", "C4", "#C4", "D4", "#D4", "E4", "F4", "#F4", "G4", "#G4",
			"A4", "#A4", "B4", "C5", "#C5", "D5", "#D5", "E5", "F5" };
	static byte[] twocordMidi = { (byte) 0x4D, (byte) 0x54, (byte) 0x68,
			(byte) 0x64, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x06,
			(byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x02, (byte) 0x04,
			(byte) 0x00, (byte) 0x4D, (byte) 0x54, (byte) 0x72, (byte) 0x6B,
			(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x23, (byte) 0x00,
			(byte) 0xFF, (byte) 0x54, (byte) 0x05, (byte) 0x00, (byte) 0x00,
			(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xFF,
			(byte) 0x58, (byte) 0x04, (byte) 0x04, (byte) 0x02, (byte) 0x18,
			(byte) 0x08, (byte) 0x00, (byte) 0xFF, (byte) 0x59, (byte) 0x02,
			(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xFF, (byte) 0x51,
			(byte) 0x03, (byte) 0x07, (byte) 0xA1, (byte) 0x1F, (byte) 0x9F,
			(byte) 0x7F, (byte) 0xFF, (byte) 0x2F, (byte) 0x00, (byte) 0x4D,
			(byte) 0x54, (byte) 0x72, (byte) 0x6B, (byte) 0x00, (byte) 0x00,
			(byte) 0x00, (byte) 0x54, (byte) 0x00, (byte) 0xFF, (byte) 0x09,
			(byte) 0x04, (byte) 0x28, (byte) 0xCE, (byte) 0xDE, (byte) 0x29,
			(byte) 0x00, (byte) 0xFF, (byte) 0x03, (byte) 0x14, (byte) 0x53,
			(byte) 0x6D, (byte) 0x61, (byte) 0x72, (byte) 0x74, (byte) 0x4D,
			(byte) 0x75, (byte) 0x73, (byte) 0x69, (byte) 0x63, (byte) 0x20,
			(byte) 0x53, (byte) 0x6F, (byte) 0x66, (byte) 0x74, (byte) 0x53,
			(byte) 0x79, (byte) 0x6E, (byte) 0x74, (byte) 0x68, (byte) 0x00,
			(byte) 0xB0, (byte) 0x00, (byte) 0x79, (byte) 0x00, (byte) 0xB0,
			(byte) 0x20, (byte) 0x00, (byte) 0x00, (byte) 0xC0, (byte) 0x00,
			(byte) 0x00, (byte) 0xB0, (byte) 0x07, (byte) 0x65, (byte) 0x00,
			(byte) 0xB0, (byte) 0x0A, (byte) 0x40, (byte) 0x00, (byte) 0xB0,
			(byte) 0x07, (byte) 0x66, (byte) 0x00, (byte) 0xB0, (byte) 0x07,
			(byte) 0x6E, (byte) 0x0A, (byte) 0xB0, (byte) 0x07, (byte) 0x66,
			(byte) 0x00, (byte) 0x90, (byte) 0x39, (byte) 0x38, (byte) 0x00,
			(byte) 0x90, (byte) 0x3B, (byte) 0x46, (byte) 0x9F, (byte) 0x75,
			(byte) 0x80, (byte) 0x39, (byte) 0x00, (byte) 0x00, (byte) 0x80,
			(byte) 0x3B, (byte) 0x00, (byte) 0x00, (byte) 0xFF, (byte) 0x2F,
			(byte) 0x00 };

	static int posCord[][] = { { 0 }, { 0x82, 0x86, 0x8b, 0x8f },
			{ 0x7e, 0x82, 0x86, 0x8b, 0x8f, 0x93 },
			{ 0x7e, 0x82, 0x86, 0x8a, 0x8f, 0x93, 0x97, 0x9b } };
	
	public MidiGenerator() {
//		init();
//	}
//	static byte[][] excord = new byte[8][];
//	static byte[][] exana = new byte[8][];
//	public void init() {
//		excord[0] = twocordMidi;
//		excord[1] = twocordMidi;
//		excord[2] = threecordMidi;
//		excord[3] = fourcordMidi;
//
//		exana[1] = twoanaMidi;
//		exana[2] = threeanaMidi;
//		exana[3] = fouranaMidi;
//		exana[5] = sixanaMidi;
//		exana[7] = eightanaMidi;
	}
//	public static Sequence makeseq(int key) {
//		byte[] b = twocordMidi;
//		Sequence s1 = null;
//		int[][] pos = posCord;
//		try {
//			ByteArrayInputStream bais;
//			for (int i = 0; i < 4; i++) {
//				b[pos[1][i]] = (byte) key;
//			}
//			// System.out.print(bytesToHexString(b));
//			bais = new ByteArrayInputStream(b);
//			s1 = MidiSystem.getSequence(bais);
//			System.out.println("hello:"+s1.getTickLength());
//			System.out.println(bytesToHexString(b)+":"+b.length);
//		} catch (InvalidMidiDataException ex) {
//			Logger.getLogger(MidiGenerator.class.getName()).log(Level.SEVERE,
//					null, ex);
//		} catch (IOException ex) {
//			Logger.getLogger(MidiGenerator.class.getName()).log(Level.SEVERE,
//					null, ex);
//		}
//		return s1;
//
//	}
	
	MediaPlayer p = new MediaPlayer();
	
}
