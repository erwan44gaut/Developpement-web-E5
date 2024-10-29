package com.esiee.tp2.domain;

public class Person {
	private Long id;
	private String lastname;
	private String firstname;
	private String mail;
	private String mobilePhone;
	private String login;
	private String password;
	private Civility civility;
	private Function function;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Civility getCivility() {
		return civility;
	}
	public void setCivility(Civility civility) {
		this.civility = civility;
	}
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
}
