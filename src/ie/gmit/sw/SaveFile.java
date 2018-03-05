package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SaveFile {
	public static void save(String filePath,StringBuilder sb)
	{
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(filePath + ".txt"));	
			pw.println(sb);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nCannot create directory\n");
			e.printStackTrace();
			UserInterface.run();
		}
	}
}
