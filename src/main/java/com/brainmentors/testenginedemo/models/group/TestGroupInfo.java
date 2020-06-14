package com.brainmentors.testenginedemo.models.group;

import java.util.ArrayList;

import com.brainmentors.testenginedemo.models.test.Test;

public class TestGroupInfo {
	private int testid;
	private ArrayList<Integer> gIds;
	private ArrayList<Test> tests;
	private String message;
	@Override
	public String toString() {
		return "TestGroupInfo [testid=" + testid + ", gIds=" + gIds + ", tests=" + tests + ", message=" + message + "]";
	}
	public ArrayList<Test> getTests() {
		return tests;
	}
	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public ArrayList<Integer> getgIds() {
		return gIds;
	}
	public void setgIds(ArrayList<Integer> gIds) {
		this.gIds = gIds;
	}
}
