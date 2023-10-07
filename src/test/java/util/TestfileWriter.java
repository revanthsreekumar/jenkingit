package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestfileWriter {
	public boolean lineWriter(String fileName,String content) {
		String filePath = "target/"+fileName; // Replace with your desired file path
		File file = new File(filePath);

		try(FileWriter fileWriter = new FileWriter(file,true)) {
			// Check if the file already exists
			if (file.exists()) {
				//System.out.println("File already exists.");
			} else {
				// If the file doesn't exist, create it
				boolean created = file.createNewFile();
				}
			fileWriter.write(content+"\n");
		return true;	
		}
		catch(IOException e){
			e.printStackTrace();
			return false;
		}
		
		
		
	}
}
