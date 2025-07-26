package CoreJavaBrushUp_1.InterviewQuestions;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String s = sc.nextLine();

        usingStack(s);

    }

    static void usingForLoop(String s) {
        for (int i = s.length()-1; i>=0 ; i--) {
            System.out.print(s.charAt(i));
        }
    }

    static void usingStack(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
