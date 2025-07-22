package Utility;

import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static Utility.BaseTest.baseUri;

public class FrameworkUtilities {

    //Text Color::Green
    public static String textColorGreen(String text) {
        return "<span style = 'color:green'>" + text + "</span>";
    }

    //Text Color::Red
    public static String textColorRed(String text) {
        return "<span style = 'color:red'>" + text + "</span>";
    }

    //Text Color::Orange
    public static String textColorOrange(String text) {
        return "<span style = 'color:orange'>" + text + "</span>";
    }

    //Text Color::Any
    public static String textColor(String color, String text) {
        if (color != null && color.length() >= 3) {
            color = color.toLowerCase();
            return "<span style = 'color:" + color + "'>" + text + "</span>";
        } else {
            System.out.println("Specified Color not available in Color Library. Going with Default Color");
            return null;
        }
    }

    //Background Color::Red
    public static String backgroundColorRed(String text) {
        return "<span style='color:white; background-color:red; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Orange
    public static String backgroundColorOrange(String text) {
        return "<span style='color:white; background-color:orange; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Green
    public static String backgroundColorGreen(String text) {
        return "<span style='color:white; background-color:green; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Red
    public static String backgroundColorPurple(String text) {
        return "<span style='color:white; background-color:purple; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Any
    public static String backgroundColor(String color, String text) {
        if (color != null && color.length() >= 3) {
            color = color.toLowerCase();
            return "<span style='color:white; background-color:" + color + "; padding:5px;'>" + text + "</span>";
        } else {
            System.out.println("Specified Color not available in Color Library. Going with Default Color");
            return null;
        }
    }

    //get Base URI from Config.properties
    public static String getBaseUri() {
        if (baseUri.isEmpty()) {
            try {
                FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\application.properties");
                Properties prop = new Properties();
                prop.load(reader);
                baseUri = prop.getProperty("RestAssured_BaseURI").replace("\"", "");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return baseUri;
        }
        return baseUri;
    }

    //get Any Value from Application.properties
    public static String getValueFromProperties(String key) throws IOException {
        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\application.properties");
        Properties prop = new Properties();
        prop.load(reader);
        String value = prop.getProperty(key);
        Assert.assertNotNull(value, "No Such Key: " + key);
        System.out.println("Key: " + key + ", Value: " + value);
        return (String) value;
    }
}
