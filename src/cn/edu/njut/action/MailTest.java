package cn.edu.njut.action;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {
	public static void main(String[] args) {
	      // Sender's email ID needs to be mentioned
	      String from = "njtechmlab@gmail.com";
	      String to = "du@njut.edu.cn";

	      // Get system properties
	      Properties props = System.getProperties();

	      props.put("mail.smtp.user","njtechmlab@gmail.com"); 
	      props.put("mail.smtp.password", "!@njtechmlab");
	      props.put("mail.smtp.host", "smtp.gmail.com"); 
	      props.put("mail.smtp.port", "25"); 
	      props.put("mail.debug", "true"); 
	      props.put("mail.smtp.auth", "true"); 
	      props.put("mail.smtp.starttls.enable","true"); 
	      props.put("mail.smtp.EnableSSL.enable","true");
	      props.setProperty("mail.user", "njtechmlab@gmail.com");
	      props.setProperty("mail.password", "!@njtechmlab");

	      props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
	      props.setProperty("mail.smtp.socketFactory.fallback", "false");   
	      props.setProperty("mail.smtp.port", "465");   

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(props);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("This is actual message");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}
