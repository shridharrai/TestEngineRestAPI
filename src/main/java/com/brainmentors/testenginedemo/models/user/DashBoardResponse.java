package com.brainmentors.testenginedemo.models.user;

import org.springframework.stereotype.Component;

import com.brainmentors.testenginedemo.models.test.TestResponse;

@Component
public class DashBoardResponse {
	private UserInfo userinfo;
	private TestResponse testinfo;
	@Override
	public String toString() {
		return "DashBoardResponse [userinfo=" + userinfo + ", testinfo=" + testinfo + "]";
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public TestResponse getTestinfo() {
		return testinfo;
	}
	public void setTestinfo(TestResponse testinfo) {
		this.testinfo = testinfo;
	}
}
