package org.com.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPostRequest {
    private String username;
    private String email;
    private String password;
}
