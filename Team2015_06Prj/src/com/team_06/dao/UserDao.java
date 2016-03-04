package com.team_06.dao;

import com.team_06.entity.User;

public interface UserDao {
	/**
	 * 用户登录功能
	 * 
	 * @param user
	 * @return 返回登录账号的信息
	 */
	public User Login(String loginname, String passworld);

	/**
	 * 注册用户功能
	 * 
	 * @param user
	 * @return 返回登注册号的信息
	 */
	public boolean insert(User user);

	/**
	 * 删除（销毁）用户信息
	 * 
	 * @param user
	 * @return 返回被删除册号的信息
	 */
	public boolean delete(String loginname, String passworld);
}
