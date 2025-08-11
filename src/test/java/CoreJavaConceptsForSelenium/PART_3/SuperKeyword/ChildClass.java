package CoreJavaConceptsForSelenium.PART_3.SuperKeyword;

public class ChildClass extends ParentClass{
    String str = "Child";

    void getName() {
        System.out.println(str);
        System.out.println(this.str);
        System.out.println(super.str);
    }

    public static void main(String[] args) {
        ParentClass pc = new ParentClass();
        System.out.println(pc.str);

        ChildClass cc = new ChildClass();
        cc.getName();
    }
}
