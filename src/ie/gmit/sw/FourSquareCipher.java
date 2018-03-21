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
	public static void encrypt(char a, char b, StringBuilder e,int pos1, int pos2) {
		/* 
		need to loop through ALL rows and columns
		need to form bigram
		*/
		//NOT DETECTING CHARS AT END OF LINE
		int line = 0;
		//store row and column of char
		int positionOfChar[] = new int[4];
		boolean found = false, found1 = false;
		for(int j = 0; j < 6; j++)
		{
			if(a == matrix[line][j] && line < 5)
			{
				positionOfChar[0] = line;
				positionOfChar[1] = j;
				found = true;
			}
			else if(b == matrix[line][j + 4] && line >= 5)
			{
				positionOfChar[2] = line;
				positionOfChar[3] = j + 4;

				a =  matrix[positionOfChar[2]][positionOfChar[1]];
				b = matrix[positionOfChar[0]][positionOfChar[3]];
				e.setCharAt(pos1, b);
				e.setCharAt(pos2, a);
				found1 = true;
			}
			if(found == true && found1 == true)
			{
				System.out.println(" CHAR 1: " + a + " Char 2: " + b);
				break;
			}
			if(j == 5 && line < 9)
			{
				line++;
				j = 0;
				continue;
			}
		}
 	}
	public static StringBuilder decrypt(char a, char b, StringBuilder d,int pos1, int pos2) {
		//LOGIC WRONG
		System.out.println("Decrypting...");
		/* 
		need to loop through ALL rows and columns
		need to form bigram
		*/
		//NOT DETECTING CHARS AT END OF LINE
		int line = 0;
		//store row and column of char
		int positionOfChar[] = new int[4];
		boolean found = false, found1 = false;
		for(int j = 0; j < 6; j++)
		{
			if(a == matrix[line][j] && line < 5)
			{
				positionOfChar[0] = line;
				positionOfChar[1] = j;
				found = true;
			}
			else if(b == matrix[line][j + 4] && line >= 5)
			{
				positionOfChar[2] = line;
				positionOfChar[3] = j + 4;

				a =  matrix[positionOfChar[2]][positionOfChar[1]];
				b = matrix[positionOfChar[0]][positionOfChar[3]];
				d.setCharAt(pos1, b);
				d.setCharAt(pos2, a);
				found1 = true;
			}
			if(found == true && found1 == true)
			{
				System.out.println(" CHAR 1: " + a + " Char 2: " + b);
				break;
			}
			if(j == 5 && line < 9)
			{
				line++;
				j = 0;
				continue;
			}
		}
		return d;
	}
}
