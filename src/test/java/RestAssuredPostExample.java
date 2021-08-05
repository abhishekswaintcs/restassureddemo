import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

public class RestAssuredPostExample {

    public static void main(String args[]){


        JSONObject requestJson = new JSONObject();
        requestJson.put("name","Abhishek");
        requestJson.put("job","qa");


        RestAssured.baseURI = "https://reqres.in";
        Response response = RestAssured.given()
                .header("Content-type","application/json")
                .body(requestJson.toString())
                .when().post("/api/users")
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(),201);

        JSONObject responseJson = new JSONObject(response.getBody().prettyPrint());

        // Assert name
        Assert.assertEquals(responseJson.getString("name"),"Abhishek");

        // Assert job
        Assert.assertEquals(responseJson.getString("job"),"dev");



    }

}
