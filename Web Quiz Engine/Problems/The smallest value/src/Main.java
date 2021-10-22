import java.util.Scanner;

class Main {

    public static long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        long m = scanner.nextLong();
        int n = 0;

        while (n<m){
            System.out.println(factorialUsingForLoop(n));
        }


    }
}