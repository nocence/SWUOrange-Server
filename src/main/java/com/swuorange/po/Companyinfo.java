package com.swuorange.po;

import java.io.Serializable;

public class Companyinfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer companyinfoId;

    private String licenceNum;

    private String companyName;

    private String companyAddress;

    private String legalPerson;

    private Integer registerCapital;

    private String companyType;

    private String compositionForm;

    private String registrationAuthority;

    private String businessScope;

    private String contactAddress;

    private String phone;
    
    private Integer state;

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

	@Override
	public String toString() {
		return "Companyinfo [companyinfoId=" + companyinfoId + ", licenceNum=" + licenceNum + ", companyName="
				+ companyName + ", companyAddress=" + companyAddress + ", legalPerson=" + legalPerson
				+ ", registerCapital=" + registerCapital + ", companyType=" + companyType + ", compositionForm="
				+ compositionForm + ", registrationAuthority=" + registrationAuthority + ", businessScope="
				+ businessScope + ", contactAddress=" + contactAddress + ", phone=" + phone + ", state=" + state + "]";
	}

	
}
