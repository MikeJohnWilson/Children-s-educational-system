package com.team_06.shapecalc.impl;

import java.text.DecimalFormat;

import com.team_06.question.ShapeClacQuestion;

public abstract class ShapeQuestionImpl implements ShapeClacQuestion {
	/*
	 * 正确面积
	 */
	public double mArea;
	/*
	 * 正确周长
	 */
	public double mPerimeter;
	/*
	 * 回答的周长
	 */
	public double mPerimeterAnswer;
	/*
	 * 回答的面积
	 */
	public double mAreaAnswer;
	/*
	 * 题目名称
	 */
	public String mName;
	/*
	 * 回答正确情况.
	 */
	public String mAnswerInfo;

	public boolean mIsRightArea;
	public boolean mIsRightPerimeter;

	public double getmArea() {
		return mArea;
	}

	public void setmArea(double mArea) {
		this.mArea = mArea;
	}

	public double getmPerimeter() {
		return mPerimeter;
	}

	public void setmPerimeter(double mPerimeter) {
		this.mPerimeter = mPerimeter;
	}

	public double getmPerimeterAnswer() {
		return mPerimeterAnswer;
	}

	public void setmPerimeterAnswer(double mPerimeterAnswer) {
		this.mPerimeterAnswer = mPerimeterAnswer;
	}

	public double getmAreaAnswer() {
		return mAreaAnswer;
	}

	public void setmAreaAnswer(double mAreaAnswer) {
		this.mAreaAnswer = mAreaAnswer;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmAnswerInfo() {
		return mAnswerInfo;
	}

	public void setmAnswerInfo(String mAnswerInfo) {
		this.mAnswerInfo = mAnswerInfo;
	}

	public boolean ismIsRightArea() {
		return mIsRightArea;
	}

	public void setmIsRightArea(boolean mIsRightArea) {
		this.mIsRightArea = mIsRightArea;
	}

	public boolean ismIsRightPerimeter() {
		return mIsRightPerimeter;
	}

	public void setmIsRightPerimeter(boolean mIsRightPerimeter) {
		this.mIsRightPerimeter = mIsRightPerimeter;
	}

	public ShapeQuestionImpl() {
		mArea = -1;
		mPerimeter = -1;
		mAreaAnswer = -1;
		mPerimeterAnswer = -1;

		mName = "未知图形";
		mAnswerInfo = "未答题";

	}
	// 此函数用户格式化数据，保留小数点后两位,返回格式化后的字符串
	//@auther zhw 15/10/10 6:43 pm 
    private String FormatData(double data){
		DecimalFormat df1 = new DecimalFormat("#####0.00");
		return df1.format(data);
    }
	@Override
	public String getRightAnswerString() {
		// TODO Auto-generated method stub
		String mTemp; // @auther zhw 15/10/08 5:08 pm 精简字符串 
		mTemp = mName + "的面积正确答案是： " + FormatData(mArea) + "。\r\n";   //auther zhw 15/10/10 6:45 pm
		mTemp += "     " + mName + "的周长正确答案是： " + FormatData(mPerimeter) // 使用新建的格式函数FormatData
				+ "。";
		return mTemp;
	}
    
	@Override
	public String getAnsewerString() {
		// TODO Auto-generated method stub
		String mTemp;
		// @auther zhw 15/10/08 5:09 pm 精简字符串 
		mTemp = mName + "的面积答案是:" + FormatData(mAreaAnswer) //auther zhw 15/10/10 6:45 pm
				+ "。\r\n";                                       // 使用新建的格式函数FormatData
		mTemp += "     " + mName + "的周长答案是： "
				+ FormatData(mPerimeterAnswer) + "。";

		return mTemp;
	}

	@Override
	public String getAnswerInfo() {
		// TODO Auto-generated method stub
		mAnswerInfo = "";
		if (this.AnseweredArea()) {
			if (this.mIsRightArea) {
				mAnswerInfo += "本题面积答案正确";

			} else {
				mAnswerInfo += "本题面积答案错";
			}

		} else {
			mAnswerInfo += "本题未回答面积答案";
		}

		if (this.AnseweredPerimeter()) {
			if (this.mIsRightPerimeter) {
				mAnswerInfo += "，本题周长答案正确";

			} else {
				mAnswerInfo += "，本题周长答案错";
			}

		} else {
			mAnswerInfo += "，本题未回答周长答案。";

		}

		return mAnswerInfo;
	}

	@Override
	public double getRightArea() {
		// TODO Auto-generated method stub
		return mArea;
	}

	@Override
	public double getRightPerimeter() {
		// TODO Auto-generated method stub
		return mPerimeter;
	}

	@Override
	public boolean setAreaAnswer(double area) {
		// TODO Auto-generated method stub
		this.mAreaAnswer = area;
		if (mArea == area) {
			mIsRightArea = true;

		} else {
			mIsRightArea = false;
		}
		return mIsRightArea;
	}

	@Override
	public boolean setPerimeterAnswer(double perimeter) {
		// TODO Auto-generated method stub
		this.mPerimeterAnswer = perimeter;
		if (mPerimeter == perimeter)
			mIsRightPerimeter = true;
		else
			mIsRightPerimeter = false;

		return mIsRightPerimeter;

	}

	@Override
	public boolean AnseweredArea() {
		// TODO Auto-generated method stub
		if (this.mAreaAnswer == -1)
			return false;
		else
			return true;
	}

	@Override
	public boolean AnseweredPerimeter() {
		// TODO Auto-generated method stub
		if (this.mPerimeterAnswer == -1)
			return false;
		else
			return true;
	}

	@Override
	public String getShapeName() {
		// TODO Auto-generated method stub
		return mName;
	}

	@Override
	public String getQuestionType() {
		// TODO Auto-generated method stub
		return "ShapeClac";
	}

}
