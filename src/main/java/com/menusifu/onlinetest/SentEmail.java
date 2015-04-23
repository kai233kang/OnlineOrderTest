package com.menusifu.onlinetest;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;


public class SentEmail
{
    private String mailhost = "smtp.gmail.com";

    public static synchronized void sendMail(String subject, String body, String sender, String recipients)
            throws Exception
    {

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host","smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    { return new PasswordAuthentication("kangkai@menusifu.com","kk1984118");     }
                });

        MimeMessage message = new MimeMessage(session);
        message.setSender(new InternetAddress(sender));
        message.setSubject(subject);
        message.setContent(body, "text/plain");
        if (recipients.indexOf(',') > 0){
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            message.setSubject("flushing online order server ");
            message.setText("flushing online order testing environment crashed");
            message.setSentDate(new Date());
            System.out.println("Message sent.");
        }

        else {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
            message.setSubject("flushing online order server ");
            message.setText("flushing online order testing environment crashed");
            message.setSentDate(new Date());
            System.out.println("Message sent.");
        }

        Transport.send(message);

    }


}

