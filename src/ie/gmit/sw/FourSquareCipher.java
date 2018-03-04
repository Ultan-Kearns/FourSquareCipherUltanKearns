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
		boolean found = false;
		/* 
		need to loop through ALL rows and columns
		need to form bigram
		only works for first line due to j+ 5 could - a[1] but not working
		*/
		int [] a = new int[3];
		System.out.println(e.length());
		//Worst: O(N) / 3 + 25
		for(int i = 0; i < e.length(); i = i + 3)
		{
			found = false;
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 5; k++)
				{
					if(e.charAt(i) == matrix[j][k])
					{
						//index of letter 1
						a[0] = k;
						//row of letter 1
						a[1] = j;
					}
					else if(e.charAt(i + 1) == matrix[j + 5][k + 5])
					{
						//index of letter 2
						a[2] = k + 5;
						e.setCharAt(i + 1, matrix[j + 5][a[0]]);
						found = true;
						break;
					}
				}
				if(found == true)
				{
					e.setCharAt(i, matrix[a[1]][a[2]]);
					break;
				}
			}
		}
		a = null;
		return e;
		}
	}
