package CoreJavaConceptsForSelenium.PART_4.Collections;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Assignment_Collections {

    static final int [] arr = {1,2,2,3,4,4,5,4,6,6,8,8,7,8,9,0,1,3,0,0};

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int j = 0;
        for (Integer i : arr) {
            j++;
            hashMap.put(j, i);
        }


        Set<Map.Entry<Integer, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> map : set) {
            System.out.println("Key: " + map.getKey() + " || Value: " + map.getValue());
        }

        hashMap.clear();
        Assert.assertTrue(hashMap.isEmpty(), "hashMap is Empty");
        for (Integer i : arr) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i,(hashMap.get(i)+1));
            }
        }

        System.out.println(hashMap);

        StringBuilder builder = new StringBuilder();
        Set<Map.Entry<Integer, Integer>> set_new = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> map : set_new) {
            System.out.println("Integer: " + map.getKey() + " || Count: " + map.getValue());
            if (map.getValue() == 1) {
                builder.append(map.getKey()).append(", ");
            }
        }

        System.out.println("Unique Numbers in array: " + builder.deleteCharAt(builder.length()-2));
    }

}
