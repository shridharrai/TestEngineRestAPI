package com.brainmentors.testenginedemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.testenginedemo.Services.DashBoardService;
import com.brainmentors.testenginedemo.models.user.DashBoardResponse;
import com.brainmentors.testenginedemo.models.user.User;

@RestController
public class DashBoardController {
	@Autowired
	private DashBoardService service;
	
	@PostMapping(path="/dashboard")
	public @ResponseBody DashBoardResponse dashboard(@RequestBody User user) {
		return service.dashboard(user);
	}
}
