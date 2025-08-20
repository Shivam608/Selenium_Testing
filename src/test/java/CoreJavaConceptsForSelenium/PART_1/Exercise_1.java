package CoreJavaConceptsForSelenium.PART_1;
public class Exercise_1 {
    public static void main (String[] args) {
        /**
         * Create an Array:
         * Create a new array called numbers to store 5 numerical values of your choice (they can be whole numbers or decimal)
         *
         */

        int[] numericArray = {1,2,3,5,6};

        /**
         * Access and Print:
         * Print the following:
         * The first element of the numbers array.
         * The last element of the numbers array.
         */
        System.out.println("First Element: "+numericArray[0]);
        System.out.println("Last Element: "+numericArray[numericArray.length -1]);

        /**
         * Using a loop, print the elements of the numbers array in reverse order
         */
        StringBuilder s = new StringBuilder();
        for (int i = numericArray.length-1;i>=0 ;i-- ) {
            s.append(numericArray[i]);
        }
        System.out.println("Reverse Order: " + s);

        /**
         * Bonus: Element Count:
         * Calculate the total number of elements within the numbers array.
         */
        System.out.println("Element Count: " + numericArray.length);
    }
}
