package com.team_06.dao;

import java.util.List;

import com.team_06.entity.QuestionType;

public interface QuestionTypeDao {

	/**
	 * 通过id查询一个问题类型的详情信息
	 * 
	 * @param id
	 * @return 单独的一条信息
	 */
	public QuestionType select(int id);

	/**
	 * 增加一个问题类型
	 * 
	 * @param questionType
	 * @return 成功：true 失败：false
	 */
	public boolean insert(QuestionType questionType);

	/**
	 * 或缺数据库中所有的问题类型
	 * 
	 * @return 一个List
	 */
	public List<QuestionType> getAllType();

}
