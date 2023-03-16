package org.com.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailsPostRequest {
    private int sender;
    private String recipient;
    private String subject;
    private String message;
}
