package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;

public class CopyOfIOtest {

	public static void main(String[] args) {
		String str1 = "test_home_billboard1_aa";
		String str2 = "test_home_billboard2_aa";
		String str3 = "test_home_billboard3_aa";
		String str4 = "test_home_billboard4_aa";
		String str5 = "test_home_billboard5_aa";
		
		StringBuffer sb = new StringBuffer();
		
		String[] arr = {str1,str2,str3,str4,str5};
		
		for(int i = 0; i<arr.length ; i++ ){
			sb.append(arr[i]);
			String[] strArr = arr[i].split("_");
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
				write.append(sb);
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

}
