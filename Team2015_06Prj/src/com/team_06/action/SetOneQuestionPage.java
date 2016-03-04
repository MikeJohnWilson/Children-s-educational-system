package com.team_06.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.team_06.dao.QuestionDao;
import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.entity.Questions;
import com.team_06.entity.User;
import com.team_06.question.Question;
import com.team_06.question.ShapeClacQuestion;
import com.team_06.question.ShapeJudgeQuestion;
import com.team_06.question.SortQuestion;

public class SetOneQuestionPage extends ActionSupport {
	private static final long serialVersionUID = 1L;

	ActionContext ctx;
	/**
	 * 从session中获取当前问题
	 */
	Question question;
	/**
	 * 从session中获取当前问题类型
	 */
	public int questionType;
	/**
	 * 用户id
	 */
	int userId;
	/**
	 * 面积
	 */
	double area;
	/**
	 * 周长
	 */
	double perimeter;
	/**
	 * 排序的答案
	 */
	String userArray;
	/**
	 * 选择题的答案
	 */
	boolean judge;
	/**
	 * 题目的描述
	 */
	String questionName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	public String getUserArray() {
		return userArray;
	}

	public void setUserArray(String userArray) {
		this.userArray = userArray;
	}

	public boolean isJudge() {
		return judge;
	}

	public void setJudge(boolean judge) {
		this.judge = judge;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public SetOneQuestionPage() {
		init();
	}

	public void init() {
		ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		question = (Question) session.get("aQuestion");

		this.setQuestionType((int) session.get("questionType"));


		User user = new User();
		user = (User) session.get("user");
		this.setUserId(user.getId());
		

	}

	public String setAquestion() {
		Question mQuestion = this.getQuestion();
		String questionType = mQuestion.getQuestionType();
		if (questionType.equals("ShapeClac")) {
			ShapeClacQuestion shapeClacQuestion = (ShapeClacQuestion) question;
			shapeClacQuestion.setAreaAnswer(this.getArea());
			shapeClacQuestion.setPerimeterAnswer(this.getPerimeter());
		} else if (questionType.equals("ShapeJudge")) {
			ShapeJudgeQuestion shapeJudgeQuestion = (ShapeJudgeQuestion) question;
			shapeJudgeQuestion.setJudge(this.isJudge());
		} else {
			SortQuestion sortQuestion = (SortQuestion) question;
			int[] arrayNum = new int[10];
			String[] string = this.getUserArray().split(" ");
			for (int i = 0; i < string.length; i++) {
				arrayNum[i] = Integer.parseInt(string[i]);
				System.out.println("!!!!!!!!!!!!!" + arrayNum[i]);
			}
			sortQuestion.setUserAnswerList(arrayNum);
		}

		QuestionDao dao = new QuestionDaoImpl();

		Questions questions = new Questions();
		questions.setQuestionBelonged(this.getUserId());
		questions.setQuestionIsRight(this.getQuestion().getAnswerInfo());
		questions.setQuestionName(this.getQuestion().getQuestionString());
		questions.setQuestionRightDescription(this.getQuestion()
				.getRightAnswerString());
		questions.setQuestionUserDescription(this.getQuestion()
				.getAnsewerString());
		questions.setQusetionType(this.getQuestionType());

		dao.insert(questions);
		return SUCCESS;
	}
}
