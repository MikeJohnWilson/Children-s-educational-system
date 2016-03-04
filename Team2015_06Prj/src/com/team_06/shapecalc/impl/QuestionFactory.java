package com.team_06.shapecalc.impl;

import com.team_06.shapecalc.impl.CircleQuestionImpl;
import com.team_06.shapecalc.impl.TriangleQuestionImpl;
import com.team_06.shapecalc.impl.RectangleQuestionImpl;
import com.team_06.sort.impl.SortQuestionImpl;
import com.team_06.sort.impl.FindExtremeQuestionImpl;
import com.team_06.question.Question;
import com.team_06.shapejudge.impl.TriangleJudgeQuestionImpl;

public class QuestionFactory {
	public Question createQuestion(int type) {
		Question mQuestion = null;
		switch (type) {
		case 1:
			mQuestion = new TriangleQuestionImpl();
			break;
		case 2:
			mQuestion = new RectangleQuestionImpl();
			break;
		case 3:
			mQuestion = new CircleQuestionImpl();
			break;
		case 4:
			mQuestion = new SortQuestionImpl();
			break;
		case 5:
			mQuestion = new FindExtremeQuestionImpl();
			break;
		case 6:
			mQuestion = new TriangleJudgeQuestionImpl();
			break;
		}
		return mQuestion;
	}

	public Question CreateQuestion(String type) {
		Question mQuestion = null;
		if (type == "Triangle")
			mQuestion = new TriangleQuestionImpl();
		else if (type == "Rectangle")
			mQuestion = new RectangleQuestionImpl();
		else if (type == "Circle")
			mQuestion = new CircleQuestionImpl();
		else if (type == "Sort")
			mQuestion = new SortQuestionImpl();
		else if (type == "Find")
			mQuestion = new FindExtremeQuestionImpl();
		else if (type == "TriangleJudge")
			mQuestion = new TriangleJudgeQuestionImpl();

		return mQuestion;
	}

	public int getQuestionTypeId(String type) {
		int typeid = 1;
		if (type == "class com.team_06.shapecalc.impl.TriangleQuestionImpl")
			typeid = 1;
		else if (type == "class com.team_06.shapecalc.impl.RectangleQuestionImpl")
			typeid = 2;
		else if (type == "class com.team_06.shapecalc.impl.CircleQuestionImpl")
			typeid = 3;
		else if (type == "class com.team_06.shapecalc.impl.SortQuestionImpl")
			typeid = 4;
		else if (type == "class com.team_06.shapecalc.impl.FindExtremeQuestionImpl")
			typeid = 5;
		else if (type == "class com.team_06.question.IShapeJudgeQusition.TriangleJudgeQuestionImpl")
			typeid = 6;
		return typeid;
	}

}
