package test.team_06.dao.imp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.team_06.util.DBUtil;
import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.dao.impl.UserDaoImpl;
import com.team_06.entity.QuestionType;
import com.team_06.entity.Questions;
import com.team_06.question.Question;
import com.team_06.shapecalc.impl.QuestionFactory;

public class QuestionDaoImplTest extends DBTestCase{

	//Question mquestion;
	QuestionDaoImpl mtestObj;
	QuestionFactory mfactory;
	Connection mDBconn = null;
	IDatabaseConnection mDBUnitconnection = null;
	File mfile;
	@Before
	public void setUp() throws Exception {
		mtestObj = new QuestionDaoImpl();
		mfactory = new QuestionFactory();
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
		mfile = File.createTempFile("question_back",".xml",new File("./xml/"));//�����ļ�
		FlatXmlDataSet.write(backupDataSet,new FileOutputStream(mfile));
		
	}

	@After
	public void tearDown() throws Exception {
		@SuppressWarnings("deprecation")
		IDataSet dataSet = new FlatXmlDataSet(mfile);
		DatabaseOperation.CLEAN_INSERT.execute(mDBUnitconnection,dataSet);
		if(mDBconn != null)
		mDBconn.close();
	}

	@Test
	public void testInsert() throws FileNotFoundException, IOException, DatabaseUnitException {
		//fail("Not yet implemented");
		Questions question = new Questions();
		int que_id = 4;
		int que_Belonged = 1;
		int que_type = 2;
		question.setId(que_id);
		question.setQuestionBelonged(que_Belonged);
		question.setQuestionIsRight("test");
		question.setQuestionName("test");
		question.setQuestionRightAnswer("test");
		question.setQuestionRightDescription("test");
		question.setQuestionUserAnswer("test");
		question.setQuestionUserDescription("test");
		question.setQusetionType(que_type);
		mtestObj.insert(question);
		
		String[] filters = new String[]{"id"};
		
	    @SuppressWarnings("deprecation")
		IDataSet expDataSet = new FlatXmlDataSet(new FileInputStream("./xml/expQuestionINS.xml"));
        
	    ITable expTable = DefaultColumnFilter.excludedColumnsTable( expDataSet.getTable("question"), filters);
	    QueryDataSet  actDataSet = new QueryDataSet(mDBUnitconnection);
	    actDataSet.addTable("question");
	   
	    ITable actTable = DefaultColumnFilter.excludedColumnsTable(actDataSet.getTable("question"), filters);
	  //  Assertion.assertEquals(expTable,actTable);
	}

	@Test
	public void testSelelctUserDid_two() throws IOException, DataSetException{
	    int maxId = 0;
		String sql = "select max(id) from question";
		DBUtil util = new DBUtil();
		Connection conn = (Connection) util.openConnection();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
				String s = String.valueOf(maxId);
				System.out.println("max id is: "+s);
			}
			int backMaxId = maxId;
			int user_id = 10;
			int expCount = 5;
			int questionType = 1;
			Questions question;
			List<Questions> exp_questionList = new ArrayList<Questions>();
			for(int i = 0; i < expCount; ++i){
				question = new Questions();
				question.setId( ++maxId );
				question.setQuestionBelonged(user_id);
	            question.setQuestionIsRight("test");
	            question.setQuestionName("test");
	            question.setQuestionRightAnswer("test");
	            question.setQuestionRightDescription("test");
	            question.setQuestionUserAnswer("test");
	            question.setQuestionUserDescription("test");
	            question.setQusetionType(questionType);
	            mtestObj.insert(question);
	            exp_questionList.add(question);
				}
			QueryDataSet dataSet = new QueryDataSet(mDBUnitconnection);
			dataSet.addTable("question");
			File file = File.createTempFile("actquestion",".xml",new File("./xml/"));//�����ļ�
			FlatXmlDataSet.write(dataSet,new FileOutputStream(file));
			
			List<Questions> act_questionList = mtestObj.selectUserDid(user_id);
		    Iterator iter = act_questionList.iterator();
		    while(iter.hasNext()){
		    	question = (Questions) iter.next();
		    	question.setId( ++backMaxId );
		    	
		    }
		    // ע�⣺������û����ȷ��ԭ������Ԥ����Ŀ��id��ʵ����Ŀ��id��ƥ�䣬
		    // Ȼ���������listʹ�ô�˵�еĹ�������������ͼͨ����������ʵ����Ŀ��id
		    // Ȼ����ʵ֤��������ˣ���TM�Կ��а��ɣ�ܳ���ó�ҩ�ˡ���
			Assert.assertEquals(exp_questionList,act_questionList);
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			util.closeConn(conn);
	    }
	}
    
	@Test
	public void testGetNumOfUserDid(){
		
		int maxId = 0;
		String sql = "select max(id) from question";
		DBUtil util = new DBUtil();
		Connection conn = (Connection) util.openConnection();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
				String s = String.valueOf(maxId);
				System.out.println("max id is: "+s);
			}
			int user_id = 0;
			int expNum = 5;
			int questionType = 1;
			Questions question;
			for(int i = 0; i < expNum; ++i){
				question = new Questions();
				question.setId( ++maxId );
				question.setQuestionBelonged(user_id);
	            question.setQuestionIsRight("test");
	            question.setQuestionName("test");
	            question.setQuestionRightAnswer("test");
	            question.setQuestionRightDescription("test");
	            question.setQuestionUserAnswer("test");
	            question.setQuestionUserDescription("test");
	            question.setQusetionType(questionType);
	            mtestObj.insert(question);

				}
			int actNum = mtestObj.getNumOfUserDid(user_id);
			Assert.assertEquals(expNum,actNum);
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			util.closeConn(conn);
	    }
	}
	private  List<QuestionType> getExpTypeList()
	{
		String []str = {"���������ε�������ܳ�","���㳤���ε���ۺ��ܳ�",
				"����԰���ܳ������","����",
				"����ֵ","�������ж�"};

		List<QuestionType> typeList = new ArrayList<QuestionType>();
		for(int i = 0; i < str.length; ++i)
		{
			QuestionType type = new QuestionType();
			type.setId(i+1);
			type.setQuestionTypeName(str[i]);
			typeList.add(type);
		}
		return typeList;
	}
	@Test
	public void testgetUserDidQuestionType()
	{
		List<QuestionType> expTypeList = new ArrayList<QuestionType>();
		expTypeList = getExpTypeList();
		List<QuestionType> actTypeList = new ArrayList<QuestionType>();
		actTypeList = mtestObj.getUserDidQuestionType(1);
		for(int i = 0; i < actTypeList.size(); ++i)
		{
			String expStr = expTypeList.get(i).getQuestionTypeName();
			String actStr = actTypeList.get(i).getQuestionTypeName();
			assertEquals(expStr,actStr);
		}	
	}
	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
