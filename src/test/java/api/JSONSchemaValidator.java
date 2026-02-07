package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONSchemaValidator {

    @Test
    public void Test2(){
        baseURI = "https://reqres.in/api";
        // Debug: In response ra console
        String response = given()
                .get("/users?page=2")
                .then()
                .log().all()  // ← In tất cả response (headers, body, status)
                .extract()
                .asString();

        System.out.println("===== RESPONSE BODY =====");
        System.out.println(response);
        System.out.println("=========================");

        // Sau đó validate schema
        given()
                .get("/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("myschema.json"));
    }
}
