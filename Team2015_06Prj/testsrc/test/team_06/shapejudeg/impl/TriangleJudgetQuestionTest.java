package test.team_06.shapejudeg.impl;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.team_06.shapejudge.impl.TriangleJudgeQuestionImpl;


public class TriangleJudgetQuestionTest extends testShapeJudgeQuestion{

	TriangleJudgeQuestionImpl testobj;
	@Before
	public void setUp() throws Exception {
		testobj = new TriangleJudgeQuestionImpl();
		this.baseTestobj = (TriangleJudgeQuestionImpl) testobj;
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 三角形判定构造函数对应的测试函数
	 */
	@Test
	public void testTriangleJudegQuestionImpl_one() {
		//fail("Not yet implemented");
		
	    int expBorder_x = 10;
	    int expBorder_y = 10;
	    int expBorder_z = 10;
	    testobj = new TriangleJudgeQuestionImpl(10,10,10);
	    int actBorder_x = testobj.mBorder_x;
	    int actBorder_y = testobj.mBorder_y;
	    int actBorder_z = testobj.mBorder_z;
        Assert.assertEquals(expBorder_x,actBorder_x);
        Assert.assertEquals(expBorder_y,actBorder_y);
        Assert.assertEquals(expBorder_z,actBorder_z);
        
	}

	/**
	 * 
	 */
	@Test
	public void testTriangleJudegQuestionImpl_two() {
		//fail("Not yet implemented");
		testobj = new TriangleJudgeQuestionImpl();
	    
	}
	@Test
	public void testGetShapeName(){
	
		String expName = "三角形";
		String actName =  testobj.mName;
		Assert.assertEquals(expName,actName);
	}
	@Test
	public void testGetQuestionString()
	{
		
		String expString = "题目：三条边，边x为 " + Integer.toString(testobj.mBorder_x) +
				"，边x为 " + Integer.toString(testobj.mBorder_y) +
				"，边y为 " + Integer.toString(testobj.mBorder_z) +
				", 请判定这三条边是否能构成三角形。";
		String actString = testobj.getQuestionString();
		Assert.assertEquals(expString,actString);	
	}
	@Test
	public void testGetRightAnswerString_one(){
		String expString ="正确答辩：三条边，边x为 " + Integer.toString(testobj.mBorder_x) +
				"，边y为 " + Integer.toString(testobj.mBorder_y) +
				"，边z为 " + Integer.toString(testobj.mBorder_z) +
				",  三条边能构成三角形。";
		testobj.mRightAnswer = true;
		String actString = testobj.getRightAnswerString();	
		Assert.assertEquals(expString,actString);	
	}
	@Test
	public void testGetRightAnswerString_two(){
		String expString ="正确答辩：三条边，边x为 " + Integer.toString(testobj.mBorder_x) +
				"，边y为 " + Integer.toString(testobj.mBorder_y) +
				"，边z为 " + Integer.toString(testobj.mBorder_z) +
				",  三条边不能构成三角形。";
		testobj.mRightAnswer = false;
		String actString = testobj.getRightAnswerString();	
		Assert.assertEquals(expString,actString);	
	}
	@Test
	public void testGetAnswerString_one(){
		String expString = "你的答辩：三条边，边x为 " + Integer.toString(testobj.mBorder_x) +
				"，边y为 " + Integer.toString(testobj.mBorder_y) +
				"，边z为 " + Integer.toString(testobj.mBorder_z);
		testobj.mAnswer = true;	
		expString += ",  三条边能构成三角形。";
		String actString = testobj.getAnsewerString();
		Assert.assertEquals(expString,actString);
	}
	@Test
	public void testGetAnswerString_two(){
		String expString = "你的答辩：三条边，边x为 " + Integer.toString(testobj.mBorder_x) +
				"，边y为 " + Integer.toString(testobj.mBorder_y) +
				"，边z为 " + Integer.toString(testobj.mBorder_z);	
	    testobj.mAnswer = false;	
		expString += ",  三条边不能构成三角形。";
		
		String actString = testobj.getAnsewerString();
		Assert.assertEquals(expString,actString);
	}
	@Test
	public void testJudge_one()
	{
		testobj.mBorder_x = 2;
		testobj.mBorder_y = 3;
		testobj.mBorder_z = 4;
		boolean expJudge = true;
		boolean actJudge = testobj.Judge();
		Assert.assertEquals(expJudge,actJudge);
	}
	
	@Test
	public void testJudge_two()
	{
		testobj.mBorder_x = 2;
		testobj.mBorder_y = 4;
		testobj.mBorder_z = 3;
		boolean expJudge = true;
		boolean actJudge = testobj.Judge();
		Assert.assertEquals(expJudge,actJudge);
	}
	@Test
	public void testJudge_three()
	{
		testobj.mBorder_x = 3;
		testobj.mBorder_y = 2;
		testobj.mBorder_z = 5;
		boolean expJudge = false;
		boolean actJudge = testobj.Judge();
		Assert.assertEquals(expJudge,actJudge);
	}
	@Test
	public void testJudge_four()
	{
		testobj.mBorder_x = 3;
		testobj.mBorder_y = 5;
		testobj.mBorder_z = 2;
		boolean expJudge = false;
		boolean actJudge = testobj.Judge();
		Assert.assertEquals(expJudge,actJudge);
	}
	@Test
	public void testJudge_five()
	{
		testobj.mBorder_x = 4;
		testobj.mBorder_y = 2;
		testobj.mBorder_z = 3;
		boolean expJudge = true;
		boolean actJudge = testobj.Judge();
		Assert.assertEquals(expJudge,actJudge);
	}
	@Test
	public void testJudge_six()
	{
		testobj.mBorder_x = 5;
		testobj.mBorder_y = 3;
		testobj.mBorder_z = 2;
		boolean expJudge = false;
		boolean actJudge = testobj.Judge();
		Assert.assertEquals(expJudge,actJudge);
	}
	@Test
	public void testGetQuestionType()
	{
		String expString = "ShapeJudge";
		String actString = testobj.getQuestionType();
		Assert.assertEquals(expString,actString);
	}
}
