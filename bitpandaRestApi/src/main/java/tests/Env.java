package tests;

        import io.restassured.RestAssured;
        import io.restassured.response.Response;

public class Env {

    public static String freeApiUrl(){
        String freeApiUrl = "https://reqres.in";
        return freeApiUrl;
    }

    public static String developerHereUrl(){
        String developerHereUrl = "https://geocode.search.hereapi.com/v1/geocode";
        return developerHereUrl;
    }

}

