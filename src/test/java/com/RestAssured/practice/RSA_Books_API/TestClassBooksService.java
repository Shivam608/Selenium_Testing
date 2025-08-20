package com.RestAssured.practice.RSA_Books_API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassBooksService extends httpRequestMethods {

    @Test(dataProvider = "DataSet")
    public void addBooks(String input1, String input2) {
        String isbn = input1.trim();
        int aisle = Integer.parseInt(input2);

        SeleniumTest = extentReports.createTest("Books API");
        // Add books to Data Base using POST httpRequest
        restApiPostBooks(isbn, aisle);
        System.out.println(Response);
        String id = JsonExtractor("ID");
        System.out.println(id);

        restApiGetBooksById(id);
        System.out.println(Response);

        restApiDeleteBooksById(id);
        System.out.println(Response);

    }

    @DataProvider(name = "DataSet")
    public Object[][] getData() {
        return new Object[][]{{"abc", "2019"}, {"ghi", "2020"}, {"mno", "2021"}};
    }
}
