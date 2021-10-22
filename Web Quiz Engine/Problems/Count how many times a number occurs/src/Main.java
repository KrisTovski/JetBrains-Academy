import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();

        int[] ints = new int[arrayLength];

        int counter = 0;

        for (int i = 0; i < arrayLength; i++) {
            ints[i] = scanner.nextInt();

        }
        int number = scanner.nextInt();

        for (int i = 0; i < arrayLength; i++) {
            if (ints[i] == number) {
                counter++;
            }
        }

        System.out.println(counter);

    }
}