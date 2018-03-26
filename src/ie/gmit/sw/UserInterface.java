package ie.gmit.sw;
import java.io.IOException;
//Code by Ultan Kearns
import java.util.Scanner;

public class UserInterface {
	
	private static Scanner input = new Scanner(System.in);
	static int response;
	public static void run() throws IOException {
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
			System.out.println("Set Keys: ");
			SetKeys.setKey();
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
