package com.swuorange.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String account;

    private String password;

    private String realname;

    private String tel;

    private String email;

    private Date registTime;

    private Date updateTime;

    private BigDecimal totalAccount;

    private BigDecimal balance;

    private Integer companyinfoId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public BigDecimal getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(BigDecimal totalAccount) {
		this.totalAccount = totalAccount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getCompanyinfoId() {
		return companyinfoId;
	}

	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
	}

	
	public User(){}
	public User(Integer userId, String account, String password, String realname, String tel, String email,
			Date registTime, Date updateTime, BigDecimal totalAccount, BigDecimal balance,Integer companyinfoId) {
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.realname = realname;
		this.tel = tel;
		this.email = email;
		this.registTime = registTime;
		this.updateTime = updateTime;
		this.totalAccount = totalAccount;
		this.balance = balance;
		this.companyinfoId = companyinfoId;
	}
	
}
