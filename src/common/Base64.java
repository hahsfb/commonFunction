package common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {

	public static void main(String[] args) {
		String aa = getBase64("都是渣渣！");
		System.out.println(aa);
		System.out.println(decode(aa));
	}

	
	/**
	 * base64加密操作
	 * @param str
	 * @return
	 */
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}
	
	/**
	 * base64 解密操作
	 * @param str
	 * @return
	 */
	   public static String decode(String str){    
	   String resultStr = "";
	   try {    
	       BASE64Decoder decoder = new BASE64Decoder();    
	       byte[] bt = decoder.decodeBuffer(str);    
	       resultStr = new String(bt, "utf-8");
	   } catch (IOException e) {    
	       e.printStackTrace();    
	   }
	       return resultStr;    
	   }   
}
