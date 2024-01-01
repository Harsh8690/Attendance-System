package com.example.attendance;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class Mail {
    public static void email(String sender,String receiver,String sub,String message){
        Properties pr=new Properties();
        pr.put("mail.smtp.auth",true);

        pr.put("mail.smtp.starttls.enable",true);
        pr.put("mail.smtp.port","587");
        pr.put("mail.smtp.host","smtp.gmail.com");

        String email="harshdholipal@gmail.com";
        String pass="cdmrhorjaboalujq";

        Session session=Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(email,pass);
            }
        });

        try {
            Message msg=new MimeMessage(session);
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
            msg.setFrom(new InternetAddress(sender));
            msg.setSubject(sub);
            msg.setText(message);

            Transport.send(msg);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
