package com.team_06.question;

public interface Question {
	/**
	 * 获取题目描述.
	 */
	public String getQuestionString();

	/**
	 * 获取题目系统正确答案描述.
	 */
	public String getRightAnswerString();

	/**
	 * 获取题目学生答案描述.
	 */
	public String getAnsewerString();

	/**
	 * 获取学生题目解答的正确情况.
	 */
	public String getAnswerInfo();

	/**
	 * 学生当前所答题目类型
	 * 
	 * @return
	 */
	public String getQuestionType();

}
