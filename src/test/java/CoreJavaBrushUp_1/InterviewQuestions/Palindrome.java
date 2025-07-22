package CoreJavaBrushUp_1.InterviewQuestions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number...");
        long x = sc.nextLong();

        if (x>=Integer.MAX_VALUE){ throw new InputMismatchException("Input Too Large for Integer");}
        int a = (int) x;

        if(isPalindrome(a)) {
            System.out.println(a + " is Palindrome");
        } else System.out.println(a + " is not Palindrome");

    }

    static boolean isPalindrome(int a) {

        int num = a;
        int reversedNum = 0;
        while (a != 0) {
            int x = a%10;
            reversedNum = reversedNum*10+x;
            a = a/10;
        }
        return num == reversedNum;
    }
}
