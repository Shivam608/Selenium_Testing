package Utility;

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
        if(color != null && color.length()>=3) {
            color = color.toLowerCase();
            return "<span style = 'color:" +color+ "'>" + text + "</span>";
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
        if(color != null && color.length()>=3) {
            color = color.toLowerCase();
            return "<span style='color:white; background-color:" + color + "; padding:5px;'>" + text + "</span>";
        } else {
            System.out.println("Specified Color not available in Color Library. Going with Default Color");
            return null;
        }
    }
}
