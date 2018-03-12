package ie.gmit.sw;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {
	public static void save(String filePath,StringBuilder sb) throws IOException
	{
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filePath));	
			pw.println(sb);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			System.out.println("\nCannot create directory\n");
			UserInterface.run();
		}
	}
}
