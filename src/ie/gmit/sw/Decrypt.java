package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Decrypt {
	public static void setup() {
		Scanner console = new Scanner(System.in);
		// change to file path also need to specify if URL
		System.out.println("Enter path for file: ");
		String fileName = console.next();
		File file = new File(fileName);
		StringBuilder e = new StringBuilder();
		Scanner fileScan;
		try {
			fileScan = new Scanner(file);
			while (fileScan.hasNext()) {
				String line = fileScan.next().toUpperCase();
				System.out.println(fileScan.next());
				e.append(line);
			}
			fileScan.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("File not found\n");
			UserInterface.run();
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
			SaveFile.save(fileName, FourSquareCipher.decrypt(encrypt));
			System.out.println("");
			console.close();
			UserInterface.run();

		} catch (Exception SaveFail) {
			System.out.println("Invalid input or file not found\n Try running as admin?\n");
		}
	}
}
