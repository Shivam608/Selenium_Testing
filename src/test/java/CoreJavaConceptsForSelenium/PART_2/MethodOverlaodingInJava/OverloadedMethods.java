package CoreJavaConceptsForSelenium.PART_2.MethodOverlaodingInJava;

public class OverloadedMethods {

    public static void main(String[] args) {
        OverloadedMethods overloadedMethods = new OverloadedMethods();
        overloadedMethods.getData();
        overloadedMethods.getData(1);
        overloadedMethods.getData(1, "1");
        overloadedMethods.getData("1", 1);
    }

    public void getData() {
        System.out.println("No parameters");
    }

    public void getData(int a){
        System.out.println("1 Parameter: " + a);
    }

    public void getData(int a, String b){
        System.out.println("2 Parameter, Order is 1st: Integer and 2nd: String: " + a + " " + b);
    }

    public void getData(String b, int a){
        System.out.println("2 Parameter, Order is 1st: String and 2nd: Integer: " + a + " " + b);
    }

}
