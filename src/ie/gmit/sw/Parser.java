package ie.gmit.sw;

public class Parser {
	public static StringBuilder parse(StringBuilder e)
	{
		//Check if e is even
		if(e.length() % 2 != 0)
		{
			e.append('Z');
		}
		//Big O(N / 2) As it is half the length of e
		//maybe call encrypt from here
		for(int i = 2; i < e.length(); i = i + 2)
		{ 
			FourSquareCipher.encrypt(i,e);
			e.insert(i,' ');
			i++;
		}
		return e;
	}
}
