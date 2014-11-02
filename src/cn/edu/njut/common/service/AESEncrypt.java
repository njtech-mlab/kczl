package cn.edu.njut.common.service;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncrypt {
	 public static String encrypt(String content) {
         try {
        	 	 String keystr = "51EAE009C67B1EF8";
                 KeyGenerator kgen = KeyGenerator.getInstance("AES");
                 kgen.init(128, new SecureRandom(keystr.getBytes()));
                 SecretKey secretKey = kgen.generateKey();
                 byte[] enCodeFormat = secretKey.getEncoded();
                 SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                 Cipher cipher = Cipher.getInstance("AES");
                 byte[] byteContent = content.getBytes("utf-8");
                 cipher.init(Cipher.ENCRYPT_MODE, key);
                 byte[] result = cipher.doFinal(byteContent);
                 return parseByte2HexStr(result);
         } catch (Exception e) {
         	e.printStackTrace();
         }
         return null;
	 }
	 
	 private static String parseByte2HexStr(byte buf[]) {  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < buf.length; i++) {  
	                String hex = Integer.toHexString(buf[i] & 0xFF);  
	                if (hex.length() == 1) {  
	                        hex = '0' + hex;  
	                }  
	                sb.append(hex.toUpperCase());  
	        }  
	        return sb.toString();  
	 }
}
