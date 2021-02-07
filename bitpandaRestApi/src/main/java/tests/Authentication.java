package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authentication {

    public static String getToken(){
        //baseURI = "https://account.api.here.com";

        Response response = RestAssured.given().auth().
                oauth("AzdTFijr_fXF7oHNKiRnlw","UmKKOvcpZttor-yoHZRBNVlYi2Pndj5ngh7lL0e6lbSz8cicEm23QlqXIiNT2yk5JVX4QUTG-1lkkaxEIUQEWg","","").
                formParam("grant_type", "client_credentials").
                post("https://account.api.here.com/oauth2/token");

        return response.getBody().jsonPath().get("access_token");

    }

}
