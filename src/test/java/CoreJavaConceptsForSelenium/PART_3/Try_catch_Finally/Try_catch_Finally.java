package CoreJavaConceptsForSelenium.PART_3.Try_catch_Finally;

public class Try_catch_Finally {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;
        try{
            int c = 30;
            int d = a/b;
            System.out.println(d);
        } catch (ArithmeticException e) {
            System.exit(0);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Hii");
        }

        ///  Finally block will run no matter what,
        ///  finally block can be skipped with only one way i.e using System.exit(statucCode)
        ///  else we need to click on stop execution

    }
}
