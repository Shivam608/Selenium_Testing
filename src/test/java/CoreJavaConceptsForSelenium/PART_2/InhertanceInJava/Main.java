package CoreJavaConceptsForSelenium.PART_2.InhertanceInJava;

public class Main {
    public static void main(String[] args) {
        ParentClass pc = new ChildClass();
        ChildClass cc = new ChildClass();
        System.out.println(pc.skinColor);
        System.out.println(cc.skinColor);

//        ChildClass cp = new ParentClass();
//        Above, not possible as ChildClass is extending ParentClass,
//        also we cannot extend ParentClass to ChildClass as Child is already extending Parent,
//        the above will be not allowed as it will give an error of Cyclic Inheritance in Java
    }
}
