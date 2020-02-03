package com.fisco.scheduler.vo;

import java.io.Serializable;

public class Nurse implements Serializable {

	private static final long serialVersionUID = 1182780460329618336L;
	private String name;
	private String type;
	private String birthDate;
	private int workCount;
	private String lastWorkDate;
	private String lastWorkTime;

	public Nurse() {
		this.workCount = 0;
		this.lastWorkDate = "";
		this.lastWorkTime = "";
	}

	public String getName() {
		return name;
	}

	public Nurse setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public Nurse setType(String type) {
		this.type = type;
		return this;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public Nurse setBirthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public String getLastWorkDate() {
		return lastWorkDate;
	}

	public Nurse setLastWorkDate(String lastWorkDate) {
		this.lastWorkDate = lastWorkDate;
		return this;
	}

	public String getLastWorkTime() {
		return lastWorkTime;
	}

	public Nurse setLastWorkTime(String lastWorkTime) {
		this.lastWorkTime = lastWorkTime;
		return this;
	}

	public int getWorkCount() {
		return workCount;
	}

	public Nurse setWorkCount(int workCount) {
		this.workCount = workCount;
		return this;
	}

	@Override
	public String toString() {
		return "Nurse [name=" + name + ", type=" + type + ", birthDate=" + birthDate + ", workCount=" + workCount
				+ ", lastWorkDate=" + lastWorkDate + ", lastWorkTime=" + lastWorkTime + "]";
	}

}
