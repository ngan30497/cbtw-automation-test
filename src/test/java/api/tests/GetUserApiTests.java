package api.tests;

import api.client.ReqresClient;
import org.testng.annotations.Test;

public class GetUserApiTests {
    @Test
    public void TC_API_GetUser_Success() {
        ReqresClient
                .authRequest()
                .get("/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void TC_API_GetUser_NotFound() {
        ReqresClient
                .authRequest()
                .get("/users/999")
                .then()
                .statusCode(404);
    }

    @Test
    public void TC_API_GetUser_InvalidId() {
        ReqresClient
                .authRequest()
                .get("/users/abc")
                .then()
                .statusCode(404);
    }
}
