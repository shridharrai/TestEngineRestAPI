package com.brainmentors.testenginedemo.heplers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainmentors.testenginedemo.DAO.StudentDAO;
import com.brainmentors.testenginedemo.models.group.GroupResponse;
import com.brainmentors.testenginedemo.models.group.TestGroupInfo;
import com.brainmentors.testenginedemo.models.test.Question;
import com.brainmentors.testenginedemo.models.test.QuestionResponse;
import com.brainmentors.testenginedemo.models.test.StudentAnswer;
import com.brainmentors.testenginedemo.models.test.StudentAnswerResponse;
import com.brainmentors.testenginedemo.models.test.Test;
import com.brainmentors.testenginedemo.models.group.Group;
import com.brainmentors.testenginedemo.utils.MessageBundle;
import com.brainmentors.testenginedemo.utils.StatusCode;

@Component
public class StudentHelper {
	@Autowired
	private StudentDAO dao;
	@Autowired
	private MessageBundle messageBundle;
	
	public GroupResponse createGroup(Group group) {
		GroupResponse response = new GroupResponse();
		response.setUserid(group.getUid());
		dao.createGroup(group);
		int gid = dao.getGroupId(group.getName());
		if (gid > 0) {
			int record = dao.groupTeacherMap(gid, group.getUid());
			if (record > 0) {
				response.setGroupid(gid);
				response.setStatusCode(StatusCode.SUCCESS);
				response.setMessage(messageBundle.getMessage("group.msg"));
				return response;
			}
		}
		response.setStatusCode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("group.errormsg"));
		return response;
	}
	
	public GroupResponse getAllGroups(int uid) {
		GroupResponse response = new GroupResponse();
		response.setUserid(uid);
		ArrayList<Group> groups = dao.getAllGroups(uid);
		if (groups != null) {
			response.setStatusCode(StatusCode.SUCCESS);
			response.setMessage(messageBundle.getMessage("groupFetch.msg"));
			response.setGroups(groups);
			return response;
		}
		response.setStatusCode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("groupFetch.errormsg"));
		return response;
	}
	
	public TestGroupInfo testGroupMap(TestGroupInfo groups) {
		TestGroupInfo response = new TestGroupInfo();
		response.setTestid(groups.getTestid());
		int record = dao.testGroupMap(groups.getgIds(), groups.getTestid());
		if (record > 0) {
			response.setMessage(messageBundle.getMessage("group.msg"));
			return response;
		}
		response.setMessage(messageBundle.getMessage("group.errormsg"));
		return response;
	}
	
	public TestGroupInfo getAllTest(int userid) {
		TestGroupInfo response = new TestGroupInfo();
		ArrayList<Test> tests = dao.getAllTest(userid);
		if (tests != null) {
			response.setMessage(messageBundle.getMessage("testFetch.msg"));
			response.setTests(tests);
			return response;
		}
		response.setMessage(messageBundle.getMessage("testFetch.errormsg"));
		return response;
	}
	
	public StudentAnswerResponse addStudentAnswers(StudentAnswer answer) {
		StudentAnswerResponse response = new StudentAnswerResponse();
		
		Integer id = dao.getPreviousAnswers(answer.getUid(), answer.getQid(), answer.getTestid());
		
		if (id > 0) {
			System.out.println("Success "+id);
			int record = dao.updateAnswer(answer.getYourAns(), id);
			if (record > 0) {
				response.setStatusCode(StatusCode.SUCCESS);
				response.setMessage(messageBundle.getMessage("studentAnswered.msg"));
				return response;
			}
		}
		else {
			answer.setDated(new Date());
			int record = dao.addAnswer(answer);
			if (record > 0) {
				response.setStatusCode(StatusCode.SUCCESS);
				response.setMessage(messageBundle.getMessage("studentAnswered.msg"));
				return response;
			}
		}
		
		response.setStatusCode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("studentAnswered.errormsg"));
		return response;
	}
	
	public int getTotalScore(QuestionResponse res) {
		int total = 0;
		ArrayList<Question> list = res.getQuestions();
		for (Question ques : list) {
			String rightAns = dao.getrightAns(ques.getQid());
			String yourAns = dao.getuserAnswer(ques.getQid(), res.getTestid());
			if (yourAns != null) {
				if (yourAns.equalsIgnoreCase(rightAns)) {
					total = total + ques.getScore();
				}
			}
		}
		return total;
	}
	
	public StudentAnswerResponse submitTest(StudentAnswer ans, int score) {
		StudentAnswerResponse response = new StudentAnswerResponse();
		int rec = dao.submitTest(ans, score);
		if (rec > 0) {
			response.setMessage(messageBundle.getMessage("testSubmit.msg"));
			response.setStatusCode(StatusCode.SUCCESS);
			response.setScore(score);
			return response;
		}
		response.setMessage(messageBundle.getMessage("testSubmit.errormsg"));
		response.setStatusCode(StatusCode.SUCCESS);
		return response;
	}
}
