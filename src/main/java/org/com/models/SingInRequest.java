package org.com.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingInRequest {
    private String username;
    private String password;
}
