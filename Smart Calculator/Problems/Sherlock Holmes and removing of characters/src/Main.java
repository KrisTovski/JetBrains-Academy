import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<Character> word1 = scanner.nextLine().toLowerCase().chars()
                .mapToObj(e -> (char) e).collect(Collectors.toCollection(ArrayList::new));
        List<Character> word2 = scanner.nextLine().toLowerCase().chars()
                .mapToObj(e -> (char) e).collect(Collectors.toCollection(ArrayList::new));
        Iterator<Character> iter = word1.iterator();
        while (iter.hasNext()) {
            if (word2.remove(iter.next())) {
                iter.remove();
            }
        }
        System.out.println(word1.size() + word2.size());
    }
}