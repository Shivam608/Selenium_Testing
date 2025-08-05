package CoreJavaConceptsForSelenium.InterviewQuestions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Odd_Even {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number...");
        long a = sc.nextLong();

        if (a>=Integer.MAX_VALUE){ throw new InputMismatchException("Input Too Large for Integer");}

        if (a%2 == 0) {
            System.out.println(a + "Even Number");
        } else if (a%2 == 1) {
            System.out.println("Odd Number");
        } else {
            System.out.println("Invalid Data");
        }
    }
}
