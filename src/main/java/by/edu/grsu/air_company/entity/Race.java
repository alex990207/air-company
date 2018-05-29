package by.edu.grsu.air_company.entity;

import java.util.Date;

public class Race extends Entity {
	private static final long serialVersionUID = -7790711166782221895L;

	private Date date;
	
	private String name;
	
	public Race() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
