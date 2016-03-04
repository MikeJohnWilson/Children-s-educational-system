package com.team_06.entity;

public class Questions {
	/**
	 * 问题的id
	 */
	int Id;
	/**
	 * 问题的类型
	 */
	int QusetionType;
	/**
	 * 问题的详细描述
	 */
	String QuestionName;
	/**
	 * 系统给出的问题的正确答案
	 */
	String QuestionRightAnswer;
	/**
	 * 用户给出的问题的正确答案
	 */
	String QuestionUserAnswer;
	/**
	 * 答案是否正确
	 */
	String QuestionIsRight;
	/**
	 * 问题是谁做的
	 */
	int QuestionBelonged;
	/**
	 * 系统给出的答案的描述
	 */
	String QuestionRightDescription;
	/**
	 * 用户给出的答案的描述
	 */
	String QuestionUserDescription;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getQusetionType() {
		return QusetionType;
	}
	public void setQusetionType(int qusetionType) {
		QusetionType = qusetionType;
	}
	public String getQuestionName() {
		return QuestionName;
	}
	public void setQuestionName(String questionName) {
		QuestionName = questionName;
	}
	public String getQuestionRightAnswer() {
		return QuestionRightAnswer;
	}
	public void setQuestionRightAnswer(String questionRightAnswer) {
		QuestionRightAnswer = questionRightAnswer;
	}
	public String getQuestionUserAnswer() {
		return QuestionUserAnswer;
	}
	public void setQuestionUserAnswer(String questionUserAnswer) {
		QuestionUserAnswer = questionUserAnswer;
	}
	public String getQuestionIsRight() {
		return QuestionIsRight;
	}
	public void setQuestionIsRight(String questionIsRight) {
		QuestionIsRight = questionIsRight;
	}
	public int getQuestionBelonged() {
		return QuestionBelonged;
	}
	public void setQuestionBelonged(int questionBelonged) {
		QuestionBelonged = questionBelonged;
	}
	public String getQuestionRightDescription() {
		return QuestionRightDescription;
	}
	public void setQuestionRightDescription(String questionRightDescription) {
		QuestionRightDescription = questionRightDescription;
	}
	public String getQuestionUserDescription() {
		return QuestionUserDescription;
	}
	public void setQuestionUserDescription(String questionUserDescription) {
		QuestionUserDescription = questionUserDescription;
	}
	
}
