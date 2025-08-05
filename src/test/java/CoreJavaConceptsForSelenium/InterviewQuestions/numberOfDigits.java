package CoreJavaConceptsForSelenium.InterviewQuestions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class numberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number...");
        long a = sc.nextLong();

        if (a>=Integer.MAX_VALUE){ throw new InputMismatchException("Input Too Large for Integer");}

        String s = a + "";
        System.out.println("Number of Digits in the given Number: " + s.length());
    }
}
