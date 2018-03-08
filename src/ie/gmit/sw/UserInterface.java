package ie.gmit.sw;
//Code by Ultan Kearns
import java.util.Scanner;

public class UserInterface {
	
	private static Scanner input = new Scanner(System.in);
	static int response;
	public static void run() {
		System.out.println("1.Encrypt\n2.Decrypt\n3.Set Keys\n4.Exit");
		System.out.print("Choose option: ");
		try{
		 response = input.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid type entered try again");
		}
		switch (response) {
		case 1:
			EncryptDecrypt.setup(1);
			input.close();
			break;
		case 2:
			EncryptDecrypt.setup(2);
			break;
		case 3:
			//allow users to set keys 25 or generate keys yourself use collections.shuffle
			System.out.println("Set Keys: ");
			input.nextLine();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("\nInvalid type entered\n");
			input.nextLine();
			run();
		}
	}
}
