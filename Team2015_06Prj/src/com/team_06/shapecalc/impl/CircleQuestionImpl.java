package com.team_06.shapecalc.impl;

import com.team_06.question.ShapeClacQuestion;
import com.team_06.random.*;

public class CircleQuestionImpl extends ShapeQuestionImpl implements
		ShapeClacQuestion {
	/**
	 * mCircleRadius Բ�뾶
	 */
	public int mCircleRadius;
	public Random mRandom = new Random();
    // @auther zhw 15/10/08 4:54 pm �Զ���Ĭ�Ϲ��캯����������ʽ��ʼ������
	public CircleQuestionImpl() {
        super();
		mName = "Բ��";
		initRadius();
		CalcArea();
		CalcPerimeter();
	}

	public void initRadius() {
		mCircleRadius = mRandom.randomNum();
	}

	public int getmCircleRadius() {
		return mCircleRadius;
	}

	public void setmCircleRadius(int mCircleRadius) {
		this.mCircleRadius = mCircleRadius;
	}

	public final void CalcArea() {
		mArea = Math.PI * mCircleRadius * mCircleRadius;
	}

	public final void CalcPerimeter() {
		mPerimeter = 2 * Math.PI * mCircleRadius;
	}

	@Override
	public final String getQuestionString() {
		String temp;// @auther zhw 15/10/08 5:10 pm �����ַ��� 
		temp = "һ���뾶ΪR = " + Integer.toString(mCircleRadius)
				+ ", ������Բ��������ܳ���";
		return temp;
	}

	/**
	 * ����Random���͵Ķ���
	 * 
	 * @return
	 */
	public Random getmRandom() {
		return mRandom;
	}

	/**
	 * ����Random ����
	 * 
	 * @param mRandom
	 */
	public void setmRandom(Random mRandom) {
		this.mRandom = mRandom;
	}
}
