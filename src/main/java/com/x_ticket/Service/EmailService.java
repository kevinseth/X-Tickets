package com.x_ticket.Service;

import com.x_ticket.Model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Retryable
    public void sendEmail(String to, String subject, String text) throws MessagingException {
        logger.info("Sending email to {}", to);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        mailSender.send(message);
        logger.info("Email sent successfully to {}", to);
    }

    @Async
    @Retryable
    public void sendBulkEmail(EmailRequest emailRequest) {
        List<String> toList = Arrays.asList(emailRequest.getTo().split(","));
        for (String to : toList) {
            try {
                sendEmail(to, emailRequest.getSubject(), emailRequest.getText());
            } catch (MessagingException e) {
                logger.error("Failed to send email to {}: {}", to, e.getMessage());
            }
        }
    }
}