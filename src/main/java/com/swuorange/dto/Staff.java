package com.swuorange.dto;

public class Staff {
	
	
	private Integer staffId;
	private Integer staffAge;
	private String staffName;
	private String staffPassword;
	private String staffSex;
	private String staffTel;
	private String staffEmail;
	private Integer companyinfoId;
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public Integer getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public String getStaffSex() {
		return staffSex;
	}
	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}
	public String getStaffTel() {
		return staffTel;
	}
	public void setStaffTel(String staffTel) {
		this.staffTel = staffTel;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public Integer getCompanyinfoId() {
		return companyinfoId;
	}
	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffAge=" + staffAge + ", staffName=" + staffName + ", staffPassword="
				+ staffPassword + ", staffSex=" + staffSex + ", staffTel=" + staffTel + ", staffEmail=" + staffEmail
				+ ", companyinfoId=" + companyinfoId + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
