package com.selenium.practice.CoreJava.CoreJavaBrushUp_1;

import java.util.Stack;

public class ReversingAString {
    public static void main(String[] args) {
        String s = "Hello World";
//        ReversingAString.usingDSA(s);
        ReversingAString.usingForLoop(s);
    }

    private static void usingForLoop(String s) {

        for (int i = s.length()-1; i >=0 ; i--) {
            System.out.print(s.charAt(i));
        }
    }

    private static void usingDSA(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
