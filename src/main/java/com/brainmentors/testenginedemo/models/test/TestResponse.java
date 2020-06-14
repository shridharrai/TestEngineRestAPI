package com.brainmentors.testenginedemo.models.test;

import java.util.ArrayList;

public class TestResponse {
	private int testid;
//	private String name;
	private String message;
	private String statusCode;
	private ArrayList<Test> tests;
	public ArrayList<Test> getTests() {
		return tests;
	}
	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
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
	@Override
	public String toString() {
		return "TestResponse [testid=" + testid + ", message=" + message + ", statusCode=" + statusCode + ", tests="
				+ tests + "]";
	}
}
