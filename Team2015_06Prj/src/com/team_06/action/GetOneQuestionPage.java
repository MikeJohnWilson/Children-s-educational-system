package com.team_06.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.team_06.question.Question;
import com.team_06.shapecalc.impl.QuestionFactory;

public class GetOneQuestionPage extends ActionSupport {
	/*
	 * ceshi swl
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 问题类型
	 */
	public int questionType;
	/**
	 * 问题类型
	 */
	Question aQuestion;
	/**
	 * 问题的描述
	 */
	String questionName; 
	
	ActionContext ctx;
		
	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public Question getaQuestion() {
		return aQuestion;
	}

	public void setaQuestion(Question aQuestion) {
		this.aQuestion = aQuestion;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}
    public GetOneQuestionPage(){
    	init();
    }
    public void init(){
    	ctx = ActionContext.getContext();
    }
	@Override
	public String execute(){
		getAquestion();
		int key = this.getQuestionType();
		if (key == 1 || key == 2 || key == 3) {
			return "ShapeClac";
		} else if (key == 4 || key == 5) {
			return "SortNum";
		} else {
			return "ShapeJudge";
		}
	}
	
	/**
	 * 获取一个题目
	 */
	public void getAquestion() {
		QuestionFactory factory = new QuestionFactory();
		aQuestion = factory.createQuestion(questionType);
		String questionName = aQuestion.getQuestionString();
		this.setQuestionName(questionName);
		
		//ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		session.put("aQuestion", aQuestion);
		session.put("questionType", questionType);
	}
}
