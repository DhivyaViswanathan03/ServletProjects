package com.divs.Dto;

public class Employee {

	private String eid;
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", email=" + email + ", emobile="
				+ emobile + "]";
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getEage() {
		return eage;
	}
	public void setEage(Integer eage) {
		this.eage = eage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmobile() {
		return emobile;
	}
	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}
	private String ename;
	private Integer eage;
	private String email;
	private String emobile;
}
