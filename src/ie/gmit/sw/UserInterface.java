package ie.gmit.sw;
import java.io.IOException;
//Code by Ultan Kearns
import java.util.Scanner;

public class UserInterface {
	
	private static Scanner input = new Scanner(System.in);
	static int response;
	static String userUrl = new String();
	public static void run() throws IOException {
		//need to add URL support add getinputstream
		System.out.println("1.Encrypt\n2.Decrypt\n3.Set Keys\n4.To encrypt URL\n5.To decrypt URL");
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
			break;
		case 2:
			EncryptDecrypt.setup(2);
			break;
		case 3:
			FourSquareCipher.setKey();
			break;
		case 4:
			try
			{
			System.out.println("\nPlease enter URL: ");
			userUrl = input.next();
			UrlEncrypt.urlSetup(userUrl, 1);
			}
			catch(Exception e)
			{
				System.out.println("\nInvalid URL\n");
				UserInterface.run();
			}
			break;
		case 5:
			try
			{
			System.out.println("\nPlease enter URL: ");
			userUrl = input.next();
			UrlEncrypt.urlSetup(userUrl, 2);
			}
			catch(Exception e)
			{
				System.out.println("\nInvalid URL\n");
				UserInterface.run();
			}
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("\nInvalid type entered\n");
			input.nextLine();
			run();
		}
	}
}
