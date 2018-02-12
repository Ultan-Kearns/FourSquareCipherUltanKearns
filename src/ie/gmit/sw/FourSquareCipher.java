package ie.gmit.sw;

public class FourSquareCipher {
	//replace first five letters from rows with letters from last five
	private static char[][] matrix = {
			{'A', 'B', 'C', 'D', 'E', 'Z', 'G', 'P', 'T', 'F'},
			{'F', 'G', 'H', 'I', 'K', 'O', 'I', 'H', 'M', 'U'},
			{'L', 'M', 'N', 'O', 'P', 'W', 'D', 'R', 'C', 'N'},
			{'Q', 'R', 'S', 'T', 'U', 'Y', 'K', 'E', 'Q', 'A'},
			{'V', 'W', 'X', 'Y', 'Z', 'X', 'V', 'S', 'B', 'L'},
			{'M', 'F', 'N', 'B', 'D', 'A', 'B', 'C', 'D', 'E'},
			{'C', 'R', 'H', 'S', 'A', 'F', 'G', 'H', 'I', 'K'},
			{'X', 'Y', 'O', 'G', 'V', 'L', 'M', 'N', 'O', 'P'},
			{'I', 'T', 'U', 'E', 'W', 'Q', 'R', 'S', 'T', 'U'},
			{'L', 'Q', 'Z', 'K', 'P', 'V', 'W', 'X', 'Y', 'Z'}
		};
	public static StringBuffer encrypt(StringBuffer e) {
		System.out.println("Encrypting...");
		for(int i = 0; i < e.length(); i++)
		{
			System.out.println(e.charAt(i) + " " + matrix[i][i]);
			if(e.charAt(i) == matrix[i][i])
			{
				e.setCharAt(i, matrix[i][i + 5]);
			}
		}
		System.out.println("Encrypted\n");
		return e;
	}
	public static StringBuffer decrypt(StringBuffer e) {
		System.out.println("Decrypting...");
		for(int i = 0; i < e.length(); i++)
		{
			if(e.charAt(i) == matrix[i][i])
			{
				e.setCharAt(i, matrix[i][i - 5]);
			}
		}
		System.out.println("Decrypted\n");
		return e;
	}

}
