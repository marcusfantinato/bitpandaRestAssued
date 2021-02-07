package freeApi;

import org.testng.annotations.Test;
import tests.Body;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostCreateUser {
    Body bodyRequest = new Body();

    @Test
    public void postCreateUser(){
                given().contentType("application/json").body(bodyRequest.createBody().toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201).
                    body("name", equalTo("Tester")).
                    body("job", equalTo("Automation Tester"));

    }
}
