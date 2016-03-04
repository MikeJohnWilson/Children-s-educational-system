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
	 * �û���id��
	 */
	int userId;
	/**
	 * �û���������Ŀ����
	 */
	int userDidNum;
	/**
	 * ���ݿ��ִ��ڵ�������������
	 */
	List<QuestionType> questionAllTypeList;
	/**
	 * �û�������������������
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
	 * ��ʼ�� ��ȡ�û���id
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
	 * ��ȡϵͳ���ڵ���Ŀ����
	 * 
	 * @return List�б�
	 */
	public List<QuestionType> getQuestionTypeList() {
		questionAllTypeList = new ArrayList<QuestionType>();

		QuestionTypeDao dao = new QuestionTypeDaoImpl();
		questionAllTypeList = dao.getAllType();
		return questionAllTypeList;
	}

	/**
	 * ��ȡ�û����������������Ŀ����
	 * 
	 * @return List�б�
	 */
	public List<QuestionType> getQuestionTypeUserDid() {
		questionUserTypeList = new ArrayList<QuestionType>();

		QuestionDao dao = new QuestionDaoImpl();
		questionUserTypeList = dao.getUserDidQuestionType(getUserId());

		return questionUserTypeList;
	}

	/**
	 * ��ȡ�û���������Ŀ����
	 * 
	 * @return �ַ���
	 */
	public String getNumOfUserDid() {
		QuestionDao dao = new QuestionDaoImpl();
		userDidNum = dao.getNumOfUserDid(getUserId());
		return String.valueOf(userDidNum);
	}
}
