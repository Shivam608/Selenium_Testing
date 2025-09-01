package Practice_Assignments.Java;

import java.util.Arrays;
import java.util.Stack;

public class ShiftZeroAtEnd {
    public static void main(String[] args) {

        int[] arr = {1,2,0,3,4,0,0,6,0,7,0,8,9,0};
        int[] arr2 = {2,3,0,1,5,0,0,4,0,8,0,7,9,0};
        String str = "programming";

        /// To move zero's at the end of the array
        Arrays.sort(arr);
        int[] arr_ = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            arr_[arr.length-1 - i] = arr[i];
        }

        System.out.println(Arrays.toString(arr_));

        int n = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : arr2) {
            if (i == 0) {
                n++;
            } else stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            stack.push(0);
        }

        System.out.println(stack);

        Stack<Character> stack1 = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!stack1.contains(c)) {
                stack1.push(c);
            }
        }

        System.out.println(stack1);

        StringBuilder b_ = new StringBuilder();
        while (!stack1.isEmpty()) {
            b_.append(stack1.pop());
        }
        b_.reverse();

        String str_ = String.valueOf(b_);
        System.out.println(str_);
    }
}
