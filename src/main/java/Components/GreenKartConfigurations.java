package Components;

import Utility.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class GreenKartConfigurations extends BaseTest {

    private static String convertEnum(Enum e) {
        String s =String.valueOf(e);
        return s;
    }

    public static List<String> listOfVegetables() {
        List<String> list = new ArrayList<>();
        list.add(convertEnum(GreenKartProducts.Beans));
        list.add(convertEnum(GreenKartProducts.Almonds));
        list.add(convertEnum(GreenKartProducts.Strawberry));
        list.add(convertEnum(GreenKartProducts.Walnuts));
        list.add(convertEnum(GreenKartProducts.Mango));
        list.add(convertEnum(GreenKartProducts.Corn));
        list.add(convertEnum(GreenKartProducts.Cashews));
        list.add(convertEnum(GreenKartProducts.Cucumber));
        list.add(convertEnum(GreenKartProducts.Mango));
        list.add(convertEnum(GreenKartProducts.Water_Melon));
        list.add(convertEnum(GreenKartProducts.Beans));
        list.add(convertEnum(GreenKartProducts.Pumpkin));
        list.add(convertEnum(GreenKartProducts.Beetroot));
        list.add(convertEnum(GreenKartProducts.Pears));
        list.add(convertEnum(GreenKartProducts.Onion));
        return list;
    }


}
