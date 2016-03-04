package com.team_06.shapecalc.impl;

import com.team_06.random.*;

public class RectangleQuestionImpl extends ShapeQuestionImpl {

	/**
	 * ���γ�
	 */
	public int mLength;
	/**
	 * ���ο�
	 */
	public int mWidth;
	Random mRandomL = new Random();
	Random mRandomW = new Random();

	public int getmLength() {
		return mLength;
	}

	public void setmLength(int mLength) {
		this.mLength = mLength;
	}

	public int getmWidth() {
		return mWidth;
	}

	public void setmWidth(int mWidth) {
		this.mWidth = mWidth;
	}
    //@auther zhw 15/10/08 4:26 �Զ���Ĭ�Ϲ��캯�������ڶ����ݵ�
	//��ʽ��ʼ��
	public RectangleQuestionImpl(){
		super();
		initData();
		CalcArea();
		CalcPerimeter();
	}
	
	//@auther zhw 15/10/08 4:30 ���ڶ�mName,���ַ����ĳ�ʼ��
	public void initData()
	{
		super.mName = "����";
		initLenWid();
	}
	/**
	 * ��ʼ�����ȺͿ��
	 */
	public void initLenWid() {
		mLength = mRandomL.randomNum();
		mWidth = mRandomW.randomNum();
	}

	/**
	 * ������ε����
	 */
	public void CalcArea() {
		mArea = mLength * mWidth;
	}

	/**
	 * ������ε��ܳ�
	 */
	public void CalcPerimeter() {
		mPerimeter = 2 * (mLength + mWidth);
	}

	@Override
	public String getQuestionString() {
		// TODO Auto-generated method stub
		String temp;// @auther zhw 15/10/08 5:10 pm �����ַ���  
		temp = "һ��Ϊ�����Σ��䳤Ϊ " + Integer.toString(mLength) + "��Ϊ"
				+ Integer.toString(mWidth) + ", �����������ε�������ܳ���";
		return temp;
	}

	/**
	 * ����Random���͵Ķ���
	 * 
	 * @return
	 */
	public Random getmRandomL() {
		return mRandomL;
	}

	public Random getmRandomW() {
		return mRandomW;
	}

	/**
	 * ����Random ����
	 * 
	 * @param mRandom
	 */
	public void setmRandomL(Random mRandomL) {
		this.mRandomL = mRandomL;
	}

	public void setmRandomW(Random mRandomW) {
		this.mRandomW = mRandomW;
	}

}
