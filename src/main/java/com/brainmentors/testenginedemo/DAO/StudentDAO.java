package com.brainmentors.testenginedemo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.brainmentors.testenginedemo.models.group.Group;
import com.brainmentors.testenginedemo.models.test.StudentAnswer;
import com.brainmentors.testenginedemo.models.test.Test;
import com.brainmentors.testenginedemo.utils.Query;

@Repository
public class StudentDAO {
	@Autowired
	private JdbcTemplate template;
	
	public int createGroup(Group group) {
		int rec = template.update(Query.CREATE_GROUP, group.getName(), group.getDescr());
		return rec;
	}
	
	public int getGroupId(String name) {
		int groupId = template.queryForObject(Query.GET_GROUP_BY_NAME, new Object[] {name}, Integer.class);
		return groupId;
	}
	
	public int groupTeacherMap(int gid, int uid) {
		int rec = template.update(Query.TEACHER_GROUP_MAPPING, gid, uid);
		return rec;
	}
	
	public ArrayList<Group> getAllGroups(int uid) {
		List<Group> groups = template.query(Query.GET_ALL_GROUP, new Object[] {uid}, new GroupMapper());
		return (ArrayList<Group>) groups;
	}
	
	public int testGroupMap(ArrayList<Integer> gids, int testid) {
		int rec = 0;
		for (Integer gid : gids) {
			rec = template.update(Query.TEST_GROUP_MAPPING, testid, gid);
		}
		return rec;
	}
	
	public ArrayList<Test> getAllTest(int uid) {
		List<Test> tests = template.query(Query.GET_ALL_TEST_FOR_STUDENT, new Object[] {uid}, new TestMapper());
		return (ArrayList<Test>) tests;
	}
	
	public Integer getPreviousAnswers(int uid, int qid, int testid) {
		
		try {
		Integer id = template.queryForObject(Query.GET_PREVIOUS_ANSWERS, new Object[] {uid, qid, testid}, Integer.class);
		return id;
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public int updateAnswer(String newAnswer, int id) {
		int record = template.update(Query.UPDATE_STUDENT_ANSWER, newAnswer, id);
		return record;
	}
	
	public int addAnswer(StudentAnswer answer) {
		int record = template.update(Query.ADD_STUDENT_ANSWER, answer.getUid(), answer.getTestid(), answer.getQid(), answer.getYourAns(), answer.getDated());
		return record;
	}
	
	public String getrightAns(int id) {
		String rightAns = template.queryForObject(Query.GET_RIGHT_ANSWER, new Object[] {id, "Y"}, String.class);
		return rightAns;
	}
	
	public String getuserAnswer(int qid, int testid) {
		String yourAns = template.queryForObject(Query.GET_USER_ANSWER, new Object[] {qid, testid}, String.class);
		return yourAns;
	}
	
	public int submitTest(StudentAnswer ans, int score) {
		int record = template.update(Query.SUBMIT_TEST, ans.getUid(), ans.getTestid(), score);
		return record;
	}
}

class GroupMapper implements RowMapper<Group> {

	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Group group = new Group();
		group.setGid(rs.getInt("gid"));
		group.setName(rs.getString("name"));
		group.setDescr(rs.getString("descr"));
		group.setStatus(rs.getString("status"));
		return group;
	}
	
}

//class TestMapper implements RowMapper<Test> {
//
//	public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
//		// TODO Auto-generated method stub
//		Test test = new Test();
//		test.setId(rs.getInt("testid"));
//		test.setName(rs.getString("name"));
//		test.setDescr(rs.getString("descr"));
//		test.setDuration(rs.getInt("duration"));
//		test.setNoOfAttempts(rs.getInt("attempts"));
//		test.setPassingScore(rs.getInt("passingScore"));
//		test.setCreatedBy(rs.getString("createdby"));
//		test.setCreationDateTime(rs.getDate("creationtime"));
//		return test;
//	}
//	
//}