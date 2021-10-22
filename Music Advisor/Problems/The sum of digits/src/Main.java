import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String[] strings = scanner.nextLine().split("");
        int result = 0;

        for (String s : strings) {
            result += Integer.parseInt(s);
        }

        System.out.println(result);
    }
}