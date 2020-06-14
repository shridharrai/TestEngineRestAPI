package com.brainmentors.testenginedemo.models.test;

import java.util.ArrayList;

public class RegCodesResponse {
	private ArrayList<String> codes;
	private int groupid;
	private String statusCode;
	private String message;
	public ArrayList<String> getCodes() {
		return codes;
	}
	public void setCodes(ArrayList<String> codes) {
		this.codes = codes;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
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
		return "RegCodesResponse [codes=" + codes + ", groupid=" + groupid + ", statusCode=" + statusCode + ", message="
				+ message + "]";
	}
}
