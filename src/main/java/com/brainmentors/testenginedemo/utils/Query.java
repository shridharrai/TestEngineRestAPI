package com.brainmentors.testenginedemo.utils;

public interface Query {
	String LOGIN_SQL = "select user.uid, userid, user.name as uname, phone ,email, role.name as rolename, rights.name as rightname,"
			+ " rights.url from user_mst user, role_mst role, user_role_mapping urmap, "
			+ "right_mst rights,role_right_mapping rrmap  where userid=? and password=?"
			+ " and user.uid=urmap.uid and role.roleid=urmap.roleid and rrmap.roleid=role.roleid "
			+ "and rrmap.rightid=rights.rightid";
	String TEST_ADD_SQL = "insert into test_mst (name,descr, duration, attempts, createdby, creationtime, passingscore) values(?,?,?,?,?,?,?)";
	String TEST_MAPPING_ADD_SQL = "insert into user_test_mapping (testid,uid) values(?,?)";
	String TEST_SELECT_BY_ID = "select testid from test_mst where name=?";
	String ADD_QUESTION = "insert into question_mst(name, score) values(?,?)";
	String QUESTION_BY_ID = "select id from question_mst where name=?";
	String ADD_ANSWER = "insert into answer_mst(name,descr,rightAns,Qid) values(?,?,?,?)";
	String QUESTION_TEST_MAPPING = "insert into test_question_mapping(testid, qid) values(?,?)";
	String GET_ALL_QUESTIONS_BY_TEST = "select q.id, q.name, q.status, q.score from question_mst q, test_question_mapping tqmap where tqmap.testid = ? and tqmap.qid = q.id";
	String GET_ANSWERS = "select ans.id, ans.name, ans.descr, ans.status, ans.rightAns, ans.Qid from answer_mst ans where ans.Qid = ?";
	String GET_QUESTION = "select * from question_mst where id = ?";
	String USER_QUESTION_MAPPING = "insert into user_question_mapping(uid, qid) values(?,?)";
	String GET_ALL_QUESTIONS_BY_USER = "select q.id, q.name, q.status, q.score from question_mst q, user_question_mapping uqmap where uqmap.uid = ? and uqmap.qid = q.id";
	String GET_ALL_TEST = "select t.testid, t.name, t.descr, t.passingScore, t.duration, t.attempts, t.status, t.createdby, t.creationtime from test_mst t, user_test_mapping utmap where utmap.uid = ? and utmap.testid = t.testid";
	String CREATE_GROUP = "insert into group_mst(name, descr) values(?, ?)";
	String GET_GROUP_BY_NAME = "select gid from group_mst where name = ?";
	String TEACHER_GROUP_MAPPING = "insert into teacher_group_mapping(gid, uid) values(?, ?)";
	String GET_ALL_GROUP = "select g.gid, g.name, g.descr, g.status from group_mst g, teacher_group_mapping tgmap where tgmap.uid = ? and tgmap.gid = g.gid";
	String TEST_GROUP_MAPPING = "insert into test_group_mapping(testid, gid) values(?, ?)";
	String GET_ALL_TEST_FOR_STUDENT= "select t.testid, t.name, t.descr, t.passingScore, t.duration, t.attempts, t.status, t.createdby, t.creationtime from test_mst t, group_reg_codes grcode, test_group_mapping tgmap where grcode.uid = ? and grcode.gid = tgmap.gid and tgmap.testid = t.testid";
	String GET_PREVIOUS_ANSWERS = "select id from user_question_answered where uid = ? and qid = ? and testid = ?";
	String UPDATE_STUDENT_ANSWER = "update user_question_answered set yourAns = ? where id = ?";
	String ADD_STUDENT_ANSWER = "insert into user_question_answered(uid, testid, qid, yourAns, dated) values(?,?,?,?,?)";
	String GET_RIGHT_ANSWER = "select descr from answer_mst where Qid = ? and rightAns = ?";
	String GET_USER_ANSWER = "select yourAns from user_question_answered where qid = ? and testid = ?";
	String SUBMIT_TEST = "insert into score_card(uid, testid, score) values(?, ?, ?)";
	String REG_CODES = "insert into group_reg_codes(regcode, gid) values(?, ?)";
	String GET_REG_CODES = "select regcode from group_reg_codes where gid = ?";
	String REGISTRATION_SQL = "insert into user_mst(userid, password, name, address, phone, email) values(?,?,?,?,?,?)";
	String GET_ROLE_ID = "select roleid from role_mst where name = ?";
	String GET_USER_ID = "select uid from user_mst where userid = ?";
	String USER_ROLE_MAPPING = "insert into user_role_mapping(uid, roleid) values(?, ?)";
	String USER_REGCODE_MAPPING = "update group_reg_codes set uid = ? where regcode = ?";
	String GET_SCORE = "select uid, score from score_card where testid = ?";
	String COUNT_TEST = "select count(testid) from test_mst";
	String COUNT_GROUP = "select count(gid) from group_mst";
	String COUNT_TEACHER = "select count(id) from user_role_mapping where roleid = 1";
	String COUNT_STUDENT = "select count(id) from user_role_mapping where roleid = 2";
}
