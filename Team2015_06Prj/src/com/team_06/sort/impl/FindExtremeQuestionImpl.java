package com.team_06.sort.impl;

/**
 * @author WJY ���������е����ֵ����Сֵ
 */
public class FindExtremeQuestionImpl extends GetNumQuestionImpl {
	/**
	 * mRightMaxNum �����е����ֵ mRightMinNum �����е���Сֵ mUserMaxNum �û�����������е����ֵ
	 * mUserMinNum �û�����������е���Сֵ
	 */
	public int getmRightMaxNum() {
		return mRightAnswerList[0];
	}

	public void setmRightMaxNum(int mRightMaxNum) {
		super.mRightAnswerList[0] = mRightMaxNum;
	}

	public int getmRightMinNum() {
		return mRightAnswerList[1];
	}

	public void setmRightMinNum(int mRightMinNum) {
		super.mRightAnswerList[1] = mRightMinNum;
	}

	public int getmUserMaxNum() {
		return super.mUserAnswerList[0];
	}

	public void setmUserMaxNum(int mUserMaxNum) {
		super.mUserAnswerList[0] = mUserMaxNum;
	}

	public int getmUserMinNum() {
		return super.mUserAnswerList[1];
	}

	public void setmUserMinNum(int mUserMinNum) {
		super.mUserAnswerList[1] = mUserMinNum;
	}
  
	
  // @auther ֣��ΰ��15/10/8 3:15 pm. ������ʾ��д�����캯�� �����ݾ��г�ʼ��
	public  FindExtremeQuestionImpl(){
		super();
		mQuestionName = "���Ҽ�ֵ";
		setNumList();
		getRightAnswer();
		
	}
	// public int []mList =new int [10];
	/**
	 * @param numList
	 * @return �����е����ֵ
	 */
	public int findMaxNum(int numList[]) {
		int max = 0;
		for (int i = 0; i < numList.length; i++) {
			if (max < numList[i]) {
				max = numList[i];
			}
		}
		return max;
	}
	/**
	 * @param numList
	 * @return �����е���Сֵ
	 */
	public int findMinNum(int numList[]) {
		int min = 9999;
		for (int i = 0; i < numList.length; i++) {
			if (min > numList[i]) {
				min = numList[i];
			}
		}
		return min;
	}
	@Override
	public String getQuestionString() {
		String str = "";
		for (int i = 0; i < mNumList.length; i++) {
			str += String.valueOf(mNumList[i]);
			str += ","; // ÿ������
		}
		String temp = new String();
		temp = "�ҳ�����ʮ�������е����ֵ����Сֵ:" + str;
		return temp;
	}

	@Override
	public String getRightAnswerString() {
		
		String strMaxNum = "";
		String strMinNum = "";
	//	strMaxNum += String.valueOf(findMaxNum(mNumList));
	//	strMinNum += String.valueOf(findMinNum(mNumList));
		strMaxNum += String.valueOf(mRightAnswerList[0]);
		strMinNum += String.valueOf(mRightAnswerList[1]);
		String temp = new String();
		temp = "���ֵ��:" + strMaxNum + " ��С��ֵ��:" + strMinNum;
		return temp;
	}

	@Override
	public String getAnsewerString() {
		String strMaxNum = "";
		String strMinNum = "";
		strMaxNum += String.valueOf(mUserAnswerList[0]);
		strMinNum += String.valueOf(mUserAnswerList[1]);
		String temp = new String();
		temp = "���ֵ��:" + strMaxNum + " ��Сֵ��:" + strMinNum;
		return temp;
	}

	@Override
	public int[] getRightAnswer() {
		mRightAnswerList[0] = findMaxNum(super.mNumList);
		mRightAnswerList[1] = findMinNum(super.mNumList);
		return mRightAnswerList;
	}

	@Override
	public void setAnswerList(int[] rightAnswer) {
		mRightAnswerList = getRightAnswer();
	}

	@Override
	public boolean answered() {
		if (mUserAnswerList.length > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setNumList() {
		super.setNumList();
	}
	@Override
	public void isRightAnswer() {
		//@auther zhw 15/10/08 ɾ����mIsRight �ĳ�ʼ������Ϊ�������Ѿ���ʼ����
		//�����������๤��
		mIsRight = true;
		int length = 2;
		for (int i = 0; i < length; ++i) {
			if (mUserAnswerList[i] != mRightAnswerList[i]) {
				mIsRight = false;
		   	    break;
			}
		}
	}
	@Override
	public String getAnswerInfo() {
		isRightAnswer(); // @auther zhw 15/10/08 4:46 ��Ӹú������൱�ڸ�������mIsRight
		String strAnswerInfo = "ѧ���Ĵ���:";
		if (mIsRight) {
			strAnswerInfo += "��ȷ��";
		} else {
			strAnswerInfo += "�����";
		}
		return strAnswerInfo;
	}

}
