package com.RestAssured.practice.RSA_Books_API;

import io.restassured.path.json.JsonPath;

public abstract class BaseTestBooksApi extends Utility.BaseTest {

    public static final String baseUri = "http://216.10.245.166";
    public static final String postUri = "/Library/Addbook.php";
    public static final String getUri = "/Library/GetBook.php";
    public static final String deleteUri = "/Library/DeleteBook.php";
    public static String Response;

    abstract String restApiPostBooks(String isbn, int aisle);
    abstract String restApiGetBooksById(String id);
    abstract String restApiDeleteBooksById(String id);

    protected <T> T JsonExtractor(String path) {
        JsonPath js = new JsonPath(Response);
        return js.get(path);
    }

}