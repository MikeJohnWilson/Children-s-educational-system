package test.team_06.dao.imp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.dbunit.Assertion;
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

import com.mysql.jdbc.Connection;
import com.team_06.dao.impl.UserDaoImpl;
import com.team_06.entity.User;

public class UserDaoImplTest extends DBTestCase {

	UserDaoImpl mUserDaoImpl;
	User mUser;
	Connection mDBconn = null;
	IDatabaseConnection mDBUnitconnection = null;
	File mfile;
	
	
	@Before
	public void setUp() throws Exception {
		mUserDaoImpl = new UserDaoImpl();
		mDBconn = null;
		mDBUnitconnection = null;		
		//本例使用mysql数据库 
		Class.forName("com.mysql.jdbc.Driver");
		//连接DB 
		mDBconn= (Connection) DriverManager.getConnection(
				"jdbc:mysql://10.10.10.59:3308/Team2015_06PrjDB?","root", "123456");
		//获得DB连接
		mDBUnitconnection = new DatabaseConnection(mDBconn);

		DatabaseConfig config = mDBUnitconnection.getConfig();  
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());  

		//对数据库中的操作对象表usertbl进行备份
		QueryDataSet backupDataSet = new QueryDataSet(mDBUnitconnection);
		backupDataSet.addTable("user");
		mfile = File.createTempFile("user_back",".xml",new File("./xml/"));//备份文件
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
    public void testLogin_one(){
    	String userName = "test";
    	String userPassword = "test";
    	boolean exp = true;
    	User actUser = mUserDaoImpl.Login(userName, userPassword);
    	boolean act = true;
    	if(actUser==null)
    		act = false;
    	Assert.assertEquals(exp,act);
    	
    	
    }
    @Test
    public void testLogin_two(){
    	String userName = "test";
    	String userPassword = "123";
    	boolean exp = false;
    	User actUser = mUserDaoImpl.Login(userName, userPassword);
    	boolean act = true;
    	if(actUser==null)
    		act = false;
    	Assert.assertEquals(exp,act);
    }
    
    @Test
    public void testdelete() throws FileNotFoundException, IOException, DatabaseUnitException, SQLException{
    	
		mUserDaoImpl.delete("test","test");
        String[] filters = new String[]{"id"};
			
	    @SuppressWarnings("deprecation")
	    IDataSet expDataSet = new FlatXmlDataSet(new FileInputStream("./xml/expTableDEL.xml"));
	        
	    ITable expTable = DefaultColumnFilter.excludedColumnsTable( expDataSet.getTable("user"), filters);
		QueryDataSet  actDataSet = new QueryDataSet(mDBUnitconnection);
	    actDataSet.addTable("user");
	    
	    ITable actTable = DefaultColumnFilter.excludedColumnsTable(actDataSet.getTable("user"), filters);
	  //  Assertion.assertEquals(expTable,actTable);
		
	
		
    }
    
    @Test
	public void testInsert() throws FileNotFoundException, IOException, SQLException, DatabaseUnitException 
	{
		
		User user = new User();
		user.setUserLoginname("zhenghongwei");;
		user.setUserPassworld("tongluren");
		mUserDaoImpl.insert(user);
		String[] filters = new String[]{"id"};
	    @SuppressWarnings("deprecation")
		IDataSet expDataSet = new FlatXmlDataSet(new FileInputStream("./xml/expTableINS.xml"));      
		 ITable expTable = DefaultColumnFilter.excludedColumnsTable( expDataSet.getTable("user"), filters);
		 QueryDataSet  actDataSet = new QueryDataSet(mDBUnitconnection);
         actDataSet.addTable("user");   
	  ITable actTable = DefaultColumnFilter.excludedColumnsTable(actDataSet.getTable("user"), filters);
		 //   Assertion.assertEquals(expTable,actTable);
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
