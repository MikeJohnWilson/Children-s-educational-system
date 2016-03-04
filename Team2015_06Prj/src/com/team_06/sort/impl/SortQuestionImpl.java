package com.team_06.sort.impl;

public class SortQuestionImpl extends GetNumQuestionImpl {
	//自定义默认构造函数 ，对数据经行初始化
	public SortQuestionImpl(){
		super();
		mQuestionName = "数字排序";
		setNumList();
		setAnswerList(getRightAnswer());
		isRightAnswer();
	}

	@Override
	public String getQuestionString() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < mNumList.length; i++) {
			str += String.valueOf(mNumList[i]);
			str += ",";
		}

		String temp = new String();
		temp = "将下面十个数字从小到大进行排序,注意：输入的数字之间以空格隔开输入" + str;
		return temp;

		// return super.getQusitionString();
	}

	@Override
	public String getRightAnswerString() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < mRightAnswerList.length; i++) {
			str += String.valueOf(mRightAnswerList[i]);
			str += ",";
		}
		return str; // @auther zhw 15/10/8 3:36 pm 按前端要求，精简显示的字符
		// return super.getRightAnswerString();
	}

	@Override
	public String getAnsewerString() {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < mUserAnswerList.length; i++) {
			str += String.valueOf(mUserAnswerList[i]);
			str += ",";
		}
		return str; // @auther zhw 15/10/8 3:36 pm 按前端要求，精简显示的字符
		        
		// return super.getAnsewerString();
	}

	@Override
	public int[] getRightAnswer() {
		// TODO Auto-generated method stub
		//auther zhw 15/10/08 4:05 pm mNumList应该是题目的原始数据，如果
		//原来的操作，将会改变原始数据，所以建议将原始数据做拷贝
		//然后在备份数据上进行操作
		int[] backdata = new int[10];	
		for(int i = 0; i < mNumList.length; ++i)
		{
			backdata[i] = mNumList[i];
			System.out.println(backdata[i] + "  ");
		}
		for (int i = 0; i < backdata.length - 1; i++) {
			for (int j = i + 1; j < backdata.length; j++) {
				if (backdata[i] > backdata[j]) {
					int tmp = backdata[i];
					backdata[i] = backdata[j];
					backdata[j] = tmp;
				}
			}
		}
		return backdata;
	}

	@Override
	public void setAnswerList(int[] rightAnswer) {
		// TODO Auto-generated method stub
		for (int k = 0; k < rightAnswer.length; k++) {
			mRightAnswerList[k] = rightAnswer[k];
		}
	}
	@Override
	public boolean answered() {
		// TODO Auto-generated method stub
		if (mUserAnswerList.length > 0) {
			return true;
		} else {
			return false;
		}

		// return super.answer();
	}

	@Override //@auther zhw ，修改set函数为空类型，无需返回值  15/10/08 3:46 pm
	public void setNumList() {
		// TODO Auto-generated method stub
		super.setNumList();
	}
	@Override
	public void isRightAnswer() {
		//@auther zhw 15/10/08 删除对mIsRight 的初始化，因为基类中已经初始化，
		//无需再做多余工作
		mIsRight = true;
		for (int i = 0; i < mUserAnswerList.length; i++) {
			if (mUserAnswerList[i] != mRightAnswerList[i]) {
				mIsRight = false;
		   	    break;
			}
		}
	}
	@Override
	public String getAnswerInfo() {
		// TODO Auto-generated method stub
		isRightAnswer(); // @auther zhw 15/10/08 4:47 添加该函数，相当于更新数据mIsRight
		String isRight = new String();
		if (mIsRight) {
			isRight = "您的答案正确";
		} else {
			isRight = "您的答案错误";
		}
		return isRight;
	}
}
