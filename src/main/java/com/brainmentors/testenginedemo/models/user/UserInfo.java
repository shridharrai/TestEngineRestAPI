package com.brainmentors.testenginedemo.models.user;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserInfo {
	private int uid;
	private String userid;
	private String roleName;
	private String message;
	private String tokenId;
	private List<Right> rights;
	private String statuscode;
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", userid=" + userid + ", roleName=" + roleName + ", message=" + message
				+ ", tokenId=" + tokenId + ", rights=" + rights + ", statuscode=" + statuscode + "]";
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public List<Right> getRights() {
		return rights;
	}
	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
}
