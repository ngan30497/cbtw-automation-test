package api.tests;

import api.client.ReqresClient;
import api.model.LoginRequest;
import api.model.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTests {
    @Test
    public void TC_API_Login_Success() {
        LoginRequest request = new LoginRequest();
        request.email = "eve.holt@reqres.in";
        request.password = "pistol";

        Response response = ReqresClient
                .baseRequest()
                .body(request)
                .post("/login");

        response.then().statusCode(200);

        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertNotNull(loginResponse.token);

        ReqresClient.setToken(loginResponse.token);
    }

    @Test
    public void TC_API_Login_MissingPassword() {
        LoginRequest request = new LoginRequest();
        request.email = "eve.holt@reqres.in";

        ReqresClient
                .baseRequest()
                .body(request)
                .post("/login")
                .then()
                .statusCode(400);
    }

    @Test
    public void TC_API_Login_InvalidCredential() {
        LoginRequest request = new LoginRequest();
        request.email = "wrong@email.com";
        request.password = "123";

        ReqresClient
                .baseRequest()
                .body(request)
                .post("/login")
                .then()
                .statusCode(400);
    }
}


