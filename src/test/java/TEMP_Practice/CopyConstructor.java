package TEMP_Practice;

public class CopyConstructor {

    public static void main(String[] args) {

        Animal a = new Animal("Tiger");
        System.out.println(a.name);

        Animal b = new Animal(a);
        System.out.println(b.name);
    }

}

class Animal {
    String name = "";

    //Shallow Copy (Copy Constructor)
    Animal(Animal other) {
        this.name = other.name;
    }

    Animal(String name) {
        this.name = name;
    }
}
