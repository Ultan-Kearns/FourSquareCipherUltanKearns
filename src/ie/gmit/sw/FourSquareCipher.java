package ie.gmit.sw;
//Code by Ultan Kearns

import java.io.IOException;
import java.util.Scanner;

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
		 *  O(log n) as it takes 2 characters
		 */
		for(int j = 0; j < 5; j++)
		{
			if(a == 'J')
			{
				a = 'I';
			}
			if(b == 'J')
			{
				b = 'I';
			}
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
		 * O(log n) as it takes 2 characters
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
	public static void setKey() throws IOException {
		int line = 0;
		char replace = 0;
		System.out.println("Set Keys: ");
		Scanner console = new Scanner(System.in);
		//Need to remove dupes(maybe use set)
		for(int i = 0; i < 5; i++)
		{
			if(line < 5)
			{
				System.out.println("\nEnter decimal to exit\nPlease enter character for Line " + line  + " position " + (i  +  5)  +  ": ");
			}
			else
			{
				System.out.println("\nEnter decimal to exit\n\nPlease enter character for position " + i  + " Line " + line  + ": ");
			}
			//check if decimal is entered
			if(replace <= 57 && replace >= 48)
			{
				System.out.println("\nDecimal entered keys are set\n");
				break;
			}
			replace = console.next().charAt(0);
			//O(1) toUpperCase is a constant time operation on a character
			matrix[line][i] = Character.toUpperCase(replace);
			if(i == 4 && line < 9)
			{
				i = -1;
				line++;
				continue;
			}
		}
		UserInterface.run();
		console.close();
	}
}
