package org.com.clients;

import org.com.models.SingInRequest;
import org.com.models.SingInResponse;
import io.restassured.response.Response;

public class SignInClient extends BaseClient {
    public SignInClient() {
        super();
    }
    public SingInResponse post(SingInRequest credential) {
        Response response =  prepareRequest()
                .body(credential)
                .when()
                .post(baseUrl+"/api");
        SingInResponse singInResponse = response.as(SingInResponse.class);
        return singInResponse;
    }
}
