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
		//need to find data structure that will loop only once
		int line = 0;
		//store row and column of char
		int positionOfChar[] = new int[4];
		boolean found = false, found1 = false;

		System.out.println(" CHAR 1: " + a + " Char 2: " + b);
		for(int j = 0; j < 5; j++)
		{
			if(a == matrix[line][j])
			{
				System.out.println("Line: " + line + "  Position: " + j + " Char: " + a);
				positionOfChar[0] = line;
				positionOfChar[1] = j;
				found = true;
			}
			else if(b == matrix[line][j + 5] && line > 4)
			{
				positionOfChar[2] = line;
				positionOfChar[3] = j + 5;
				System.out.println("Line: " + line + "  Position: " + j + " Char: " + b);
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
			if(j == 4 && line < 9)
			{
				line++;
				j = 0;
				continue;
			}
		}
 	}
	public static StringBuilder decrypt(StringBuilder d) {
		//LOGIC WRONG
		System.out.println("Decrypting...");
		boolean found = false;
		/* 
		need to loop through ALL rows and columns
		need to form bigram
		only works for first line due to j+ 5 could - a[1] but not working
		*/
		int [] a = new int[3];
		//Worst: O(N) / 3 + 25
		for(int i = 0; i < d.length(); i = i + 3)
		{
			found = false;
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 5; k++)
				{
					if(d.charAt(i) == matrix[j][k + 5])
					{
						//index of letter 1
						a[0] = k;
						//row of letter 1
						a[1] = j;
					}
					else if(d.charAt(i + 1) == matrix[j + 5][k - 5])
					{
						//index of letter 2
						a[2] = k - 5;
						d.setCharAt(i + 1, matrix[j + 5][a[0]]);
						found = true;
						break;
					}
				}
				if(found == true)
				{
					d.setCharAt(i, matrix[a[1]][a[2]]);
					break;
				}
			}
		}
		a = null;
		System.out.println("Decrypted");
		return d;
	}
}
