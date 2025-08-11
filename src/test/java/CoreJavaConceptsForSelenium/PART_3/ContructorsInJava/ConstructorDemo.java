package CoreJavaConceptsForSelenium.PART_3.ContructorsInJava;

public class ConstructorDemo {

    public void getData() {
        System.out.println("Hello World");
    }

    public ConstructorDemo(){
        System.out.println("Inside no Parameterized Constructor");
    }

    public ConstructorDemo(int a, String b){
        System.out.println("Inside Parameterized Constructor");
        System.out.println("Integer Value: " + a);
        System.out.println("String Value: " + b);
    }


}
