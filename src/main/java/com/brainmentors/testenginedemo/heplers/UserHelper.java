package com.brainmentors.testenginedemo.heplers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainmentors.testenginedemo.DAO.UserDAO;
import com.brainmentors.testenginedemo.models.user.User;
import com.brainmentors.testenginedemo.models.user.UserInfo;
import com.brainmentors.testenginedemo.utils.MessageBundle;
import com.brainmentors.testenginedemo.utils.StatusCode;

@Component
public class UserHelper {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private MessageBundle messageBundle;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserInfo login(User userObject) {
		return userDAO.doLogin(userObject);
	}
	
	public UserInfo register(User user) {
		UserInfo response = new UserInfo();
		int record = userDAO.register(user);
		if (record > 0) {
			int uid = userDAO.getUId(user.getUserid());
			int roleid = userDAO.getRoleId(user.getRole());
			int rec = userDAO.userRoleMap(uid, roleid);
			if (rec > 0) {
				if (user.getRegcode() != null) {
					int records = userDAO.userRegCodeMap(uid, user.getRegcode());
				}
				response.setStatuscode(StatusCode.SUCCESS);
				response.setMessage(messageBundle.getMessage("register.msg"));
				return response;
			}
		}
		response.setStatuscode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("register.errormsg"));
		return response;
	}
}
