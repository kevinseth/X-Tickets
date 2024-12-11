package com.x_ticket.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



public class EmailRequest {

    @NotEmpty(message = "Recipient email must not be empty")
    @Email(message = "Invalid email format")
    private String to;

    @NotEmpty(message = "Subject must not be empty")
    @Size(max = 255, message = "Subject must not exceed 255 characters")
    private String subject;

    @NotEmpty(message = "Email body must not be empty")
    private String text;

    // Constructors
    public EmailRequest() {
    }

    public EmailRequest(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    // Getters and Setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // toString for debugging
    @Override
    public String toString() {
        return "EmailRequest{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
