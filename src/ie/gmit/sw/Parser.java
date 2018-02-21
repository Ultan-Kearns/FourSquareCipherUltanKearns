package ie.gmit.sw;

public class Parser {
	public static StringBuilder parse(StringBuilder e)
	{
		if(e.length() % 2 != 0)
		{
			e.append('Z');
		}
		for(int i = 2; i < e.length(); i = i + 2)
		{ 
			e.insert(i,' '); 
			i++;
		}
		return e;
	}
}
