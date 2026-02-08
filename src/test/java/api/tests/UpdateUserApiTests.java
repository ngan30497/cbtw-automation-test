package api.tests;

import api.client.ReqresClient;
import api.model.UpdateUserRequest;
import org.testng.annotations.Test;

public class UpdateUserApiTests {
    @Test
    public void TC_API_UpdateUser_Success() {
        UpdateUserRequest request = new UpdateUserRequest();
        request.name = "Automation Tester";
        request.job = "QA";

        ReqresClient
                .authRequest()
                .body(request)
                .put("/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void TC_API_UpdateUser_InvalidUserId() {
        UpdateUserRequest request = new UpdateUserRequest();
        request.name = "Test";
        request.job = "QA";

        ReqresClient
                .authRequest()
                .body(request)
                .put("/users/999")
                .then()
                .statusCode(404);
    }

    @Test
    public void TC_API_UpdateUser_EmptyBody() {
        ReqresClient
                .authRequest()
                .body("{}")
                .put("/users/2")
                .then()
                .statusCode(400);
    }
}
