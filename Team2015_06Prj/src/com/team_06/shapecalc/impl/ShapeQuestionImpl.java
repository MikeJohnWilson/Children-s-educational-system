package com.team_06.shapecalc.impl;

import java.text.DecimalFormat;

import com.team_06.question.ShapeClacQuestion;

public abstract class ShapeQuestionImpl implements ShapeClacQuestion {
	/*
	 * ��ȷ���
	 */
	public double mArea;
	/*
	 * ��ȷ�ܳ�
	 */
	public double mPerimeter;
	/*
	 * �ش���ܳ�
	 */
	public double mPerimeterAnswer;
	/*
	 * �ش�����
	 */
	public double mAreaAnswer;
	/*
	 * ��Ŀ����
	 */
	public String mName;
	/*
	 * �ش���ȷ���.
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

		mName = "δ֪ͼ��";
		mAnswerInfo = "δ����";

	}
	// �˺����û���ʽ�����ݣ�����С�������λ,���ظ�ʽ������ַ���
	//@auther zhw 15/10/10 6:43 pm 
    private String FormatData(double data){
		DecimalFormat df1 = new DecimalFormat("#####0.00");
		return df1.format(data);
    }
	@Override
	public String getRightAnswerString() {
		// TODO Auto-generated method stub
		String mTemp; // @auther zhw 15/10/08 5:08 pm �����ַ��� 
		mTemp = mName + "�������ȷ���ǣ� " + FormatData(mArea) + "��\r\n";   //auther zhw 15/10/10 6:45 pm
		mTemp += "     " + mName + "���ܳ���ȷ���ǣ� " + FormatData(mPerimeter) // ʹ���½��ĸ�ʽ����FormatData
				+ "��";
		return mTemp;
	}
    
	@Override
	public String getAnsewerString() {
		// TODO Auto-generated method stub
		String mTemp;
		// @auther zhw 15/10/08 5:09 pm �����ַ��� 
		mTemp = mName + "���������:" + FormatData(mAreaAnswer) //auther zhw 15/10/10 6:45 pm
				+ "��\r\n";                                       // ʹ���½��ĸ�ʽ����FormatData
		mTemp += "     " + mName + "���ܳ����ǣ� "
				+ FormatData(mPerimeterAnswer) + "��";

		return mTemp;
	}

	@Override
	public String getAnswerInfo() {
		// TODO Auto-generated method stub
		mAnswerInfo = "";
		if (this.AnseweredArea()) {
			if (this.mIsRightArea) {
				mAnswerInfo += "�����������ȷ";

			} else {
				mAnswerInfo += "��������𰸴�";
			}

		} else {
			mAnswerInfo += "����δ�ش������";
		}

		if (this.AnseweredPerimeter()) {
			if (this.mIsRightPerimeter) {
				mAnswerInfo += "�������ܳ�����ȷ";

			} else {
				mAnswerInfo += "�������ܳ��𰸴�";
			}

		} else {
			mAnswerInfo += "������δ�ش��ܳ��𰸡�";

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
