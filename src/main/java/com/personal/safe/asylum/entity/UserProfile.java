package com.personal.safe.asylum.entity;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userProfile")
public class UserProfile {

	@Id
	private String id;

	private String name;

	private String cell_number;

	private String residential_number;

	private String date_of_birth;

	private String emailId;

	private HashMap<AddressType, Address> addresses;

	public UserProfile() {

	}

	public UserProfile(String name, String cell_number, String residential_number, String date_of_birth,
			String emailId) {
		this.name = name;
		this.cell_number = cell_number;
		this.residential_number = residential_number;
		this.date_of_birth = date_of_birth;
		this.emailId = emailId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the cell_number
	 */
	public String getCell_number() {
		return cell_number;
	}

	/**
	 * @param cell_number the cell_number to set
	 */
	public void setCell_number(String cell_number) {
		this.cell_number = cell_number;
	}

	/**
	 * @return the residential_number
	 */
	public String getResidential_number() {
		return residential_number;
	}

	/**
	 * @param residential_number the residential_number to set
	 */
	public void setResidential_number(String residential_number) {
		this.residential_number = residential_number;
	}
	
	/**
	 * @return the date_of_birth
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * @param date_of_birth the date_of_birth to set
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the addresses
	 */
	public HashMap<AddressType, Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(HashMap<AddressType, Address> addresses) {
		this.addresses = addresses;
	}
}
