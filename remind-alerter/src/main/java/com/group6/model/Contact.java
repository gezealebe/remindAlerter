package com.group6.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="birthDate")
	private LocalDate birthDate;
	
	@Column(name="anniversary")
	private LocalDate anniversary;
	
	@Column(name="remindDate")
	private int remindDate; 
	
	@Column(name="reminderTypes")
    private String reminderTypes;

	@Column(name="userId")
    private String userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(LocalDate anniversary) {
		this.anniversary = anniversary;
	}

	public int getRemindDate() {
		return remindDate;
	}

	public void setRemindDate(int remindDate) {
		this.remindDate = remindDate;
	}

	public String getReminderTypes() {
		return reminderTypes;
	}

	public void setReminderTypes(String reminderTypes) {
		this.reminderTypes = reminderTypes;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
