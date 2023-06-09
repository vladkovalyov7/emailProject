package org.com.models;


import lombok.Data;

@Data
public class EmailsPostResponse {
    private int id;
    private int sender;
    private String recipient;
    private String subject;
    private String message;
}
