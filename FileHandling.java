package autopilot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
	public static void waypointFromFile(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scan = new Scanner(file);
		ArrayList<String> fileLines = new ArrayList<String>();
		
	}
}
