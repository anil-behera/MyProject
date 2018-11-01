package org.anil.myprograms.serialization.client;
/*
 * 
 * 

Question: Is constructor of class called during DeSerialization process?
Answer:  This question which will check your in depth knowledge of Serialization and constructor chaining concepts. It depends on whether our object has implemented 
Serializable or Externalizable.If Serializable has been implemented - constructor is not called during DeSerialization process.
But, if Externalizable has been implemented - constructor is called during DeSerialization process.

Question: Is constructor of super class called during DeSerialization process of subclass (Important)?
Answer. Again your basic java concepts will be tested over here. It is depends on whether our superclass has implemented Serializable or not.
If superclass has implemented Serializable - constructor is not called during DeSerialization process.
If superclass has not implemented Serializable - constructor is called during DeSerialization process.

Question 22. How can subclass avoid Serialization if its superClass has implemented Serialization interface (Important)?
Answer. If superClass has implemented Serializable that means subclass is also Serializable (as subclass always inherits all features from its parent class), 
for avoiding Serialization in sub-class we can define writeObject() method and throw NotSerializableException() from there as done below.

private void writeObject(ObjectOutputStream os) throws NotSerializableException {
        throw new NotSerializableException("This class cannot be Serialized");
}
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.anil.myprograms.serialization.models.Address;
import org.anil.myprograms.serialization.models.Engineer;

public class ClientEngineer {

	public static void main(String[] args) {
		String fileName="C:\\BT Anil\\Java Workspace\\MyProj\\bin\\org\\anil\\myprograms\\serialization\\files\\Person.ser";
		
		//serialize(fileName);
		deserialize(fileName);
		

	}

	private static void serialize(String fileName) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(fileName))) ) {
			Address address=new Address(21, 12, "Bangalore");
			Engineer e1=new Engineer(1, "xyz", "ETC");
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
			Engineer e2=(Engineer) ois.readObject();
			System.out.println(e2);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
