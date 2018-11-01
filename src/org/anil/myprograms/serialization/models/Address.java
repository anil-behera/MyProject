package org.anil.myprograms.serialization.models;

import java.io.Serializable;

public class Address implements Serializable{
	
	private static final long serialVersionUID = -6785337034040823790L;
	
	int houseNum;
	int streetnum;
	
	String city;
	
	public Address(int houseNum, int streetnum, String city) {
		super();
		this.houseNum = houseNum;
		this.streetnum = streetnum;
		this.city = city;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public int getStreetnum() {
		return streetnum;
	}
	public void setStreetnum(int streetnum) {
		this.streetnum = streetnum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "House Number : "+this.getHouseNum() +"\t Street :"+ this.getStreetnum() + "\t City: "+this.getCity();
	}
	
}
