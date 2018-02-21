package ie.gmit.sw;
//Code by Ultan Kearns

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
			console.nextLine();
			StringBuilder e = new StringBuilder(console.nextLine().toUpperCase());
			String temp = e.toString();
			temp = temp.replaceAll(" ", "");
			StringBuilder encrypt = new StringBuilder(temp);
			System.out.println(encrypt);
			Parser.parse(encrypt);
			System.out.println("AFTER PARSE: " + encrypt);
			try {
				FourSquareCipher.encrypt(e);
			}
			catch(Exception File)
			{
				System.out.println("Invalid input or file not found\n Try running as admin?\n");
			}
			run();
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
