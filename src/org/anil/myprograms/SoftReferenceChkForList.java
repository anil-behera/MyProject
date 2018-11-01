package org.anil.myprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Students{
	int id;
	String Name;
	String Desig;
	public Students(int id, String name, String desig) {
		super();
		this.id = id;
		Name = name;
		Desig = desig;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDesig() {
		return Desig;
	}
	public void setDesig(String desig) {
		Desig = desig;
	}
	
	@Override
	public String toString() {
		
		return getId()+ "  " + getName()+ "  "  + getDesig();
	}
}

public class SoftReferenceChkForList {

	public static void main(String[] args) {
		List<Students> al=new ArrayList<Students>(Arrays.asList(new Students(1, "ab", "Dev"),new Students(2, "ab2", "Sr Dev"),new Students(3, "ab3", "Lead")));
		
		System.out.println(al.toString());
		
		updateStudent(al);
		
		System.out.println(al);
	}
	
	static void updateStudent(List<Students> students) {
		/*for(Students s: students) {
			if(s.getDesig().equals("Dev")){
				System.out.println("changing");
				s.setDesig("Changed Dev");
			}
		}*/
		
		students.stream()
				.filter( item -> item.getDesig().equals("Dev") )
				.forEach(s->s.setDesig("Changed Dev"));
		
		System.out.println("Changed");
		
		String s=students.stream()
        .filter( c -> c.getDesig().equals("Sr Dev"))
        .findAny()
        .map(v -> "China")
        .orElse(null);
		
		System.out.println(s);
	}

}
