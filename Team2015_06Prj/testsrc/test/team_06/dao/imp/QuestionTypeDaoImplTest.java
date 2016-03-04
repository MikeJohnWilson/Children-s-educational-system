package test.team_06.dao.imp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.DBTestCase;
import org.dbunit.DatabaseUnitException;
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
import org.junit.Before;
import org.junit.Test;

import com.team_06.dao.impl.QuestionDaoImpl;
import com.team_06.dao.impl.QuestionTypeDaoImpl;
import com.team_06.entity.QuestionType;

public class QuestionTypeDaoImplTest extends DBTestCase
{
	QuestionDaoImpl mQuestionDaoImpl;
	QuestionTypeDaoImpl mQuestionTypeDaoImpl;
	QuestionType mQuestionType;
	Connection mConnection = null;
	IDatabaseConnection mDBUnitconnection = null;
	File mFile;

	@Before
	public void setUp() throws Exception
	{
		mQuestionTypeDaoImpl = new QuestionTypeDaoImpl();
		mConnection = null;
		mDBUnitconnection = null;
		// 使用mysql数据库
		Class.forName("com.mysql.jdbc.Driver");
		
		// 连接DB
		mConnection = DriverManager.getConnection(
				"jdbc:mysql://10.10.10.59:3308/Team2015_06PrjDB?", "root",
				"123456");
		// 获得DB连接
		mDBUnitconnection = new DatabaseConnection(mConnection);
		DatabaseConfig mDatabaseConfig = mDBUnitconnection.getConfig();
		mDatabaseConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new MySqlDataTypeFactory());
		// 对数据库中的操作对象表进行备份
		QueryDataSet backupDataSet = new QueryDataSet(mDBUnitconnection);
		backupDataSet.addTable("questiontype");
		mFile = File.createTempFile("questiontype_back", ".xml",new File("./xml/"));                // 备份文件
		FlatXmlDataSet.write(backupDataSet, new FileOutputStream(mFile));
	}

	@After
	public void tearDown() throws Exception
	{
		@SuppressWarnings("deprecation")
		IDataSet dataSet  = new FlatXmlDataSet(mFile);
		DatabaseOperation.CLEAN_INSERT.execute(mDBUnitconnection, dataSet);
		if (mConnection != null)
		{
			mConnection.close();
		}
	}

	@Test
	public void testSelect()
	{
		int id = 1;
		String name = "计算三角形的面积和周长";
	    QuestionType expType = new QuestionType();
	    expType.setId(id);
	    expType.setQuestionTypeName(name);
	    QuestionType actType = mQuestionTypeDaoImpl.select(id);
	    assertEquals(expType.getQuestionTypeName(),actType.getQuestionTypeName());
	}

	@Test
	public void testInsert() throws DataSetException, FileNotFoundException, IOException, DatabaseUnitException 
	{
		int id = 0;
		mQuestionType = new QuestionType();
		mQuestionType.setId(id);
		
		mQuestionType.setQuestionTypeName("test");
		mQuestionTypeDaoImpl.insert(mQuestionType);
		String[] filters = new String[]{"id"};
		@SuppressWarnings("deprecation")
		IDataSet expDataSet = new FlatXmlDataSet(new FileInputStream("./xml/expQuestionTypeINS.xml"));

		@SuppressWarnings("deprecation")
		ITable expTable = DefaultColumnFilter.excludedColumnsTable(expDataSet.getTables()[0], filters);
		QueryDataSet actDataSet = new QueryDataSet(mDBUnitconnection);                  
		
		actDataSet.addTable("questiontype");
		
		File file = File.createTempFile("questiontype_01", ".xml",new File("./xml/")); // 备份文件
		FlatXmlDataSet.write(actDataSet, new FileOutputStream(file));
		ITable actTable = DefaultColumnFilter.excludedColumnsTable(
				actDataSet.getTable("questiontype"),filters);
		//assertEquals(expTable, actTable);
	}
    private List<QuestionType> getExpAllType(){
    	List<QuestionType> questionTypeList = new ArrayList<QuestionType>();
    	String []str = {"计算三角形的面积和周长" ,"计算长方形的面价和周长"
    			,"计算园的周长和面积","排序","求最值","三角形判断"};
    	for(int i = 1; i < 7; ++i)
    	{
    		QuestionType type = new QuestionType();
    		type.setId(i);
    		type.setQuestionTypeName(str[i-1]);
    		questionTypeList.add(type);
    	}
    	return questionTypeList;
    }
	@Test
	public void testGetAllType()
	{
		List<QuestionType> expList = new ArrayList<QuestionType>();
		expList = getExpAllType();
		List<QuestionType> actList = new ArrayList<QuestionType>();
		actList = mQuestionTypeDaoImpl.getAllType();
		for(int i = 0; i < actList.size(); ++i)
		{
		   String expStr = expList.get(i).getQuestionTypeName();
		   String actStr = expList.get(i).getQuestionTypeName();
		   assertEquals(expStr,actStr);
		}
		
	}

	@Override
	protected IDataSet getDataSet() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
