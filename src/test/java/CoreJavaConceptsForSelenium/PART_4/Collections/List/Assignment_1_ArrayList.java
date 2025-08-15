package CoreJavaConceptsForSelenium.PART_4.Collections.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Assignment_1_ArrayList {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "mango", "apple"));
        //Print the array list after additions
        System.out.println("Initial ArrayList: " + list);

//        //Remove 2nd Occurrence of Apple
//        int i = 1;
//        int j = 0;
//        for (String e : list) {
//            if (e.equals("apple")) {
//                if (i == 2) {
//                    list.remove(j);
//                    break;
//                } else i++;
//            }
//            j++;
//        }

        System.out.println(list);

        Iterator<String> it = list.iterator();
        int k = 0;
        while (it.hasNext()) {
            if (it.next().equals("apple")) {
                k++;
                if (k == 2) {
                    it.remove();
                    break;
                }
            }
        }

        System.out.println(list);

        //Remove the first occurrence of "apple" from the ArrayList.
//        for (String e : list) {
//            if (e.equals("apple")) {
//                list.remove(e);
//                break;
//            }
//        }
//        //Print the ArrayList after the removal.
//        System.out.println("ArrayList after the removal of 'apple' from 1st occurrence: ");
//        System.out.println(list);

//        //Check if the ArrayList contains the element "orange".
//        //Print a message indicating whether "orange" is found or not.
//        if (list.contains("orange")) System.out.println("Orange is Found in the list at Index: " + list.indexOf("orange"));
//
//        //Print the size of the ArrayList.
//        System.out.println("Size of Array: " + list.size());
//
//        //Use a loop to iterate through the ArrayList and print the index and value of each element.
//        for (String s: list) {
//            System.out.println("Index of " + s + " is " + list.indexOf(s));
//        }

        //Remove all occurrences of apple
//        list.stream().filter(s -> !s.equals("apple")).forEach(System.out::println);



    }
}
