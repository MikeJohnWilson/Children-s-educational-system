package test.team_06.action.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.text.DecimalFormat;
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
import com.team_06.action.SetOneQuestionPage;
import com.team_06.question.Question;
import com.team_06.shapecalc.impl.RectangleQuestionImpl;
import com.team_06.shapejudge.impl.TriangleJudgeQuestionImpl;
import com.team_06.sort.impl.FindExtremeQuestionImpl;
import com.team_06.sort.impl.GetNumQuestionImpl;

public class SetOneQuestionPageTest {

	SetOneQuestionPage mtestObj;
	public ActionContext ctx;

	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		ctx = mock(ActionContext.class);
		Map<String, Object> session = new HashMap<String, Object>();
		when(ctx.getSession()).thenReturn( session);
		
	    mtestObj = new SetOneQuestionPage(){			
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
	public void testSetAQuestion_one() {		
		mtestObj.setCtx(ctx);
		RectangleQuestionImpl expquestion = new RectangleQuestionImpl();
		mtestObj.setQuestion(expquestion);
		String expString = "success";
		String actString = mtestObj.setAquestion();
	    Assert.assertEquals(expString,actString);
	}
	@Test
	public void testSetAQuestion_two()
	{
		TriangleJudgeQuestionImpl expquestion = new TriangleJudgeQuestionImpl();
		mtestObj.setQuestion(expquestion);
		String expString = "success";
		String actString = mtestObj.setAquestion();
	    Assert.assertEquals(expString,actString);
	}
	@Test
	public void testSetAQuestion_three()
	{
		FindExtremeQuestionImpl expquestion = new FindExtremeQuestionImpl();
		mtestObj.setQuestion(expquestion);
		String userArray = "1 2 3 4";
		mtestObj.setUserArray(userArray);
		String expString = "success";
		String actString = mtestObj.setAquestion();
	    Assert.assertEquals(expString,actString);
	}

}
