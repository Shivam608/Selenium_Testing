package CoreJavaConceptsForSelenium.PART_2.AbstractionInJava;

public class AirIndia extends CentralArlineOrg{

    public static void main(String[] args) {

        /// Below is an implementation of the abstract class with object created immediately
//        CentralArlineOrg ai = new CentralArlineOrg() {
//            @Override
//            public void aeroplaneColor() {
//
//            }
//        };

        AirIndia ai = new AirIndia();
        ai.aeroplaneColor();
        ai.engine();                //inheritance
        ai.safetyRules();           //inheritance
    }
    @Override
    public void aeroplaneColor() {
        System.out.println("Body Color Red and White");
    }
}
