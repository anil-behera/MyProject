package org.anil.myprograms.serialization.models;

public class Person {
	String Name;
	Address address;
	
	Person(){
		System.out.println("Inside con Person");
	}
	
	public Person(String name, Address address) {
		super();
		Name = name;
		this.address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
