package Utility;

public interface CustomizedReportStatements {
    //Text Color::Green
    public default String textColorGreen(String text) {
        return "<span style = 'color:green'>" + " " + text + " " + "</span>";
    }

    //Text Color::Red
    public default String textColorRed(String text) {
        return "<span style = 'color:red'>" + " " + text + " " + "</span>";
    }

    //Text Color::Orange
    public default String textColorOrange(String text) {
        return "<span style = 'color:orange'>" + " " + text + " " + "</span>";
    }

    //Text Color::Any
    public default String textColor(String color, String text) {
        if (color != null && color.length() >= 3) {
            color = color.toLowerCase();
            return "<span style = 'color:" + color + "'>"+ " " + text + " " +"</span>";
        } else {
            System.out.println("Specified Color not available in Color Library. Going with Default Color");
            return null;
        }
    }

    //Background Color::Red
    public default String backgroundColorRed(String text) {
        return "<span style='color:white; background-color:red; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Orange
    public default String backgroundColorOrange(String text) {
        return "<span style='color:white; background-color:orange; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Green
    public default String backgroundColorGreen(String text) {
        return "<span style='color:white; background-color:green; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Red
    public default String backgroundColorPurple(String text) {
        return "<span style='color:white; background-color:purple; padding:5px;'>" + text + "</span>";
    }

    //Background Color::Any
    public default String backgroundColor(String color, String text) {
        if (color != null && color.length() >= 3) {
            color = color.toLowerCase();
            return "<span style='color:white; background-color:" + color + "; padding:5px;'>" + text + "</span>";
        } else {
            System.out.println("Specified Color not available in Color Library. Going with Default Color");
            return null;
        }
    }
}
