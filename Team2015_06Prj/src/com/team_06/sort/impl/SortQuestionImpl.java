package com.team_06.sort.impl;

public class SortQuestionImpl extends GetNumQuestionImpl {
	//�Զ���Ĭ�Ϲ��캯�� �������ݾ��г�ʼ��
	public SortQuestionImpl(){
		super();
		mQuestionName = "��������";
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
		temp = "������ʮ�����ִ�С�����������,ע�⣺���������֮���Կո��������" + str;
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
		return str; // @auther zhw 15/10/8 3:36 pm ��ǰ��Ҫ�󣬾�����ʾ���ַ�
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
		return str; // @auther zhw 15/10/8 3:36 pm ��ǰ��Ҫ�󣬾�����ʾ���ַ�
		        
		// return super.getAnsewerString();
	}

	@Override
	public int[] getRightAnswer() {
		// TODO Auto-generated method stub
		//auther zhw 15/10/08 4:05 pm mNumListӦ������Ŀ��ԭʼ���ݣ����
		//ԭ���Ĳ���������ı�ԭʼ���ݣ����Խ��齫ԭʼ����������
		//Ȼ���ڱ��������Ͻ��в���
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

	@Override //@auther zhw ���޸�set����Ϊ�����ͣ����践��ֵ  15/10/08 3:46 pm
	public void setNumList() {
		// TODO Auto-generated method stub
		super.setNumList();
	}
	@Override
	public void isRightAnswer() {
		//@auther zhw 15/10/08 ɾ����mIsRight �ĳ�ʼ������Ϊ�������Ѿ���ʼ����
		//�����������๤��
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
		isRightAnswer(); // @auther zhw 15/10/08 4:47 ��Ӹú������൱�ڸ�������mIsRight
		String isRight = new String();
		if (mIsRight) {
			isRight = "���Ĵ���ȷ";
		} else {
			isRight = "���Ĵ𰸴���";
		}
		return isRight;
	}
}
