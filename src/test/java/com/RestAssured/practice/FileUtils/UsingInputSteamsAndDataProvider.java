package com.RestAssured.practice.FileUtils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsingInputSteamsAndDataProvider {

    @Test(dataProvider = "getDataFromFile")
    public void testWithInputStream(String input_1, String input_2, String input_3) {
        System.out.println("Input 1:" + input_1);
        System.out.println("Input 2:" + input_2);
        System.out.println("Input 3:" + input_3);
    }

    @DataProvider
    private Object[][] getDataFromFile() throws IOException {

        List<Object[]> data = new ArrayList<>();

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        try(InputStream stream = new FileInputStream(path + "testData.csv");
        BufferedReader read = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            boolean isHeader = true;
            while ((line = read.readLine()) != null) {

                //Skips Header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] arr = line.split(",");
                String[] arr_ = new String[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    arr_[i] = arr[i].trim();
                }
                data.add(arr_);
            }
        }

        return data.toArray(new Object[data.size()][]);
    }
}
