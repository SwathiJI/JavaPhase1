package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManagement 
{
	public static List<String> getAllFiles(String folderpath)
	{
			//Creating File Object
			File n1=new File(folderpath);
			
			//Getting all the files into FileArray
			File[] listoffiles = n1.listFiles();
			
			//Declare a List to Store File Names
			List<String> fileNames = new ArrayList<String>();
			
			for(File n:listoffiles)
				fileNames.add(n.getName());
			
			//Return the List
			return fileNames;
	}
	
	/**
	 * This method will create or append the content into the specified files
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean addFiles(String folderpath, String fileName, List<String> content)
	{
		try
		{
			//Creating File object
			File n1 = new File(folderpath, fileName);
			FileWriter fw =	new FileWriter(n1);	
			
			//Displaying Content of the file
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
	
	/**
	 * This method will delete the file name if its present in the directory 
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	
	public static boolean deleteFile(String folderpath, String fileName)
	{
		File file = new  File(folderpath+"\\"+fileName);
		
		try
		{
			//Deleting the file
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception Ex)
		{
				return false;
		}
	}
	
	/**
	 * This method will search the file name
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String folderpath, String fileName)
	{
		//Create the file object to search file
		File file = new  File(folderpath+"\\"+fileName);
		
		//Searching File
		if(file.exists())
			return true;
		else
			return false;
	}
}
