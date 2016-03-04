package com.team_06.sort.impl;

/**
 * @author WJY 查找数组中的最大值和最小值
 */
public class FindExtremeQuestionImpl extends GetNumQuestionImpl {
	/**
	 * mRightMaxNum 数组中的最大值 mRightMinNum 数组中的最小值 mUserMaxNum 用户输入的数组中的最大值
	 * mUserMinNum 用户输入的数组中的最小值
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
  
	
  // @auther 郑宏伟，15/10/8 3:15 pm. 必须显示的写出构造函数 对数据经行初始化
	public  FindExtremeQuestionImpl(){
		super();
		mQuestionName = "查找极值";
		setNumList();
		getRightAnswer();
		
	}
	// public int []mList =new int [10];
	/**
	 * @param numList
	 * @return 数组中的最大值
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
	 * @return 数组中的最小值
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
			str += ","; // 每个数字
		}
		String temp = new String();
		temp = "找出下面十个数字中的最大值和最小值:" + str;
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
		temp = "最大值是:" + strMaxNum + " 最小的值是:" + strMinNum;
		return temp;
	}

	@Override
	public String getAnsewerString() {
		String strMaxNum = "";
		String strMinNum = "";
		strMaxNum += String.valueOf(mUserAnswerList[0]);
		strMinNum += String.valueOf(mUserAnswerList[1]);
		String temp = new String();
		temp = "最大值是:" + strMaxNum + " 最小值是:" + strMinNum;
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
		//@auther zhw 15/10/08 删除对mIsRight 的初始化，因为基类中已经初始化，
		//无需再做多余工作
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
		isRightAnswer(); // @auther zhw 15/10/08 4:46 添加该函数，相当于更新数据mIsRight
		String strAnswerInfo = "学生的答案是:";
		if (mIsRight) {
			strAnswerInfo += "正确的";
		} else {
			strAnswerInfo += "错误的";
		}
		return strAnswerInfo;
	}

}
