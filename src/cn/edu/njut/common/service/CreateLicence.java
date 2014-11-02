package cn.edu.njut.common.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class CreateLicence {
	public static String createLicence(String info) throws NoSuchAlgorithmException
	{
		//Date systemTime=new Date();
		//Random random=new Random();
		//int randomInt=random.nextInt();
		
		StringBuffer str=new StringBuffer();
		str.append(info);
		//str.append(systemTime.toString());
		//str.append(randomInt);
		str.append("This part was modified at 21:00, 2013-05-16");	// modified by Hongwei Du

		String licence=MD5Encoder.md5Encoder(str.toString());
		return licence;
	}
}
