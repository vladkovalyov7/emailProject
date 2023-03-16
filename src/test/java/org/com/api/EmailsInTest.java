package org.com.api;

import io.restassured.response.Response;
import org.com.clients.EmailsClient;
import org.com.clients.SignInClient;
import org.com.models.EmailsPostRequest;
import org.com.models.EmailsResponse;
import org.com.models.SingInRequest;
import org.com.models.SingInResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class EmailsInTest {

    private EmailsClient client;

    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest("vladkovalyov67", "2Cs5Z2j7");
        SingInResponse responseSI = clientSI.post(credential);
        client = new EmailsClient(responseSI.getToken());
    }

    @Test
    public void postEmails(){
        EmailsClient client = new EmailsClient();
        EmailsPostRequest requestBody = new EmailsPostRequest(1,
                "vladkovalyov67@example.com",
                "string",
                "string");
        EmailsResponse response = client.successPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getRecipient(), "vladkovalyov67@example.com");
    }

//    @Test
//    public void getEmails() {
//        EmailsClient clientSI = new EmailsClient();
//        EmailsPostRequest credentialUser = new EmailsPostRequest(1, "vladkovalyov67@example.com", "string", "string");
//        Response responseUserSI = clientSI.successPost(credentialUser, "vladkovalyov67@example.com");
//        client = new  EmailsClient(responseUserSI.get);
//        EmailsResponse responseUser = client.getListUsers("vladkovalyov67");
//        Assert.assertEquals(responseUser.getStatusCode(), 200);
//    }








}
