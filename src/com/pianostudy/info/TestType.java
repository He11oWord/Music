package com.pianostudy.info;

public class TestType {

	/**
	 * ��Ŀ��ģʽΪ����
	 */
	public static final int ITEM_MODE_ANALYSY = 1;
	/**
	 * ��Ŀ��ģʽΪ����
	 */
	public static final int ITEM_MODE_PITCH = 2;
	/**
	 * ��Ŀ�����ͣ� ����������Ӳ˵����������飬��7��
	 */
	public static final String menuListAna[] = { "��������", "��������", "�ֽ�������",
			"������", "�ֽ��ߺ���", "�ߺ���", "����" };

	/**
	 * ��Ŀ�����ͣ�����������Ӳ˵����������飬��8��
	 */
	public static final String menuListPitch[] = { "����", "��������", "��������",
			"�ֽ�������", "������", "�ֽ��ߺ���", "�ߺ���", "����" };

	String TestTypeName;
	String TestChoiceString;
	String TestChoice[];
	int num; // ��Ŀ����
	int current;
	String description; // ����

	ItemInfo items[]; // 7

	final static int harmoney = 1;// ����
	final static int melody = 2;// ����

	// final static String analysisTest[]=
	// {"��������","��������","�ֽ�������","������","�ֽ��ߺ���","�ߺ���","����"};//7
	public final static String toneChoice[] = { "С����", "�����", "С����", "������",
			"���Ķ�", "��ȫ��", "�����", "С����", "������", "С�߶�", "���߶�", "��һ��", "���˶�", "" };// 13}
	public final static String threeChordChoice[] = { "��������", "��������", "����������",
			"С������", "С������", "С��������", "��������", "��������", "����������", "��������" }; // 10
	public final static int threeChordInt[] = { 43, 35, 54, 34, 45, 53, 33, 36,
			63, 44 };

	public final static String sevenChordChoice[] = { "��С7", "��С56", "��С34",
			"��С2", "СС7", "СС56", "СС34", "СС2", "��С7", "��С56", "��С34", "��С2",
			"����7", "���7", "���56", "���34", "���2", "С��7", "С��56", "С��34", "С��2",
			"����7", "����56", "����34", "����2" }; // 28
	public final static int sevenChordInt[] = { 433, 332, 324, 243, 343, 432,
			323, 234, 334, 342, 423, 233, 333, 434, 341, 414, 143, 344, 441,
			413, 134, 443, 431, 314, 144 };

	public final static String scaleChoice1[] = { "��Ȼ���", "�������", "���ɴ��",
			"��ȻС��", "����С��", "����С��" }; // 6
	public final static int scaleInt1[] = { 2212221, 2212131, 2212122, 2122122,
			2122131, 2122221 };
	public final static String scaleChoice2[] = { "����", "�̵�", "�ǵ�", "�յ�", "���" }; // 5
	public final static int scaleInt2[] = { 22323, 23232, 32322, 23223, 32232 };
	public final static String scaleChoice3[] = { "������", "���Ｊ��", "������",
			"�ܿ���������", "�������" }; // 5
	public final static int scaleInt3[] = { 2122212, 1222122, 2221221, 2212212,
			1221222 };
}
