package CoreJavaConceptsForSelenium.PART_2.ArraysInJava;

public class Arrays {

    public static void main(String[] args) {
        int[][] a = new int[2][3];
        a[0][0] = 2;
        a[0][1] = 4;
        a[0][2] = 5;
        a[1][0] = 3;
        a[1][1] = 4;
        a[1][2] = 7;
        System.out.println(a[1][0]);
        int[][] b = {{2, 4, 5}, {3, 4, 7}, {5, 2, 1}};
        System.out.println(b[2][1]);

        int k = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {                    /// Row
            for (int j = 0; j < b[i].length; j++) {             /// Column
            if (b[i][j] < k)
                k = b[i][j];
            }
        }

        System.out.println("Min Value: " + k);
    }
}
