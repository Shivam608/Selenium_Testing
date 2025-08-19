package TEMP_Practice;

class Person {
    String name;
    int age;

    // Constructor 1
    Person() {
        this("Unknown", 0); // calls Constructor 2
        System.out.println("Default constructor called");
    }

    // Constructor 2
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor called");
    }
}

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();          // calls default -> parameterized
        Person p2 = new Person("John", 30); // directly calls parameterized


        System.out.println(p1.age);
        System.out.println(p1.name);
    }
}
