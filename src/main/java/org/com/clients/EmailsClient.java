package org.com.clients;

import io.restassured.response.Response;
import org.com.models.EmailsPostRequest;
import org.com.models.EmailsResponse;

import static java.lang.String.format;

public class EmailsClient extends BaseClient {
    private String token;
    public EmailsClient(){
        super();
    }
    public EmailsClient(String token){
        super();
        this.token = token;
    }

    public EmailsResponse successPost(EmailsPostRequest request){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl+"/api/emails")
                .as(EmailsResponse.class);
    }



    public EmailsResponse getListUsers(String next){
        return (EmailsResponse) prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/emails" + next);
    }

}
