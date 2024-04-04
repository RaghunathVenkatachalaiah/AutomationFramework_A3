package pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		

		
			
		//Step1 : Open the document in Java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
			
		//Step2 : Create object of Properties class java.util
		Properties p=new Properties();
			
		//Step3 : Load the File Input Stream to Properties
		p.load(fis);
			
		//Step4 : Use the KEY and fetch the value
		String value = p.getProperty("url");
		System.out.println(value);

		}

	
	}


