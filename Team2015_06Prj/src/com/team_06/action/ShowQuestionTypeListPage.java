package com.team_06.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.team_06.dao.QuestionDao;
import com.team_06.dao.QuestionTypeDao;
import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.dao.impl.QuestionTypeDaoImpl;
import com.team_06.entity.QuestionType;
import com.team_06.entity.User;

public class ShowQuestionTypeListPage extends ActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户的id；
	 */
	int userId;
	/**
	 * 用户做过的题目数量
	 */
	int userDidNum;
	/**
	 * 数据库种存在的所有问题类型
	 */
	List<QuestionType> questionAllTypeList;
	/**
	 * 用户做过的所有问题类型
	 */
	List<QuestionType> questionUserTypeList;

	ActionContext ctx;

	public int getUserDidNum() {
		return userDidNum;
	}

	public void setUserDidNum(int userDidNum) {
		this.userDidNum = userDidNum;
	}

	public List<QuestionType> getQuestionAllTypeList() {
		return questionAllTypeList;
	}

	public void setQuestionAllTypeList(List<QuestionType> questionAllTypeList) {
		this.questionAllTypeList = questionAllTypeList;
	}

	public List<QuestionType> getQuestionUserTypeList() {
		return questionUserTypeList;
	}

	public void setQuestionUserTypeList(List<QuestionType> questionUserTypeList) {
		this.questionUserTypeList = questionUserTypeList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

	public ShowQuestionTypeListPage() {
		Init();
	}

	/**
	 * 初始化 获取用户的id
	 */
	public void Init() {
		ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		User user = new User();
		user = (User) session.get("user");
		setUserId(user.getId());
	}

	/**
	 * return success
	 */
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		getQuestionTypeList();
		getQuestionTypeUserDid();
		getNumOfUserDid();
		return SUCCESS;
	}

	/**
	 * 获取系统存在的题目类型
	 * 
	 * @return List列表
	 */
	public List<QuestionType> getQuestionTypeList() {
		questionAllTypeList = new ArrayList<QuestionType>();

		QuestionTypeDao dao = new QuestionTypeDaoImpl();
		questionAllTypeList = dao.getAllType();
		return questionAllTypeList;
	}

	/**
	 * 获取用户做过的题的所有题目类型
	 * 
	 * @return List列表
	 */
	public List<QuestionType> getQuestionTypeUserDid() {
		questionUserTypeList = new ArrayList<QuestionType>();

		QuestionDao dao = new QuestionDaoImpl();
		questionUserTypeList = dao.getUserDidQuestionType(getUserId());

		return questionUserTypeList;
	}

	/**
	 * 获取用户做过的题目数量
	 * 
	 * @return 字符串
	 */
	public String getNumOfUserDid() {
		QuestionDao dao = new QuestionDaoImpl();
		userDidNum = dao.getNumOfUserDid(getUserId());
		return String.valueOf(userDidNum);
	}
}
