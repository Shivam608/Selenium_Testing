package com.RestAssured.practice.RSA_Books_API;

public class JsonPayLoad {

    public String postRequestPayLoad(String isbn, int aisle, String... str) {

        String bookName = null;
        String authorName = null;

        if (str.length==1) {
            bookName = str[0];
        } else if (str.length==2) {
            bookName = str[0];
            authorName = str[1];
        } else if (str.length>=3) {
            System.out.println("Invalid set of Data provided for str. Length of str should not be more than 2");
        } else {
            bookName = "Learn abc with youtube";
            authorName = "Google";
        }

        return "{\n" +
                "\"name\":\""+bookName+"\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\""+authorName+"\"\n" +
                "}";
    }

    public String deleteRequestPayLoad(String id) {
        return "{\n" +
                "\"ID\" : \""+ id +"\"\n" +
                "} \n";
    }
}
