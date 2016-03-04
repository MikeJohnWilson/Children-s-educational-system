package com.team_06.dao;

import java.util.List;

import com.team_06.entity.QuestionType;

public interface QuestionTypeDao {

	/**
	 * ͨ��id��ѯһ���������͵�������Ϣ
	 * 
	 * @param id
	 * @return ������һ����Ϣ
	 */
	public QuestionType select(int id);

	/**
	 * ����һ����������
	 * 
	 * @param questionType
	 * @return �ɹ���true ʧ�ܣ�false
	 */
	public boolean insert(QuestionType questionType);

	/**
	 * ��ȱ���ݿ������е���������
	 * 
	 * @return һ��List
	 */
	public List<QuestionType> getAllType();

}
