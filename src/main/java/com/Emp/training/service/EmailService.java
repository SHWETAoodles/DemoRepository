package com.Emp.training.service;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public boolean sendEmail(String subject,String message,String to) {
		boolean f=false;
		String from="shwetasingh4249@gmail.com";
		String host="smtp.gmail.com";
		Properties properties=System.getProperties();
		System.out.println("PRPERTIES "+properties);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session=Session.getInstance(properties, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("shwetasingh4249@gmail.com","S1792@74T");
				
			}
			
		});
		
		session.setDebug(true);
		MimeMessage m=new MimeMessage(session);
		try {
			m.setFrom();
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(to) );
			m.setSubject(subject);
			m.setText(message);
			Transport.send(m);
			System.out.println("send success......");
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
