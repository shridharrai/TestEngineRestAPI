package com.brainmentors.testenginedemo.models.group;

public class Group {
	private int uid;
	private int gid;
	private String name;
	private String descr;
	private String status;
	@Override
	public String toString() {
		return "Group [uid=" + uid + ", gid=" + gid + ", name=" + name + ", descr=" + descr + ", status=" + status
				+ "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
