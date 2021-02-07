package freeApi;
        import org.testng.annotations.Test;
        import static io.restassured.RestAssured.given;
        import tests.Env;



public class DeleteUser {
    Env baseUrl = new Env();
    @Test
    public void DeleteUser(){
        given().contentType("application/json").
                when().
                delete(baseUrl.freeApiUrl()+"/api/users/2").
                then().statusCode(204);
    }
}
