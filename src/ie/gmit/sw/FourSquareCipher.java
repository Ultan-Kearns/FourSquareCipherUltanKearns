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
		int line = 0;
		//store row and column of char
		int positionOfChar[] = new int[4];
		boolean found = false, found1 = false;
		/*
		 * Worst Case: O(15) as it will have to check every line and character
		 */
		for(int j = 0; j < 5; j++)
		{
			if(a == matrix[line][j] && line < 5 && found != true)
			{
				positionOfChar[0] = line;
				positionOfChar[1] = j;
				found = true;
			}
			else if(b == matrix[line][j + 5] && line >= 5 && found1 != true )
			{
				positionOfChar[2] = line;
				positionOfChar[3] = j + 5;
				a =  matrix[positionOfChar[2]][positionOfChar[1]];
				b = matrix[positionOfChar[0]][positionOfChar[3]];
				//set char at O(1) as it just overwrites the character
				e.setCharAt(pos1, b);
				e.setCharAt(pos2, a);
				found1 = true;
			}
			if(found == true && found1 == true)
			{
				break;
			}
			if(j == 4 && line < 9)
			{
				line++;
				j = -1;
				continue;
			}
		}
 	}
	public static StringBuilder decrypt(char a, char b, StringBuilder d,int pos1, int pos2) {
		int line = 0;
		//store row and column of char
		int positionOfChar[] = new int[4];
		boolean found = false, found1 = false;
		/*
		 * Worst Case: O(15) as it will have to check every line and character
		 */
		for(int j = 0; j < 5; j++)
		{
			if(a == matrix[line][j + 5] && line < 5 && found != true)
			{
				positionOfChar[0] = line;
				positionOfChar[1] = j + 5;
				found = true;
			}
			else if(b == matrix[line][j] && line >= 5 && found1 != true)
			{
				positionOfChar[2] = line;
				positionOfChar[3] = j;
				a =  matrix[positionOfChar[2]][positionOfChar[1]];
				b = matrix[positionOfChar[0]][positionOfChar[3]];
				//O(1)
				d.setCharAt(pos1, b);
				d.setCharAt(pos2, a);
				found1 = true;
			}
			if(found == true && found1 == true)
			{
				break;
			}
			if(j == 4 && line < 9)
			{
				line++;
				j = -1;
				continue;
			}
		}
		return d;
	}
}
