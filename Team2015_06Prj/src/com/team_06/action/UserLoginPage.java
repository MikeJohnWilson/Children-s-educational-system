package com.team_06.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.team_06.dao.UserDao;
import com.team_06.dao.impl.UserDaoImpl;
import com.team_06.entity.User;

@SuppressWarnings("serial")
public class UserLoginPage extends ActionSupport {

	/**
	 * �û��ĵ�¼�˺�
	 */
	private String userLoginName;
	/**
	 * �û��ĵ�¼����
	 */
	private String userPassWorld;
	/**
	 * Ҫ��¼���û�
	 */
	User user;

	private ActionContext ctx;
	public UserLoginPage(){
		Init();
	}
	
	public void Init(){
		ctx = ActionContext.getContext();
	}
	public void setCtx(ActionContext ctx){
		this.ctx=ctx;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserPassWorld() {
		return userPassWorld;
	}

	public void setUserPassWorld(String userPassWorld) {
		this.userPassWorld = userPassWorld;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �û���¼��action
	 * 
	 * @return �ַ���
	 */

	public String Login() {
		UserDao dao = new UserDaoImpl();
		user = new User();
		user = dao.Login(getUserLoginName(), getUserPassWorld());
		if (user != null) {
			Map<String, Object> session = ctx.getSession();
			session.put("user", user);
			return SUCCESS;
		} else {
			addActionError("�û��������ڻ������������������!");
			return ERROR;
		}
	}

	/**
	 * 2015/9/10 ���� ��¼��������
	 * 
	 * @return
	 */
	public String Register() {
		return "Register";
	}
}
