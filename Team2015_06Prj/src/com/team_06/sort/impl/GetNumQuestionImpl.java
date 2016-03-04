package com.team_06.sort.impl;

import com.team_06.question.SortQuestion;

public abstract class GetNumQuestionImpl implements SortQuestion {
	public int[] mNumList = new int[10];
	public int[] mUserAnswerList = new int[10];
	public int[] mRightAnswerList = new int[10];
	public boolean mIsRight;
	public String mQuestionName = new String();
    
	
	public int[] getmNumList() {
		return mNumList;
	}

	public void setmNumList(int[] mNumList) {
		this.mNumList = mNumList;
	}

	public int[] getmUserAnswerList() {
		return mUserAnswerList;
	}

	public void setmUserAnswerList(int[] mUserAnswerList) {
		this.mUserAnswerList = mUserAnswerList;
	}

	public int[] getmRightAnswerList() {
		return mRightAnswerList;
	}

	public void setmRightAnswerList(int[] mRightAnswerList) {
		this.mRightAnswerList = mRightAnswerList;
	}

	public boolean ismIsRight() {
		return mIsRight;
	}

	public void setmIsRight(boolean mIsRight) {
		this.mIsRight = mIsRight;
	}

	public String getmQuestionName() {
		return mQuestionName;
	}

	public void setmQuestionName(String mQuestionName) {
		this.mQuestionName = mQuestionName;
	}

	public GetNumQuestionImpl() {
		super();
		mIsRight = true;
		mQuestionName = "δ֪����";
	}
	/**
	 * ��ȡʮ�������
	 * 
	 * @return
	 * @author zhw ���޸�set����Ϊ�����ͣ����践��ֵ 15/10/08 3:46 pm
	 * @author zhw,�޸�������������������ÿ�β�����Ϊ1��bug
	 */
	public void setNumList() {
		for (int j = 0; j < mNumList.length; j++) {
			mNumList[j] = (int) Math.abs(Math.random() * 100 + 1);
		}
	}
	@Override
	public int[] getUserAnswer() {
		return mUserAnswerList;
	}
    @Override
    public void setUserAnswerList(int[] userAnswer){
    	for(int i = 0; i < userAnswer.length; ++i)
    	{
    		mUserAnswerList[i] = userAnswer[i];
    	}	
    }
	@Override
	public String getQuestionType() {
		// TODO Auto-generated method stub
		return "SortNum";
	}
}
