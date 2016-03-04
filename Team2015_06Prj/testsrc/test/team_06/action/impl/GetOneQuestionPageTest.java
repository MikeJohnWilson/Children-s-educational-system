package test.team_06.action.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.dbunit.database.IDatabaseConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.opensymphony.xwork2.ActionContext;
import com.team_06.action.GetOneQuestionPage;
import com.team_06.question.Question;
import com.team_06.shapecalc.impl.QuestionFactory;

public class GetOneQuestionPageTest {

	GetOneQuestionPage mtestObj;
	public ActionContext ctx;
	Connection mDBconn = null;
	IDatabaseConnection mDBUnitconnection = null;
	File mfile;

	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		ctx = mock(ActionContext.class);
		Map<String, Object> session = new HashMap<String, Object>();
		when(ctx.getSession()).thenReturn( session);
		
	    mtestObj = new GetOneQuestionPage(){			
			public void init()
			{
				 this.setCtx(ctx);
			} 
		};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExcute_one()
	{
		mtestObj.setCtx(ctx);
		int key = 1;
		String expType = "ShapeClac";	
		mtestObj.setQuestionType(key);
		String actType = mtestObj.execute();
		Assert.assertEquals(expType,actType);
	}
	@Test
	public void testExcute_two()
	{
		int key = 4;
		String expType = "SortNum";	
		mtestObj.setQuestionType(key);
		String actType = mtestObj.execute();
		Assert.assertEquals(expType,actType);
	}@Test
	public void testExcute_three()
	{
		int key = 6;
		String expType = "ShapeJudge";	
		mtestObj.setQuestionType(key);
		String actType = mtestObj.execute();
		Assert.assertEquals(expType,actType);
	}
	@Test
	public void testGetOneQuestion() {
		//fail("Not yet implemented");
		mtestObj.setCtx(ctx);
		Question expquestion ;
		QuestionFactory factory = new QuestionFactory();
		expquestion = factory.createQuestion(1);
		String expString = expquestion.getQuestionType();
		int type = 1;
		mtestObj.setQuestionType(type);
		mtestObj.getAquestion();
		Question actquestion = mtestObj.getaQuestion();
		String actString = actquestion.getQuestionType();
		Assert.assertEquals(expString,actString);
	}

}
