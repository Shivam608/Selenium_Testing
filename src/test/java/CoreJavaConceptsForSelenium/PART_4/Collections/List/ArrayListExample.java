package CoreJavaConceptsForSelenium.PART_4.Collections.List;

import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        java.util.ArrayList<Integer> arrayList_1 = new java.util.ArrayList<>();

        arrayList_1.add(10);
        arrayList_1.add(20);

        arrayList_1.add(2, 40);
        System.out.println(arrayList_1.getFirst());
        System.out.println(arrayList_1.getLast());
        List<Integer> abc= arrayList_1.reversed();
        System.out.println(arrayList_1.size());
        System.out.println(arrayList_1);
        System.out.println(abc);

        System.out.println(arrayList_1.contains(40));
        System.out.println(arrayList_1.isEmpty());
//        // remove all elements using while loop
//
//        int i = 0;
//        while (!arrayList_1.isEmpty()) {
//            arrayList_1.remove(i);
//        }
//        System.out.println(arrayList_1);

    }
}
