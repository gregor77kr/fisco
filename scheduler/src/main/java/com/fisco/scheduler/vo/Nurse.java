package com.fisco.scheduler.vo;

import java.io.Serializable;

public class Nurse implements Serializable {

	private static final long serialVersionUID = 1182780460329618336L;
	private String name;
	private String type;
	private String birthDate;
	private String workCount;
	private String lastWorkDate;
	private String lastWorkTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getLastWorkDate() {
		return lastWorkDate;
	}

	public void setLastWorkDate(String lastWorkDate) {
		this.lastWorkDate = lastWorkDate;
	}

	public String getLastWorkTime() {
		return lastWorkTime;
	}

	public void setLastWorkTime(String lastWorkTime) {
		this.lastWorkTime = lastWorkTime;
	}

	public String getWorkCount() {
		return workCount;
	}

	public void setWorkCount(String workCount) {
		this.workCount = workCount;
	}

	@Override
	public String toString() {
		return "Nurse [name=" + name + ", type=" + type + ", birthDate=" + birthDate + ", workCount=" + workCount
				+ ", lastWorkDate=" + lastWorkDate + ", lastWorkTime=" + lastWorkTime + "]";
	}

}
