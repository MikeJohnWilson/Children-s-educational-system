package com.team_06.shapecalc.impl;

import com.team_06.random.*;

public class RectangleQuestionImpl extends ShapeQuestionImpl {

	/**
	 * 矩形长
	 */
	public int mLength;
	/**
	 * 矩形宽
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
    //@auther zhw 15/10/08 4:26 自定义默认构造函数，用于对数据的
	//显式初始化
	public RectangleQuestionImpl(){
		super();
		initData();
		CalcArea();
		CalcPerimeter();
	}
	
	//@auther zhw 15/10/08 4:30 用于对mName,等字符串的初始化
	public void initData()
	{
		super.mName = "矩形";
		initLenWid();
	}
	/**
	 * 初始化长度和宽度
	 */
	public void initLenWid() {
		mLength = mRandomL.randomNum();
		mWidth = mRandomW.randomNum();
	}

	/**
	 * 计算矩形的面积
	 */
	public void CalcArea() {
		mArea = mLength * mWidth;
	}

	/**
	 * 计算矩形的周长
	 */
	public void CalcPerimeter() {
		mPerimeter = 2 * (mLength + mWidth);
	}

	@Override
	public String getQuestionString() {
		// TODO Auto-generated method stub
		String temp;// @auther zhw 15/10/08 5:10 pm 精简字符串  
		temp = "一个为长方形，其长为 " + Integer.toString(mLength) + "宽为"
				+ Integer.toString(mWidth) + ", 请计算该正方形的面积和周长。";
		return temp;
	}

	/**
	 * 返回Random类型的对象
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
	 * 设置Random 对象
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
