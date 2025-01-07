package com.x_ticket.Controller;

import com.x_ticket.Model.EmailRequest;
import com.x_ticket.Service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
            logger.info("Email sent successfully to {}", emailRequest.getTo());
            return ResponseEntity.ok("Email sent successfully to " + emailRequest.getTo());
        } catch (MessagingException e) {
            logger.error("Failed to send email to {}: {}", emailRequest.getTo(), e.getMessage());
            return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
        }
    }

    @PostMapping("/send-bulk")
    public ResponseEntity<String> sendBulkEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendBulkEmail(emailRequest);
            logger.info("Bulk email sent successfully to multiple recipients");
            return ResponseEntity.ok("Bulk email sent successfully to multiple recipients");
        } catch (Exception e) { // Catch any other exceptions
            logger.error("Failed to send bulk email: {}", e.getMessage());
            return ResponseEntity.status(500).body("Failed to send bulk email: " + e.getMessage());
        }
    }
}