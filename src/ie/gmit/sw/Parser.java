package ie.gmit.sw;

public class Parser {
	public static StringBuilder parse(StringBuilder e)
	{
		/*O(N)
		 * Due to the fact that it depends on length
		 * of the object StringBuilder e
		*/
		for(int i = 1; i < e.length() - 1; i++)
		{
			if(e.charAt(i) == ' ')
			{
				e.deleteCharAt(i);
				continue;
			}
			else if(i % 2 == 0)
			{
				e.insert(i,' ');
			}
		}
		//need to remove white space from stringbuilder before appending
		if(e.length() % 2 != 0)
		{
			e.append('Z');
		}
		return e;
	}
}
