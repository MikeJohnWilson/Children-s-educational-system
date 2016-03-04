package com.team_06.shapecalc.impl;

import com.team_06.question.ShapeClacQuestion;
import com.team_06.random.*;

public class CircleQuestionImpl extends ShapeQuestionImpl implements
		ShapeClacQuestion {
	/**
	 * mCircleRadius 圆半径
	 */
	public int mCircleRadius;
	public Random mRandom = new Random();
    // @auther zhw 15/10/08 4:54 pm 自定义默认构造函数，用于显式初始化数据
	public CircleQuestionImpl() {
        super();
		mName = "圆形";
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
		String temp;// @auther zhw 15/10/08 5:10 pm 精简字符串 
		temp = "一个半径为R = " + Integer.toString(mCircleRadius)
				+ ", 请计算该圆的面积和周长。";
		return temp;
	}

	/**
	 * 返回Random类型的对象
	 * 
	 * @return
	 */
	public Random getmRandom() {
		return mRandom;
	}

	/**
	 * 设置Random 对象
	 * 
	 * @param mRandom
	 */
	public void setmRandom(Random mRandom) {
		this.mRandom = mRandom;
	}
}
