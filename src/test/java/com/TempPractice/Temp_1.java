package com.TempPractice;

import java.util.Arrays;
import java.util.Stack;

public class Temp_1 {
    static {
        System.out.println("hello World");
    }
    public static void main(String[] args) {

//        String str = "Hello World";
//        String[] atr = {"Hello", "World", "Java"};
//        Stack<Character> stack = new Stack<>();
//
//        for (char c : Arrays.toString(atr).toCharArray()){
//            stack.push(c);
//        }
//        while (!stack.isEmpty()) {
//            System.out.print(stack.pop());
//        }

        Stack<Integer> strInt = new Stack<>();
        int[] arr = {1,2,3,4,5};
//        for (int a : Arrays.toString(arr).toCharArray()) {
        for (int a : arr) {
            strInt.push(a);
        }
        while (!strInt.isEmpty()) {
            System.out.print(strInt.pop()+" ");
        }
        System.out.println();

        System.out.println(Character.getNumericValue(arr[0]));
    }
}
