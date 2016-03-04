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
		String expStr = "Բ��";
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
		String expStr = "һ���뾶ΪR = 2, ������Բ��������ܳ���";
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
		exp+="����δ�ش�����𰸣�����δ�ش��ܳ��𰸡�";
		mCircleQuestionImpl.mAreaAnswer=-1;
		mCircleQuestionImpl.mPerimeterAnswer=-1;
		String act=mCircleQuestionImpl.getAnswerInfo();
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
		mCircleQuestionImpl.mAreaAnswer=1.0;
		mCircleQuestionImpl.mIsRightArea=true;
		mCircleQuestionImpl.mPerimeterAnswer=-1;
		String act=mCircleQuestionImpl.getAnswerInfo();
		assertEquals(exp, act);
	}

@Test
 public void testgetAnswerInfo_03(){
	String exp="��������𰸴�����δ�ش��ܳ��𰸡�";
	
	mCircleQuestionImpl.mAreaAnswer=1.0;
	mCircleQuestionImpl.mIsRightArea=false;
	mCircleQuestionImpl.mPerimeterAnswer=-1;
	String act=mCircleQuestionImpl.getAnswerInfo();
	assertEquals(exp, act);
}
 
 
@Test
	public void testgetAnswerInfo_04(){
		String exp="";
		exp+="����δ�ش�����𰸣������ܳ�����ȷ";
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
		exp+="����δ�ش�����𰸣������ܳ��𰸴�";
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
		String exp= mCircleQuestionImpl.getShapeName() + "�������ȷ���ǣ� " + FormatData(mCircleQuestionImpl.getRightArea()) + "��\r\n";
		exp +="     " + mCircleQuestionImpl.getShapeName() + "���ܳ���ȷ���ǣ� " + FormatData(mCircleQuestionImpl.getRightPerimeter()) + "��";
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
		String exp=  mCircleQuestionImpl.getShapeName() + "���������:" + FormatData(mCircleQuestionImpl.mAreaAnswer) + "��\r\n";
		exp +="     " + mCircleQuestionImpl.getShapeName() + "���ܳ����ǣ� " + FormatData(mCircleQuestionImpl.mPerimeterAnswer) + "��";
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
