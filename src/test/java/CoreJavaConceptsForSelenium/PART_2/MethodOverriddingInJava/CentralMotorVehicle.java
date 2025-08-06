package CoreJavaConceptsForSelenium.PART_2.MethodOverriddingInJava;

public class CentralMotorVehicle {

    public void EngineDynamics() {
        System.out.println("Parent Class Vehicle Should have Square Engine");
    }

    public final void EngineConfiguration() {
        System.out.println("Parent Class 4 Stroke FI BS6 Engine");
    }

    private void NoOfCylinders() {
        System.out.println("Parent Class Should be a Single Cylinder Engine");
    }

    protected void seatingCapacity() {
        System.out.println("Parent Class Max No Of Persons allowed to sit is 2");
    }

    public static void curbWeight() {
        System.out.println("Parent Class Should be not more than 150Kgs");
    }

}
