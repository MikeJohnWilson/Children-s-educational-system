package com.team_06.question;

public interface SortQuestion extends Question {
	/**
	 * ��ȡϵͳ��������ȷ��
	 * 
	 * @return ��������
	 */
	public int[] getRightAnswer();

	/**
	 * ��ȡѧ�������Ĵ�
	 * 
	 * @return ��������
	 */
	public int[] getUserAnswer();

	/**
	 * ���ô�
	 * 
	 * @return ������ȷ�Ĵ��б�
	 */
	public void setAnswerList(int[] rightAnswer);
	/**
	 * @auther zhw ���ô𰸣������û������Ĵ�
	 * @param rightAnswer
	 */
	public void setUserAnswerList(int[] userAnswer);

	/**
	 * �ж�ѧ���Ĵ��Ƿ���ȷ
	 */
	public void isRightAnswer();

	/**
	 * �ж�ѧ���Ƿ������
	 * 
	 * @return �ǣ�true ��false
	 */
	public boolean answered();
}
