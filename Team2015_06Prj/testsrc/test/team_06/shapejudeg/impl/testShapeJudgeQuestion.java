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
	 * getAnwserInfo ���Ժ���1
	 */
	@Test
	public void testGetAnwserInfo_one() {
		String expString = "";
		baseTestobj.mIsAnswer = true;
		baseTestobj.mIsRightAnswer = true;
		expString += "�����жϴ���ȷ";
		String actString = baseTestobj.getAnswerInfo();
		Assert.assertEquals(expString,actString);
	}
	
	/**
	 * getAnwserInfo ���Ժ���2
	 */
	@Test
	public void testGetAnwserInfo_two() {
		String expString = "";
		baseTestobj.mIsAnswer = true;
		baseTestobj.mIsRightAnswer = false;
		
		expString += "�����жϴ𰸴�";
		String actString = baseTestobj.getAnswerInfo();
		Assert.assertEquals(expString,actString);
		//fail("Not yet implemented");
	}
	/**
	 * getAnswerInfo ���Ժ���3
	 */
	@Test
	public void testGetAnwserInfo_three() {
		String expString = "";
		baseTestobj.mIsAnswer = false;
	   	expString += "����δ����";   
		String actString = baseTestobj.getAnswerInfo();
		Assert.assertEquals(expString,actString);
	}
	/**
	 * setJudge ���Ժ���1
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
	 * setJudge ���Ժ���2
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
	 * setJudge ���Ժ���3
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
	 * setJudge ���Ժ���4
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
	 * getJudgeAnswer ���Ժ���
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
	 * getRightAnswer ���Ժ���
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
	 * Answered ���Ժ���
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
