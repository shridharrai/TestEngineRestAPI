package com.brainmentors.testenginedemo.models.test;

public class ScoreCard {
	private int uid;
	private int score;
	@Override
	public String toString() {
		return "ScoreCard [uid=" + uid + ", score=" + score + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
