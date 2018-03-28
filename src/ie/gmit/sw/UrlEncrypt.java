package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class UrlEncrypt {
	public static void urlSetup(String urlLink,int response) throws IOException
	{
		Scanner console = new Scanner(System.in);
		URL url = new URL(urlLink);
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder urlText = new StringBuilder();
		String line = urlReader.readLine();
		while (line != null) {
			//O(1) Appends to end of string
			urlText.append(line);
			//O(1)
			urlText.append('\n');
			line = urlReader.readLine();
		}
		System.out.println("Plaintext: " + urlText.toString());
		urlReader.close();
		String temp = urlText.toString();
		temp = temp.replaceAll("[^a-zA-Z0-9<>]", "");
		temp = temp.toUpperCase();
		StringBuilder encrypt = new StringBuilder(temp);
		System.out.println("\nPARSING");
		System.out.println("\nPlease enter the directory where you want to save file: ");
		String fileName = console.next();
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
			console.close();
		} catch (Exception SaveFail) {
			System.out.println("Invalid input or file not found\n Try running as admin?\n");
			console.close();
		}
	}
}
