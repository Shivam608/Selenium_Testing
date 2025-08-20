package CoreJavaConceptsForSelenium.PART_4.Collections.Maps;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "India");
        hashMap.put(2, "Australia");
        hashMap.put(3, "Europe");
        hashMap.put(4, "UAE");
        hashMap.put(5, "India");

        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(10));
        System.out.println(hashMap.getOrDefault(6, "America"));
        System.out.println(hashMap);

        //Printing the Key and value Separately
        Set map = hashMap.entrySet();
        Iterator it = map.iterator();

        while (it.hasNext()) {
            Map.Entry mp = (Map.Entry)it.next();
            System.out.print(mp.getKey());
            System.out.println(mp.getValue());
        }

        //Maintaining Type Safety
        Set<Map.Entry<Integer, String>> map_1 = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> it_1 = map_1.iterator();

        while (it_1.hasNext()) {
            Map.Entry<Integer, String> it_map = it_1.next();
            System.out.println("Key: " + it_map.getKey() + "  ||  Value: " + it_map.getValue());
        }

    }
}
