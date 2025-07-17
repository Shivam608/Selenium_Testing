package com.selenium.practice.TempPractice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Temp_5 {
    public static void main(String[] args) {
        String xyz = LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM uuuu")).replace(" ", "_");
        System.out.println(System.getProperty("user.dir") + "/Reports/SeleniumTestReports_" + xyz + ".html");
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH mm ss")).replace(" ", "_");
        System.out.println(time);
    }
}
