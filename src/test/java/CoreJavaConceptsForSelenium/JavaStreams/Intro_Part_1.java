package CoreJavaConceptsForSelenium.JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Intro_Part_1 {

    ArrayList<String> names = new ArrayList<>();
    List<String> list;

    public static void main(String[] args) {
        Intro_Part_1 introPart1 = new Intro_Part_1();
//        introPart1.merge2listUsingSteams();
        introPart1.usingStreamDistinct();
    }

    public void regularWay() {
        names.add("Pranay");
        names.add("Shivam");
        names.add("Pronoy");
        names.add("Bose");
        names.add("Shubham");

        int count = 0;
        for (String str:  names) {
            if (str.toLowerCase().startsWith("p")) {
                System.out.println(str);
                count++;
            }
        }

        System.out.println("Total: " + count);
    }

    public void usingSteams() {
        names.add("Pranay");
        names.add("Shivam");
        names.add("Pronoy");
        names.add("Bose");
        names.add("Shubham");

        // 1st way : filter with condition and Print
        long count = names.stream().filter(str -> str.toLowerCase().startsWith("p")).peek(System.out::println).count();
        System.out.println("Count: " + count);

        //2nd Way : filter with condition and Print
        long count_ = names.stream().filter(str -> {
            boolean isTrue = str.toLowerCase().startsWith("s");
            if (isTrue) System.out.println(str);
            return isTrue;
        }).count();
        System.out.println("New Count: " + count_);

        //3d way
        System.out.println("Condition: Print Names with Length more than 4");
        names.stream().filter(str-> str.length()>4).forEach(s-> System.out.println(s)); //Old way
//        names.stream().filter(str-> str.length()>4).forEach(System.out::println); /// New way

        //Limiting to 1 output after condition is true
        System.out.println("Condition: Print Names with Length more than 4 and Limit to first 2 values");
        names.stream().filter(str-> str.length()>4).limit(2).forEach(System.out::println);
    }

    public void usingStreamMaps() {
        Stream.of("Pranay", "Shivam", "Shubham", "Bose", "Pronoy")
                .map(String::toLowerCase)
                .filter(str -> str.endsWith("y"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println();
        List<String> list = Arrays.asList("Pranay", "Shivam", "Shubham", "Bose", "Pronoy");
        list.stream().filter(s-> s.toLowerCase().endsWith("y")).sorted().map(String::toUpperCase).forEach(System.out::println);
    }

    public void merge2listUsingSteams() {
        list = Arrays.asList("Pranay", "Shivam", "Shubham", "Bose", "Pronoy");
        names.add("Pranay");
        names.add("Shivam");
        names.add("Pronoy");
        names.add("Bose");
        names.add("Shubham");

        Stream<String> newStream = Stream.concat(list.stream(), names.stream());
//        newStream.forEach(System.out::println);
        newStream.sorted().forEach(System.out::println);
        System.out.println();
    }

    public void usingStreamMatchArgs() {
        System.out.println("Example of Steam anyMatch");
        List<String> newList = Stream.concat(list.stream(), names.stream()).toList();
        boolean isAvailable = newList.stream().anyMatch(s -> s.equalsIgnoreCase("Bose"));
        System.out.println(isAvailable);
    }

    public void usingSteamCollect(int... value) {
        List<String> list = Arrays.asList("Pranay", "Shivam", "Shubham", "Bose", "Pronoy");
        List<String> newList = list.stream()
                .filter(s-> s.toLowerCase().endsWith("y"))
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        if (value.length > 1 && list.size()>value.length) {
            Arrays.stream(value).mapToObj(list::get).forEach(System.out::println);
        } else System.out.println(newList.getFirst());
    }

    public void usingStreamDistinct() {
        int[] arr = {1,2,3,4,5,6,3,4,7,8,9,9,0,1,2,0};
        Arrays.stream(arr).distinct().sorted().forEach(System.out::print);
    }
}
