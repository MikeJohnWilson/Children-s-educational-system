package com.team_06.shapejudge.impl;

public class TriangleJudgeQuestionImpl extends ShapeJudgeQuestionImpl {

	/**
	 * 三角形判定的三条边x，y，z
	 */
	public int mBorder_x;
	public int mBorder_y;
	public int mBorder_z;
	/**
	 * 题目类型的名字
	 */
	public String mName;

	public int getmBorder_x() {
		return mBorder_x;
	}

	public void setmBorder_x(int mBorder_x) {
		this.mBorder_x = mBorder_x;
	}

	public int getmBorder_y() {
		return mBorder_y;
	}

	public void setmBorder_y(int mBorder_y) {
		this.mBorder_y = mBorder_y;
	}

	public int getmBorder_z() {
		return mBorder_z;
	}

	public void setmBorder_z(int mBorder_z) {
		this.mBorder_z = mBorder_z;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public TriangleJudgeQuestionImpl() {
		mName = "三角形";
		mBorder_x = Math.abs((int) (Math.random() * 100 + 1));
		mBorder_y = Math.abs((int) (Math.random() * 100 + 1));
		mBorder_z = Math.abs((int) (Math.random() * 100 + 1));
		this.mRightAnswer = Judge();
		
		// @auther 郑宏伟，15/10/8 3:13 /pm  初始化相关函数
		
		// mRightAnswer = Judge();
	}

	public TriangleJudgeQuestionImpl(int a, int b, int c) {
		mName = "三角形";
		mBorder_x = a;
		mBorder_y = b;
		mBorder_z = c;
		this.mRightAnswer = Judge();
	}

	@Override
	public String getShapeName() {
		// TODO Auto-generated method stub
		return mName;
	}

	@Override
	public String getQuestionString() {
		// TODO Auto-generated method stub
		String temp;
		temp = "题目：三条边，边x为 " + Integer.toString(mBorder_x) + "，边x为 "
				+ Integer.toString(mBorder_y) + "，边y为 "
				+ Integer.toString(mBorder_z) + ", 请判定这三条边是否能构成三角形。";
		return temp;
	}

	@Override
	public String getRightAnswerString() {
		// TODO Auto-generated method stub
		String temp;
		temp = "正确答辩：三条边，边x为 " + Integer.toString(mBorder_x) + "，边y为 "
				+ Integer.toString(mBorder_y) + "，边z为 "
				+ Integer.toString(mBorder_z);
		if (this.mRightAnswer == true)
			temp += ",  三条边能构成三角形。";
		else
			temp += ",  三条边不能构成三角形。";
		return temp;
	}

	@Override
	public String getAnsewerString() {
		// TODO Auto-generated method stub
		String temp;
		temp = "你的答辩：三条边，边x为 " + Integer.toString(mBorder_x) + "，边y为 "
				+ Integer.toString(mBorder_y) + "，边z为 "
				+ Integer.toString(mBorder_z);
		if (this.mAnswer == true) {
			temp += ",  三条边能构成三角形。";
		}

		else {
			temp += ",  三条边不能构成三角形。";
		}
		return temp;
	}

	/**
	 * @return 判断是否是三角形，返回为真，表示是三角形，返回为假，表示不是三角形
	 */
	public boolean Judge() {
		if (((mBorder_y + mBorder_z) > mBorder_x)
				&& ((mBorder_x + mBorder_z) > mBorder_y)
				&& ((mBorder_y + mBorder_x) > mBorder_z))
			return true;
		else
			return false;
	}
}
