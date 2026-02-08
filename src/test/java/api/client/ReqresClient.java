package api.client;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

//Base config api
public class ReqresClient {
    private static final String BASE_URL = "https://reqres.in/api";
    private static final String API_KEY =
            "pro_3425928220287c5c166f9aafc7f214893a281a90647c58d9";

    private static String token;

    static {
        RestAssured.baseURI = BASE_URL;
    }

    // Base request: luôn có x-api-key
    public static RequestSpecification baseRequest() {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", API_KEY);
    }

    // Auth request: x-api-key + Bearer token
    public static RequestSpecification authRequest() {
        return baseRequest()
                .header("Authorization", "Bearer " + token);
    }

    public static void setToken(String accessToken) {
        token = accessToken;
    }

    public static String getToken() {
        return token;
    }
}

