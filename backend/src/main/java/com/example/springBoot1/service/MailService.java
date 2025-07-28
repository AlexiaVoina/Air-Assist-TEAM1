package com.example.springBoot1.service;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.Properties;
import io.github.cdimascio.dotenv.Dotenv;

@Slf4j
public class MailService {

    public void sendMail(){
        Dotenv dotenv = Dotenv.load();

        final String username = dotenv.get("MAIL_USER");
        final String password = dotenv.get("MAIL_PASSWORD");

        Properties prop = new Properties();
        try {
            prop.load(MailService.class.getResourceAsStream("/mailData.properties"));
            log.info("props loaded successfully");
        }
        catch (IOException e) {
            log.error("Error loading mail properties", e);
            return;
        }

        Session session = Session.getInstance(prop,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("george.lucaci02@gmail.com")
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);
            log.info("Done");

        } catch (MessagingException e) {
            log.error("Error sending email: {}", e.getMessage());
        }

    }
}
