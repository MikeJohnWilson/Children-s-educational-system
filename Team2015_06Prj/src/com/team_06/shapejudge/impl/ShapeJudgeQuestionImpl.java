package com.team_06.shapejudge.impl;

import com.team_06.question.ShapeJudgeQuestion;

public abstract class ShapeJudgeQuestionImpl implements ShapeJudgeQuestion {

	public boolean mRightAnswer;
	public boolean mAnswer;
	public boolean mIsAnswer;
	public boolean mIsRightAnswer;
	public String mAnswerInfo;

	public boolean ismRightAnswer() {
		return mRightAnswer;
	}

	public void setmRightAnswer(boolean mRightAnswer) {
		this.mRightAnswer = mRightAnswer;
	}

	public boolean ismAnswer() {
		return mAnswer;
	}

	public void setmAnswer(boolean mAnswer) {
		this.mAnswer = mAnswer;
	}

	public boolean ismIsAnswer() {
		return mIsAnswer;
	}

	public void setmIsAnswer(boolean mIsAnswer) {
		this.mIsAnswer = mIsAnswer;
	}

	public boolean ismIsRightAnswer() {
		return mIsRightAnswer;
	}

	public void setmIsRightAnswer(boolean mIsRightAnswer) {
		this.mIsRightAnswer = mIsRightAnswer;
	}

	public String getmAnswerInfo() {
		return mAnswerInfo;
	}

	public void setmAnswerInfo(String mAnswerInfo) {
		this.mAnswerInfo = mAnswerInfo;
	}

	public ShapeJudgeQuestionImpl() {
		mIsAnswer = false;
		mRightAnswer = true;
		mAnswer = false;
	}

	@Override
	public String getAnswerInfo() {
		// TODO Auto-generated method stub
		mAnswerInfo = "";
		if (this.Answered()) {
			if (this.mIsRightAnswer) {
				mAnswerInfo += "本题判断答案正确";

			} else {
				mAnswerInfo += "本题判断答案错";
			}

		} else {
			mAnswerInfo += "本题未作答";

		}

		return mAnswerInfo;
	}

	@Override
	public boolean setJudge(boolean answer) {
		// TODO Auto-generated method stub
		mIsAnswer = true;
		mAnswer = answer;
		if (this.mAnswer == this.mRightAnswer)
			mIsRightAnswer = true;
		else
			mIsRightAnswer = false;

		return mIsRightAnswer;
	}

	@Override
	public boolean getJudgeAnswer() {
		// TODO Auto-generated method stub
		return mAnswer;
	}

	@Override
	public boolean getRightAnswer() {
		// TODO Auto-generated method stub
		return mRightAnswer;
	}

	@Override
	public boolean Answered() {
		// TODO Auto-generated method stub
		return mIsAnswer;
	}
	@Override
	public String getQuestionType() {
		// TODO Auto-generated method stub
		return "ShapeJudge";
	}
}
