package com.brainmentors.testenginedemo.models.group;

import java.util.ArrayList;

public class GroupResponse {
	private int groupid;
	private int userid;
	private String statusCode;
	private String message;
	private ArrayList<Group> groups;
	@Override
	public String toString() {
		return "GroupResponse [groupid=" + groupid + ", userid=" + userid + ", statusCode=" + statusCode + ", message="
				+ message + ", groups=" + groups + "]";
	}
	public ArrayList<Group> getGroups() {
		return groups;
	}
	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
}
