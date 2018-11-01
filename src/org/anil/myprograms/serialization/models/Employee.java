package org.anil.myprograms.serialization.models;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 8723570820829986379L;
	
	int id;
	String name;
	String Email;
	long phone;
	Address address;
	public Employee(int id, String name, String email, long phone, Address address) {
		super();
		this.id = id;
		this.name = name;
		Email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		
		return "Id : "+this.getId() +" Name : "+this.getName() +" Email : "+ this.getEmail() +" Phone : "+ this.getPhone() +"\n Address :" + this.getAddress();
	}
	
	
}
