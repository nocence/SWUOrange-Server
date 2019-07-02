package com.swuorange.dto;

public class StaffPage {
	
	private int staffId;
	private int staffAge;
	private String staffName;
	private String staffPassword;
	private String staffSex;
	private String staffTel;
	private String staffEmail;
	private int companyinfoId;
	private Integer nowPage;
	
	
	
	
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(int staffAge) {
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
	public int getCompanyinfoId() {
		return companyinfoId;
	}
	public void setCompanyinfoId(int companyinfoId) {
		this.companyinfoId = companyinfoId;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffAge=" + staffAge + ", staffName=" + staffName + ", staffPassword="
				+ staffPassword + ", staffSex=" + staffSex + ", staffTel=" + staffTel + ", staffEmail=" + staffEmail
				+ ", companyinfoId=" + companyinfoId + "]";
	}
	
	
	
	
	
	
	
	
}
