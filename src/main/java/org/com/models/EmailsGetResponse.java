package org.com.models;

import lombok.Data;

import java.util.ArrayList;
@Data
public class EmailsGetResponse {
    private int count;
    private Object next;
    private Object previous;
    private ArrayList<Object> results;
}
