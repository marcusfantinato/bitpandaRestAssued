
package freeApi;


import org.testng.annotations.Test;
import tests.Env;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetUserInformation {
    Env baseUrl = new Env();
    @Test
    public void GetUserInformation(){
        given().contentType("application/json").
                when().
                get(baseUrl.freeApiUrl()+"/api/users/12").
                then().statusCode(200).
                body("data.email", equalTo("rachel.howell@reqres.in")).
                body("data.first_name", equalTo("Rachel")).
                body("data.last_name", equalTo("Howell"));
    }
}
