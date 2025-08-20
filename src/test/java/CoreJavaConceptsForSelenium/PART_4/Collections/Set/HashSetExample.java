package CoreJavaConceptsForSelenium.PART_4.Collections.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>(Arrays.asList("USA", "UK", "CANADA", "INDIA"));
        System.out.println(hashSet);
        hashSet.remove("CANADA");
        System.out.println(hashSet.isEmpty());
        System.out.println(hashSet.size());
        System.out.println(hashSet);

        for (String e : hashSet) {
            System.out.println(e);
        }

        System.out.println("Using Iterator");
        Iterator<String> it = hashSet.iterator();
        int i = 2;
        int j = 0;
        while (it.hasNext()) {
            it.next(); j++;
            if (j == i){
                System.out.println(it.next());
            }
        }
    }
}
