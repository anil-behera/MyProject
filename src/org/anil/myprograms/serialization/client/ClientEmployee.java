package org.anil.myprograms.serialization.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.anil.myprograms.serialization.models.Address;
import org.anil.myprograms.serialization.models.Employee;

public class ClientEmployee {

	public static void main(String[] args) {
		String fileName="C:\\BT Anil\\Java Workspace\\MyProj\\bin\\org\\anil\\myprograms\\serialization\\files\\Employee.txt";
		
		serialize(fileName);
		deserialize(fileName);
		

	}

	private static void serialize(String fileName) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(fileName))) ) {
			Address address=new Address(21, 12, "Bangalore");
			Employee e1=new Employee(1, "xyz", "xyz@abc.com", 12345, address);
			
			oos.writeObject(e1);
			System.out.println("Serialization Done");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	private static void deserialize(String fileName) {
		
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			Employee e2=(Employee) ois.readObject();
			System.out.println(e2);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
