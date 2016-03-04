package test.team_06.shapecalc.impl;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.team_06.random.Random;
import com.team_06.shapecalc.impl.CircleQuestionImpl;

public class CircleQuestionImplTest
{
	Random mRandom;
	CircleQuestionImpl mCircleQuestionImpl;
	@Before
	public void setUp() throws Exception
	{
		mRandom = new Random();
		mCircleQuestionImpl = new CircleQuestionImpl();
		
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCircleQuestionImpl()
	{
		String expStr = "圆形";
		String actStr = mCircleQuestionImpl.mName;
		assertEquals(expStr, actStr);
	}

	@Test
	public void testInitRadius()
	{
		Random mockedRandom = mock(Random.class);
	when(mockedRandom.randomNum()).thenReturn(2);
	mCircleQuestionImpl.setmRandom(mockedRandom);

	mCircleQuestionImpl.initRadius();
	int expRadius = 2;
	int actRadius = mCircleQuestionImpl.mCircleRadius;
	assertEquals(expRadius,actRadius);
	}

	@Test
	public void testCalcArea()
	{
		Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(2);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		mCircleQuestionImpl.CalcArea();
		double expArea = Math.PI*4;
		double actArea = mCircleQuestionImpl.mArea;
		assertEquals(expArea, actArea,0.2);
	}

	@Test
	public void testCalcPerimeter()
	{
		Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(2);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		mCircleQuestionImpl.CalcPerimeter();
		double expPerimeter = 2*Math.PI*2;
		double actPerimeter = mCircleQuestionImpl.mPerimeter;
		assertEquals(expPerimeter, actPerimeter,0.2);
	}

	@Test
	public void testGetQuestionString()
	{
		Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(2);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		String expStr = "一个半径为R = 2, 请计算该圆的面积和周长。";
		String actStr = mCircleQuestionImpl.getQuestionString();
		assertEquals(expStr, actStr);
	}

	@Test
	public void testGetQuestionType()
	{
		String exp = "ShapeClac";
		String act = mCircleQuestionImpl.getQuestionType();
		assertEquals(exp,act);
	}
	

	@Test
	public void testgetAnswerInfo_01(){
		String exp="";
		exp+="本题未回答面积答案，本题未回答周长答案。";
		mCircleQuestionImpl.mAreaAnswer=-1;
		mCircleQuestionImpl.mPerimeterAnswer=-1;
		String act=mCircleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
	
	@Test
	public void testgetAnswerInfo_02(){
		String exp="本题面积答案正确，本题未回答周长答案。";
		
		/*Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(1);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		mCircleQuestionImpl.CalcArea();
		mCircleQuestionImpl.mAreaAnswer=mCircleQuestionImpl.getRightArea();*/
		mCircleQuestionImpl.mAreaAnswer=1.0;
		mCircleQuestionImpl.mIsRightArea=true;
		mCircleQuestionImpl.mPerimeterAnswer=-1;
		String act=mCircleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}

@Test
 public void testgetAnswerInfo_03(){
	String exp="本题面积答案错，本题未回答周长答案。";
	
	mCircleQuestionImpl.mAreaAnswer=1.0;
	mCircleQuestionImpl.mIsRightArea=false;
	mCircleQuestionImpl.mPerimeterAnswer=-1;
	String act=mCircleQuestionImpl.getAnswerInfo();
	assertEquals(exp, act);
}
 
 
@Test
	public void testgetAnswerInfo_04(){
		String exp="";
		exp+="本题未回答面积答案，本题周长答案正确";
		mCircleQuestionImpl.mAreaAnswer=-1;
		/*int radius=1;
		mCircleQuestionImpl=new CircleQuestionImpl(radius);
		mCircleQuestionImpl.mPerimeterAnswer=mCircleQuestionImpl.getRightPerimeter();*/
		mCircleQuestionImpl.mPerimeterAnswer=1.0;
		mCircleQuestionImpl.mIsRightPerimeter=true;
		String act=mCircleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
 @Test
	public void testgetAnswerInfo_05(){
		String exp="";
		exp+="本题未回答面积答案，本题周长答案错";
		mCircleQuestionImpl.mAreaAnswer=-1;
		/*int radius=1;
		mCircleQuestionImpl=new CircleQuestionImpl(radius);
		mCircleQuestionImpl.mPerimeterAnswer=mCircleQuestionImpl.getRightPerimeter();*/
		mCircleQuestionImpl.mPerimeterAnswer=1.0;
		mCircleQuestionImpl.mIsRightPerimeter=false;
		String act=mCircleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
   private String FormatData(double data){
		DecimalFormat df1 = new DecimalFormat("#####0.00");
		return df1.format(data);
   }
 @Test
	public void testgetRightAnswerString(){
	 Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(1);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		mCircleQuestionImpl.CalcArea();
		String exp= mCircleQuestionImpl.getShapeName() + "的面积正确答案是： " + FormatData(mCircleQuestionImpl.getRightArea()) + "。\r\n";
		exp +="     " + mCircleQuestionImpl.getShapeName() + "的周长正确答案是： " + FormatData(mCircleQuestionImpl.getRightPerimeter()) + "。";
		String act=mCircleQuestionImpl.getRightAnswerString();
		assertEquals(exp, act);
		
	}
 @Test
	public void testgetAnswerString(){
	 /*Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(1);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		mCircleQuestionImpl.CalcArea();*/
		String exp=  mCircleQuestionImpl.getShapeName() + "的面积答案是:" + FormatData(mCircleQuestionImpl.mAreaAnswer) + "。\r\n";
		exp +="     " + mCircleQuestionImpl.getShapeName() + "的周长答案是： " + FormatData(mCircleQuestionImpl.mPerimeterAnswer) + "。";
		String act=mCircleQuestionImpl.getAnsewerString();
		assertEquals(exp, act);
		
	}
 
 @Test
 public void testsetAreaAnswer_01(){
	 boolean exp=true;
	 Random mockedRandom = mock(Random.class);
	 when(mockedRandom.randomNum()).thenReturn(1);
	 mCircleQuestionImpl.setmRandom(mockedRandom);
	 mCircleQuestionImpl.initRadius();
	 mCircleQuestionImpl.CalcArea();
	 double area=Math.PI*1.0;
	 boolean act=mCircleQuestionImpl.setAreaAnswer(area);
	 assertEquals(exp, act);
 }

 @Test
 public void testsetAreaAnswer_02(){
	 boolean exp=false;
	 Random mockedRandom = mock(Random.class);
	 when(mockedRandom.randomNum()).thenReturn(1);
	 mCircleQuestionImpl.setmRandom(mockedRandom);
	 mCircleQuestionImpl.initRadius();
	 mCircleQuestionImpl.CalcArea();
	 double area=Math.PI*2.0;
	 boolean act=mCircleQuestionImpl.setAreaAnswer(area);
	 assertEquals(exp, act);
 }
 
 
 @Test
 public void testsetPerimeterAnswer_01(){
	 boolean exp=true;
	 Random mockedRandom = mock(Random.class);
	 when(mockedRandom.randomNum()).thenReturn(1);
	 mCircleQuestionImpl.setmRandom(mockedRandom);
	 mCircleQuestionImpl.initRadius();
	 mCircleQuestionImpl.CalcPerimeter();
	 double perimeter=Math.PI*2.0;
	 boolean act=mCircleQuestionImpl.setPerimeterAnswer(perimeter);
	 assertEquals(exp, act);
 }

 @Test
 public void testsetPerimeterAnswer_02(){
	 boolean exp=false;
	 Random mockedRandom = mock(Random.class);
	 when(mockedRandom.randomNum()).thenReturn(1);
	 mCircleQuestionImpl.setmRandom(mockedRandom);
	 mCircleQuestionImpl.initRadius();
	 mCircleQuestionImpl.CalcPerimeter();
	 double perimeter=Math.PI*1.0;
	 boolean act=mCircleQuestionImpl.setPerimeterAnswer(perimeter);
	 assertEquals(exp, act);
 }
}
