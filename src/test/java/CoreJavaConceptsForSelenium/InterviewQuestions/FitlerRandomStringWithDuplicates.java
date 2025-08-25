package CoreJavaConceptsForSelenium.InterviewQuestions;

import java.util.*;

public class FitlerRandomStringWithDuplicates {

    public static void main(String[] args) {

        String str = "aaccccddddiiiizzzzzyyyyhhh";
        char[] c = str.toCharArray();

        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        StringBuilder b = new StringBuilder();
        for (char c_ : c) {
            b.append(c_);
        }

        System.out.println(b);

        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char c__ : c) {
            if (!linkedHashMap.containsKey(c__)) {
                linkedHashMap.put(c__ , 1);
            } else {
                linkedHashMap.put(c__ , linkedHashMap.get(c__)+1);
            }
        }

        System.out.println(linkedHashMap);

        StringBuilder b_ = new StringBuilder();
        Set<Map.Entry<Character, Integer>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> map = iterator.next();
            b_.append(map.getKey()).append(" ");
        }

        System.out.println(b_);
    }
}
