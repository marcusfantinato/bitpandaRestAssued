package freeApi;
        import org.testng.annotations.Test;
        import tests.Body;
        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.equalTo;

public class PutUpdateUser {
    Body bodyRequest = new Body();

    @Test
    public void PutUpdateUser(){
        given().contentType("application/json").body(bodyRequest.updateBody().toJSONString()).
                when().
                post("https://reqres.in/api/users/2").
                then().statusCode(201).
                body("name", equalTo("Tester")).
                body("job", equalTo("Automation Tester"));
    }
}
