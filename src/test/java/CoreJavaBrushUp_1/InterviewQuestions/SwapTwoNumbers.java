package CoreJavaBrushUp_1.InterviewQuestions;

import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Numbers: "); int a = sc.nextInt();
        System.out.print("Enter Second Numbers: "); int b = sc.nextInt();
        System.out.println("Numbers before Swap, First Number: " + a + ". Second Number: " + b);
        swap(a,b);
    }

    static void swap(int a, int b) {
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("Numbers after Swapping. First: " + a + ", Second: " + b);
    }
}
