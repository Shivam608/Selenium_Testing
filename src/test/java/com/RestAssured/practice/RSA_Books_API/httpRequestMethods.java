package com.RestAssured.practice.RSA_Books_API;

import io.restassured.RestAssured;

public class httpRequestMethods extends BaseTestBooksApi{

    JsonPayLoad body = new JsonPayLoad();

    //----------------------POST----------------------//

    /**
     * This method add Books into DB
     * @param isbn
     * @param aisle
     * @return Response as String
     */
    @Override
    String restApiPostBooks(String isbn, int aisle) {
        RestAssured.baseURI= baseUri;
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body.postRequestPayLoad(isbn, aisle))
                .when().post(postUri)
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        return Response;
    }

    @Override
    String restApiGetBooksById(String id) {
        RestAssured.baseURI = baseUri;
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("ID", id)
                .when().get(getUri)
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        return Response;
    }

    @Override
    String restApiDeleteBooksById(String id) {
        RestAssured.baseURI = baseUri;
        Response = RestAssured.given()
                .body(body.deleteRequestPayLoad(id))
                .when().post(deleteUri)
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        return Response;
    }

}
