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
			Encryption.encrypt();
			run();
			break;
		case 2:
			Decryption.decrypt();
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
