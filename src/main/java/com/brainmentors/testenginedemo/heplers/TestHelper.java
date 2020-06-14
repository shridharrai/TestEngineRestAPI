package com.brainmentors.testenginedemo.heplers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainmentors.testenginedemo.DAO.TestDAO;
import com.brainmentors.testenginedemo.models.test.Question;
import com.brainmentors.testenginedemo.models.test.QuestionResponse;
import com.brainmentors.testenginedemo.models.test.QuestionTestMap;
import com.brainmentors.testenginedemo.models.test.RegCodesResponse;
import com.brainmentors.testenginedemo.models.test.ScoreResponse;
import com.brainmentors.testenginedemo.models.test.Test;
import com.brainmentors.testenginedemo.models.test.TestResponse;
import com.brainmentors.testenginedemo.utils.MessageBundle;
import com.brainmentors.testenginedemo.utils.StatusCode;

@Component
public class TestHelper {
	@Autowired
	private TestDAO dao;
	@Autowired
	private MessageBundle messageBundle;

	
	
	public TestDAO getDao() {
		return dao;
	}



	public void setDao(TestDAO dao) {
		this.dao = dao;
	}

	public TestResponse addTest(Test test) {
		TestResponse response = dao.addTest(test);
		if(response.getStatusCode().equals(StatusCode.SUCCESS)) {
			int testId = dao.getTestId(test.getName());
			response.setTestid(testId);
//			response.setName(test.getName());
			int uid = test.getUid();
			boolean result = dao.addTestMap(testId, uid);
			if(!result) {
				response.setStatusCode(StatusCode.FAIl);
				response.setMessage("Error During Test Mapping");
			}
		
		}
		return response;
		}
	
	public QuestionResponse addQuestion(Question question) {
		QuestionResponse response = new QuestionResponse();
		int records = dao.addQuestion(question);
		if (records > 0) {
			int questionId = dao.getQuestionId(question.getName());
			
			int record = dao.addAnswer(question.getAnswers(), questionId);
			
			if (record > 0) {
				int rec = dao.UserQuestionMap(question.getUid(), questionId);
				
				if (rec > 0) {
					response.setStatusCode(StatusCode.SUCCESS);
					response.setMessage(messageBundle.getMessage("question.msg"));
					response.setUid(question.getUid());
					return response;
				}
				}
			
		}
		response.setStatusCode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("question.errormsg"));
		return response;
	}
	
	public QuestionResponse testQuestionMap(QuestionTestMap questions) {
		QuestionResponse response = new QuestionResponse();
		int records = dao.testQuestionMap(questions.getQuestionids(), questions.getTestid());
		if (records > 0) {
			response.setStatusCode(StatusCode.SUCCESS);
			response.setMessage(messageBundle.getMessage("question.msg"));
			response.setTestid(questions.getTestid());
			return response;
		}
		response.setStatusCode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("question.errormsg"));
		return response;
	}
	
	public QuestionResponse getAllQuestionsByTest(int testid) {
		ArrayList<Question> questions = dao.getAllQuestionsByTest(testid);
		for (Question question : questions) {
			question.setAnswers(dao.getAnswers(question.getQid()));
		}
		System.out.println("Questions finale "+questions);
		QuestionResponse response = new QuestionResponse();
		response.setStatusCode(StatusCode.SUCCESS);
		response.setTestid(testid);
		response.setQuestions(questions);
		return response;
	}
	
	public QuestionResponse getAllQuestionsByUser(int userid) {
		ArrayList<Question> questions = dao.getAllQuestionsByUser(userid);
		for (Question question : questions) {
			question.setAnswers(dao.getAnswers(question.getQid()));
		}
		System.out.println("Questions finale "+questions);
		QuestionResponse response = new QuestionResponse();
		response.setStatusCode(StatusCode.SUCCESS);
		response.setUid(userid);
		response.setQuestions(questions);
		return response;
	}
	
	public Question getQuestion(int questionid) {
		Question question = dao.getQuestion(questionid);
		question.setAnswers(dao.getAnswers(question.getQid()));
		System.out.println("Question is "+question);
		return question;
	}
	
	public TestResponse getAllTest(int uid) {
		TestResponse response = new TestResponse();
		ArrayList<Test> tests = dao.getAllTest(uid);
		if (tests != null) {
			response.setStatusCode(StatusCode.SUCCESS);
			response.setMessage(messageBundle.getMessage("testFetch.msg"));
			response.setTests(tests);
			return response;
		}
		response.setStatusCode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("testFetch.errormsg"));
		return response;
	}
	
	public RegCodesResponse getRegCodes(int gid, int num) {
		RegCodesResponse response = new RegCodesResponse();
		response.setGroupid(gid);
		int rec = dao.generateRegCodes(gid, num);
		if (rec > 0) {
			List<String> codes = dao.getRegCodes(gid);
			System.out.println("Size "+codes.size());
			if (codes.size() >= num) {
				response.setCodes((ArrayList<String>) codes);
				response.setStatusCode(StatusCode.SUCCESS);
				response.setMessage(messageBundle.getMessage("regcode.msg"));
				return response;
			}
		}
		response.setStatusCode(StatusCode.FAIl);
		response.setMessage(messageBundle.getMessage("regcode.errormsg"));
		return response;
	}
	
	public ScoreResponse getScores(int testid) {
		ScoreResponse response = new ScoreResponse();
		response.setScores(dao.getScores(testid));
		response.setStatuscode(StatusCode.SUCCESS);
		return response;
	}
}
