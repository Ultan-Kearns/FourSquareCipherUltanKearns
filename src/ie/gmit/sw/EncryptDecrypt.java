package ie.gmit.sw;

 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EncryptDecrypt {
	// change to file path also need to specify if URL
	public static void setup(int response) throws IOException {
		Scanner console = new Scanner(System.in);
		StringBuilder e = new StringBuilder();
		//test purposes
		long startTime = 0;
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
			FileReader file = new FileReader(fileName);
			//O(log n)
			BufferedReader fileScan = new BufferedReader(file);
			String line = fileScan.readLine();
			while (line != null) {
				//O(1) Appends to end of string
				e.append(line);
				//O(1)
				e.append('\n');
				line = fileScan.readLine();
			}
			System.out.println("Plaintext: " + e.toString());
			 file.close();
			 fileScan.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("File not found\n");
			console.nextLine();
			UserInterface.run();
		}
		String temp = e.toString();
		temp = temp.replaceAll("[^a-zA-Z0-9]", "");
		temp = temp.toUpperCase();
		StringBuilder encrypt = new StringBuilder(temp);
		temp = null;
		e = null;
		System.out.println("\nPARSING");
		System.out.println("\nPlease enter the directory where you want to save file: ");
		fileName = console.next();
		startTime = System.nanoTime();
		long totalTime = 0;
		try {
			if(response == 1)
			{
				Parser.parse(encrypt,1);
				SaveFile.save(fileName,encrypt);
				System.out.println("\nFile Saved");
				System.out.println("\nEncrypted: " + encrypt.toString());
				UserInterface.run();
			}
			else if(response == 2)
			{
				//O(N/2)
				Parser.parse(encrypt,2);
				//o(log n)
				SaveFile.save(fileName, encrypt);
				System.out.println("Decrypted: " + encrypt.toString());
				System.out.println("\nFile Saved");
				UserInterface.run();
			}
			totalTime = System.nanoTime() - startTime;
			System.out.println("Time taken: " + totalTime + " ns");
			console.close();
		} catch (Exception SaveFail) {
			System.out.println("Invalid input or file not found\n Try running as admin?\n");
			console.close();
		}
	}
}
