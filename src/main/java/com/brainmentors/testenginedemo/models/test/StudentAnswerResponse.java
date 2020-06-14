package com.brainmentors.testenginedemo.models.test;

public class StudentAnswerResponse {
	private String statusCode;
	private String message;
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "StudentAnswerResponse [statusCode=" + statusCode + ", message=" + message + ", score=" + score + "]";
	}
}
