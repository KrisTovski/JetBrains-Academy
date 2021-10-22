import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MIN_VALUE;

        do {
            int number = scanner.nextInt();
            if (number % 4 == 0 && number > max) {
                max = number;
            }
        } while (scanner.hasNext());
        System.out.println(max);
    }
}