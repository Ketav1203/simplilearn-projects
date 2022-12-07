package com.lockedme;
 
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	List<MyFile> files = new ArrayList<>(); // Creating "files" object of "MyFile" type
	// Creating constructor
	public FileUtil() {

	}
	public List<MyFile> getFiles() // Creating method "getFiles" with the type "List<MyFile>" 
	{
	     int count = 1; // creating "count" variable to use as a ID 

		File f = new File("f://JavaFiles");  //storing file directory or path in f object
		String[] fs = f.list();  //using list() method to read file and store names of files in fs
		for(String file:fs)  
		{
			files.add(new MyFile(count, file)); //adding files names from list in fs  with numbering in "files" object
			count ++;
			
		}
	     return files;
	}
	public void addFile(String fileName)throws IOException // Creating "addFile" method void type which takes string input 
	{
		File f = new File("f://JavaFiles//"+fileName+".txt"); // Creating object "f" to store path, name of file (input from user) & file extension(.txt)
		f.createNewFile(); // createNewFile()(Which throws exception) method used for creating new empty file with the name and file type stored in "f"
		
	}
	public boolean deleteFile(String fileName) // Creating "deleFile" method (boolean type) which takes string input
	{
		boolean isDeleted = false; // Creating boolean variable with value false
		files = getFiles(); // storing files in "files" object using "getFiles" method
		for(MyFile file:files) // using for each loop to go through "files"
		{
			if(file.getFileName().startsWith(fileName)==true) // using if statement by passing "getFileName" method which return value starts with input value(using "startsWith" method)
			{
				File f = new File("f://JavaFiles//"+file.getFileName()); // Creating "f" object which stores return value from "getFileName" method
				f.delete(); // using delete method on "f" object
				isDeleted = true; //making isDeleted variable value "true" to break out of for loop
				break;
			}
			else 
			{
				System.out.println("File not found\nPlease enter the file name from list of files ");
				break;
			}
		
		}
		files.clear();
		return isDeleted;
			
	}
	public boolean search(String fileName)
	{
		boolean isIdentified = false;
		files = getFiles();
		for(MyFile file : files)
		{
			if(file.getFileName().startsWith(fileName))
			{
				isIdentified = true;
				break;
			}
		}
		return isIdentified;
	}
}
