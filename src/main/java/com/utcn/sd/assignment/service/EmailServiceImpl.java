package com.utcn.sd.assignment.service;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class EmailServiceImpl {

    public void sendSimpleMessage(String to, String subject, String text) throws MessagingException, IOException {
        JavaMailSender emailSender = getJavaMailSender();
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("pgc.so.owner@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);        emailSender.send(message);
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("pgc.so.owner");
        mailSender.setPassword("stackoverflow");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
