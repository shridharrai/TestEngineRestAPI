package com.brainmentors.testenginedemo.models.test;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Test {
	private int uid;
	private int id;
	private String name;
	private String descr;
	private int noOfAttempts;
	private int duration;
	private int passingScore;
	private String createdBy;
	private Date creationDateTime;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public int getNoOfAttempts() {
		return noOfAttempts;
	}
	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPassingScore() {
		return passingScore;
	}
	public void setPassingScore(int passingScore) {
		this.passingScore = passingScore;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDateTime() {
		return creationDateTime;
	}
	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	@Override
	public String toString() {
		return "Test [uid=" + uid + ", id=" + id + ", name=" + name + ", descr=" + descr + ", noOfAttempts="
				+ noOfAttempts + ", duration=" + duration + ", passingScore=" + passingScore + ", createdBy="
				+ createdBy + ", creationDateTime=" + creationDateTime + "]";
	}
}
