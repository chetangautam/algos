package org.learn;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class FileR {

	public static void main(String[] args)  {
		File file = new File("/tmp/filename.txt");
		
		FileR o = new FileR();
		try {
			InputStream is = o.getClass().getResourceAsStream("file.txt");
			Files.copy(is, file.getAbsoluteFile().toPath());
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

