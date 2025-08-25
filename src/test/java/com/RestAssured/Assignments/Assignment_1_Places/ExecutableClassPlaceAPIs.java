package com.RestAssured.Assignments.Assignment_1_Places;

import com.RestAssured.practice.PoJos.Assignment_1_Pojos.RequestSpec.PlaceApi;
import com.RestAssured.practice.PoJos.Assignment_1_Pojos.RequestSpec.location;
import com.RestAssured.practice.PoJos.Assignment_1_Pojos.ResponseSpec.placeApiPostResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExecutableClassPlaceAPIs extends ApiCommonMethods{

    @Test
    public void validatePlaceApiCalls() {

        SeleniumTest = extentReports.createTest("Validating RestAPi Calls");

        SeleniumTest.info("Add Place");
        placeApiPostResponse response1 = addPlace(setPlaceValues());
        System.out.println(response1.getPlace_id());
        System.out.println(response1.getId());
        System.out.println(response1.getReference());
        System.out.println(response1.getScope());
        System.out.println(response1.getStatus());

        getPlace(response1.getPlace_id());
        Response.prettyPrint();


    }

     PlaceApi setPlaceValues() {
        PlaceApi placeApi = new PlaceApi();
        location lc = new location();
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");

        lc.setLat(-38.383494);
        lc.setLng(33.427362);

        placeApi.setLocation(lc);
        placeApi.setAccuracy(50);
        placeApi.setName("Frontline house");
        placeApi.setPhone_number("(+91) 983 893 3937");
        placeApi.setAddress("29, side layout, cohen 09");
        placeApi.setTypes(types);
        placeApi.setWebsite("http://google.com");
        placeApi.setLanguage("French-IN");

        return placeApi;
    }
}
