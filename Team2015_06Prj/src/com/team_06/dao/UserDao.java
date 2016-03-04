package com.team_06.dao;

import com.team_06.entity.User;

public interface UserDao {
	/**
	 * �û���¼����
	 * 
	 * @param user
	 * @return ���ص�¼�˺ŵ���Ϣ
	 */
	public User Login(String loginname, String passworld);

	/**
	 * ע���û�����
	 * 
	 * @param user
	 * @return ���ص�ע��ŵ���Ϣ
	 */
	public boolean insert(User user);

	/**
	 * ɾ�������٣��û���Ϣ
	 * 
	 * @param user
	 * @return ���ر�ɾ����ŵ���Ϣ
	 */
	public boolean delete(String loginname, String passworld);
}
