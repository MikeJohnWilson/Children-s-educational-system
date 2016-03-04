package test.team_06.shapejudeg.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.team_06.shapejudge.impl.ShapeJudgeQuestionImpl;


/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public abstract class testShapeJudgeQuestion {

	ShapeJudgeQuestionImpl baseTestobj;
	/**
	 * getAnwserInfo ²âÊÔº¯Êý1
	 */
	@Test
	public void testGetAnwserInfo_one() {
		String expString = "";
		baseTestobj.mIsAnswer = true;
		baseTestobj.mIsRightAnswer = true;
		expString += "±¾ÌâÅÐ¶Ï´ð°¸ÕýÈ·";
		String actString = baseTestobj.getAnswerInfo();
		Assert.assertEquals(expString,actString);
	}
	
	/**
	 * getAnwserInfo ²âÊÔº¯Êý2
	 */
	@Test
	public void testGetAnwserInfo_two() {
		String expString = "";
		baseTestobj.mIsAnswer = true;
		baseTestobj.mIsRightAnswer = false;
		
		expString += "±¾ÌâÅÐ¶Ï´ð°¸´í";
		String actString = baseTestobj.getAnswerInfo();
		Assert.assertEquals(expString,actString);
		//fail("Not yet implemented");
	}
	/**
	 * getAnswerInfo ²âÊÔº¯Êý3
	 */
	@Test
	public void testGetAnwserInfo_three() {
		String expString = "";
		baseTestobj.mIsAnswer = false;
	   	expString += "±¾ÌâÎ´×÷´ð";   
		String actString = baseTestobj.getAnswerInfo();
		Assert.assertEquals(expString,actString);
	}
	/**
	 * setJudge ²âÊÔº¯Êý1
	 */
	@Test
	public void testSetJudge_one(){
		
		boolean answer = true;
		boolean rightAnswer = true;
		boolean expJudge = true;
		baseTestobj.mRightAnswer = rightAnswer;
		boolean actJudge = baseTestobj.setJudge(answer);
		Assert.assertEquals(expJudge,actJudge);
		
	}
	/**
	 * setJudge ²âÊÔº¯Êý2
	 */
	@Test
	public void testSetJudge_Two(){
		
		boolean answer = true;
		boolean rightAnswer = false;
		boolean expJudge = false;
		baseTestobj.mRightAnswer = rightAnswer;
		boolean actJudge = baseTestobj.setJudge(answer);
		Assert.assertEquals(expJudge,actJudge);
		
	}
	/**
	 * setJudge ²âÊÔº¯Êý3
	 */
	@Test
	public void testSetJudge_three(){
		
		
		boolean answer = false;
		boolean rightAnswer = true;
		boolean expJudge = false;
		baseTestobj.mRightAnswer = rightAnswer;
		boolean actJudge = baseTestobj.setJudge(answer);
		Assert.assertEquals(expJudge,actJudge);
	}
	/**
	 * setJudge ²âÊÔº¯Êý4
	 */
	@Test
	public void testSetJudge_four(){
		
		boolean answer = false;
		boolean rightAnswer = false;
		boolean expJudge = true;
		baseTestobj.mRightAnswer = rightAnswer;
		boolean actJudge = baseTestobj.setJudge(answer);
		Assert.assertEquals(expJudge,actJudge);		
	}
	/**
	 * getJudgeAnswer ²âÊÔº¯Êý
	 */
	@Test
	public void testGetJudgeAnswer(){
		boolean answer = false;
		baseTestobj.mAnswer = answer;
		boolean expAnwser = answer;
		boolean actAnwser = baseTestobj.getJudgeAnswer();
		Assert.assertEquals(expAnwser,actAnwser);
	}
	/**
	 * getRightAnswer ²âÊÔº¯Êý
	 */
	@Test
	public void testGetRightAnswer(){
		boolean rightAnswer = false;
		baseTestobj.mRightAnswer = rightAnswer;
		boolean expAnwser = rightAnswer;
		boolean actAnwser = baseTestobj.getRightAnswer();
		Assert.assertEquals(expAnwser,actAnwser);
	}
	/**
	 * Answered ²âÊÔº¯Êý
	 */
	@Test
	public void testAnswered(){
		boolean answered = false;
		baseTestobj.mIsAnswer = answered;
		boolean expAnwser = answered;
		boolean actAnwser = baseTestobj.Answered();
		Assert.assertEquals(expAnwser,actAnwser);
	}
}
