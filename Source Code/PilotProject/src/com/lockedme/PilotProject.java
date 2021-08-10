package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PilotProject 
{
	static final String folderpath="D:\\Suheal\\MyPhase1 Project\\LockedMe Files";
	
	public static void main(String[] args)
	{
		//Variable Decalartion
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
		
		//Closing Scanner Object
		obj.close();
	}
	
}