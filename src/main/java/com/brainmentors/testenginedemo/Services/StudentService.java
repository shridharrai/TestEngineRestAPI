package com.brainmentors.testenginedemo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmentors.testenginedemo.heplers.StudentHelper;
import com.brainmentors.testenginedemo.models.group.Group;
import com.brainmentors.testenginedemo.models.group.GroupResponse;
import com.brainmentors.testenginedemo.models.group.TestGroupInfo;
import com.brainmentors.testenginedemo.models.test.Question;
import com.brainmentors.testenginedemo.models.test.QuestionResponse;
import com.brainmentors.testenginedemo.models.test.StudentAnswer;
import com.brainmentors.testenginedemo.models.test.StudentAnswerResponse;
import com.brainmentors.testenginedemo.utils.StatusCode;

@Service
public class StudentService {
	@Autowired
	private StudentHelper helper;
	@Autowired
	private TestService service;
	
	public GroupResponse createGroup(Group group) {
		return helper.createGroup(group);
	}
	
	public GroupResponse getAllGroups(int uid) {
		return helper.getAllGroups(uid);
	}
	
	public TestGroupInfo testGroupMap(TestGroupInfo groups) {
		return helper.testGroupMap(groups);
	}
	
	public TestGroupInfo getAllTest(int userid) {
		return helper.getAllTest(userid);
	}
	
	public Question addStudentAnswers(StudentAnswer answer) {
		StudentAnswerResponse response = helper.addStudentAnswers(answer);
		if (response.getStatusCode() == StatusCode.SUCCESS) {
			return service.getQuestion(answer.getNextqid());
		}
		return null;
	}
	
	public StudentAnswerResponse submitTest(StudentAnswer answer) {
		StudentAnswerResponse response = helper.addStudentAnswers(answer);
		if (response.getStatusCode() == StatusCode.SUCCESS) {
			QuestionResponse res = service.getAllQuestionsByTest(answer.getTestid());
			if (res != null) {
				int score = helper.getTotalScore(res);
				return helper.submitTest(answer, score);
			}
		}
		response.setStatusCode(StatusCode.FAIl);
		return response;
	}
}
