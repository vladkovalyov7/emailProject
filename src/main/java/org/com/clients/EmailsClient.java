package org.com.clients;

import io.restassured.response.Response;
import org.com.models.*;

import static java.lang.String.format;

public class EmailsClient extends BaseClient {
    private String token;
    private int sender;
    public EmailsClient(){
        super();
    }
    public EmailsClient(String token){
        super();
        this.token = token;
    }
    public EmailsClient(int sender) {
        this.sender = sender;
    }

    public EmailsPostResponse emailPost(EmailsPostRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .post(baseUrl+"/api/emails")
                .as(EmailsPostResponse.class);
    }


    public Response getListEmails(String results){
        return prepareRequest()
                .when()
                .get(baseUrl+"/api/emails/" +results);
    }


    public EmailsGetResponse getEmail(){
        return prepareRequest()
                .when()
                .get(baseUrl+"/api/emails/")
                .as(EmailsGetResponse.class);

    }

    public Response delete(int id) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(baseUrl+"/api/emails/" +id );
    }


    public UserPostResponse userPost(UserPostRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .post(baseUrl +"api/users/")
                .as(UserPostResponse.class);
    }

    public UserGetResponse getUser(){
        return prepareRequest()
                .when()
                .get(baseUrl +"api/users/current/")
                .as(UserGetResponse.class);
    }


}
