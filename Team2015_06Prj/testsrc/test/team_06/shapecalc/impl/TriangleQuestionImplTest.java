package test.team_06.shapecalc.impl;
import java.text.DecimalFormat;

import com.team_06.random.Random;
import com.team_06.shapecalc.impl.TriangleQuestionImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriangleQuestionImplTest
{

	Random mRandomBtm;                                //���������εױ�
	Random mRandomHei;                                 //���������εĸ�
	TriangleQuestionImpl mTriangleQuestionImpl;
	@Before
	public void setUp() throws Exception
	{
		mRandomBtm = new Random();
		mRandomHei = new Random();
		mTriangleQuestionImpl = new TriangleQuestionImpl();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testInitBtmHei()
	{
		Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		int expBtm = 4;
		int expHei = 2;
		int actBtm = mTriangleQuestionImpl.mBottom;
		int actHei = mTriangleQuestionImpl.mHeight;
		assertEquals(expBtm, actBtm);
		assertEquals(expHei, actHei);
	}

	@Test
	public void testCalcPerimeter()
	{
		Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		mTriangleQuestionImpl.CalcPerimeter();
	    double expPerimeter =8.0;
		double actPerimeter = mTriangleQuestionImpl.mPerimeter;
		assertEquals(expPerimeter, actPerimeter,0.2);
	}

	@Test
	public void testCalcArea()
	{
		Random mockedRandomBtm = mock(Random.class);
	when(mockedRandomBtm.randomNum()).thenReturn(4);
	Random mockedRandomHei = mock(Random.class);
	when(mockedRandomHei.randomNum()).thenReturn(2);
	mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
	mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
	mTriangleQuestionImpl.initBtmHei();
	mTriangleQuestionImpl.CalcArea();
    double expArea =4.0;
	double actArea = mTriangleQuestionImpl.mArea;
	assertEquals(expArea, actArea,0.2);
	}

	@Test
	public void testGetQuestionString()
	{
		Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		String expQuestionString = "һ�������Σ��ױ߳�Ϊ 4, ��Ϊ2�������������ε�������ܳ���";
		String actQuestionString = mTriangleQuestionImpl.getQuestionString();
		assertEquals(expQuestionString, actQuestionString);
	}

	@Test
	public void testGetQuestionType()
	{
		String exp = "ShapeClac";
		String act = mTriangleQuestionImpl.getQuestionType();
		System.out.println(act);
		assertEquals(exp,act);
	} 

	
	
	@Test
	public void testgetAnswerInfo_01(){
		String exp="";
		exp+="����δ�ش�����𰸣�����δ�ش��ܳ��𰸡�";
		mTriangleQuestionImpl.mAreaAnswer=-1;
		mTriangleQuestionImpl.mPerimeterAnswer=-1;
		String act=mTriangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
	
	@Test
	public void testgetAnswerInfo_02(){
		String exp="�����������ȷ������δ�ش��ܳ��𰸡�";
		
		/*Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(1);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		mCircleQuestionImpl.CalcArea();
		mCircleQuestionImpl.mAreaAnswer=mCircleQuestionImpl.getRightArea();*/
		mTriangleQuestionImpl.mAreaAnswer=1.0;
		mTriangleQuestionImpl.mIsRightArea=true;
		mTriangleQuestionImpl.mPerimeterAnswer=-1;
		String act=mTriangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}

@Test
 public void testgetAnswerInfo_03(){
	String exp="��������𰸴�����δ�ش��ܳ��𰸡�";
	
	mTriangleQuestionImpl.mAreaAnswer=1.0;
	mTriangleQuestionImpl.mIsRightArea=false;
	mTriangleQuestionImpl.mPerimeterAnswer=-1;
	String act=mTriangleQuestionImpl.getAnswerInfo();
	assertEquals(exp, act);
}
 
 
@Test
	public void testgetAnswerInfo_04(){
		String exp="";
		exp+="����δ�ش�����𰸣������ܳ�����ȷ";
		mTriangleQuestionImpl.mAreaAnswer=-1;
		/*int radius=1;
		mCircleQuestionImpl=new CircleQuestionImpl(radius);
		mCircleQuestionImpl.mPerimeterAnswer=mCircleQuestionImpl.getRightPerimeter();*/
		mTriangleQuestionImpl.mPerimeterAnswer=1.0;
		mTriangleQuestionImpl.mIsRightPerimeter=true;
		String act=mTriangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
 @Test
	public void testgetAnswerInfo_05(){
		String exp="";
		exp+="����δ�ش�����𰸣������ܳ��𰸴�";
		mTriangleQuestionImpl.mAreaAnswer=-1;
		/*int radius=1;
		mCircleQuestionImpl=new CircleQuestionImpl(radius);
		mCircleQuestionImpl.mPerimeterAnswer=mCircleQuestionImpl.getRightPerimeter();*/
		mTriangleQuestionImpl.mPerimeterAnswer=1.0;
		mTriangleQuestionImpl.mIsRightPerimeter=false;
		String act=mTriangleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}
 private String FormatData(double data){
		DecimalFormat df1 = new DecimalFormat("#####0.00");
		return df1.format(data);
   }
 @Test
	public void testgetRightAnswerString(){
	 Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		mTriangleQuestionImpl.CalcArea();
		String exp= mTriangleQuestionImpl.getShapeName() + "�������ȷ���ǣ� " + FormatData(mTriangleQuestionImpl.getRightArea()) + "��\r\n";
		exp +="     " + mTriangleQuestionImpl.getShapeName() + "���ܳ���ȷ���ǣ� " + FormatData(mTriangleQuestionImpl.getRightPerimeter()) + "��";
		String act=mTriangleQuestionImpl.getRightAnswerString();
		assertEquals(exp, act);
		
	}
 @Test
	public void testgetAnswerString(){
	 /*Random mockedRandom = mock(Random.class);
		when(mockedRandom.randomNum()).thenReturn(1);
		mCircleQuestionImpl.setmRandom(mockedRandom);
		mCircleQuestionImpl.initRadius();
		mCircleQuestionImpl.CalcArea();*/
		String exp= mTriangleQuestionImpl.getShapeName() + "���������:" + FormatData(mTriangleQuestionImpl.mAreaAnswer) + "��\r\n";
		exp +="     " + mTriangleQuestionImpl.getShapeName() + "���ܳ����ǣ� " + FormatData(mTriangleQuestionImpl.mPerimeterAnswer) + "��";
		String act=mTriangleQuestionImpl.getAnsewerString();
		assertEquals(exp, act);
		
	}
 
 @Test
 public void testsetAreaAnswer_01(){
	 boolean exp=true;
	 Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		mTriangleQuestionImpl.CalcArea();
	 System.out.println(mTriangleQuestionImpl.mArea);
	 double area=(double)(1*4);
	 boolean act=mTriangleQuestionImpl.setAreaAnswer(area);
	 assertEquals(exp, act);
 }

 @Test
 public void testsetAreaAnswer_02(){
	 boolean exp=false;
	 Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		mTriangleQuestionImpl.CalcArea();
	 double area=12.0;
	 boolean act=mTriangleQuestionImpl.setAreaAnswer(area);
	 assertEquals(exp, act);
 }
 
 
 @Test
 public void testsetPerimeterAnswer_01(){
	 boolean exp=true;
	 Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		mTriangleQuestionImpl.CalcPerimeter();
		
		double mAngle = Math.atan(((double) mTriangleQuestionImpl.mHeight / (mTriangleQuestionImpl.mBottom / 2)));
		int temp1 = mTriangleQuestionImpl.mHeight;
		if (mAngle != 0)
			temp1 = (int) (mTriangleQuestionImpl.mHeight / Math.sin(mAngle));

		int temp2 = mTriangleQuestionImpl.mHeight;
		if (mAngle != Math.PI / 2)
		{
			temp2 = (int) (mTriangleQuestionImpl.mHeight / Math.sin(Math.PI - mAngle));
		}
		double perimeter = mTriangleQuestionImpl.mBottom + temp1 + temp2;
	 boolean act=mTriangleQuestionImpl.setPerimeterAnswer(perimeter);
	 assertEquals(exp, act);
 }

 @Test
 public void testsetPerimeterAnswer_02(){
	 boolean exp=false;
	 Random mockedRandomBtm = mock(Random.class);
		when(mockedRandomBtm.randomNum()).thenReturn(4);
		Random mockedRandomHei = mock(Random.class);
		when(mockedRandomHei.randomNum()).thenReturn(2);
		mTriangleQuestionImpl.setmRandomBtm(mockedRandomBtm);
		mTriangleQuestionImpl.setmRandomHei(mockedRandomHei);
		mTriangleQuestionImpl.initBtmHei();
		mTriangleQuestionImpl.CalcPerimeter();
	 double perimeter=13.0;
	 boolean act=mTriangleQuestionImpl.setPerimeterAnswer(perimeter);
	 assertEquals(exp, act);
 }
}
