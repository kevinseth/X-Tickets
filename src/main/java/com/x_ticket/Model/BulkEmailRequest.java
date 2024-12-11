package com.x_ticket.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class BulkEmailRequest {

    @NotEmpty(message = "Recipient list must not be empty")
    @Email(message = "Each recipient email must be valid")
    private List<@Email(message = "Invalid email format") String> toList;

    @NotEmpty(message = "Subject must not be empty")
    @Size(max = 255, message = "Subject must not exceed 255 characters")
    private String subject;

    @NotEmpty(message = "Email body must not be empty")
    private String text;

    // Constructors
    public BulkEmailRequest() {
    }

    public BulkEmailRequest(List<String> toList, String subject, String text) {
        this.toList = toList;
        this.subject = subject;
        this.text = text;
    }

    // Getters and Setters
    public List<String> getToList() {
        return toList;
    }

    public void setToList(List<String> toList) {
        this.toList = toList;
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
        return "BulkEmailRequest{" +
                "toList=" + toList +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
