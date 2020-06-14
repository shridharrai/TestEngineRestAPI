package com.brainmentors.testenginedemo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmentors.testenginedemo.heplers.UserHelper;
import com.brainmentors.testenginedemo.models.user.User;
import com.brainmentors.testenginedemo.models.user.UserInfo;

@Service
public class UserService implements IUserService {
	@Autowired
	UserHelper helper;
	
	public UserHelper getHelper() {
		return helper;
	}

	public void setHelper(UserHelper helper) {
		this.helper = helper;
	}
	
	public UserInfo login(User userObject) {
		// TODO Auto-generated method stub
		return helper.login(userObject);
	}
	
	public UserInfo register(User user) {
		return helper.register(user);
	}
}
