package com.team_06.entity;

public class User {
	/**
	 * �û�id
	 */
	int Id;
	/**
	 * �û���¼��
	 */
	String UserLoginname;
	/**
	 * �û�����
	 */
	String UserPassworld;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserLoginname() {
		return UserLoginname;
	}

	public void setUserLoginname(String userLoginname) {
		UserLoginname = userLoginname;
	}

	public String getUserPassworld() {
		return UserPassworld;
	}

	public void setUserPassworld(String userPassworld) {
		UserPassworld = userPassworld;
	}

}
