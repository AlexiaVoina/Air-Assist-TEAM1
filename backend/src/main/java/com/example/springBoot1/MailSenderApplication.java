package com.example.springBoot1;


import com.example.springBoot1.service.MailService;

public class MailSenderApplication {

    public static void main(String[] args) {
        MailService mailService = new MailService();
        mailService.sendMail();
    }
}
