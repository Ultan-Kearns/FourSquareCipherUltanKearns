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
		*/
		//for each in string
		int [] a = new int[3];
		for(int i = 0; i < e.length() / 2; i = i + 2)
		{
			found = false;
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 5; k++)
				{
					if(e.charAt(i) == matrix[j][k])
					{
						a[0] = k;
						a[2] = j;
					}
					else if(e.charAt(i + 1) == matrix[j + 5][k + 5])
					{
						a[1] = k + 5;
						e.setCharAt(i + 1, matrix[j + 5][a[0]]);
						found = true;
						break;
					}
				}
				if(found == true)
				{
					e.setCharAt(i, matrix[a[2]][a[1]]);
					break;
				}
			}
		}
		return e;
		}
	}
