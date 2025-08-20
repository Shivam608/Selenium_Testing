package com.RestAssured.PoJos.Courses_Response;

import java.util.List;

public class ResponsePayLoad {

    private DashBoard dashBoard;
    private List<Courses> courses;

    public DashBoard getDashBoard() {
        return dashBoard;
    }

    public void setDashBoard(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
}
