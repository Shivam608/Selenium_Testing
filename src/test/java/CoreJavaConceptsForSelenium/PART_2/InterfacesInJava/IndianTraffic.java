package CoreJavaConceptsForSelenium.PART_2.InterfacesInJava;

public class IndianTraffic implements CentralTraffic, ContinentalTraffic{
    public static void main(String[] args) {
        CentralTraffic ct = new IndianTraffic();
        //Example: RunTime Polymorphism (Loose Coupling)
        ct.green();
        ct.red();
        ct.yellow();
        ct.methodBodyExample_2();
        CentralTraffic.methodBodyExample_3();
        //Cannot access methodBodyExample_1() as its private

        ContinentalTraffic cnt = new IndianTraffic();
        cnt.example_1();

        //Example: Compile time Polymorphism (Tight coupling)
        IndianTraffic it = new IndianTraffic();
        it.timer();

    }
    @Override
    public void green() {
        System.out.println("Go");
    }

    @Override
    public void red() {
        System.out.println("Stop");
    }

    @Override
    public void yellow() {
        System.out.println("Go Slow");
    }

    public void timer() {
        System.out.println("Wait until Timer is 0");
    }

    @Override
    public void example_1() {
        System.out.println("example_1 from ContinentalTraffic");
    }
}
