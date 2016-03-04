package com.team_06.question;

public interface ShapeJudgeQuestion extends Question {
	/**
	 * 系统设置判断答辩.
	 * 
	 * @param answer
	 *            答案.
	 * @return 答案是否正确 正确 true 错误 false.
	 */
	public boolean setJudge(boolean answer);

	/**
	 * 获取图形判定答案.
	 * 
	 * @return 返回答案 true 图像正确, false 图形错误.
	 */
	public boolean getJudgeAnswer();

	/**
	 * 获取学生图形判定正确答案.
	 * 
	 * @return 返回答案 true 图像正确, false 图形错误.
	 */
	public boolean getRightAnswer();

	/**
	 * 学生是否回答题目.
	 * 
	 * @return 是否回答， 回答 true， 未答 false.
	 */
	public boolean Answered();

	/**
	 * 获取形状名称.
	 * 
	 * @return 形状名称.
	 */
	public String getShapeName();
}
