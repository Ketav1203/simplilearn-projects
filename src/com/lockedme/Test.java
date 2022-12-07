package com.lockedme;

import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args)throws IOException {
		FileUtil util = new FileUtil(); //creating object 
		int ch; // Creating variable for switch case
		Scanner sc = new Scanner(System.in); // creating Scanner object "sc"
		System.out.println("***Welcome To LockedMe.com***");
		System.out.println("Developed by - Ketav Laxman Padkil");
		System.out.println("Here is List of files in directory\n");
		List<MyFile> files1 = util.getFiles(); // Creating files1 variable of "List<MyFIle>" type to store returned "files" from "getFiles" method
		for(MyFile f:files1) // using for each loop to go through files variable
			System.out.println(f.getId() + "\t" + f.getFileName() ); //Printing files using "get" method
		files1.clear(); 
		do // using do while loop to iterate
		{
			
			// Creating menu for user
			System.out.println("\n1.To Add a file press '1'");
			System.out.println("2.To Delete a file press '2'");
			System.out.println("3.To Display All files press '3'");
			System.out.println("4.To Search a file press '4'");
			System.out.println("5.To Exit press '5'");
			System.out.println("Enter the choice");
			try {
			ch = sc.nextInt(); // taking input from user to choose from menu
	      	}
			catch(InputMismatchException a)
			{
				System.out.println("please run program again and enter number inbetween 1 to 5 as a choice");
				ch = 5;
			}
				
			switch(ch) // using switch case to go through menu
			{
			case 1:
					String fileName; // Creating string type variable to store user input file name
					System.out.println("Enter the file name");
					fileName = sc.next(); // taking string type input from user as a file name
					util.addFile(fileName); // using "addFile" method from "FileUtil" class using "util" object
					break;
			case 2:
					String fileName1; // Creating string type variable to store user input file name
					System.out.println("Enter the file name");
					fileName1 = sc.next();// taking string type input from user as a file name
					util.deleteFile(fileName1);// using "deleteFile" method from "FileUtil" class using "util" object
					break;
			case 3:
					List<MyFile> files2 = util.getFiles(); // Creating files2 variable of "List<MyFIle>" type to store returned "files" from "getFiles" method
					for(MyFile f:files2) // using for each loop to go through files variable
						System.out.println(f.getId() + "\t" + f.getFileName() ); //Printing files using "get" method
					files2.clear(); 
					break;
			case 4:
					String fileName2;
					System.out.println("Enter the filename");
					fileName2 = sc.next();
					if(util.search(fileName2))
						System.out.println("File is existed");
					else
						System.out.println("File not existed");
					break;
			}
		}while (ch < 5);
	}

}
