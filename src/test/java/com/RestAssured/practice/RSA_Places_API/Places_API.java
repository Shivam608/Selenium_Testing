package com.RestAssured.practice.RSA_Places_API;

import Utility.FrameworkConstants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;

public class Places_API {

    public static final String baseUrl = FrameworkConstants.baseUriRSA;
    public static final String get_Uri = "/maps/api/place/get/json";
    public static final String put_Uri = "/maps/api/place/update/json";
    public static final String delete_Uri = "/maps/api/place/delete/json";
    public static final String key = "key";
    public static final String Value = "qaclick123";
    public static String Response = "";
    public static String PlaceID = null;
    static Throwable t = new Throwable();

    public static void main(String[] args) {
        Places_API restPlace = new Places_API();
        /**
         *
         * Given - add all input details
         * when - Hit and submin the api
         * Then - vadate the response
         */
//        endToEndFlow(restPlace);


        String[] str = {"3741eca98df132310ac3766e60866a12", "d166a28e7063063fbaf2c20ec63f1fab", "7dcda7a0bfc8680999f83f01816a3ce9", "13d49cd36dfc68c8c580f47a294e900e"};

        for (String s : str) {
            try {
                restPlace.deletePlaceIds(s, restPlace);
            } catch (Exception e) {
                System.out.println(t.getMessage());
            }

        }


    }

    private void deletePlaceIds(String customPlaceId, Places_API rEstIntro) {


        try {
            rEstIntro.restApiDelete(customPlaceId);
            rEstIntro.restApiGet(customPlaceId);
        } catch (Throwable th) {
            t = th;
        }


    }

    private static void endToEndFlow(Places_API restPlace) {
        //----------------POST CALL----------------------------------//
        ///  Using POST method to add new Data in RSA database
        ///   this is called sending request payload
        restPlace.restApiPost();

        PlaceID = restPlace.jsonExtractor("place_id");
        String status = restPlace.jsonExtractor("status");
        Assert.assertEquals(status, "OK");
        System.out.println("Extracted Place ID: " + PlaceID);

        //----------------GET CALL----------------------------------//
        ///  Using Get method to GET details of Place using Place ID
        ///   this is called getting Response payload
        String oldGetResponse = restPlace.restApiGet();
        System.out.println("GET Response After POST.......: \n" + new JsonPath(Response).prettify());

        //----------------PUT CALL----------------------------------//
        ///  Using PUT method to update details of Place using Place ID
        ///  here I am sending as well as receiving Payload
        restPlace.restApiPut();
        String putResponse = restPlace.jsonExtractor("msg");
        Assert.assertEquals(putResponse, "Address successfully updated", "Failed to Validate Put Response.");
        System.out.println("Put API Response: " + Response);

        //----------------GET CALL----------------------------------//
        String newGetResponse = restPlace.restApiGet();
        Assert.assertNotEquals(newGetResponse, oldGetResponse, "Old and New Response Matching");
        System.out.println("Old Response: " + new JsonPath(oldGetResponse).prettify() + ",\n" + "New Response: " + new JsonPath(newGetResponse).prettify());

        //----------------DELETE CALL----------------------------------//
        ///  Using DELETE method to delete details of Place using Place ID
        ///  here I am sending as well as receiving Payload
        restPlace.restApiDelete();
        System.out.println("Received Response from Delete Request: " + Response);
    }


    /**
     * This Method is used to Add a place
     */
    private String restApiPost() {

        System.out.println("Performing Rest API POST to add new Location Details");
        RestAssured.baseURI = baseUrl;
        Response = RestAssured.given()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"location\": {\n" +
                        "        \"lat\": -153.383494,\n" +
                        "        \"lng\": 23.427362\n" +
                        "    },\n" +
                        "    \"accuracy\": 40,\n" +
                        "    \"name\": \"Frontline house\",\n" +
                        "    \"phone_number\": \"(+91)900921831\",\n" +
                        "    \"address\": \"129, West layout, India 560066\",\n" +
                        "    \"types\": [\n" +
                        "        \"Garden\",\n" +
                        "        \"house\"\n" +
                        "    ],\n" +
                        "    \"website\": \"http://rsa.com\",\n" +
                        "    \"language\": \"EN-US\"\n" +
                        "}")
                .when().post("/maps/api/place/add/json")
                .then().assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();

        return Response;
    }

    /**
     * This Method is used to get the Place Details from Place ID
     * Dependent on Post Method
     * Place_ID shouldn't be null
     */

    private String restApiGet(String... placeId) {

        System.out.print("Performing Rest API GET to get all Place Details");
        String getPlaceId = (placeId.length == 0 || placeId[0].isEmpty()) ? PlaceID : placeId[0];
        System.out.println(" from PlaceID: " + getPlaceId);
        Assert.assertNotNull(getPlaceId, "Place ID is Null");

        RestAssured.baseURI = baseUrl;
        Response = RestAssured.given()
                .queryParam(key, Value)
                .queryParam("place_id", getPlaceId)
                .when().get(get_Uri)
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        return Response;
    }

    private String restApiPut(String... placeId) {

        System.out.print("Performing Rest API PUT to get all Place Details");
        String putPlaceId = (placeId.length == 0 || placeId[0].isEmpty()) ? PlaceID : placeId[0];
        System.out.println(" from PlaceID: " + putPlaceId);
        Assert.assertNotNull(putPlaceId, "Place ID is Null");

        System.out.println("Performing Update Operation");
        RestAssured.baseURI = baseUrl+put_Uri;
        Response = RestAssured.given()
                .queryParam(key, Value)
                .queryParam("place_id", putPlaceId)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + putPlaceId + "\",\n" +
                        "\"address\":\"70 winter walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put()
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        return Response;
    }

    private String restApiDelete(String... placeId) {

        System.out.print("Performing Rest API DELETE to delete a Particular Place Details ");
        String deletePlaceId = (placeId.length == 0 || placeId[0].isEmpty()) ? PlaceID : placeId[0];
        System.out.println(" from PlaceID: " + deletePlaceId);
        Assert.assertNotNull(deletePlaceId, "Place ID is Null");

        System.out.println("Performing Delete Operation");
        RestAssured.baseURI = baseUrl;

        Response = RestAssured.given()
                .queryParam(key, Value)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"place_id\":\"" + deletePlaceId + "\"\n" +
                        "}")
                .when().delete(delete_Uri)
                .then().assertThat().statusCode(200)
                .body("status", equalTo("OK"))
                .extract().response().asString();

        return Response;
    }


    private String jsonExtractor (String path) {
        JsonPath js = new JsonPath(Places_API.Response);
        return js.getString(path);
    }

    public String PostMethodUsingJsonPayLoadFile() throws IOException {

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\jsonPayLoadPlaceAPI.json";
        String postBody = new String(Files.readAllBytes(Paths.get(path)));
        RestAssured.baseURI=baseUrl;
        return RestAssured.given().log().all()
                .queryParam("key", "qaclick123")
                .body(postBody)
                .when().post("/maps/api/place/add/json")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
}
