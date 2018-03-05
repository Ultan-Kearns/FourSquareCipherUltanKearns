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
			//could put these in same class
			Encrypt.setup();
		case 2:
			Decrypt.setup();
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
