package com.team_06.entity;

public class User {
	/**
	 * 用户id
	 */
	int Id;
	/**
	 * 用户登录名
	 */
	String UserLoginname;
	/**
	 * 用户密码
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
