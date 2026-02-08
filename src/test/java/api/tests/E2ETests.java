package api.tests;

import api.client.ReqresClient;
import api.model.UpdateUserRequest;
import org.testng.annotations.Test;

public class E2ETests {

    @Test
    public void TC_API_E2E_Login_Get_Update() {

        // Login
        LoginApiTests login = new LoginApiTests();
        login.TC_API_Login_Success();

        // Get User
        ReqresClient
                .authRequest()
                .get("/users/2")
                .then()
                .statusCode(200);

        // Update User
        UpdateUserRequest request = new UpdateUserRequest();
        request.name = "E2E User";
        request.job = "Automation";

        ReqresClient
                .authRequest()
                .body(request)
                .put("/users/2")
                .then()
                .statusCode(200);
    }

}
