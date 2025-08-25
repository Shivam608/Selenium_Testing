package com.RestAssured.practice.Serializartion_DeSerialization;

import com.RestAssured.practice.PoJos.Courses_Response.Courses;
import com.RestAssured.practice.PoJos.Courses_Response.DashBoard;
import com.RestAssured.practice.PoJos.Courses_Response.ResponsePayLoad;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

public class Serialization_DeSerialization {

    public static void main(String[] args) {

        /// Serialization - Converted Java Object to Json Object
        RestAssured.baseURI = "";
        RestAssured.given()
                .body(setPayLoad())
                .when().put()
                .then().extract().response().asString();

        /// De-Serialization - converted Json Object to Jva Object
        RestAssured.baseURI= "";
        ResponsePayLoad payLoad = RestAssured.given()
                .body("/body")
                .when().get("uri")
                .then()
                .extract().as(ResponsePayLoad.class);

        System.out.println(payLoad.getDashBoard().getPurchaseAmount());
        System.out.println(payLoad.getCourses().get(1).getPrice());

    }

    public static ResponsePayLoad setPayLoad() {
        DashBoard dashBoard = new DashBoard();
        dashBoard.setPurchaseAmount(910);
        dashBoard.setWebsite("http://www.rsa.com");

        Courses course_1 = new Courses();
        course_1.setTitle("RestAssured");
        course_1.setPrice(200);
        course_1.setCopies(1);

        Courses course_2 = new Courses();
        course_2.setTitle("Selenium");
        course_1.setPrice(100);
        course_1.setCopies(3);

        Courses course_3 = new Courses();
        course_3.setTitle("TestNg");
        course_1.setPrice(50);
        course_1.setCopies(2);

        List<Courses> courses = new ArrayList<>();
        courses.add(course_1);
        courses.add(course_2);
        courses.add(course_3);

        ResponsePayLoad payLoad = new ResponsePayLoad();
        payLoad.setDashBoard(dashBoard);
        payLoad.setCourses(courses);
        return payLoad;
    }
}
