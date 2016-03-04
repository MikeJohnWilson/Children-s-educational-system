package test.team_06.sortquestion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import com.team_06.sort.impl.SortQuestionImpl;

public class SortQuestionImplTest {
	SortQuestionImpl sortQuestionImplTest;
	@Before
	public void setUp() throws Exception {
		sortQuestionImplTest=new SortQuestionImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetQuestionType() {
		//fail("Not yet implemented");
		String exp="SortNum";
		String act=sortQuestionImplTest.getQuestionType();
		Assert.assertEquals(exp,act);
	}

	@Test
	public void testAnsered_01() {
		//fail("Not yet implemented");
		sortQuestionImplTest.mUserAnswerList[0]=1;
		
		boolean exp=true;
		boolean act=sortQuestionImplTest.answered();
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testAnsered_02() {
		//fail("Not yet implemented");
		sortQuestionImplTest.mUserAnswerList=new int[0];
		
		boolean exp=false;
		boolean act=sortQuestionImplTest.answered();
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testGetAnsewerString() {
		//fail("Not yet implemented");
		int a[]={1,2,3,4,5,6,7,8,9,0};
		sortQuestionImplTest.mUserAnswerList=a;
	
		String exp="1,2,3,4,5,6,7,8,9,0,";
		String act=sortQuestionImplTest.getAnsewerString();
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testGetAnswerInfo_01() {
		int []rightAnswer = new int[10];
		int []userAnswer = new int[10];
		for(int i = 0; i < 10; ++i)
		{
			rightAnswer[i] = i;
			userAnswer[i] = i;
		}
		sortQuestionImplTest.setmRightAnswerList(rightAnswer);
		sortQuestionImplTest.setmUserAnswerList(userAnswer);
		
		sortQuestionImplTest.mIsRight=true;
		String exp="您的答案正确";
		String act=sortQuestionImplTest.getAnswerInfo();
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testGetAnswerInfo_02() {
		//fail("Not yet implemented");
		sortQuestionImplTest.mIsRight=false;
	
		String exp="您的答案错误";
		String act=sortQuestionImplTest.getAnswerInfo();
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testGetQusitionString() {
		//fail("Not yet implemented");
		int a[]={9,8,7,6,5,4,3,2,1,0};
		sortQuestionImplTest.mNumList=a;
	
		String exp="将下面十个数字从小到大进行排序,注意：输入的数字之间以空格隔开输入9,8,7,6,5,4,3,2,1,0,";
		String act=sortQuestionImplTest.getQuestionString();
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testGetRightAnswer() {
		//fail("Not yet implemented");
		int a[]={9,8,7,6,5,4,3,2,1,0};
		sortQuestionImplTest.mNumList=a;
	
		int exp[]={0,1,2,3,4,5,6,7,8,9};
		int act[]=sortQuestionImplTest.getRightAnswer();
		
		for(int i=0;i<10;i++){
			Assert.assertEquals(exp[i],act[i]);
		}
	}
	
	@Test
	public void testGetRightAnswerString() {
		//fail("Not yet implemented");
		int a[]={9,8,7,6,5,4,3,2,1,0};
		sortQuestionImplTest.mRightAnswerList=a;
	
		String exp="9,8,7,6,5,4,3,2,1,0,";
		String act=sortQuestionImplTest.getRightAnswerString();
		
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testGetUserAnswer() {
		int []exp = new int[10];
		for(int i = 0; i < 10; ++i)
		{
			exp[i] = i;
		}
		sortQuestionImplTest.setmUserAnswerList(exp);
		int act[] = sortQuestionImplTest.getUserAnswer();
		
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testIsRightAnswer_01() {
		//fail("Not yet implemented");
		sortQuestionImplTest.mUserAnswerList[0]=1;
		sortQuestionImplTest.mRightAnswerList[0]=2;
		sortQuestionImplTest.isRightAnswer();
		
		boolean exp=false;
		boolean act=sortQuestionImplTest.mIsRight;
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testIsRightAnswer_02() {
		//fail("Not yet implemented");
		int a[]={1,2,3,4,5,6,7,8,9,0};
		sortQuestionImplTest.mUserAnswerList=a;
		sortQuestionImplTest.mRightAnswerList=a;
		sortQuestionImplTest.isRightAnswer();
		
		boolean exp=true;
		boolean act=sortQuestionImplTest.mIsRight;
		Assert.assertEquals(exp,act);
	}
	
	@Test
	public void testSetAnswerList() {
		//fail("Not yet implemented");
		int a[]={1,2,3,4,5,6,7,8,9,0};
		sortQuestionImplTest.setAnswerList(a);
		
		int exp[]=a;
		int act[]=sortQuestionImplTest.mRightAnswerList;
		
		for(int i=0;i<10;i++){
			Assert.assertEquals(exp[i],act[i]);
		}
	}
	
	@Test
	public void testSetNumList() {
		//fail("Not yet implemented");
		
	}
}
