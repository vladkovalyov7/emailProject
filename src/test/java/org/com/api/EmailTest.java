package org.com.api;

import io.restassured.response.Response;
import org.com.clients.EmailsClient;
import org.com.clients.SignInClient;
import org.com.models.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class EmailTest {

    private EmailsClient client;

    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest("vladkovalyov67", "2Cs5Z2j7");
        SingInResponse responseSI = clientSI.post(credential);
        client = new EmailsClient(responseSI. getToken());
    }

    @Test
    public void postEmails(){
        EmailsClient client = new EmailsClient();
        EmailsPostRequest requestBody = new EmailsPostRequest(1,
                "vladkovalyov67@example.com",
                "string",
                "string");
        EmailsPostResponse response = client.emailPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getRecipient(), "vladkovalyov67@example.com");
    }

    @Test
    public void getEmails() {
        EmailsClient clientSI = new EmailsClient();
        EmailsPostRequest credentialUser = new EmailsPostRequest(1, "vladkovalyov67@example.com", "string", "string");
        EmailsPostResponse responseUserSI = clientSI.emailPost(credentialUser);
        client = new  EmailsClient(responseUserSI.getSender());
        Response responseUser = client.getListEmails("vladkovalyov67@example.com");
        Assert.assertEquals(responseUser.getStatusCode(), 200);
    }


    @Test
    public void getEmailId() {
        EmailsClient client = new EmailsClient();
        EmailsGetResponse response = client.getEmail();
        Assert.assertEquals(response.getCount(), 216);
    }

    @Test
    public void SuccessCreateAndDeleteChallenge() {
        EmailsClient client = new EmailsClient();
        EmailsPostRequest requestBody = new EmailsPostRequest(1,
                "vladkovalyov67@example.com",
                "string",
                "string");
        EmailsPostResponse response = client.emailPost(requestBody);
        int id = response.getId();
        Response responseDel = client.delete(id);
        Assert.assertEquals(responseDel.statusCode(), 200);
    }


    @Test
    public void postUser(){
        EmailsClient client = new EmailsClient();
        UserPostRequest requestBody = new UserPostRequest("vlad",
                "vlad@example.com",
                "string");
        UserPostResponse response = client.userPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getUsername(), "vlad");
    }


    @Test
    public void postUserV(){
        EmailsClient client = new EmailsClient();
        UserPostRequest credential = new  UserPostRequest("vladqwertyjhjhq","usdsdsduysdser@example.com", "2Cs5Z2j7");
        UserPostResponse response = client.userPost(credential);
        Assert.assertEquals(response.getUsername(), "vladqwertyjhjhq");
    }


    @Test
    public void getUser() {
        EmailsClient client = new EmailsClient();
        UserGetResponse response = client.getUser();
        Assert.assertEquals(response.getId(), 216);
    }

}
