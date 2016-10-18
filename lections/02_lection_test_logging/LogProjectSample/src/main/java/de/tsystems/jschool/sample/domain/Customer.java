package de.tsystems.jschool.sample.domain;

import org.apache.log4j.Logger;


public class Customer extends BaseEntity{
	
	private final static Logger log = Logger.getLogger(Customer.class);
	
	private String firstName;
	private String lastName;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public Customer(String firstName, String lastName) {

		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public void writeInfoLogAboutMe(){
		writeInfoLogAboutMe(getClass().getName(), firstName, lastName);
	}



	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
	
		return firstName;
	}



	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
	
		this.firstName = firstName;
	}



	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
	
		return lastName;
	}



	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
	
		this.lastName = lastName;
	}
	
	
}
