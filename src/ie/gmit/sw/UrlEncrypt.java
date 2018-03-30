package ie.gmit.sw;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlEncrypt {
	public static void urlSetup(String urlLink,int response) throws IOException
	{
		
		Scanner console = new Scanner(System.in);
		Document doc = Jsoup.connect(urlLink).get();
		String temp = "";
		Elements pageElements = doc.body().select("*");
		System.out.println("\nPlaintext: ");
		for(Element pageElement: pageElements)
		{
			System.out.println(pageElement.text());
			temp += pageElement.text();
		}
		temp = temp.replaceAll("[^a-zA-Z]", "");
		temp = temp.toUpperCase();
		Jsoup.parse(temp);
		StringBuilder encrypt = new StringBuilder(temp);
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
