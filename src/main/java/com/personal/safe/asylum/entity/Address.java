package com.personal.safe.asylum.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address {

	private String id;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String street;
	
	private String house_no;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the house_no
	 */
	public String getHouse_no() {
		return house_no;
	}

	/**
	 * @param house_no the house_no to set
	 */
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	
	
}
