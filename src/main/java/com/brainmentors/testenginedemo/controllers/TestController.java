package com.brainmentors.testenginedemo.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.brainmentors.testenginedemo.Services.IUserService;
import com.brainmentors.testenginedemo.Services.TestService;
import com.brainmentors.testenginedemo.models.test.Question;
import com.brainmentors.testenginedemo.models.test.QuestionResponse;
import com.brainmentors.testenginedemo.models.test.QuestionTestMap;
import com.brainmentors.testenginedemo.models.test.RegCodesResponse;
import com.brainmentors.testenginedemo.models.test.ScoreResponse;
import com.brainmentors.testenginedemo.models.test.Test;
import com.brainmentors.testenginedemo.models.test.TestResponse;

@RestController
@CrossOrigin
public class TestController {
	@Autowired
	private TestService service;
	
	@RequestMapping(path = "/addtest",method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TestResponse createTest(@RequestBody Test test) {
		test.setCreationDateTime(new Date());
		return service.addTest(test);
		
	}
	
	@RequestMapping(path = "/addquestion",method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody QuestionResponse addQuestion(@RequestBody Question question) {
		return service.addQuestion(question);
	}
	
	@PostMapping(path = "/addQuestionsToTest")
	public @ResponseBody QuestionResponse testQuestionMap(@RequestBody QuestionTestMap questions) {
		return service.testQuestionMap(questions);
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws Exception{
		System.out.println("Inside Controller");
//		service.upload(file);
		return "Added";
	}
	
	@GetMapping("/getAllQuestionsByTest/{testid}")
	public @ResponseBody QuestionResponse getAllQuestionsByTest(@PathVariable("testid") int testid) {
		return service.getAllQuestionsByTest(testid);
	}
	
	@GetMapping("/getAllQuestionsByUser/{uid}")
	public @ResponseBody QuestionResponse getAllQuestionsByUser(@PathVariable("uid") int userid) {
		return service.getAllQuestionsByUser(userid);
	}
	
	@GetMapping("/getQuestion/{qid}")
	public @ResponseBody Question getQuestion(@PathVariable("qid") int questionid) {
		return service.getQuestion(questionid);
	}
	
	@GetMapping("/getAllTest/{uid}")
	public @ResponseBody TestResponse getAllTest(@PathVariable("uid") int userid) {
		return service.getAllTest(userid);
	}
	
	@GetMapping("/getRegCodes/{gid}/{num}")
	public @ResponseBody RegCodesResponse getRegCodes(@PathVariable("gid") int gid, @PathVariable("num") int num) {
		return service.getRegCodes(gid, num);
	}
	
	@GetMapping("/getScores/{testid}")
	public @ResponseBody ScoreResponse getScores(@PathVariable("testid") int testid) {
		return service.getScores(testid);
	}
}
