package com.team_06.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.team_06.dao.QuestionDao;
import com.team_06.entity.QuestionType;
import com.team_06.entity.Questions;
import com.team_06.util.DBUtil;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public boolean insert(Questions question) {
		// TODO Auto-generated method stub
		boolean success = false;
		String sql = "insert into question (que_type,que_name,que_rightanswer,que_useranswer,que_isright,que_belonged,que_rightanswerdescription,que_useranswerdescription) VALUES (?,?,?,?,?,?,?,?)";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		if(conn!=null)
		{
		try {
		
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, question.getQusetionType());
			pstmt.setString(2, question.getQuestionName());
			pstmt.setString(3, question.getQuestionRightAnswer());
			pstmt.setString(4, question.getQuestionUserAnswer());
			pstmt.setString(5, question.getQuestionIsRight());
			pstmt.setInt(6, question.getQuestionBelonged());
			pstmt.setString(7, question.getQuestionRightDescription());
			pstmt.setString(8, question.getQuestionUserDescription());

			if (pstmt.executeUpdate() > 0) // @auther zhw 修改返回形式，如果直接返回，数据库无法关闭
				success = true;
			else
				success = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		}
		System.out.println("QuestionDao insert");
		return success;
	}

	@Override
	public List<Questions> selectUserDid(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from question where que_belonged=?";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();

		List<Questions> questionList = new ArrayList<Questions>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int type = rs.getInt(2);
				String name = rs.getString(3);
				String rightAnswer = rs.getString(4);
				String userAnswer = rs.getString(5);
				String isRight = rs.getString(6);
				int belonged = rs.getInt(7);
				String rightDescription = rs.getString(8);
				String userDescription = rs.getString(9);

				Questions question = new Questions();

				question.setId(id);
				question.setQusetionType(type);
				question.setQuestionName(name);
				question.setQuestionRightAnswer(rightAnswer);
				question.setQuestionUserAnswer(userAnswer);
				question.setQuestionIsRight(isRight);
				question.setQuestionBelonged(belonged);
				question.setQuestionRightDescription(rightDescription);
				question.setQuestionUserDescription(userDescription);

				questionList.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return questionList;
	}

	@Override
	public int getNumOfUserDid(int userId) {
		// TODO Auto-generated method stub

		List<Questions> questionList = new ArrayList<Questions>();
		questionList = selectUserDid(userId);

		return questionList.size();
	}

	@Override
	public List<QuestionType> getUserDidQuestionType(int userId) {
		// TODO Auto-generated method stub
		String sqls = "select distinct que_type from question where que_belonged=?";
		DBUtil utils = new DBUtil();
		Connection conns = utils.openConnection();
		int[] newArray = new int[100];
		try {
			PreparedStatement pstmts = conns.prepareStatement(sqls);
			pstmts.setInt(1, userId);
			
			ResultSet rss = pstmts.executeQuery();
			int key=0;
			while(rss.next()){
				newArray[key]=rss.getInt(1);
				key++;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			utils.closeConn(conns);
		}

		List<QuestionType> questionTypeList = new ArrayList<QuestionType>();
		String sql = "select * from questiontype";// 注意在测试这个函数的时候发现一个bug,问题显示数据库表没有显示
		DBUtil util = new DBUtil(); // 果然questionTypr这个表不存在，
									// 显然是逗比队友坑我，所以改成了
									// questionType
		Connection conn = util.openConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				for (int i = 0; i < newArray.length; i++) {
					if (newArray[i] != 0 && newArray[i] == id) {
						String type = rs.getString(2);

						QuestionType questionType = new QuestionType();

						questionType.setId(id);
						questionType.setQuestionTypeName(type);

						questionTypeList.add(questionType);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return questionTypeList;
	}
}
