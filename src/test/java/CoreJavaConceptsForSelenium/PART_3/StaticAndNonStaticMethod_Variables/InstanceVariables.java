package CoreJavaConceptsForSelenium.PART_3.StaticAndNonStaticMethod_Variables;

public class InstanceVariables {

    String name;
    String address;
    String city;

    InstanceVariables() {}

    InstanceVariables(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }


    public static void main(String[] args) {
        InstanceVariables insVar = new InstanceVariables();
        InstanceVariables insVar_Par = new InstanceVariables("Pranay", "WhiteField", "Bangalore");

        System.out.println(insVar_Par.name);    //Pranay
        System.out.println(insVar.name);        //null


        //Instance Variables are tagged to Object, and are class level variables
        //If declared static, the above two print statements will give output as Pranay
        //as static variables are not tagged to Object and are called are class variables

        ClassVariables_static classVariablesStatic = new ClassVariables_static();
        classVariablesStatic.getProtectedData();
    }
}
