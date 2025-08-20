package com.RestAssured.practice.RSA_Places_API;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

/**  ***** PayLoad
 {
    "dashboard":
        {
        "purchaseAmount": 910,
        "website": "rahulshettyacademy.com"
        },
        "courses":
    [
        {
            "title": "Selenium Python",
            "price": 50,
            "copies": 6
        },
        {
            "title": "Cypress",
            "price": 40,
            "copies": 4
        },
        {
            "title": "RPA",
            "price": 45,
            "copies": 10
        }
    ]
 }
 */

public class MockJsonPayLoad {

    public static final String jsonPayLoad = "{\n" +
            "\n" +
            "\"dashboard\": {\n" +
            "\n" +
            "\"purchaseAmount\": 910,\n" +
            "\n" +
            "\"website\": \"rahulshettyacademy.com\"\n" +
            "\n" +
            "},\n" +
            "\n" +
            "\"courses\": [\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"Selenium Python\",\n" +
            "\n" +
            "\"price\": 50,\n" +
            "\n" +
            "\"copies\": 6\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"Cypress\",\n" +
            "\n" +
            "\"price\": 40,\n" +
            "\n" +
            "\"copies\": 4\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"RPA\",\n" +
            "\n" +
            "\"price\": 45,\n" +
            "\n" +
            "\"copies\": 10\n" +
            "\n" +
            "}\n" +
            "\n" +
            "]\n" +
            "\n" +
            "}";

    public static void main(String[] args) {

        JsonPath js = new JsonPath(jsonPayLoad);
        js.prettyPrint();

        //Print Number of Courses
        int i = js.getInt("courses.size()");
        System.out.println("Courses: " + i);

        //Print purchase Amount
        String purchaseAmt = js.getString("dashboard.purchaseAmount");
        System.out.println("Total Amt: " + purchaseAmt);

        //Print Title of all Course and Store Title of 1st Course
        String titleOf1stCourse = js.getString("courses[0].title");
        int rpaCopies = 0;
        for (int j = 0; j < i; j++) {
            System.out.println("Course " + (j+1));
            String courseTitle = js.getString("courses["+j+"].title");
            System.out.print("Title: " + courseTitle);
            System.out.print(", Price: " + js.getString("courses["+j+"].price"));
            System.out.println(", Copies Sold: " + js.getString("courses["+j+"].copies") +"\n");
            if (courseTitle.toLowerCase().contains("rpa")) {
                rpaCopies = js.getInt("courses["+j+"].copies");
                break;
            }
        }

        System.out.println("Title of 1st Course: " + titleOf1stCourse);
        System.out.println("No of Copies sold for RPA Course: " + rpaCopies);


        //Get Sum of all Course Prices
        int actualPrice = js.getInt("dashboard.purchaseAmount");
        int expectedSum = 0;
        for (int j = 0; j < i; j++) {
            int price = js.getInt("courses["+j+"].price");
            int copies = js.getInt("courses["+j+"].copies");
            expectedSum += price*copies;
        }

        System.out.println("Total Price of All Courses: " + expectedSum);
        Assert.assertEquals(actualPrice, expectedSum, "Failed to Match Total Price");
        System.out.println("Expected Price: " + expectedSum + ", Actual Price: " + actualPrice);
        
//        String rpaCourseTitle = js.getString("courses[2].title");
//        if (rpaCourseTitle.toLowerCase().contains("rpa")) {
//            System.out.println("No. Of Copies Sold for RPA: " + js.getString("courses[2].copies"));
//        }
    }
}
