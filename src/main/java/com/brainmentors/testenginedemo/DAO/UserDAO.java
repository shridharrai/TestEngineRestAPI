package com.brainmentors.testenginedemo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.brainmentors.testenginedemo.models.user.Right;
import com.brainmentors.testenginedemo.models.user.User;
import com.brainmentors.testenginedemo.models.user.UserInfo;
import com.brainmentors.testenginedemo.utils.Query;

@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	static List<Right> rights ;
	private Logger logger = Logger.getLogger(UserDAO.class);
	public UserInfo doLogin(User user) {
		logger.debug("Inside DAO "+user);
		rights = new ArrayList<Right>();
		List<UserInfo> list  = jdbcTemplate.query(Query.LOGIN_SQL, new Object[] {user.getUserid(), 
				user.getPassword()},new UserInfoMapper() );
		logger.debug("After JDBC Call "+list);
		if(list==null) {
			return null;
		}
		if(list.size()==0) {
			return null;
		}
		list.get(0).setRights(rights);
		 return list.get(0);
	}
	
	public int register(User user) {
		int record = jdbcTemplate.update(Query.REGISTRATION_SQL, user.getUserid(), user.getPassword(), user.getName(), user.getAddress(), user.getPhone(), user.getEmail());
		return record;
	}
	
	public int getUId(String userid) {
		int uid = jdbcTemplate.queryForObject(Query.GET_USER_ID, new Object[] {userid}, Integer.class);
		System.out.println("Uid is "+uid);
		return uid;
	}
	
	public int getRoleId(String roleName) {
		int roleid = jdbcTemplate.queryForObject(Query.GET_ROLE_ID, new Object[] {roleName}, Integer.class);
		System.out.println("Roleid is "+roleid);
		return roleid;
	}
	
	public int userRoleMap(int uid, int roleid) {
		int records = jdbcTemplate.update(Query.USER_ROLE_MAPPING, uid, roleid);
		return records;
	}
	
	public int userRegCodeMap(int uid, String regcode) {
		int records = jdbcTemplate.update(Query.USER_REGCODE_MAPPING, uid, regcode);
		return records;
	}

}

class UserInfoMapper implements RowMapper<UserInfo>{

	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo();
		userInfo.setUid(rs.getInt("uid"));
		userInfo.setUserid(rs.getString("userid"));
		userInfo.setRoleName(rs.getString("rolename"));
		Right right = new Right();
		right.setName(rs.getString("rightname"));
		right.setUrl(rs.getString("url"));
		UserDAO.rights.add(right);
		return userInfo;
	}
}
