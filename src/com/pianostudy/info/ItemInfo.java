package com.pianostudy.info;


/**
 * ÿ����Ŀ��������Ϣ
 * @Description TODO
 * @author lizhao
 * @date 2015-11-8 ����7:37:22
 */
public class ItemInfo {
	/**
	 * ����Ŀ���ų�����������
	 */
	public short num = 0; // length of notes
	
	/**
	 * �ȼ�-1
	 */
	public short factor = 0;
	/**
	 * �����жϵ��±�
	 */
	public short index = -1; // index to names
	/**
	 * �Ƿ�һ���Բ�����
	 */
	public boolean isCord = false;
	/**
	 * ���淽ʽ��������������
	 */
	public short testClass;
	public short notes[];
	public String names[];
	public int key = 0;

	// byte 3 - test class, byte 2 - mainlevel, byte 0/1 -
	// index of the test
	/**
	 * ���ü�ֵ
	 * 
	 * @param mainlevel
	 *            ����ģʽ
	 * @param ind
	 */
	public void setKey(int mainlevel, int ind) {
		key = (testClass << 24) + (mainlevel << 16) + ind;
	}

	/**
	 * �൱��toString����
	 * ��� "����  -0-F3  A3" ����-��names[index]�жϣ��ȼ��͵�һ���ַ��룬�����ַ���
	 * @return
	 */
//	public String toStr() {
//		//��� "-0-F3" �ȼ� �� ��һ���ַ���
//		String str = "-" + factor + "-"+ MidiGenerator.notename[notes[0] - TestGenerator.noteStart];
//		//������ǵ���ģʽ����ǰ�油�����ơ���� + ��������
//		if (index >= 0) {
//			str = names[index] + str;
//		}
//
//		//����ж�����������ں��油��
//		for (int i = 1; i < num; i++) {
//			str = str
//					+ ":"
//					+ MidiGenerator.notename[notes[i] - TestGenerator.noteStart];
//		}
//		return str;
//	}

	/**
	 * TestItem�Ĺ��췽��
	 * @param note
	 */
	public ItemInfo(short note) {
		notes = new short[1];
		notes[0] = note;
		num = 1;
	}

	public ItemInfo(int ns[]) {
		num = (short) ns.length;
		for (int i = 0; i < num; i++) {
			notes[i] = (short) ns[i];
		}
	}
	/**
	 * TestItem�Ĺ��췽������¡�������isCord
	 * @param clone
	 * @param is_Cord
	 */
	public ItemInfo(ItemInfo clone, boolean is_Cord) {
		num = clone.num;
		factor = clone.factor;
		index = clone.index;
		isCord = is_Cord;
		testClass = clone.testClass;
		notes = clone.notes;
		names = clone.names;
	}

	public ItemInfo(String choices[], int ind, int f, short ns[]) {
		names = choices;
		index = (short) ind;
		factor = (short) f;
		notes = new short[2];
		notes = ns;
		num = (short) ns.length;
	}

	public ItemInfo(String choices[], int ind, int f, short note0, short note1) {
		names = choices;
		index = (short) ind;
		factor = (short) f;
		notes = new short[2];
		notes[0] = note0;
		notes[1] = note1;
		num = 2;
	}

	public ItemInfo(String choices[], int ind, int f, short note0, short note1,
			short note2) {
		names = choices;
		index = (short) ind;
		factor = (short) f;
		notes = new short[3];
		notes[0] = note0;
		notes[1] = note1;
		notes[2] = note2;
		num = 3;
	}

	public ItemInfo(String choices[], int ind, int f, short note0, short note1,
			short note2, short note3) {
		names = choices;
		index = (short) ind;
		factor = (short) f;
		notes = new short[4];
		notes[0] = note0;
		notes[1] = note1;
		notes[2] = note2;
		notes[3] = note3;
		num = 4;
	}

}
