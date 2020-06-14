package com.brainmentors.testenginedemo.models.test;

public class Answer {
	private int qid;
	private int id;
	private String name;
	private String descr;
	private String status;
	private String rightAns;
	
    @Override
	public String toString() {
		return "Answer [qid=" + qid + ", id=" + id + ", name=" + name + ", descr=" + descr + ", status=" + status
				+ ", rightAns=" + rightAns + "]";
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getRightAns() {
		return rightAns;
	}
	public void setRightAns(String rightAns) {
		this.rightAns = rightAns;
	}
//	public int getQid() {
//		return Qid;
//	}
//	public void setQid(int qid) {
//		Qid = qid;
//	}
}
