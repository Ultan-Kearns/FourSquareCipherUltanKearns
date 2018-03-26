package ie.gmit.sw;

import java.io.IOException;
import java.util.Scanner;

public class SetKeys {
	public static void setKey() throws IOException {
		char[][] matrix = { 
				{ 'A', 'B', 'C', 'D', 'E', 'Z', 'G', 'P', 'T', 'F' },
				{ 'F', 'G', 'H', 'I', 'K', 'O', 'I', 'H', 'M', 'U' },
				{ 'L', 'M', 'N', 'O', 'P', 'W', 'D', 'R', 'C', 'N' },
				{ 'Q', 'R', 'S', 'T', 'U', 'Y', 'K', 'E', 'Q', 'A' },
				{ 'V', 'W', 'X', 'Y', 'Z', 'X', 'V', 'S', 'B', 'L' },
				{ 'M', 'F', 'N', 'B', 'D', 'A', 'B', 'C', 'D', 'E' },
				{ 'C', 'R', 'H', 'S', 'A', 'F', 'G', 'H', 'I', 'K' },
				{ 'X', 'Y', 'O', 'G', 'V', 'L', 'M', 'N', 'O', 'P' },
				{ 'I', 'T', 'U', 'E', 'W', 'Q', 'R', 'S', 'T', 'U' },
				{ 'L', 'Q', 'Z', 'K', 'P', 'V', 'W', 'X', 'Y', 'Z' } 
				};
		int line = 0;
		char replace;
		Scanner console = new Scanner(System.in);
		for(int i = 0; i < 5; i++)
		{
			if(line < 5)
			{
				System.out.println("\nPlease enter character for position " + (i  +  5) + " Line " + line  + ": ");
			}
			else
			{
				System.out.println("\nPlease enter character for position " + i  + " Line " + line  + ": ");
			}
			replace = console.next().charAt(0);
			matrix[line][i] = replace;
			if(i == 4 && line < 9)
			{
				i = -1;
				line++;
				continue;
			}
		}
		UserInterface.run();

	}
}
