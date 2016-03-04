package com.team_06.dao;

import java.util.List;

import com.team_06.entity.QuestionType;
import com.team_06.entity.Questions;

public interface QuestionDao {

	/**
	 * 增加一条问题记录
	 * 
	 * @param question
	 * @return
	 */
	public boolean insert(Questions question);

	/**
	 * 获取用户做过的题目列表
	 * 
	 * @return 返回用户做过的题目列表
	 */
	public List<Questions> selectUserDid(int userId);

	/**
	 * 获取用户做过的题目总数量
	 * 
	 * @return 返回用户做过的题目总数量
	 */
	public int getNumOfUserDid(int userId);

	/**
	 * 用户做过的题目类型
	 * 
	 * @param questionList
	 * @return
	 */
	public List<QuestionType> getUserDidQuestionType(int userId);
}
