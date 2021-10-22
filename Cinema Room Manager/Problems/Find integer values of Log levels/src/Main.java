import java.util.Scanner;
import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().toUpperCase().split(" ");

        int result = 0;

        for (int i = 0; i < input.length; i++) {
            result += Level.parse(input[i]).intValue();
        }

        System.out.println(result);
    }
}