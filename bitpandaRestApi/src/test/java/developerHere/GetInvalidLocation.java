package developerHere;

import org.testng.annotations.Test;
import tests.Authentication;
import tests.Env;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetInvalidLocation {
    Authentication bearer = new Authentication();
    Env baseUrl = new Env();

    @Test
    public void getMissingParameter(){
        given().headers(
                "Authorization",
                "Bearer " +  bearer.getToken()).
                queryParam("at", "48.21778,16.39463").
                when().get(baseUrl.developerHereUrl()).
                then().statusCode(400).
                body("title", equalTo("Required parameter missing. At least one of 'q' or 'qq' needs to be present"));

    }

    @Test
    public void getIllegalInput(){
        given().headers(
                "Authorization",
                "Bearer " +  bearer.getToken()).
                queryParam("at", "40.7307999,-73.9973085, 123123").
                queryParam("q", "Riesenradplatz").
                when().get(baseUrl.developerHereUrl()).
                then().statusCode(400).
                body("title", equalTo("Illegal input for parameter 'at'"));

    }


}
