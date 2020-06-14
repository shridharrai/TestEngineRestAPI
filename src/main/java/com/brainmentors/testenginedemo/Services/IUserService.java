package com.brainmentors.testenginedemo.Services;

import com.brainmentors.testenginedemo.models.user.User;
import com.brainmentors.testenginedemo.models.user.UserInfo;

public interface IUserService {
	public UserInfo login(User userObject);
	public UserInfo register(User user);
}
