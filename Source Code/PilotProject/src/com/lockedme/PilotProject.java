package com.lockedme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PilotProject 
{
	static final String folderpath="D:\\Suheal\\MyPhase1 Project\\LockedMe Files";
	public static void main(String[] args)
	{	
		int proceed = 1;
		
		
		do
		{
			//Variable Declaration
			int ch;
		
			//Display Menu
			ch=displayMenu();
			
			switch (ch)
				{
					case 1 : getAllFiles();
							break;
					case 2 : createFiles();
							break;
					case 3 : deleteFile();
							break;
					case 4 : searchFile();
							break;
					case 5 : System.exit(0);
							break;
					default : System.out.println("Invalid option");
							break;
				}
		}
		while(proceed>0);
	}
	public static int displayMenu()
	{
		Scanner obj = new Scanner(System.in);
		int ch;
		
		System.out.println("\n\n--------------------------------------------------------------");
		System.out.println("\t\t LockedMe.com");
		System.out.println("--------------------------------------------------------------");
		System.out.println("\t1. Display All Files");
		System.out.println("\t2. Add New File");
		System.out.println("\t3. Deleted a File");
		System.out.println("\t4. Search a File");
		System.out.println("\t5. Exit");
		System.out.println("\n**************************************************************");
		System.out.println("Enter your choice");
		ch = Integer.parseInt(obj.nextLine());
		
		return ch;
	}
	
	public static void getAllFiles()
	{
		//Getting File Names

		List <String> fileNames =FileManagement.getAllFiles(folderpath);
				
				
			if(fileNames.size()==0)
				System.out.println("No Files in the directory");
			else
			{
				//Sorting Files
	            Collections.sort(fileNames);
	            
	            for(String n:fileNames)
				{
					//Printing sorted file List
				System.out.println(n);
				}
			}
	}
	
	public static void createFiles()
	{
		//Add File Code


		//Variable Declaration
			Scanner obj = new Scanner(System.in);
			String fileName;
			int linesCount;
			List<String> content = new ArrayList<String>();
				
			//Read File Name from User
			System.out.println("Enter the File Name:");
			fileName=obj.nextLine();
				
			//Read Number of Lines from User
			System.out.println("Enter how many lines are there in the file");
			linesCount=Integer.parseInt(obj.nextLine());
				
			//Read Lines from User
			for(int i=1;i<=linesCount;i++)
				{
					System.out.println("Enter Line"+i+":");
					content.add(obj.nextLine());
				}
				
			//Save the content into the file
			boolean isSaved = FileManagement.addFiles(folderpath, fileName, content);
				
			if(isSaved)
					System.out.println("File and Data Saved Successfully");
			else
					System.out.println("Error while creating files. Please Contact Admin@Locedme.com");
	}
	
	public static void deleteFile()
	{
		//Code for deleting the file

			String fileName;
			Scanner obj = new Scanner(System.in);
			
			//Read the Content from user to delete the file
			System.out.println("Enter the file name to be deleted:");
			fileName = obj.nextLine();
			
			//Displaying if the entered file is deleted
			boolean isDeleted = FileManagement.deleteFile(folderpath, fileName);
			
			
			if(isDeleted)
					System.out.println("File deleted successfully");
			else
					System.out.println("File not Found");
	}
	
	public static void searchFile()
	{

		//Code for Searching the file

			String fileName;
			Scanner obj = new Scanner(System.in);
			System.out.println("Enter the file name to be searched:");
			fileName = obj.nextLine();
			
			//Is the Entered file present in the directory
			boolean isFound = FileManagement.searchFile(folderpath, fileName);
						
				if(isFound)
						System.out.println("File is present in the folder");
				else
						System.out.println("File not Found");
	}
}
