package ie.gmit.sw;

import java.util.Scanner;

public class UserInterface {
	private static Scanner console;

	public static void run() {
		System.out.println("1.Encrypt\n2.Decrypt\n3.Exit");
		System.out.print("Choose option: ");
		console = new Scanner(System.in);
		int response = console.nextInt();
		switch (response) {
		case 1:
			FourSquareCipher.encrypt();
			System.out.println("Enter path for file: ");
			String e = console.nextLine();
			try {
			}
			catch(Exception File)
			{
				System.out.println("Invalid input or file not found\n Try running as admin?\n");
			}
			run();
			break;
		case 2:
			FourSquareCipher.decrypt();
			System.out.println("Enter text or select file: ");
			String d = console.nextLine();
			try
			{
				System.out.println(0/0);;
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
