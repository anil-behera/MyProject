package org.anil.myprograms.serialization.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.anil.myprograms.serialization.models.Address;
import org.anil.myprograms.serialization.models.Graduate;

public class ClientGraduate {

	public static void main(String[] args) {
		String fileName="C:\\BT Anil\\Java Workspace\\MyProj\\bin\\org\\anil\\myprograms\\serialization\\files\\Graduate.ser";
		
		serialize(fileName);
		deserialize(fileName);
		

	}

	private static void serialize(String fileName) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(fileName))) ) {
			Address address=new Address(21, 12, "Bangalore");
			Graduate e1=new Graduate(1, "xyz", "ETC");
			e1.setName("aaa");
			e1.setAddress(address);
			
			oos.writeObject(e1);
			System.out.println("Serialization Done");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	private static void deserialize(String fileName) {
		
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			Graduate e2=(Graduate) ois.readObject();
			System.out.println(e2);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
