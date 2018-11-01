package org.anil.myprograms.serialization.models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Engineer extends Person implements Serializable{
	
	private static final long serialVersionUID = 6743787648768709060L;
	
	int roll;
	String College;
	String branch;
	public Engineer(int roll, String college, String branch) {
		//super();
		this.roll = roll;
		College = college;
		this.branch = branch;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Name : "+ this.getName() + " Roll : " + this.getRoll() +" Branch : "+ this.getBranch() + " College : " + this.getCollege() +"\nAddress : \n \t  " +this.getAddress();
	}
	
	/*private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		System.out.println("Inside");
		ois.defaultReadObject();
		setName((String)ois.readObject());
		setAddress((Address)ois.readObject());
		
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(this.getName());
		oos.writeObject(this.getAddress());;
	}*/
}
