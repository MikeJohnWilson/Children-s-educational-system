package test.team_06.action.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import com.team_06.action.UserLoginPage;

import com.opensymphony.xwork2.ActionContext;

public class UerLoginPageTest {
	public ActionContext ctx;
	UserLoginPage testObj;

	@Before
	public void setUp() throws Exception {
	    ctx =mock( ActionContext.class);
	    Map<String, Object> session = new HashMap<String, Object>();
	    when(ctx.getSession()).thenReturn(session);
	   
	    
	    testObj = new UserLoginPage(){
	    public void Init()
	    {
	    	this.setCtx(ctx);
	    }
	    };
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testLogin_01() {
		    testObj.setUserLoginName("20131309");
		    testObj.setUserPassWorld("ws19950625");
		    
		    testObj.setCtx(ctx);
		    String act = testObj.Login();
		    String exp="error";
		    assertEquals(exp,act);
		    
	}

	@Test
	public void testLogin_02() {

		    testObj.setUserLoginName("yby");
		    testObj.setUserPassWorld("123");
		    
		    testObj.setCtx(ctx);
		    String act = testObj.Login();
		    String exp="success";
		    assertEquals(exp,act);	    
	}
	@Test
	public void testRegister()
	{
		String expStr = "Register";
		String actStr = testObj.Register();
		assertEquals(expStr,actStr);
		
	}

}
