package com.team_06.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team_06.dao.UserDao;
import com.team_06.entity.User;
import com.team_06.util.DBUtil;

/**
 * 用户操作实现类
 * 
 * @author swl979623074
 * 
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User Login(String loginname, String passworld) {
		// TODO Auto-generated method stub
		String sql = "select id,user_loginname,user_passworld from user where user_loginname=? and user_passworld=?";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loginname);
			pstmt.setString(2, passworld);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				User user = new User();
				user.setId(id);
				user.setUserLoginname(loginname);
				user.setUserPassworld(passworld);
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		String sql = " insert into user (user_loginname,user_passworld) VALUES (?,?)";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUserLoginname());
			pstmt.setString(2, user.getUserPassworld());

			if (pstmt.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return false;
	}

	@Override
	public boolean delete(String loginname, String passworld) {
		// TODO Auto-generated method stub
		String sql = " delete FROM  user where user_loginname=? and user_passworld=?";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loginname);
			pstmt.setString(2, passworld);
			if (pstmt.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return false;
	}
}
