package com.pianostudy.manager;

import android.util.Log;

import com.pianostudy.info.ItemInfo;
import com.pianostudy.info.TestGenerator;
import com.pianostudy.util.MidiCreateUtil;

public class TestManager {
	/**
	 * ��ߵȼ�
	 */
	public int maxlev = 100;

	public ItemInfo testOflev[][];// = new testitem[maxlev][];

	static public ItemInfo anaTests[][][] = new ItemInfo[6][][];

	static public ItemInfo pitchTests[][][] = new ItemInfo[7][][];

	TestGenerator test_gen = new TestGenerator();

	private String tag = "TestManager";

	/**
	 * ���췽��
	 */
	public TestManager() {
		MidiCreateUtil.init();
	}

	/**
	 * ���һ��������Ŀ
	 * 
	 * @param testno
	 *            �ȼ�
	 * @param itemno
	 *            ��Ŀ
	 * @����һ�������ֵ n = estOflev.lengthΪ���ȣ�����ģʽֵ
	 * @return ���ص���һ��TestItem��
	 */
	public ItemInfo gettest(int testno, int itemno) {
		System.out.print("gettest i=" + testno + ",j=" + itemno + ":n="
				+ testOflev.length + "\n");// ��ӡ��ǰ����Ŀ��Ϣ
		ItemInfo d = testOflev[testno][itemno];// �Ӹ��������ó���Ŀ
		return d;
	}

	/**
	 * ��TestManager�г�ʼ�����Ե�ģʽ
	 * 
	 * @param testclass
	 *            ѡ�����ĸ���ʽ
	 * @param mainlevel
	 *            ѡ�����ĸ�ģʽ
	 */
	public void init(int testclass, int mainlevel) {
		if (testclass == 1) {
			initAna(mainlevel);
			testOflev = anaTests[mainlevel];
			maxlev = testOflev.length;// �տ�ʼΪ0
		} else if (testclass == 0) {
			initPitch(mainlevel);
			testOflev = pitchTests[mainlevel];
			maxlev = testOflev.length;
		}
		Log.d(tag, "testmanager-init:" + testclass + "����" + "mainlevel"
				+ mainlevel + "����" + "maxlev:" + testOflev.length);
	}

	//
	//
	// TestItem[] gen_tests(TestItem[] from, boolean is_Cord) {
	// int m = from.length;
	// TestItem[] to = new TestItem[m];
	// for (int j = 0; j < m; j++) {
	// to[j] = new TestItem(from[j], is_Cord);
	// }
	// return to;
	// }

	/**
	 * ���÷���ҳ��
	 * 
	 * @param mainlevel
	 *            ģʽ
	 */
	void initAna(int mainlevel) {
		switch (mainlevel) {
		case 0:
			init(anaTests, mainlevel, test_gen.twonote_tests, false);
			break;
		case 1:
			init(anaTests, mainlevel, test_gen.twonote_tests, true);
			break;
		case 2:
			init(anaTests, mainlevel, test_gen.threeChord_tests, false);
			break;
		case 3:
			init(anaTests, mainlevel, test_gen.threeChord_tests, true);
			break;
		case 4:
			init(anaTests, mainlevel, test_gen.sevenChord_tests, false);
			break;
		case 5:
			init(anaTests, mainlevel, test_gen.sevenChord_tests, true);
			break;
		case 6:
			init(anaTests, mainlevel, test_gen.scale_tests, false);
			break;
		}
	}

	/**
	 * ���ø���ҳ��
	 * 
	 * @param mainlevel
	 *            ģʽ
	 */
	void initPitch(int mainlevel) {
		switch (mainlevel) {
		case 0:
			init(pitchTests, mainlevel, test_gen.onenote_tests, true);
			break;
		case 1:
			init(pitchTests, mainlevel, test_gen.twonote_tests, false);
			break;
		case 2:
			init(pitchTests, mainlevel, test_gen.twonote_tests, true);
			break;
		case 3:
			init(pitchTests, mainlevel, test_gen.threeChord_tests, false);
			break;
		case 4:
			init(pitchTests, mainlevel, test_gen.threeChord_tests, true);
			break;
		case 5:
			init(pitchTests, mainlevel, test_gen.sevenChord_tests, false);
			break;
		case 6:
			init(pitchTests, mainlevel, test_gen.sevenChord_tests, true);
			break;
		case 7:
			init(pitchTests, mainlevel, test_gen.scale_tests, false);
			break;
		}
	}

	/**
	 * ��ʼ����Ŀ������Ŀ������
	 * 
	 * @param testss
	 *            һ����λ����
	 * @param mainlevel
	 *            ģʽ
	 * @param tests
	 *            ��ά����,�������Ŀ
	 * @param is_Cord
	 *            �Ƿ���һ���Բ���
	 */
	private void init(ItemInfo[][][] testss, int mainlevel, ItemInfo tests[][],
			boolean is_Cord) {
		// ���Ϊ�վͽ���
		if (testss[mainlevel] != null) {
			return;
		}
		// ��ö�ά����ĳ���
		int n = tests.length;
		// ����ȼ���ֵ��һ����ά����
		testss[mainlevel] = new ItemInfo[n][];

		for (int i = 0; i < n; i++) {
			int m = tests[i].length;
			ItemInfo[] to = new ItemInfo[m];
			for (int j = 0; j < m; j++) {
				to[j] = new ItemInfo(tests[i][j], false);
				to[j].setKey(mainlevel, j);
			}
			// to����һ��һά���飿���������Ѿ�����ֵ
			testss[mainlevel][i] = to;
		}
	}
}
