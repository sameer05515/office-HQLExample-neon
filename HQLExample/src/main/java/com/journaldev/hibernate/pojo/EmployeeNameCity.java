package com.journaldev.hibernate.pojo;

public class EmployeeNameCity {
	
	private String city;
	
	private String name;

	public EmployeeNameCity(String city, String name) {
		super();
		this.city = city;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeNameCity [getCity()=" + getCity() + ", getName()=" + getName() + "]";
	}

}
