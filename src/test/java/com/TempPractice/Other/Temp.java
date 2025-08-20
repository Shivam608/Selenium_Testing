package com.TempPractice.Other;

import java.util.Stack;

public class Temp {

    public static void main(String[] args) {

        String str = "Hello World";

        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }

        System.out.println();

//        using stack
        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
