package org.com.clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseClient {
    public final String baseUrl;
    public final ContentType contentType;

    public BaseClient() {
        this.baseUrl = "http://68.183.74.14:4005/swagger";
        this.contentType = ContentType.JSON;
    }

    public RequestSpecification prepareRequest() {
        return given()
                .baseUri(baseUrl)
                .contentType(contentType)
                .accept(contentType);
    }
}
