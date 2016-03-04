package test.team_06.action.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.opensymphony.xwork2.ActionContext;
import com.team_06.action.GetOneQuestionPage;
import com.team_06.action.ShowQuestionAnswerPage;
import com.team_06.dao.QuestionDao;
import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.dao.impl.UserDaoImpl;
import com.team_06.entity.Questions;
import com.team_06.entity.User;
import com.team_06.util.DBUtil;

public class ShowQuestionAnswerPageTest {
	
	public ActionContext mctx;
	ShowQuestionAnswerPage mtestObj;
	UserDaoImpl mUserDaoImpl;
	User mUser;
	Connection mDBconn = null;
	IDatabaseConnection mDBUnitconnection = null;
	File mfile;
	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		mctx = mock(ActionContext.class);
		Map<String, Object> session = new HashMap<String, Object>();
		when(mctx.getSession()).thenReturn( session);
		
	    mtestObj = new ShowQuestionAnswerPage(){			
			public void Init()
			{
				 this.setCtx(mctx);
			} 
		};
		mUserDaoImpl = new UserDaoImpl();
		mDBconn = null;
		mDBUnitconnection = null;		
		//����ʹ��mysql���ݿ� 
		Class.forName("com.mysql.jdbc.Driver");
		//����DB 
		mDBconn= (Connection) DriverManager.getConnection(
				"jdbc:mysql://10.10.10.59:3308/Team2015_06PrjDB?","root", "123456");
		//���DB����
		mDBUnitconnection = new DatabaseConnection(mDBconn);

		DatabaseConfig config = mDBUnitconnection.getConfig();  
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());  

		//�����ݿ��еĲ��������usertbl���б���
		QueryDataSet backupDataSet = new QueryDataSet(mDBUnitconnection);
		backupDataSet.addTable("question");
		mfile = File.createTempFile("user_back",".xml",new File("./xml/"));//�����ļ�
		FlatXmlDataSet.write(backupDataSet,new FileOutputStream(mfile));
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() throws Exception {
		
		IDataSet dataSet = new FlatXmlDataSet(mfile);
		DatabaseOperation.CLEAN_INSERT.execute(mDBUnitconnection,dataSet);
		if(mDBconn != null)
		    mDBconn.close();
	}
	private int getMaxIdFromQuestion() throws SQLException{
	    int maxId = 0;
		String sql = "select max(id) from question";
		DBUtil util = new DBUtil();
		Connection conn = (Connection) util.openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			maxId = rs.getInt(1);
			String s = String.valueOf(maxId);
	    	System.out.println("max id is: " + s);
		}
		return maxId;
	}
	 private Questions insertExpQuestion(int userId,int Id,int queType){
			
		QuestionDaoImpl mquestionDaoImpl = new QuestionDaoImpl();
		Questions question = new Questions();
		question.setId(Id);
		question.setQuestionBelonged(userId);
		question.setQuestionIsRight("test");
		question.setQuestionName("test");
		question.setQuestionRightAnswer("test");
		question.setQuestionRightDescription("test");
		question.setQuestionUserAnswer("test");
		question.setQuestionUserDescription("test");
		question.setQusetionType(queType);
		mquestionDaoImpl.insert(question);
		System.out.println("expQuestion: id = " + Id + " UserId = " + userId);
		return question;
	}
	@Test
	public void testGetAnswer() throws SQLException {
		    //fail("Not yet implemented");
		int userId = mtestObj.getUserId();
		int queType = 3;
		int MaxId = getMaxIdFromQuestion();  //�����ݿ��ȡ��ǰ��������id��
	    Questions expQuestion = insertExpQuestion(userId,++MaxId,queType);//����һ��Ԥ�ڵõ����Һ͵�ǰ�û����������⣬���Ҳ��뵽���ݿ���
	    
	    Questions actQuestion = mtestObj.getAnswer();  
	    String actName = actQuestion.getQuestionName();
	    String expName = expQuestion.getQuestionName();
	    Assert.assertEquals(expName,actName);
			
	}
	@Test
	public void testExcute()
	{
		String expStr = "success";
		String actStr = mtestObj.execute();
		assertEquals(expStr,actStr);
	}

}
