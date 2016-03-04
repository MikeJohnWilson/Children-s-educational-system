package test.team_06.action.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.team_06.action.ToUserRegisterPage;

public class ToUserRegisterPageTest {

	ToUserRegisterPage mtestObj;
	@Before
	public void setUp() throws Exception {
	     mtestObj = new ToUserRegisterPage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	    String expstr = "register";
	    String actstr = mtestObj.execute();
	    Assert.assertEquals(expstr,actstr);
	}

}
