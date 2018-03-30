package ie.gmit.sw;
import java.io.IOException;
//Code by Ultan Kearns
import java.util.Scanner;

public class UserInterface {
	
	private static Scanner input = new Scanner(System.in);
	static int response;
	static String userUrl = new String();
	public static void run() throws IOException {
		System.out.println("1.Encrypt\n2.Decrypt\n3.Set Keys\n4.To encrypt URL\n5.To decrypt URL\n6.To encrypt/decrypt word\n7.To exit");
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
			System.out.println("\nPlease enter text you would like to encrypt: ");
			String userIn = input.next();
			userIn = userIn.replaceAll("[^a-zA-Z0-9]", "");
			userIn = userIn.toUpperCase();
			StringBuilder userText = new StringBuilder(userIn);
			System.out.println("\nEnter 1.For Encrypt 2.For Decrypt");
			int userReply = input.nextInt();
			if(userReply == 1)
			{
				Parser.parse(userText, 1);
				System.out.println("Encrypted text: " +  userText.toString() + "\n");
			}
			else
			{
				Parser.parse(userText, 1);
				System.out.println("Decrypted text: " +  userText + "\n");
			}
			run();
			break;
		case 7:
			System.exit(0);
			break;
		default:
			System.out.println("\nInvalid type entered\n");
			input.nextLine();
			run();
		}
	}
}
