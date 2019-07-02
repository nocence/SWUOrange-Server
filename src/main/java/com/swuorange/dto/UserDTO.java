package com.swuorange.dto;

public class UserDTO {

	private String account;

	private String password;

	private String authcode;

	private String realname;

	private String roleName;

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	@Override
	public String toString() {
		return "UserDTO [account=" + account + ", password=" + password + ", authcode=" + authcode + "]";
	}

}
