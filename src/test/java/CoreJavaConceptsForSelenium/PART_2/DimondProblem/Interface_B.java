package CoreJavaConceptsForSelenium.PART_2.DimondProblem;

public interface Interface_B extends Interface_C{

    default void getData() {
        System.out.println("Interface B getData");
    }
}
