package com.pianostudy.manager;

import com.pianostudy.info.ItemInfo;



/**
 * ��Ŀ�ĵȼ�������
 * ��õ�ǰ��Ŀ�ĵȼ����ؿ�
 * ������һ��
 * @author lizhao
 * 
 */
public class MidiBaseManager {
	/**
	 * �ȼ�
	 */
	private int level;
	/**
	 * ��Ŀ
	 */
	private int lastItem;

	private TestManager testManager = new TestManager();

	/**
	 * ���캯��
	 */
	public MidiBaseManager() {}

	/**
	 * ��ʼ��
	 * 
	 * @param testClass
	 *            Ҫ���Եķ�ʽ��analysis����pitch
	 * @param mainevel
	 *            ѡ���Ӳ˵������ĳһ��ģʽ
	 * @param lev
	 *            �ȼ�
	 * @param last
	 *            ��Ŀ
	 */
	public void init(int testClass, int mainLevel, int lev, int last) {
		level = lev;
		lastItem = last;
		// ��ʼ��ģʽ
		testManager.init(testClass, mainLevel);
	}

	/**
	 * ��õȼ�
	 * 
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * �����Ŀ�����
	 * 
	 * @return
	 */
	public int getLastitem() {
		return lastItem;
	}

	/**
	 * 
	 * @return ��ǰ����Ŀ
	 */
	public ItemInfo getTest() {
		return testManager.gettest(level, lastItem);
		// play(t);
	}

//	final static int isNextItem = 1;
//	final static int isNextLevel = 2;
//	final static int isAllDone = 3;
//
//	/**
//	 * ����ǰ��һ���ȼ�
//	 * 
//	 * @return
//	 */
//	public int setnext() {
//		TestItem tlev[] = testManager.testOflev[level];
//		lastItem++;
//		if (lastItem < tlev.length) {
//			return isNextItem;
//		}
//		lastItem = 0;
//		level++;
//		if (level < testManager.maxlev) {
//			return isNextLevel;
//		}
//		level = 0;
//		return isAllDone;
//	}
//
//	/**
//	 * ������һ��
//	 * 
//	 * @param dir
//	 *            �����жϵ�ֵ -2����һ���ȼ� -1����һ����Ŀ 2ǰ��һ���ȼ� 1�͵���setNext����
//	 * @return ����һ�⻹����һ������ȫ������
//	 */
//	public int setnext(int dir) {
//		if (dir == -1) {
//			if (lastItem > 0) {
//				lastItem--;
//				return 0;
//			}
//			level--;
//			if (level < 0)
//				level = testManager.maxlev;
//			return 0;
//		}
//		// �����item�ڽ��ȼ�
//		if (dir == -2) {
//			if (lastItem > 0) {
//				lastItem = 0;
//				return 0;
//			}
//			level--;
//			if (level < 0)
//				level = testManager.maxlev;
//			return 0;
//		}
//		if (dir == 2) {
//			lastItem = 0;
//			level++;
//			if (level < testManager.maxlev) {
//				return isNextLevel;
//			}
//			level = 0;
//			return isAllDone;
//		}
//		return setnext();
//	}
}