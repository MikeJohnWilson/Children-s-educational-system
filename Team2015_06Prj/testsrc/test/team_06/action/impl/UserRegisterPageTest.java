package test.team_06.action.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team_06.action.UserRegisterPage;
import com.team_06.dao.UserDao;
import com.team_06.dao.impl.UserDaoImpl;

public class UserRegisterPageTest {
	UserRegisterPage mtestObj;

	@Before
	public void setUp() throws Exception {
		mtestObj = new UserRegisterPage();						
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 *用户名为空 
	 */
	@Test
	public void testRegister_one() {
		//fail("Not yet implemented");
		mtestObj.setUserLoginName("yby");
		mtestObj.setUserPassWorld("123");
		String expStr = "error";
		String actStr = mtestObj.Register();
		assertEquals(expStr,actStr);
		
	}
	/**
	 *密码为空 
	 */
	@Test
	public void testRegister_two() {
		//fail("Not yet implemented");

		UserDao dao = new UserDaoImpl();
		dao.delete("zhw1", "123");
		mtestObj.setUserLoginName("zhw1");
		mtestObj.setUserPassWorld("123");
		String expStr = "success";
		String actStr = mtestObj.Register();
	
		assertEquals(expStr,actStr);
	
	}
	/**
	 * 密码和用户名都为空
	 */
	@Test
	public void testRegister_three() {
		//fail("Not yet implemented");
		mtestObj.setUserLoginName("");
		mtestObj.setUserPassWorld("");
		mtestObj.setRepetitionPassWord("testtestte");
		
	}
	/**
	 *再次输入的密码不匹配
	 */
	@Test
	public void testRegister_four() {
		//fail("Not yet implemented");
		mtestObj.setUserLoginName("aaaaaaaaaa");
		mtestObj.setUserPassWorld("test");
		mtestObj.setRepetitionPassWord("test");
		
	}


}
