package com.brainmentors.testenginedemo.models.test;

import java.util.ArrayList;

public class QuestionTestMap {
	private ArrayList<Integer> questionids;
	private int testid;
	public ArrayList<Integer> getQuestionids() {
		return questionids;
	}
	public void setQuestionids(ArrayList<Integer> questionids) {
		this.questionids = questionids;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	@Override
	public String toString() {
		return "QuestionTestMapModel [questionids=" + questionids + ", testid=" + testid + "]";
	}
}
