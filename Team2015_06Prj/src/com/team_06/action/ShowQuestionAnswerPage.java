package com.team_06.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.team_06.dao.QuestionDao;
import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.entity.Questions;
import com.team_06.entity.User;

@SuppressWarnings("serial")
public class ShowQuestionAnswerPage extends ActionSupport {

	/**
	 * �û���id
	 */
	int userId;
	/**
	 * ��Ҫ��ȡ���û����һ���ύ������Ĵ�
	 */
	Questions questions;

	ActionContext ctx;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

	/**
	 * ���캯��
	 */
	public ShowQuestionAnswerPage() {
		Init();
	}

	/**
	 * ��ʼ�� ��ȡ�û���id
	 */
	public void Init() {
		ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		User user = new User();
		user = (User) session.get("user");
		setUserId(user.getId());
	}

	@Override
	public String execute(){
		getAnswer();	
		return SUCCESS;
	}
	
	public Questions getAnswer() {
		List<Questions> questionsList = new ArrayList<Questions>();
		questions = new Questions();
		QuestionDao dao = new QuestionDaoImpl();
		questionsList = dao.selectUserDid(userId);
		questions = questionsList.get(questionsList.size() - 1);
		return questions;
	}
}
