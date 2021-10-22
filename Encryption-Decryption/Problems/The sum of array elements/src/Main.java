import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }

        System.out.println(Arrays.stream(ints).sum());

    }
}