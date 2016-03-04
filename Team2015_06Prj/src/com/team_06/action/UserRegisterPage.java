package com.team_06.action;

import com.opensymphony.xwork2.ActionSupport;
import com.team_06.dao.UserDao;
import com.team_06.dao.impl.UserDaoImpl;
import com.team_06.entity.User;

@SuppressWarnings("serial")
public class UserRegisterPage extends ActionSupport {

	/**
	 * �û���ע���˺�
	 */
	private String userLoginName;
	private String repetitionPassWorld;
	/**
	 * �û���ע�������
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
	 * �û���ע��
	 * 
	 * @return �ַ���
	 */
	public String Register() {

		UserDao dao = new UserDaoImpl();
		User user = new User();
		user = dao.Login(getUserLoginName(), getUserPassWorld());
		if (user != null) {
			addActionError("�û����Ѿ���ע�ᣬ����������!");
			return ERROR;
		} else{
			User mUser = new User();
			mUser.setUserLoginname(getUserLoginName());
			mUser.setUserPassworld(getUserPassWorld());

			boolean act = dao.insert(mUser);
			if (act == true) {
				return SUCCESS;
			} else {
				addActionError("ע��ʧ��!");
				return ERROR;
			}
		}

	}
}