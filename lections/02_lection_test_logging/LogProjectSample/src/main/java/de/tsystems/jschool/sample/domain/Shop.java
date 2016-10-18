package de.tsystems.jschool.sample.domain;

import org.apache.log4j.Logger;


public class Shop extends BaseEntity{
	
private final static Logger log = Logger.getLogger(Shop.class);
	
	private String address;
	private String name;
	/**
	 * @param address
	 * @param name
	 */
	public Shop(String address, String name) {

		super();
		this.address = address;
		this.name = name;
	}
	
	public void writeDebugLogAboutMe(){
		writeDebugLogAboutMe(getClass().getName(), address, name);
	}
	
	
	/**
	 * @return the address
	 */
	public String getAddress() {
	
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
	
		this.address = address;
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
	
	
}
