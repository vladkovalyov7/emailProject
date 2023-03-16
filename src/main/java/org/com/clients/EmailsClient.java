package org.com.clients;

import io.restassured.response.Response;
import org.com.models.EmailsPostRequest;
import org.com.models.EmailsPostResponse;
import org.com.models.UserPostRequest;
import org.com.models.UserPostResponse;

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
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl+"/api/emails")
                .as(EmailsPostResponse.class);
    }


    public Response getListEmails(String results){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/emails" +results);
    }


    public Response getEmail(int id){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/emails" +id);
    }

    public Response delete(int id) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/api/challenge/" +id );
    }

    public UserPostResponse userPost(UserPostRequest request){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl+"/api/users")
                .as(UserPostResponse.class);
    }




}
