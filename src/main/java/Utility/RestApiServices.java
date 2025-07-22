package Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestApiServices extends BaseTest{

    public static void getBookAPIinRSA() {
        RestAssured.baseURI = "http://216.10.245.166";
        response = RestAssured.given().queryParam("AuthorName", "Pranay")
                .when().get("/Library/GetBook.php");
        if (response.statusCode() == 200) {
            System.out.println(response.prettyPrint());
        }
    }

    public static Response restApiGet(String uri, String... ipAddress){
        baseUri = ipAddress.length>0 ? ipAddress[0] : getBaseUri();
        RestAssured.baseURI = baseUri;
        response = RestAssured
                .given()
                .when()
                .get(uri);

        if (response.statusCode() == 200) {
            return response;
        } else {
            System.err.println("Failed to Perform Get Request. Status Code: " + response.statusCode());
            throw new RuntimeException("API Call Failed");
        }
    }
}
