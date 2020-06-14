package com.brainmentors.testenginedemo.models.test;

import java.util.ArrayList;

public class QuestionResponse {
	private String message;
	private String statusCode;
	private int testid;
	private int uid;
	private ArrayList<Question> questions;
	@Override
	public String toString() {
		return "QuestionResponse [message=" + message + ", statusCode=" + statusCode + ", testid=" + testid
				+ ", questions=" + questions + ", uid=" + uid + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
