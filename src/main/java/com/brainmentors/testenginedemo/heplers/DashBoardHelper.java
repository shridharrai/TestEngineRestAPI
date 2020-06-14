package com.brainmentors.testenginedemo.heplers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainmentors.testenginedemo.DAO.UserDAO;

@Component
public class DashBoardHelper {
	@Autowired
	private UserDAO dao;
	
	public int getUId(String userid) {
		return dao.getUId(userid);
	}
}
