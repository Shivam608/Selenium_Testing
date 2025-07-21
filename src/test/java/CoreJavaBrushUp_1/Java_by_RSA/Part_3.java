package CoreJavaBrushUp_1.Java_by_RSA;

public class Part_3 {
    public static void main(String[] args) {

// TODO Auto-generated method stub


        Part_3 d = new Part_3();

        String name = d.getData();

        System.out.println(name);

        MethodDemo2 d2 = new MethodDemo2();
        d2.getUserData();
        getData2();
    }

    public String getData() {
        System.out.println("hello world");
        return "rahul shetty";
    }

    public static String getData2() {
        System.out.println("hello world");
        return "rahul shetty";
    }
}

class MethodDemo2 {
    public void getUserData() {
        System.out.println("Separate Class: Method Demo 2");
    }
}
