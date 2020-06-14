package com.brainmentors.testenginedemo.models.test;

import java.util.List;

public class Question {
//	private int testid;
	private int uid;
	private int qid;
	private String name;
	private int score;
	private String status;
	private List<Answer> answers;
	@Override
	public String toString() {
		return "Question [uid=" + uid + ", qid=" + qid + ", name=" + name + ", score=" + score + ", status=" + status
				+ ", answers=" + answers + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
//	public int getTestid() {
//		return testid;
//	}
//	public void setTestid(int testid) {
//		this.testid = testid;
//	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
