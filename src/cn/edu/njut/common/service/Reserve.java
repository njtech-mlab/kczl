package cn.edu.njut.common.service;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Reserve {
	public static String decrypt(String str, String keystr) {
        try {
        		byte[] content = parseHexStr2Byte(str);
                 KeyGenerator kgen = KeyGenerator.getInstance("AES");
                 kgen.init(128, new SecureRandom(keystr.getBytes()));
                 SecretKey secretKey = kgen.generateKey();
                 byte[] enCodeFormat = secretKey.getEncoded();
                 SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");            
                 Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, key);
                byte[] result = cipher.doFinal(content);
                return new String(result);
        } catch (Exception e) {
                e.printStackTrace();
        } 
        return null;
	}
	
	private static byte[] parseHexStr2Byte(String hexStr) {  
        if (hexStr.length() < 1)  
                return null;  
        byte[] result = new byte[hexStr.length()/2];  
        for (int i = 0;i< hexStr.length()/2; i++) {  
                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
                result[i] = (byte) (high * 16 + low);  
        }  
        return result;  
    }
	
	public static void main(String[] args) {
		System.out.println(decrypt("5F37C480673A41DB163E948478A9109F", "51EAE009C67B1EF8"));
	}
}





/**
	poweredbydu
*/