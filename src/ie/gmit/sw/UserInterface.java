package ie.gmit.sw;
//Code by Ultan Kearns

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInterface {
	private static Scanner console;
	static int response;
	public static void run() {
		System.out.println("1.Encrypt\n2.Decrypt\n3.Set Keys\n4.Exit");
		System.out.print("Choose option: ");
		console = new Scanner(System.in);
		try{
		 response = console.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid type entered try again");
			run();
		}
		switch (response) {
		case 1:
			//change to file path also need to specify if URL
			System.out.println("Enter path for file: ");
			String fileName = console.next();
			File file = new File(fileName);
			StringBuilder e = new StringBuilder();
			Scanner fileScan;
			try {
				fileScan = new Scanner(file);
				while(fileScan.hasNext())
				{
					String line = fileScan.next().toUpperCase();
					System.out.println(fileScan.next());
					e.append(line);
				}
				fileScan.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("File not found\n");
				run();
			}
			String temp = e.toString();
			temp = temp.replaceAll(" ", "");
			StringBuilder encrypt = new StringBuilder(temp);
			temp = null; 
			e = null;
			System.out.println(encrypt);
			Parser.parse(encrypt);
			System.out.println("AFTER PARSE: " + encrypt);	
			try {
				System.out.println("\nPlease enter the directory where you want to save file: ");
				fileName = console.next();
				SaveFile.save(fileName,FourSquareCipher.encrypt(encrypt));
				System.out.println("");
				run();

			}
			catch(Exception SaveFail)
			{
				System.out.println("Invalid input or file not found\n Try running as admin?\n");
			 
			}
			break;
		case 2:
			//Make decrypt class?
			System.out.println("Enter text or select file: ");
			StringBuffer d = new StringBuffer();
		    d.append(console.next().toUpperCase());
			try
			{
				
			}
			catch(Exception File)
			{
				System.out.println("Invalid input or file not found\n Try running as admin?\n");
			}
			run();
			break;
		case 3:
			//allow users to set keys 25 or generate keys yourself use collections.shuffle
			System.out.println("Set Keys: ");
			console.nextLine();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("\nInvalid type entered\n");
			run();
		}
	}
}
