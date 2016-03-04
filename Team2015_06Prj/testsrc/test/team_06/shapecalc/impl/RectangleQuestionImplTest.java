package test.team_06.shapecalc.impl;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.team_06.random.Random;
import com.team_06.shapecalc.impl.RectangleQuestionImpl;

import static org.mockito.Mockito.*;

public class RectangleQuestionImplTest
{
	Random mRandomL;                    //产生长
	Random mRandomW;                  //产生宽
	RectangleQuestionImpl mRectangleQuestionImpl; 
	@Before
	public void setUp() throws Exception
	{
		mRandomL = new Random();
		mRandomW = new Random();
		mRectangleQuestionImpl = new RectangleQuestionImpl();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testInitLenWid()
	{
		Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		int expLen = 4;
		int expWid = 2;
		mRectangleQuestionImpl.initLenWid();
		int actLen = mRectangleQuestionImpl.mLength;
		int actWid = mRectangleQuestionImpl.mWidth;
		assertEquals(expLen, actLen);
		assertEquals(expWid, actWid);
	}

	@Test
	public void testCalcArea()
	{
		Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
		mRectangleQuestionImpl.CalcArea();
		double expArea = 4 * 2;
		double actArea = mRectangleQuestionImpl.mArea;
		assertEquals(expArea, actArea,0.2);
	}

	@Test
	public void testCalcPerimeter()
	{
		Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
		mRectangleQuestionImpl.CalcPerimeter();
		double expPerimeter = (4+2)*2;
		double actPerimeter = mRectangleQuestionImpl.mPerimeter;
		assertEquals(expPerimeter, actPerimeter,0.2);
	}

	@Test
	public void testGetQuestionString()
	{
		Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
		String expQuestionString = "一个为长方形，其长为 4宽为2, 请计算该正方形的面积和周长。";
		String actQuesionString = mRectangleQuestionImpl.getQuestionString();
		assertEquals(expQuestionString, actQuesionString);
	}

	@Test
	public void testGetQuestionType()
	{
		String exp = "ShapeClac";
		String act = mRectangleQuestionImpl.getQuestionType();
		assertEquals(exp,act);
	}
	
	
	
	
	@Test
	public void testgetAnswerInfo_01(){
		String exp="";
		exp+="本题未回答面积答案，本题未回答周长答案。";
		mRectangleQuestionImpl.mAreaAnswer=-1;
		mRectangleQuestionImpl.mPerimeterAnswer=-1;
		String act=mRectangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
	
	@Test
	public void testgetAnswerInfo_02(){
		String exp="本题面积答案正确，本题未回答周长答案。";
		mRectangleQuestionImpl.mAreaAnswer=1.0;
		mRectangleQuestionImpl.mIsRightArea=true;
		mRectangleQuestionImpl.mPerimeterAnswer=-1;
		String act=mRectangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}

@Test
 public void testgetAnswerInfo_03(){
	String exp="本题面积答案错，本题未回答周长答案。";
	
	mRectangleQuestionImpl.mAreaAnswer=1.0;
	mRectangleQuestionImpl.mIsRightArea=false;
	mRectangleQuestionImpl.mPerimeterAnswer=-1;
	String act=mRectangleQuestionImpl.getAnswerInfo();
	assertEquals(exp, act);
}
 
 
@Test
	public void testgetAnswerInfo_04(){
		String exp="";
		exp+="本题未回答面积答案，本题周长答案正确";
		mRectangleQuestionImpl.mAreaAnswer=-1;
		mRectangleQuestionImpl.mPerimeterAnswer=1.0;
		mRectangleQuestionImpl.mIsRightPerimeter=true;
		String act=mRectangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
 @Test
	public void testgetAnswerInfo_05(){
		String exp="";
		exp+="本题未回答面积答案，本题周长答案错";
		mRectangleQuestionImpl.mAreaAnswer=-1;
		mRectangleQuestionImpl.mPerimeterAnswer=1.0;
		mRectangleQuestionImpl.mIsRightPerimeter=false;
		String act=mRectangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
    private String FormatData(double data){
		DecimalFormat df1 = new DecimalFormat("#####0.00");
		return df1.format(data);
   }
 @Test
	public void testgetRightAnswerString(){
	 Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
		mRectangleQuestionImpl.CalcArea();
		String exp= mRectangleQuestionImpl.getShapeName() + "的面积正确答案是： " + FormatData(mRectangleQuestionImpl.getRightArea()) + "。\r\n";
		exp +="     " + mRectangleQuestionImpl.getShapeName() + "的周长正确答案是： " + FormatData(mRectangleQuestionImpl.getRightPerimeter()) + "。";
		String act=mRectangleQuestionImpl.getRightAnswerString();
		assertEquals(exp, act);
		
	}
 @Test
	public void testgetAnswerString(){
		String exp= mRectangleQuestionImpl.getShapeName() + "的面积答案是:" + FormatData(mRectangleQuestionImpl.mAreaAnswer) + "。\r\n";
		exp +="     " + mRectangleQuestionImpl.getShapeName() + "的周长答案是： " + FormatData(mRectangleQuestionImpl.mPerimeterAnswer) + "。";
		String act=mRectangleQuestionImpl.getAnsewerString();
		assertEquals(exp, act);
		
	}
 
 @Test
 public void testsetAreaAnswer_01(){
	 boolean exp=true;
	 Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
	 mRectangleQuestionImpl.CalcArea();
	 System.out.println(mRectangleQuestionImpl.mArea);
	 double area=(double)(2*4);
	 boolean act=mRectangleQuestionImpl.setAreaAnswer(area);
	 assertEquals(exp, act);
 }

 @Test
 public void testsetAreaAnswer_02(){
	 boolean exp=false;
	 Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
	 mRectangleQuestionImpl.CalcArea();
	 double area=12.0;
	 boolean act=mRectangleQuestionImpl.setAreaAnswer(area);
	 assertEquals(exp, act);
 }
 
 
 @Test
 public void testsetPerimeterAnswer_01(){
	 boolean exp=true;
	 Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
	 mRectangleQuestionImpl.CalcPerimeter();
	 double perimeter=(double)(6*2);
	 boolean act=mRectangleQuestionImpl.setPerimeterAnswer(perimeter);
	 assertEquals(exp, act);
 }

 @Test
 public void testsetPerimeterAnswer_02(){
	 boolean exp=false;
	 Random mockedRandomL = mock(Random.class);
		when(mockedRandomL.randomNum()).thenReturn(4);
		Random mockedRandomW = mock(Random.class);
		when(mockedRandomW.randomNum()).thenReturn(2);
		mRectangleQuestionImpl.setmRandomL(mockedRandomL);
		mRectangleQuestionImpl.setmRandomW(mockedRandomW);
		mRectangleQuestionImpl.initLenWid();
	 mRectangleQuestionImpl.CalcPerimeter();
	 double perimeter=13.0;
	 boolean act=mRectangleQuestionImpl.setPerimeterAnswer(perimeter);
	 assertEquals(exp, act);
 }
}
