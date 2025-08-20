package CoreJavaConceptsForSelenium.SomeBasicConcepts;

public class Composition_Aggregation {

    public static void main(String[] args) {

        //Composition
        Car_Composition car = new Car_Composition();
        car.startCar();

        //Aggregation
        Engine_Aggregation engine = new Engine_Aggregation();
        Car_Aggregation car_1 = new Car_Aggregation(engine);
        car_1.startCar();
    }
}

/// Example of Composition
class Engine_Composition {
    public void start() {
        System.out.println("Engine in Composition Starts...");
    }
}

class Car_Composition {

    private Engine_Composition engine;

    public Car_Composition() {
        this.engine = new Engine_Composition();
    }

    public void startCar() {
        engine.start();
        System.out.println("Car in Composition Starts...");
    }
}

/// Example of Aggregation
class Engine_Aggregation {
    public void start() {
        System.out.println("Engine in Aggregation starts...");
    }
}

class Car_Aggregation {

    public Engine_Aggregation engine;

    public Car_Aggregation(Engine_Aggregation engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
        System.out.println("Car in Aggregation Starts...");
    }
}
