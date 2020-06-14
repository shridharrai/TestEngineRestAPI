package com.brainmentors.testenginedemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.testenginedemo.models.group.GroupResponse;
import com.brainmentors.testenginedemo.models.group.TestGroupInfo;
import com.brainmentors.testenginedemo.models.test.Question;
import com.brainmentors.testenginedemo.models.test.StudentAnswer;
import com.brainmentors.testenginedemo.models.test.StudentAnswerResponse;
import com.brainmentors.testenginedemo.Services.StudentService;
import com.brainmentors.testenginedemo.models.group.Group;

@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping(path = "/addGroup")
	public @ResponseBody GroupResponse createGroup(@RequestBody Group group) {
		return service.createGroup(group);
	}
	
	@GetMapping(path = "/getAllGroups/{uid}")
	public @ResponseBody GroupResponse getAllGroups(@PathVariable("uid") int userid) {
		return service.getAllGroups(userid);
	}
	
	@PostMapping(path = "/addGroupTest")
	public @ResponseBody TestGroupInfo testGroupMap(@RequestBody TestGroupInfo groups) {
		return service.testGroupMap(groups);
	}
	
	@GetMapping(path = "/getAllTestByStudent/{uid}")
	public @ResponseBody TestGroupInfo getAllTest(@PathVariable("uid")int userid) {
		return service.getAllTest(userid);
	}
	
	@PostMapping(path = "/addStudentAnswers")
	public @ResponseBody Question addStudentAnswers(@RequestBody StudentAnswer answer) {
		return service.addStudentAnswers(answer);
	}
	
	@PostMapping(path = "/submitTest")
	public @ResponseBody StudentAnswerResponse submit(@RequestBody StudentAnswer answer) {
		return service.submitTest(answer);
	}
	
}
