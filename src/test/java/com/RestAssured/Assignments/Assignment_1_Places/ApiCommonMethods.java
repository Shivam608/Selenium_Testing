package com.RestAssured.Assignments.Assignment_1_Places;

import Utility.BaseTest;
import com.RestAssured.practice.PoJos.Assignment_1_Pojos.RequestSpec.PlaceApi;
import com.RestAssured.practice.PoJos.Assignment_1_Pojos.ResponseSpec.placeApiPostResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

public class ApiCommonMethods extends BaseTest {

    Response Response;

    private static RequestSpecification reqSpecBuilder() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(" ", " ");
        headers.put(" ", " ");
        headers.put(" ", " ");
        headers.put(" ", " ");
        return new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/maps/api/place/")
                .setContentType(ContentType.JSON)
                .addQueryParam("key", "qaclick123")
                .addHeaders(headers)
                .build();
    }

    private static ResponseSpecification respSpecBuilder() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    /// Rest API Post
    protected placeApiPostResponse addPlace(PlaceApi placeApi) {
        return RestAssured.given()
                .spec(reqSpecBuilder())
                .body(placeApi)
                .when().post("add/json")
                .then().spec(respSpecBuilder())
                .extract().as(placeApiPostResponse.class);

    }

    /// Rest API Get
    protected void getPlace(String place_id) {
        Response = RestAssured.given()
                .spec(reqSpecBuilder())
                .queryParam("place_id", place_id)
                .when().get("get/json")
                .then().spec(respSpecBuilder())
                .extract().response();
    }

    public RequestSpecification temp() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("");
        builder.addQueryParam("", "");
        builder.setContentType(ContentType.JSON);
        return builder.build();
    }
}
