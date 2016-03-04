package com.team_06.dao;

import java.util.List;

import com.team_06.entity.QuestionType;
import com.team_06.entity.Questions;

public interface QuestionDao {

	/**
	 * ����һ�������¼
	 * 
	 * @param question
	 * @return
	 */
	public boolean insert(Questions question);

	/**
	 * ��ȡ�û���������Ŀ�б�
	 * 
	 * @return �����û���������Ŀ�б�
	 */
	public List<Questions> selectUserDid(int userId);

	/**
	 * ��ȡ�û���������Ŀ������
	 * 
	 * @return �����û���������Ŀ������
	 */
	public int getNumOfUserDid(int userId);

	/**
	 * �û���������Ŀ����
	 * 
	 * @param questionList
	 * @return
	 */
	public List<QuestionType> getUserDidQuestionType(int userId);
}
