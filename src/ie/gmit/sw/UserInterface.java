package ie.gmit.sw;

import java.util.Scanner;

public class UserInterface {
	private static Scanner console;
	static int response;
	public static void run() {
		System.out.println("1.Encrypt\n2.Decrypt\n3.Exit");
		System.out.print("Choose option: ");
		console = new Scanner(System.in);
		try {
		 response = console.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid type entered try again");
			run();
		}
		switch (response) {
		case 1:
			System.out.println("Enter path for file: ");
			StringBuffer e = new StringBuffer();
			e.append(console.next().toUpperCase());
			try {
				System.out.println(FourSquareCipher.encrypt(e));
			}
			catch(Exception File)
			{
				System.out.println("Invalid input or file not found\n Try running as admin?\n");
			}
			run();
			break;
		case 2:
			System.out.println("Enter text or select file: ");
			StringBuffer d = new StringBuffer();
		    d.append(console.next().toUpperCase());
			FourSquareCipher.decrypt(d);
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
			System.out.println("Exiting...");
			System.exit(0);
			break;
		default:
			System.out.println("\nInvalid type entered\n");
			run();
		}
	}
}
