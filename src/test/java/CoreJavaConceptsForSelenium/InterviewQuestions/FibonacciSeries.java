package CoreJavaConceptsForSelenium.InterviewQuestions;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Max Number of Digits to be printed: ");
        int num = sc.nextInt();
        // Fibonacci Series: 0 1 1 2 3 5 8 13....
        int a = 0, b = 1, n;

        for (int i = 0; i < num; i++) {
            System.out.print(a + " ");
            n = a+b;
            a = b;
            b = n;
        }
    }
}
