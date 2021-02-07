package developerHere;

import org.testng.annotations.Test;
import tests.Authentication;
import tests.Env;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetLocation {
    Authentication bearer = new Authentication();
    Env baseUrl = new Env();

    @Test
    public void getValidAddress(){
        given().headers(
               "Authorization",
               "Bearer " +  bearer.getToken()).
               queryParam("q", "Friedrich-Schmidt-Platz 1, 1010 Wien").
               when().get(baseUrl.developerHereUrl()).
               then().statusCode(200).
                        body("items[0].address.countryName", equalTo("Österreich")).
                        body("items[0].address.city", equalTo("Wien")).
                        body("items[0].address.district", equalTo("1. Bezirk-Innere Stadt")).
                        body("items[0].address.street", equalTo("Friedrich-Schmidt-Platz")).
                        body("items[0].address.postalCode", equalTo("1010"));

    }

    @Test
    public void getTouristAttraction(){
        given().headers(
                "Authorization",
                "Bearer " +  bearer.getToken()).
                queryParam("q", "Wiener Riesenrad+Riesenradplatz+1020 Wien+ Österreich").
                when().get(baseUrl.developerHereUrl()).
                then().statusCode(200).
                body("items[0].address.countryName", equalTo("Österreich")).
                body("items[0].address.city", equalTo("Wien")).
                body("items[0].address.district", equalTo("2. Bezirk-Leopoldstadt")).
                body("items[0].address.street", equalTo("Riesenradplatz")).
                body("items[0].address.postalCode", equalTo("1020")).
                body("items[0].categories[0].name", equalTo("Touristenattraktion"));

    }

    @Test
    public void getValidLocationUsingLatitudeLongitude(){
        given().headers(
                "Authorization",
                "Bearer " +  bearer.getToken()).
                queryParam("q", "Riesenradplatz").
                queryParam("at", "48.21778,16.39463").
                when().get(baseUrl.developerHereUrl()).
                then().statusCode(200).
                body("items[0].address.countryName", equalTo("Österreich")).
                body("items[0].address.city", equalTo("Wien")).
                body("items[0].address.district", equalTo("2. Bezirk-Leopoldstadt")).
                body("items[0].address.street", equalTo("Ausstellungsstraße")).
                body("items[0].address.postalCode", equalTo("1020")).
                body("items[0].position.lat", equalTo(48.21778F)).
                body("items[0].position.lng", equalTo(16.39463F)).
                body("items[0].categories[0].name", equalTo("Parkplatz"));

    }

}



