package ie.gmit.sw;

public class Parser {
	public static StringBuilder parse(StringBuilder e,int op)
	{
		//Check if e is even
		if(e.length() % 2 != 0)
		{
			e.append('Z');
		}
		//Big O(N / 2) As it is half the length of e
		//maybe call encrypt from here only pass in 2 chars
		
		for(int i = 0; i < e.length(); i++)
		{ 
			int a = i;
			int b = i + 1;
			if(op == 1)
			{
				FourSquareCipher.encrypt(e.charAt(a),e.charAt(b), e,a,b);
			}
			else
			{
				FourSquareCipher.decrypt(e.charAt(a), e.charAt(b), e, a, b);
			}
			i++;
		}
		return e;
	}
}
