package cn.edu.njut.common.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {
	private static final String[] hexDigits={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	private static String byteToHexString(byte b)
	{
		int n=b;
		if(n<0)
			n+=256;
		String ch1=hexDigits[n/16];
		String ch2=hexDigits[n%16];
		return ch1+ch2;
	}
	
	public static String md5Encoder(String str) throws NoSuchAlgorithmException
	{
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[] bytes=md.digest(str.getBytes());
		StringBuffer result=new StringBuffer();
		for(int i=0;i<bytes.length;i++)
			result.append(byteToHexString(bytes[i]));
		return result.toString();
	}
}
