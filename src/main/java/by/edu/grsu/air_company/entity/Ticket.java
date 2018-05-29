package by.edu.grsu.air_company.entity;

import java.util.Date;

public class Ticket extends Entity {
	private static final long serialVersionUID = 8343238588149006532L;

	private Boolean firstAccessStatus;
	
	private Integer price;
	
	private Date boughtDate;
	
	private Race race;
	
	private Bagage bagage;
	
	private User user;
		
	public Ticket() {
		
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getBoughtDate() {
		return boughtDate;
	}

	public void setBoughtDate(Date boughtDate) {
		this.boughtDate = boughtDate;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Bagage getBagage() {
		return bagage;
	}

	public void setBagage(Bagage bagage) {
		this.bagage = bagage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getFirstAccessStatus() {
		return firstAccessStatus;
	}

	public void setFirstAccessStatus(Boolean firstAccessStatus) {
		this.firstAccessStatus = firstAccessStatus;
	}
}
