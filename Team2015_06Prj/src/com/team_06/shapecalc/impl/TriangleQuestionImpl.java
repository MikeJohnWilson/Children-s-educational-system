package com.team_06.shapecalc.impl;

import com.team_06.random.*;

public class TriangleQuestionImpl extends ShapeQuestionImpl {

	/**
	 * �����εױ�
	 */
	public int mBottom;
	/**
	 * �����θ�
	 */
	public int mHeight;

	/**
	 * Random���͵ĳ�Ա����
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

	
	// @auther zhw 15/10/08 4:41  �Զ���Ĭ�Ϲ��캯����������ʽ�ĳ�ʼ������
	public TriangleQuestionImpl(){
		super();
		initData();
		CalcPerimeter();
		CalcArea();
	}
	public void initData(){
		super.mName = "������";
		initBtmHei();
	}
	/**
	 * ��ʼ�������εױߺ͸�
	 */
	public void initBtmHei() {
		mBottom = mRandomBtm.randomNum();
		mHeight = mRandomHei.randomNum();
	}

	/**
	 * ���������ε��ܳ�
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
	 * ���������ε����
	 */
	public void CalcArea() {
		this.mArea = (double) mHeight * mBottom / 2;
	}

	@Override
	public String getQuestionString() {
		// TODO Auto-generated method stub
		String mTemp; // @auther zhw 15/10/08 5:10 pm �����ַ��� 
		mTemp = "һ�������Σ��ױ߳�Ϊ " + Integer.toString(mBottom) + ", ��Ϊ"
				+ Integer.toString(mHeight) + "�������������ε�������ܳ���";
		return mTemp;
	}

	/**
	 * ����Random���͵Ķ���
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
	 * ����Random ����
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
