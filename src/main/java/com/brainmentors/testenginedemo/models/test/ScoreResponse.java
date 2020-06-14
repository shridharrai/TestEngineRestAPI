package com.brainmentors.testenginedemo.models.test;

import java.util.ArrayList;

public class ScoreResponse {
	private ArrayList<ScoreCard> scores;
	private String statuscode;
	@Override
	public String toString() {
		return "ScoreResponse [scores=" + scores + ", statuscode=" + statuscode + "]";
	}
	public ArrayList<ScoreCard> getScores() {
		return scores;
	}
	public void setScores(ArrayList<ScoreCard> scores) {
		this.scores = scores;
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
}
