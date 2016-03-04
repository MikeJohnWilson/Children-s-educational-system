package com.team_06.action;

import com.opensymphony.xwork2.ActionSupport;
import com.team_06.dao.UserDao;
import com.team_06.dao.impl.UserDaoImpl;
import com.team_06.entity.User;

@SuppressWarnings("serial")
public class UserRegisterPage extends ActionSupport {

	/**
	 * 用户的注册账号
	 */
	private String userLoginName;
	private String repetitionPassWorld;
	/**
	 * 用户的注册的密码
	 */
	private String userPassWorld;

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

	public String getUserRepetitionPassWord() {
		return repetitionPassWorld;
	}

	public void setRepetitionPassWord(String repetitionPassWord) {
		this.repetitionPassWorld = repetitionPassWord;
	}

	/**
	 * 
	 * 用户的注册
	 * 
	 * @return 字符串
	 */
	public String Register() {

		UserDao dao = new UserDaoImpl();
		User user = new User();
		user = dao.Login(getUserLoginName(), getUserPassWorld());
		if (user != null) {
			addActionError("用户名已经被注册，请重新输入!");
			return ERROR;
		} else{
			User mUser = new User();
			mUser.setUserLoginname(getUserLoginName());
			mUser.setUserPassworld(getUserPassWorld());

			boolean act = dao.insert(mUser);
			if (act == true) {
				return SUCCESS;
			} else {
				addActionError("注册失败!");
				return ERROR;
			}
		}

	}
}