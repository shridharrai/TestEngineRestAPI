package com.brainmentors.testenginedemo.models.test;

import java.util.Date;

public class StudentAnswer {
	private int uid;
	private int testid;
	private int qid;
	private String yourAns;
	private Date dated;
	private int nextqid;
	public int getNextqid() {
		return nextqid;
	}
	public void setNextqid(int nextqid) {
		this.nextqid = nextqid;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
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
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getYourAns() {
		return yourAns;
	}
	public void setYourAns(String yourAns) {
		this.yourAns = yourAns;
	}
	@Override
	public String toString() {
		return "StudentAnswer [uid=" + uid + ", testid=" + testid + ", qid=" + qid + ", yourAns=" + yourAns + ", dated="
				+ dated + ", nextqid=" + nextqid + "]";
	}
}
