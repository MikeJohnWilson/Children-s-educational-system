package com.team_06.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team_06.dao.QuestionTypeDao;
import com.team_06.entity.QuestionType;
import com.team_06.util.DBUtil;

public class QuestionTypeDaoImpl implements QuestionTypeDao {

	@Override
	public QuestionType select(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from questiontype where id=?";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String typeName = rs.getString(2);

				QuestionType questionType = new QuestionType();

				questionType.setId(id);
				questionType.setQuestionTypeName(typeName);

				return questionType;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}

	@Override
	public boolean insert(QuestionType questionType) {
		// TODO Auto-generated method stub
		String sql = "insert into questiontype (id,qutp_name) VALUES (?,?)";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionType.getId());
			pstmt.setString(2, questionType.getQuestionTypeName());

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
	public List<QuestionType> getAllType() {
		// TODO Auto-generated method stub
		List<QuestionType> questionTypeList = new ArrayList<QuestionType>();
		String sql = "select * from questiontype";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { // 注意此处有修改，将原来的if（rs.next()）改成了while
				int id = rs.getInt(1); // 语句，这个实在测试中find的bug
										// 时间25/9/5/:16/41 @author 郑宏伟
				String typeName = rs.getString(2);

				QuestionType questionType = new QuestionType();

				questionType.setId(id);
				questionType.setQuestionTypeName(typeName);

				questionTypeList.add(questionType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return questionTypeList;
	}

}
