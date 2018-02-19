package ie.gmit.sw;
//Code by Ultan Kearns

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
	public static StringBuilder encrypt(StringBuilder e) {
		System.out.println("Encrypting...");
		//O(N^2)? depends on size of string and loops through array
		//need to loop through ALL rows and columns
		for(int i = 0; i < e.length(); i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				if(e.charAt(i) == matrix[j][j])
				{
					e.setCharAt(i, matrix[j][j + 5]);
					break;
				}
			}
		}
		System.out.println("Encrypted String: " + e + "\nEncrypted in: " + System.currentTimeMillis() / 600);
		return e;
	}
	

}
