package org.com.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserGetResponse {
    private int id;
    private String username;
    private String email;
}
