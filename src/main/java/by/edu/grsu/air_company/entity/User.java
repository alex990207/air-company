package by.edu.grsu.air_company.entity;

import java.util.List;

public class User extends Entity {
	private static final long serialVersionUID = -8085038872486668464L;

	private String surname;
	
	private String name;
	
	private String patronymic;
	
	private String phoneNumber;
	
	private String password;
	
	private UserStatus userStatus;
	
	private List<Ticket> tickets;
	
	public User() {
		this.userStatus = UserStatus.CUSTOMER;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
}
