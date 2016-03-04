package com.team_06.question;

public interface SortQuestion extends Question {
	/**
	 * 获取系统给出的正确答案
	 * 
	 * @return 整形数组
	 */
	public int[] getRightAnswer();

	/**
	 * 获取学生给出的答案
	 * 
	 * @return 整型数组
	 */
	public int[] getUserAnswer();

	/**
	 * 设置答案
	 * 
	 * @return 给出正确的答案列表
	 */
	public void setAnswerList(int[] rightAnswer);
	/**
	 * @auther zhw 设置答案，设置用户给出的答案
	 * @param rightAnswer
	 */
	public void setUserAnswerList(int[] userAnswer);

	/**
	 * 判断学生的答案是否正确
	 */
	public void isRightAnswer();

	/**
	 * 判断学生是否给出答案
	 * 
	 * @return 是：true 否：false
	 */
	public boolean answered();
}
