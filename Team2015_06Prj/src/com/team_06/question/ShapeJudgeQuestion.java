package com.team_06.question;

public interface ShapeJudgeQuestion extends Question {
	/**
	 * ϵͳ�����жϴ��.
	 * 
	 * @param answer
	 *            ��.
	 * @return ���Ƿ���ȷ ��ȷ true ���� false.
	 */
	public boolean setJudge(boolean answer);

	/**
	 * ��ȡͼ���ж���.
	 * 
	 * @return ���ش� true ͼ����ȷ, false ͼ�δ���.
	 */
	public boolean getJudgeAnswer();

	/**
	 * ��ȡѧ��ͼ���ж���ȷ��.
	 * 
	 * @return ���ش� true ͼ����ȷ, false ͼ�δ���.
	 */
	public boolean getRightAnswer();

	/**
	 * ѧ���Ƿ�ش���Ŀ.
	 * 
	 * @return �Ƿ�ش� �ش� true�� δ�� false.
	 */
	public boolean Answered();

	/**
	 * ��ȡ��״����.
	 * 
	 * @return ��״����.
	 */
	public String getShapeName();
}
