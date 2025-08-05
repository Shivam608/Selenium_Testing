package CoreJavaConceptsForSelenium.PART_2.LoopsInJava;

public class NestedForLoops {
    public static void main(String[] args) {

        int k = 1;

        //Forward Order
        for (int i = 0; i <= 4; i++) {
            System.out.println();
            for (int j = 1; j <= 4-i; j++) {
                System.out.print(" " + k);
                k++;
            }
        }

        System.out.print("\n");

        //Reverse Order
        for (int i = 1; i <= 4; i++) {
            System.out.println();
            for (int j = 1; j <= i ; j++) {
                k = j*3;
                System.out.print(" "+ k);
            }
        }

        //Reverse Order (Multiple of 3)
        int l = 0;
        for (int i = 1; i < 4; i++) {
            System.out.println();
            for (int j = 1; j <= i ; j++) {
                l++;
                k = 3*l;
                System.out.print(" "+ k);
            }
        }
        System.out.println();

        //Printing *
        for (int i = 0; i <= 4; i++) {
//            for (int s = 0; s < i; s++) {
//                System.out.print(" ");
//            }
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }







    }
}
