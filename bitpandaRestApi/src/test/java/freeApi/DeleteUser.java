package freeApi;
        import org.testng.annotations.Test;
        import static io.restassured.RestAssured.given;


public class DeleteUser {

    @Test
    public void DeleteUser(){
        given().contentType("application/json").
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204);
    }
}
