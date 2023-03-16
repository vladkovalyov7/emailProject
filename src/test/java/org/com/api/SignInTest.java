package org.com.api;

import org.com.clients.SignInClient;
import org.com.models.SingInRequest;
import org.com.models.SingInResponse;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SignInTest {

    @Test
    public void successSingIn() {
        SignInClient client = new SignInClient();
        SingInRequest credential = new SingInRequest("vladkovalyov67", "2Cs5Z2j7");
        SingInResponse response = client.post(credential);
        Assert.assertNotNull(response.getToken());
        System.out.println(response.getToken());
    }
}
