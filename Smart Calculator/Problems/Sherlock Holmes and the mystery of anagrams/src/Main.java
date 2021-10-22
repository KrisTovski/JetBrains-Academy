import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        Map<String, Long> map1 =
                Arrays.stream(word1.toLowerCase().split("")).
                        collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<String, Long> map2 =
                Arrays.stream(word2.toLowerCase().split("")).
                        collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(Objects.equals(map1, map2) ? "yes" : "no");
    }
}