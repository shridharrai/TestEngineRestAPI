package com.brainmentors.testenginedemo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.brainmentors.testenginedemo.models.test.Answer;
import com.brainmentors.testenginedemo.models.test.Question;
import com.brainmentors.testenginedemo.models.test.ScoreCard;
import com.brainmentors.testenginedemo.models.test.Test;
import com.brainmentors.testenginedemo.models.test.TestResponse;
import com.brainmentors.testenginedemo.models.user.Right;
import com.brainmentors.testenginedemo.models.user.UserInfo;
import com.brainmentors.testenginedemo.utils.MessageBundle;
import com.brainmentors.testenginedemo.utils.Query;
import com.brainmentors.testenginedemo.utils.StatusCode;

@Repository
public class TestDAO {
	@Autowired
	JdbcTemplate template;
	@Autowired
	private MessageBundle messageBundle;
	private Logger logger = Logger.getLogger(UserDAO.class);
	
	public TestResponse addTest(Test test) {
		int records = template.update(Query.TEST_ADD_SQL,test.getName(), test.getDescr(),
				test.getDuration(),test.getNoOfAttempts(), test.getCreatedBy(),
				test.getCreationDateTime(), test.getPassingScore());
		TestResponse response = new TestResponse();
		if(records>0) {
			
//			response.setName(test.getCreatedBy());
			response.setMessage(messageBundle.getMessage("test.msg"));
			response.setStatusCode(StatusCode.SUCCESS);
			
		}
		else {
			response.setMessage(messageBundle.getMessage("test.errormsg"));
			response.setStatusCode(StatusCode.FAIl);
		}
		return response;
	}
	
	public int getTestId(String name) {
		int testid = template.queryForObject(Query.TEST_SELECT_BY_ID, new Object[] {name}, Integer.class);
		return testid;
	}

	public boolean addTestMap(int testId, int uid) {
		int records = template.update(Query.TEST_MAPPING_ADD_SQL,testId, uid);
		return records>0;
	}
	
	public int addQuestion(Question question) {
		int records = template.update(Query.ADD_QUESTION, question.getName(), question.getScore());
		return records;
	}
	
	public int getQuestionId(String name) {
		int questionId = template.queryForObject(Query.QUESTION_BY_ID, new Object[] {name}, Integer.class);
		return questionId;
	}
	
	public int addAnswer(List<Answer> answers, int questionid) {
		int records = 0;
		for (Answer answer : answers) {
			records = template.update(Query.ADD_ANSWER, answer.getName(), answer.getDescr(), answer.getRightAns(), questionid);
		}
		return records;
	}
	
	public int testQuestionMap(List<Integer> questionids, int testid) {
		int records = 0;
		for (Integer questionid : questionids) {
			records = template.update(Query.QUESTION_TEST_MAPPING, testid, questionid);
		}
		return records;
	}
	
	public ArrayList<Question> getAllQuestionsByTest(int testid) {
		List<Question> questions = template.query(Query.GET_ALL_QUESTIONS_BY_TEST, new Object[] {testid}, new QuestionMapper());
		System.out.println("Questions are "+questions);
		return (ArrayList<Question>) questions;
	}
	
	public ArrayList<Question> getAllQuestionsByUser(int userid) {
		List<Question> questions = template.query(Query.GET_ALL_QUESTIONS_BY_USER, new Object[] {userid}, new QuestionMapper());
		System.out.println("Questions are "+questions);
		return (ArrayList<Question>) questions;
	}
	
	public ArrayList<Answer> getAnswers(int questionid) {
		List<Answer> answers = template.query(Query.GET_ANSWERS, new Object[] {questionid}, new AnswerMapper());
//		System.out.println("Answers are "+answers);
		return (ArrayList<Answer>) answers;
	}
	
	public Question getQuestion(int questionid) {
		List<Question> questions = template.query(Query.GET_QUESTION, new Object[] {questionid}, new QuestionMapper());
		return questions.get(0);
	}

	public int UserQuestionMap(int uid, int questionId) {
		// TODO Auto-generated method stub
		int rec = template.update(Query.USER_QUESTION_MAPPING, uid, questionId);
		return rec;
	}
	
	public ArrayList<Test> getAllTest(int uid) {
		List<Test> tests = template.query(Query.GET_ALL_TEST, new Object[] {uid}, new TestMapper());
		return (ArrayList<Test>) tests;
	}
	
	public int generateRegCodes(int gid, int num) {
		int record = 0;
		for (int i = 0; i < num; i++) {
			UUID code = UUID.randomUUID();
			record = template.update(Query.REG_CODES, code.toString(), gid);
		}
		System.out.println("Records are "+record);
		return record;
	}
	
	public ArrayList<String> getRegCodes(int gid) {
		List<String> codes = template.queryForList(Query.GET_REG_CODES, new Object[] {gid}, String.class);
		return (ArrayList<String>) codes;
	}
	
	public ArrayList<ScoreCard> getScores(int testid) {
		List<ScoreCard> scores = template.query(Query.GET_SCORE, new Object[] {testid}, new ScoreMapper());
		System.out.println(scores);
		return (ArrayList<ScoreCard>) scores;
	}
}

class QuestionMapper implements RowMapper<Question>{

	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Question question = new Question();
		question.setQid(rs.getInt("id"));
		question.setName(rs.getString("name"));
		question.setStatus(rs.getString("status"));
		question.setScore(rs.getInt("score"));
		return question;
	}
}

class AnswerMapper implements RowMapper<Answer>{

	public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Answer answer = new Answer();
		answer.setId(rs.getInt("id"));
		answer.setName(rs.getString("name"));
		answer.setDescr(rs.getString("descr"));
		answer.setStatus(rs.getString("status"));
		answer.setRightAns(rs.getString("rightAns"));
		answer.setQid(rs.getInt("Qid"));
		return answer;
	}
}

class TestMapper implements RowMapper<Test> {

	public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.setId(rs.getInt("testid"));
		test.setName(rs.getString("name"));
		test.setDescr(rs.getString("descr"));
		test.setDuration(rs.getInt("duration"));
		test.setNoOfAttempts(rs.getInt("attempts"));
		test.setPassingScore(rs.getInt("passingScore"));
		test.setCreatedBy(rs.getString("createdby"));
		test.setCreationDateTime(rs.getDate("creationtime"));
		return test;
	}
	
}

class ScoreMapper implements RowMapper<ScoreCard> {

	@Override
	public ScoreCard mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ScoreCard scorecard = new ScoreCard();
		scorecard.setScore(rs.getInt("score"));
		scorecard.setUid(rs.getInt("uid"));
		return scorecard;
	}
	
}
