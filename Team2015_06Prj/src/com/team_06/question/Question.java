package com.team_06.question;

public interface Question {
	/**
	 * ��ȡ��Ŀ����.
	 */
	public String getQuestionString();

	/**
	 * ��ȡ��Ŀϵͳ��ȷ������.
	 */
	public String getRightAnswerString();

	/**
	 * ��ȡ��Ŀѧ��������.
	 */
	public String getAnsewerString();

	/**
	 * ��ȡѧ����Ŀ������ȷ���.
	 */
	public String getAnswerInfo();

	/**
	 * ѧ����ǰ������Ŀ����
	 * 
	 * @return
	 */
	public String getQuestionType();

}
