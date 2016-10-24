package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class IOtest {

	public static void main(String[] args) {
		String str = "test_home_billboard_aa";
		String[] strArr = str.split("_");
		FileOutputStream fop = null;
		File directory = null;
		File file = null; 
		try {
			String fileName = "E:\\".concat(strArr[1]).concat(File.separator).concat(strArr[2]).concat(File.separator); 
			directory = new File(fileName);  
            directory.mkdirs(); 
            if (!directory.exists()) {  
                return;  
            }  
			file = new File(fileName.concat("test.txt"));
			if (!file.exists()) {
				file.createNewFile();
			}

			fop = new FileOutputStream(file);
			
			OutputStreamWriter write = new OutputStreamWriter(fop);
			write.append("1111111111111111111");
			write.close();
			fop.flush();
			fop.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("1:");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("2:");
			System.out.println(e.getMessage());
		}

	}

}
