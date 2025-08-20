package CoreJavaConceptsForSelenium.PART_2.MethodOverriddingInJava;

import org.testng.annotations.Test;

public class TvsMotoCorp extends CentralMotorVehicle{

    public static void main(String[] args) {
        TvsMotoCorp tvs = new TvsMotoCorp();
        tvs.EngineConfiguration();
        tvs.curbWeight();
        tvs.seatingCapacity();
        tvs.EngineDynamics();

        System.out.println();

        CentralMotorVehicle cmv = new TvsMotoCorp();
        cmv.EngineConfiguration();
        cmv.curbWeight();
        cmv.seatingCapacity();  // Due to run Time polymorphism printing child class method
        cmv.EngineDynamics();   // Due to run Time polymorphism printing child class method

        CentralMotorVehicle cmvtvs = new CentralMotorVehicle();
        cmvtvs.EngineConfiguration();
        cmvtvs.curbWeight();
        cmvtvs.seatingCapacity();
        cmvtvs.EngineDynamics();

    }

    @Test
    public void testMethod() {
        System.out.println("Test Annotated Method");
    }

    @Override
    public void EngineDynamics() {
        System.out.println("Child Class OverSquare Engine");
    }

    ///Cannot be overridden as method is final in Parent class
//    public void EngineConfiguration() { }

///    @Override  (we cannot use this annotation as private method already exists in parent class and private methods
///    cannot be overridden
    public void NoOfCylinders() {
        System.out.println("Child classSingle Cyl Engine");
    }

    @Override
    public void seatingCapacity() {
        System.out.println("Child class 2 People Seating Capacity");
    }

///    @Override static methods cannot be overridden in java
    public static void curbWeight() {
        System.out.println("Child Class 147Kgs");
    }



}
