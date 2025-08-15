package CoreJavaConceptsForSelenium.PART_3.StaticAndNonStaticMethod_Variables;

public class ClassVariables_static {

    String name;
    String address;
    static String city = "Bihar";
    int i=0;
    static int j = 0;
    static {
        //Used to Initialize only static Variables
        System.out.println("Static Block");
    }

    public ClassVariables_static() {
        i++;
        j++;
        System.out.println("Non Static I: " + i);
        System.out.println("Static J: " + j);
    }

    public ClassVariables_static(String name, String address) {
        this.name = name;
        this.address = address;
        i++;
        j++;
        System.out.println("Non Static I: " + i);
        System.out.println("Static J: " + j);
    }


    public static void main(String[] args) {
        System.out.println(city);
        ClassVariables_static obj_1 = new ClassVariables_static();
        ClassVariables_static obj_2 = new ClassVariables_static("Pranay", "Whitefield");
        ClassVariables_static.city = "Bangalore";

        System.out.println(obj_1.name);         //Pranay
        System.out.println(obj_2.name);         //null
        System.out.println(city);               //Bangalore

        ClassVariables_static.city = "Jamshedpur";
        System.out.println(city);

//        Instance Variables that are declared using static keyword are called as Class Variables
//        and these variables can be called directly using className.variable Name
//        This can be assigned multiple times but  variable remains same, and will print the last assigned value


    }

    protected void getProtectedData() {
        System.out.println("Protected Access Modifier Inside ClassVariable_static.java");
    }

}
