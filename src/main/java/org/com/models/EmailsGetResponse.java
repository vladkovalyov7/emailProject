package org.com.models;

import lombok.Data;

import java.util.ArrayList;
@Data
public class EmailsGetResponse {
    private int count;
    private String next;
    private String previous;
    private ArrayList<String> results;
}
