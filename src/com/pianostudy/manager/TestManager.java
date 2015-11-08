package com.pianostudy.manager;

import android.util.Log;

import com.pianostudy.info.ItemInfo;
import com.pianostudy.info.TestGenerator;
import com.pianostudy.util.MidiCreateUtil;

public class TestManager {
	/**
	 * 最高等级
	 */
	public int maxlev = 100;

	public ItemInfo testOflev[][];// = new testitem[maxlev][];

	static public ItemInfo anaTests[][][] = new ItemInfo[6][][];

	static public ItemInfo pitchTests[][][] = new ItemInfo[7][][];

	TestGenerator test_gen = new TestGenerator();

	private String tag = "TestManager";

	/**
	 * 构造方法
	 */
	public TestManager() {
		MidiCreateUtil.init();
	}

	/**
	 * 获得一个测试题目
	 * 
	 * @param testno
	 *            等级
	 * @param itemno
	 *            题目
	 * @另外一个输出的值 n = estOflev.length为长度，就是模式值
	 * @return 返回的是一个TestItem类
	 */
	public ItemInfo gettest(int testno, int itemno) {
		System.out.print("gettest i=" + testno + ",j=" + itemno + ":n="
				+ testOflev.length + "\n");// 打印当前的题目信息
		ItemInfo d = testOflev[testno][itemno];// 从该数组中拿出题目
		return d;
	}

	/**
	 * 在TestManager中初始化测试的模式
	 * 
	 * @param testclass
	 *            选的是哪个方式
	 * @param mainlevel
	 *            选的是哪个模式
	 */
	public void init(int testclass, int mainlevel) {
		if (testclass == 1) {
			initAna(mainlevel);
			testOflev = anaTests[mainlevel];
			maxlev = testOflev.length;// 刚开始为0
		} else if (testclass == 0) {
			initPitch(mainlevel);
			testOflev = pitchTests[mainlevel];
			maxlev = testOflev.length;
		}
		Log.d(tag, "testmanager-init:" + testclass + "换行" + "mainlevel"
				+ mainlevel + "换行" + "maxlev:" + testOflev.length);
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
	 * 重置分析页面
	 * 
	 * @param mainlevel
	 *            模式
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
	 * 重置高音页面
	 * 
	 * @param mainlevel
	 *            模式
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
	 * 初始化题目，把题目给填满
	 * 
	 * @param testss
	 *            一个三位数组
	 * @param mainlevel
	 *            模式
	 * @param tests
	 *            二维数组,具体的题目
	 * @param is_Cord
	 *            是否是一次性播放
	 */
	private void init(ItemInfo[][][] testss, int mainlevel, ItemInfo tests[][],
			boolean is_Cord) {
		// 如果为空就结束
		if (testss[mainlevel] != null) {
			return;
		}
		// 获得二维数组的长度
		int n = tests.length;
		// 这个等级的值是一个二维数组
		testss[mainlevel] = new ItemInfo[n][];

		for (int i = 0; i < n; i++) {
			int m = tests[i].length;
			ItemInfo[] to = new ItemInfo[m];
			for (int j = 0; j < m; j++) {
				to[j] = new ItemInfo(tests[i][j], false);
				to[j].setKey(mainlevel, j);
			}
			// to还是一个一维数组？但是里面已经有了值
			testss[mainlevel][i] = to;
		}
	}
}
