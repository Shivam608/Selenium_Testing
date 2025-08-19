package CoreJavaConceptsForSelenium.PART_2.DimondProblem;

public class Class_A implements Interface_A, Interface_B, Interface_C{
    @Override
    public void getData() {
//        Interface_B.super.getData();
    }

    public static void main(String[] args) {
         Class_A a = new Class_A();
         a.getData();
    }
}
