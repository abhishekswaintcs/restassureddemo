import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

public class RestAssuredGetExample {

    public static void main(String args[]){

        RestAssured.baseURI = "https://reqres.in";
        Response response = RestAssured.given().when().get("api/users?page=2").then().extract().response();

        Assert.assertEquals(response.statusCode(),200);

        JSONObject body = new JSONObject(response.getBody().prettyPrint());
        Assert.assertEquals(body.getJSONArray("data").getJSONObject(0).getInt("id"),7);
    }

}
