package CoreJavaConceptsForSelenium.InterviewQuestions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter  a Number: ");
        long a = sc.nextLong();
        if (a>= Integer.MAX_VALUE) { throw new InputMismatchException("Input Number Larger than Size of Number"); }

        if(isPrime((int) a)) {
            System.out.println(a + " is a Prime Number");
        } else System.out.println(a + " is Not a Prime Number");
     }

     static boolean isPrime(int num) {
         for (int i = 2; i < Math.sqrt(num); i++) {
             if (num%i == 0) {
                 return false;
             }
         } return true;
     }
}
