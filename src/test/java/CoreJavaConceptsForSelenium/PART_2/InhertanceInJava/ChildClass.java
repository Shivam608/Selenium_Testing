package CoreJavaConceptsForSelenium.PART_2.InhertanceInJava;

public class ChildClass extends ParentClass {
    String skinColor = "Brown";

    public static void main(String[] args) {
        ParentClass cc = new ChildClass();
        cc.sings();
        cc.dance();
        cc.travel();
        cc.skinColor();  //Object reference cc is from Parent class but due to
                            // inheritance its calling childclass method
    }

    @Override
    public void dance() {
        System.out.println("ChildClass Dances");;
    }

    @Override
    public void travel() {
        System.out.println("ChildClass Travelling");
    }

    @Override
    public void skinColor() {
        System.out.println("ChildClass Skin Color " + skinColor);
    }
}
