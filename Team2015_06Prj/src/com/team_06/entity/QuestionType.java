package com.team_06.entity;

public class QuestionType {

	/**
	 * 问题类型id
	 */
	int Id;
	/**
	 * 问题类型的名字
	 */
	String QuestionTypeName;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getQuestionTypeName() {
		return QuestionTypeName;
	}

	public void setQuestionTypeName(String questionType) {
		QuestionTypeName = questionType;
	}
}
