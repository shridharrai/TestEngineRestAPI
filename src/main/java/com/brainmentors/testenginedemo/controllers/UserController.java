package com.brainmentors.testenginedemo.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.testenginedemo.Services.IUserService;
import com.brainmentors.testenginedemo.models.user.User;
import com.brainmentors.testenginedemo.models.user.UserInfo;
import com.brainmentors.testenginedemo.utils.MessageBundle;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private IUserService userService;
	private Logger logger = Logger.getLogger(UserController.class);
	
	
	@RequestMapping(method = RequestMethod.POST,path = "/login",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> doLogin(@RequestBody User userObject, HttpSession session) {
		System.out.println("DO Login "+userObject);
		logger.debug("Inside doLogin "+userObject.getUserid());
		UserInfo userInfo = userService.login(userObject);
		logger.debug("After Service call Data is coming  "+userInfo);
		if(userInfo!=null) {
			userInfo.setTokenId(session.getId());
			System.out.println(":::::: Token Generated on Server "+session.getId());
			userInfo.setMessage("Login SuccessFully");
			return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
		}
		else {
			userInfo = new UserInfo();
			userInfo.setMessage("Invalid Userid or Password");
		}
		logger.debug("Ending Login "+userInfo);
		return new ResponseEntity<UserInfo>(userInfo, HttpStatus.FORBIDDEN);
	}
	
	@PostMapping(path="/register")
	public @ResponseBody UserInfo register(@RequestBody User user) {
		return userService.register(user);
	}
	
}
