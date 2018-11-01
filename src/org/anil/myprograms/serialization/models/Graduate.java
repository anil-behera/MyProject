package org.anil.myprograms.serialization.models;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Graduate extends Person implements Externalizable{
	
	private static final long serialVersionUID = 6743787648769909060L;
	int roll;
	String College;
	String branch;
	
	public Graduate() {
	}
	
	public Graduate(int roll, String college, String branch) {
		super();
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
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.getName());
		out.writeObject(this.getAddress());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.setName((String)in.readObject());
		this.setAddress((Address)in.readObject());
	}

}
