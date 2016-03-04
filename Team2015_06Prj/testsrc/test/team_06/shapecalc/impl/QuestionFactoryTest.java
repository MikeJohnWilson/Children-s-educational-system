package test.team_06.shapecalc.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team_06.question.Question;
import com.team_06.shapecalc.impl.QuestionFactory;
import com.team_06.shapecalc.impl.TriangleQuestionImpl;

public class QuestionFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcreateQuestion() {
		//fail("Not yet implemented");
		int i;
		String exp[]={ "","ShapeClac","ShapeClac","ShapeClac","SortNum","SortNum","ShapeJudge"};
		for(i=1;i<=6;i++)
		{
		QuestionFactory factory= new QuestionFactory();
		String acttype=factory.createQuestion(i).getQuestionType();
		assertEquals(exp[i], acttype);
		}
	}
	
	@Test
	public void testCreateQuestion() {
		//fail("Not yet implemented");
		int i;
		String type[]={"","Triangle","Rectangle","Circle","Sort","Find","TriangleJudge"};
		String exp[]={ "","ShapeClac","ShapeClac","ShapeClac","SortNum","SortNum","ShapeJudge"};
		for(i=1;i<=6;i++)
		{
		    QuestionFactory factory= new QuestionFactory();
		    String acttype=factory.CreateQuestion(type[i]).getQuestionType();
		   assertEquals(exp[i], acttype);
		}
	}
	
	@Test
	public void testgetQuestionTypeId() {
		//fail("Not yet implemented");
		int i;
		String type[]={"","class com.team_06.shapecalc.impl.TriangleQuestionImpl","class com.team_06.shapecalc.impl.RectangleQuestionImpl","class com.team_06.shapecalc.impl.CircleQuestionImpl","class com.team_06.shapecalc.impl.SortQuestionImpl","class com.team_06.shapecalc.impl.FindExtremeQuestionImpl","class com.team_06.question.IShapeJudgeQusition.TriangleJudgeQuestionImpl"};
		for(i=1;i<=6;i++)
		{
		QuestionFactory factory= new QuestionFactory();
		int acttype=factory.getQuestionTypeId(type[i]);
		assertEquals(i, acttype);
		}
	}
		
}
