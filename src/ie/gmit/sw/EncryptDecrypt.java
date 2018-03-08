package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EncryptDecrypt {
	public static void setup(int response) {
		Scanner console = new Scanner(System.in);
		// change to file path also need to specify if URL
		StringBuilder e = new StringBuilder();
		String fileName = "";
		try {
			System.out.println("Enter path for file: ");
			try
			{
				fileName = console.next();
			}
			catch(Exception exception)
			{
				System.out.println("invalid input");
				fileName = console.next();
			}
			File file = new File(fileName);
			Scanner fileScan;
			fileScan = new Scanner(file);
			while (fileScan.hasNext()) {
				String line = fileScan.next().toUpperCase();
				e.append(line);
			}
			fileScan.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("File not found\n");
			console.nextLine();
			UserInterface.run();
		}
		String temp = e.toString();
		temp = temp.replaceAll(" ", "");
		StringBuilder encrypt = new StringBuilder(temp);
		temp = null;
		e = null;
		//System.out.println(encrypt);
		Parser.parse(encrypt);
		System.out.println("AFTER PARSE: " + encrypt);
		System.out.println("\nPlease enter the directory where you want to save file: ");
		fileName = console.next();
		try {
			if(response == 1)
			{
			SaveFile.save(fileName,e);
			System.out.println("\nFile Saved");
			UserInterface.run();
			}
			else
			{
				SaveFile.save(fileName, FourSquareCipher.decrypt(encrypt));
				System.out.println("\nFile Saved");
				UserInterface.run();
			}
			console.close();
		} catch (Exception SaveFail) {
			System.out.println("Invalid input or file not found\n Try running as admin?\n");
			console.close();
		}
	}
}
