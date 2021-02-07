package tests;

        import io.restassured.RestAssured;
        import io.restassured.response.Response;

public class Env {

    public static String freeApiUrl(){
        //baseURI = "https://account.api.here.com";
        String freeApiUrl = "https://reqres.in";
        return freeApiUrl;
    }

}

