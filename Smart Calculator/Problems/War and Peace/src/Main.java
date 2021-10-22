import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> map = Arrays
                .stream(scanner.nextLine().toLowerCase().split("\\s+"))
                .collect(groupingBy(Function.identity(), counting()));

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .forEach((s, aLong) -> System.out.println(s + " " + aLong));

    }
}