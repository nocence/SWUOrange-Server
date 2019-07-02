package com.swuorange.dto;

import java.io.Serializable;

public class AdminCompanyDTO implements Serializable {
	
	private static final long serialVersionUID = 1123L;
	
	private String account;
	//id
	private Integer companyinfoId;
	//营业执照编码
    private String licenceNum;
    //公司名称
    private String companyName;
    //公司地址
    private String companyAddress;
    //企业法人
    private String legalPerson;
    //注册资本
    private Integer registerCapital;
    //公司类型
    private String companyType;
    //组织形式
    private String compositionForm;
    //登记机关
    private String registrationAuthority;
    //经营范围
    private String businessScope;
    //联系地址
    private String contactAddress;
    //联系电环
    private String phone;
    //审核状态
    private Integer state;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getCompanyinfoId() {
		return companyinfoId;
	}

	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
	}

	public String getLicenceNum() {
		return licenceNum;
	}

	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public Integer getRegisterCapital() {
		return registerCapital;
	}

	public void setRegisterCapital(Integer registerCapital) {
		this.registerCapital = registerCapital;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompositionForm() {
		return compositionForm;
	}

	public void setCompositionForm(String compositionForm) {
		this.compositionForm = compositionForm;
	}

	public String getRegistrationAuthority() {
		return registrationAuthority;
	}

	public void setRegistrationAuthority(String registrationAuthority) {
		this.registrationAuthority = registrationAuthority;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


}
