package ie.gmit.sw;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SaveFile {
	public static void save(String filePath,StringBuilder sb)
	{
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(filePath));	
			pw.println(sb);
			pw.close();
		} catch (Exception e) {
			System.out.println("\nCannot create directory\n");
			UserInterface.run();
		}
	}
}
