package com.team_06.entity;

public class Questions {
	/**
	 * �����id
	 */
	int Id;
	/**
	 * ���������
	 */
	int QusetionType;
	/**
	 * �������ϸ����
	 */
	String QuestionName;
	/**
	 * ϵͳ�������������ȷ��
	 */
	String QuestionRightAnswer;
	/**
	 * �û��������������ȷ��
	 */
	String QuestionUserAnswer;
	/**
	 * ���Ƿ���ȷ
	 */
	String QuestionIsRight;
	/**
	 * ������˭����
	 */
	int QuestionBelonged;
	/**
	 * ϵͳ�����Ĵ𰸵�����
	 */
	String QuestionRightDescription;
	/**
	 * �û������Ĵ𰸵�����
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
