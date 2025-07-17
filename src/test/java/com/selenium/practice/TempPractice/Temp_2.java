package com.selenium.practice.TempPractice;

public class Temp_2 implements Temp_3{
    public static void main(String args[]) throws Exception {
        int num = 10;
        printString(num);

        Temp_3.sound();
    }

    static void printString(int num) {
        for (int i = 1; i < 10; i++) {
            System.out.println("Masai School");
        }
    }

    @Override
    public void getData() {
        System.out.println("get Data");
    }

}
