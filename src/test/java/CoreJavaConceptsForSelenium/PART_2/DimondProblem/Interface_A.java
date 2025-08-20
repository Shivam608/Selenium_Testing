package CoreJavaConceptsForSelenium.PART_2.DimondProblem;

public interface Interface_A extends Interface_B, Interface_C{

    default void getData() {
        System.out.println("Interface A getData");
    }
}
