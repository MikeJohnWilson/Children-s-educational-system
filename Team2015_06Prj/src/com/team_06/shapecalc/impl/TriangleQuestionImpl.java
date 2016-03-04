package com.team_06.shapecalc.impl;

import com.team_06.random.*;

public class TriangleQuestionImpl extends ShapeQuestionImpl {

	/**
	 * 三角形底边
	 */
	public int mBottom;
	/**
	 * 三角形高
	 */
	public int mHeight;

	/**
	 * Random类型的成员变量
	 */
	Random mRandomBtm = new Random();
	Random mRandomHei = new Random();

	public int getmBottom() {
		return mBottom;
	}

	public void setmBottom(int mBottom) {
		this.mBottom = mBottom;
	}

	public int getmHeight() {
		return mHeight;
	}

	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}

	
	// @auther zhw 15/10/08 4:41  自定义默认构造函数，用于显式的初始化数据
	public TriangleQuestionImpl(){
		super();
		initData();
		CalcPerimeter();
		CalcArea();
	}
	public void initData(){
		super.mName = "三角形";
		initBtmHei();
	}
	/**
	 * 初始化三角形底边和高
	 */
	public void initBtmHei() {
		mBottom = mRandomBtm.randomNum();
		mHeight = mRandomHei.randomNum();
	}

	/**
	 * 计算三角形的周长
	 */
	public void CalcPerimeter() {
		double mAngle = Math.atan(((double) mHeight / (mBottom / 2)));
		int temp1 = mHeight;
		if (mAngle != 0)
			temp1 = (int) (mHeight / Math.sin(mAngle));

		int temp2 = mHeight;
		if (mAngle != Math.PI / 2) {
			temp2 = (int) (mHeight / Math.sin(Math.PI - mAngle));
		}
		mPerimeter = mBottom + temp1 + temp2;
	}

	/**
	 * 计算三角形的面积
	 */
	public void CalcArea() {
		this.mArea = (double) mHeight * mBottom / 2;
	}

	@Override
	public String getQuestionString() {
		// TODO Auto-generated method stub
		String mTemp; // @auther zhw 15/10/08 5:10 pm 精简字符串 
		mTemp = "一个三角形，底边长为 " + Integer.toString(mBottom) + ", 高为"
				+ Integer.toString(mHeight) + "，请计算该三角形的面积和周长。";
		return mTemp;
	}

	/**
	 * 返回Random类型的对象
	 * 
	 * @return
	 */
	public Random getmRandomBtm() {
		return mRandomBtm;
	}

	public Random getmRandomHei() {
		return mRandomHei;
	}

	/**
	 * 设置Random 对象
	 * 
	 * @param mRandom
	 */
	public void setmRandomBtm(Random mRandomBtm) {
		this.mRandomBtm = mRandomBtm;
	}

	public void setmRandomHei(Random mRandomHei) {
		this.mRandomHei = mRandomHei;
	}

}
