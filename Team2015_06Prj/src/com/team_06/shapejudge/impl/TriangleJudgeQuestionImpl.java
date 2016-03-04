package com.team_06.shapejudge.impl;

public class TriangleJudgeQuestionImpl extends ShapeJudgeQuestionImpl {

	/**
	 * �������ж���������x��y��z
	 */
	public int mBorder_x;
	public int mBorder_y;
	public int mBorder_z;
	/**
	 * ��Ŀ���͵�����
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
		mName = "������";
		mBorder_x = Math.abs((int) (Math.random() * 100 + 1));
		mBorder_y = Math.abs((int) (Math.random() * 100 + 1));
		mBorder_z = Math.abs((int) (Math.random() * 100 + 1));
		this.mRightAnswer = Judge();
		
		// @auther ֣��ΰ��15/10/8 3:13 /pm  ��ʼ����غ���
		
		// mRightAnswer = Judge();
	}

	public TriangleJudgeQuestionImpl(int a, int b, int c) {
		mName = "������";
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
		temp = "��Ŀ�������ߣ���xΪ " + Integer.toString(mBorder_x) + "����xΪ "
				+ Integer.toString(mBorder_y) + "����yΪ "
				+ Integer.toString(mBorder_z) + ", ���ж����������Ƿ��ܹ��������Ρ�";
		return temp;
	}

	@Override
	public String getRightAnswerString() {
		// TODO Auto-generated method stub
		String temp;
		temp = "��ȷ��磺�����ߣ���xΪ " + Integer.toString(mBorder_x) + "����yΪ "
				+ Integer.toString(mBorder_y) + "����zΪ "
				+ Integer.toString(mBorder_z);
		if (this.mRightAnswer == true)
			temp += ",  �������ܹ��������Ρ�";
		else
			temp += ",  �����߲��ܹ��������Ρ�";
		return temp;
	}

	@Override
	public String getAnsewerString() {
		// TODO Auto-generated method stub
		String temp;
		temp = "��Ĵ�磺�����ߣ���xΪ " + Integer.toString(mBorder_x) + "����yΪ "
				+ Integer.toString(mBorder_y) + "����zΪ "
				+ Integer.toString(mBorder_z);
		if (this.mAnswer == true) {
			temp += ",  �������ܹ��������Ρ�";
		}

		else {
			temp += ",  �����߲��ܹ��������Ρ�";
		}
		return temp;
	}

	/**
	 * @return �ж��Ƿ��������Σ�����Ϊ�棬��ʾ�������Σ�����Ϊ�٣���ʾ����������
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
