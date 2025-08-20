package com.RestAssured.practice.RSA_Places_API;

import java.io.IOException;

public class Temp {

    public static void main(String[] args) throws IOException {

        Places_API placesApi = new Places_API();
        String resp = placesApi.PostMethodUsingJsonPayLoadFile();
        System.out.println(resp);
        
    }
}
