package com.x_ticket.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage; 
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.retry.annotation.Retryable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Retryable
    public void sendEmail(String to, String subject, String text) throws MessagingException {
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
    public void sendBulkEmail(List<String> toList, String subject, String text) {
        for (String to : toList) {
            try {
                sendEmail(to, subject, text);
            } catch (MessagingException e) {
                logger.error("Failed to send email to {}: {}", to, e.getMessage());
                // You can also choose to handle this exception differently, such as sending a notification or retrying
            }
        }
    }
}
