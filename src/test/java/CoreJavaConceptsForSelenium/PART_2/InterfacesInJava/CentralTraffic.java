package CoreJavaConceptsForSelenium.PART_2.InterfacesInJava;

public interface CentralTraffic {

    void green();
    void red();
    void yellow();

    private void methodBodyExample_1() {
        System.out.println("Private Access Modifier");
    }

    default void methodBodyExample_2() {
        System.out.println("Default Access Modifier");
    }

    static void methodBodyExample_3() {
        System.out.println("static Method");
    }

}
