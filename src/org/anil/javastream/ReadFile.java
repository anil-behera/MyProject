package org.anil.javastream;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ReadFile {

	public static void main(String[] args) {
		String strline;
		try (Scanner sc=new Scanner(new FileInputStream("C:\\BT Anil\\Developements\\21CNCE-113541\\Old Log.txt"),"UTF-8")){
			while(sc.hasNextLine()) {
				strline=sc.nextLine();
				
				String[] st=strline.split(" ");
				Arrays.sort(st);
				System.out.println(Arrays.toString(st));
				
			}
		} catch (Exception e) {
		}
		

		/*List<String> alist;
		try {
			alist = Files.lines(Paths.get("C:\\BT Anil\\Developements\\21CNCE-113541\\Old Log.txt"))
				    //.filter(line -> line.contains("abc"))
				    .collect(Collectors.toList());
			Collections.sort(alist);
			System.out.println(alist.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

}
