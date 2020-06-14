package com.brainmentors.testenginedemo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmentors.testenginedemo.heplers.DashBoardHelper;
import com.brainmentors.testenginedemo.models.user.DashBoardResponse;
import com.brainmentors.testenginedemo.models.user.User;

@Service
public class DashBoardService {
	@Autowired
	private TestService testservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private DashBoardHelper helper;
	
	public DashBoardResponse dashboard(User user) {
		DashBoardResponse response = new DashBoardResponse();
		response.setUserinfo(userservice.login(user));
		int uid = helper.getUId(user.getUserid());
		response.setTestinfo(testservice.getAllTest(uid));
		return response;
	}
}
