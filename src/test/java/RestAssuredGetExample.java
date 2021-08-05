import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

public class RestAssuredGetExample {

    public static void main(String args[]){

        RestAssured.baseURI = "https://reqres.in";

        for(int i=1;i<=5;i++) {
            Response response = RestAssured.given().when().pathParam("pageId", i)

                    .get("api/users/{pageId}").then().extract().response();

            Assert.assertEquals(response.statusCode(), 200);

            JSONObject body = new JSONObject(response.getBody().prettyPrint());
            Assert.assertEquals(body.getJSONObject("data").getInt("id"), i);
        }
    }

}
