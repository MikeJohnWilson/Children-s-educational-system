package test.team_06.sort.impl;

import static org.junit.Assert.*;

import java.security.spec.MGF1ParameterSpec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team_06.sort.impl.FindExtremeQuestionImpl;

public class FindExtremeQuestionImplTest
{

	/**
	 * numList 设定的随机数数组
	 */
	int []numList = {1,2,3,4,5,6,7,8,9,10};
	FindExtremeQuestionImpl mFindExtremeQuestionImpl;
	@Before
	public void setUp() throws Exception
	{
		mFindExtremeQuestionImpl = new FindExtremeQuestionImpl();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testSetNumList()
	{
		mFindExtremeQuestionImpl.setNumList();
	}

	@Test
	public void testFindMaxNum()
	{
		int expMaxNum = 10;
		int actMaxNum = mFindExtremeQuestionImpl.findMaxNum(numList);
		assertEquals(expMaxNum, actMaxNum);
	}

	@Test
	public void testGetQusitionString()
	{
		mFindExtremeQuestionImpl.mNumList = this.numList;
		String expQuestionString = "找出下面十个数字中的最大值和最小值:1,2,3,4,5,6,7,8,9,10,";
		String actQuestionString = mFindExtremeQuestionImpl.getQuestionString();
		assertEquals(expQuestionString,actQuestionString);
	}

	@Test
	public void testGetRightAnswerString()
	{

		String expRightAnswerString = "最大值是:0 最小的值是:0";
		int []rightAnswer = new int[2];
		rightAnswer[0] = 0;
		rightAnswer[1] = 0;
		mFindExtremeQuestionImpl.setmRightAnswerList(rightAnswer);
		String actRightAnswerString = mFindExtremeQuestionImpl.getRightAnswerString();
		assertEquals(expRightAnswerString, actRightAnswerString);
	}

	@Test
	public void testGetAnsewerString()
	{
		mFindExtremeQuestionImpl.mUserAnswerList[0] = 10;
		mFindExtremeQuestionImpl.mUserAnswerList[1] = 1;
		String expRigthAnswerString = "最大值是:10 最小值是:1";
		String actRightAnswerString = mFindExtremeQuestionImpl.getAnsewerString();
		assertEquals(expRigthAnswerString, actRightAnswerString);
	}

	@Test
	public void testGetQuestionType()
	{
		String expQuestionTypeString = "SortNum";
		String actQuestionTypeString = mFindExtremeQuestionImpl.getQuestionType();
		assertEquals(expQuestionTypeString, actQuestionTypeString);
	}

	@Test
	public void testGetRightAnswer()
	{
		mFindExtremeQuestionImpl.mNumList = this.numList;
		int []expRightAnswerList = {10,1};
		int []actRightAnswerList = new int[2];
	    actRightAnswerList = mFindExtremeQuestionImpl.getRightAnswer();
	  
	    for(int i=0;i<2;i++){
	    	assertEquals(expRightAnswerList[i], actRightAnswerList[i]);
	    }
	}

	@Test
	public void testSetAnswerList()
	{
	   int []numList = new int[10];
	   for(int i = 0; i < 10; ++i)
	   {
		   numList[i] = i;   
	   }
	   int []rightAnswer = new int[10];
	   rightAnswer[0] = 9;
	   rightAnswer[1] = 0;
	   mFindExtremeQuestionImpl.setmNumList(numList);
	    mFindExtremeQuestionImpl.setAnswerList(rightAnswer);
		for (int i = 0; i < 2; i++)
		{
			assertEquals(rightAnswer[i], mFindExtremeQuestionImpl.getmRightAnswerList()[i]);
		}
	}

	@Test
	public void testAnswered_01()
	{
		boolean exp = true;
		boolean act = mFindExtremeQuestionImpl.answered();
		assertEquals(exp, act);
	}
	@Test
	public void testAnswered_02()
	{
		boolean exp = false;
		int []answer = new int[0];
		mFindExtremeQuestionImpl.mUserAnswerList = answer;
		boolean act = mFindExtremeQuestionImpl.answered();
		assertEquals(exp, act);
	}

	@Test
	public void testFindMinNum()
	{
		int expMinNum = 1;
		int actMinNUm = mFindExtremeQuestionImpl.findMinNum(numList);
		assertEquals(expMinNum, actMinNUm);
	}

	@Test
	public void testGetUserAnswer()
	{
		int []expUserAnswer = {10,1};
		mFindExtremeQuestionImpl.mNumList = numList;
		mFindExtremeQuestionImpl.setUserAnswerList(expUserAnswer);
		int []actUserAnswer = mFindExtremeQuestionImpl.getUserAnswer();
		for (int i = 0; i < 2; i++)
		{
			assertEquals(expUserAnswer[i], actUserAnswer[i]);
		}
	}

	@Test
	public void testIsRightAnswer_01()
	{
		boolean expIsRight = true;
		int []rightAnswer = new int[2];
		int []userAnswer = new int[2];
		for(int i = 0; i < rightAnswer.length; ++i)
		{
			rightAnswer[i] = i + 1;
			userAnswer[i] = i + 1;	
		}	
		mFindExtremeQuestionImpl.setmRightAnswerList(rightAnswer);
		mFindExtremeQuestionImpl.setmUserAnswerList(userAnswer);
		mFindExtremeQuestionImpl.isRightAnswer();
		
		boolean actIsRight = mFindExtremeQuestionImpl.mIsRight;
		assertEquals(expIsRight, actIsRight);
	}
	
	@Test
	public void testIsRightAnswer_02()
	{
		boolean expIsRight = false;
		int []num = {1,3};
		mFindExtremeQuestionImpl.mRightAnswerList = num;
		mFindExtremeQuestionImpl.isRightAnswer();
		boolean actIsRight = mFindExtremeQuestionImpl.mIsRight;
		assertEquals(expIsRight, actIsRight);
	}

	@Test
	public void testGetAnswerInfo_01()
	{
		
		mFindExtremeQuestionImpl.setmRightMaxNum(2);
		mFindExtremeQuestionImpl.setmRightMinNum(1);
		mFindExtremeQuestionImpl.setmUserMaxNum(2);
		mFindExtremeQuestionImpl.setmUserMinNum(1);
		String expAnswerInfoString = "学生的答案是:正确的";
		String actAnswerInfoString = "";
		actAnswerInfoString += mFindExtremeQuestionImpl.getAnswerInfo();
		assertEquals(expAnswerInfoString, actAnswerInfoString);
	}
	
	@Test
	public void testGetAnswerInfo_02()
	{
		int []rightAnswer = new int[2];
		int []userAnswer = new int[2];
		for(int i = 0; i < rightAnswer.length; ++i)
		{
			rightAnswer[i] = i + 1;
			userAnswer[i] = i + 2;	
		}	
		mFindExtremeQuestionImpl.setmRightAnswerList(rightAnswer);
		mFindExtremeQuestionImpl.setmUserAnswerList(userAnswer);
		mFindExtremeQuestionImpl.mIsRight = false;
		String expAnswerInfoString = "学生的答案是:错误的";
		String actAnswerInfoString = "";
		actAnswerInfoString += mFindExtremeQuestionImpl.getAnswerInfo();
		assertEquals(expAnswerInfoString, actAnswerInfoString);
	}
}
