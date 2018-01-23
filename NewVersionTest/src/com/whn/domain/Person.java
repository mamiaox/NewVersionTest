package com.whn.domain;

public class Person {
	private int id;
	private String name;
	private String idnumber;
	private String sex;
	private String birth;
	private String marrage;
	private String matename;

	public Person(int id, String name, String idnumber, String sex, String birth, String marrage, String matename) {
		super();
		this.id = id;
		this.name = name;
		this.idnumber = idnumber;
		this.sex = sex;
		this.birth = birth;
		this.marrage = marrage;
		this.matename = matename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMarrage() {
		return marrage;
	}

	public void setMarrage(String marrage) {
		this.marrage = marrage;
	}

	public String getMatename() {
		return matename;
	}

	public void setMatename(String matename) {
		this.matename = matename;
	}

	public Person() {
		super();
	}
}
