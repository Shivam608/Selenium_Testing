package CoreJavaConceptsForSelenium.PART_3.DateAndTimeConcepts;

import Utility.BaseTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SimpleDateTime {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat type1 = new SimpleDateFormat("MMM-dd-yyyy HH:mm");

        System.out.println(date);
        System.out.println(type1.format(date));

        //Using Calendar
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = new GregorianCalendar();
        System.out.println(calendar.getTime());
        System.out.println(calendar1.getTime());
        System.out.println(type1.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.AM_PM));


    }
}
