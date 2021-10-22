import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int length = scanner.nextInt();
        int[] a = new int[length];

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        int[] newA = new int[a.length];

        System.arraycopy(a, 0, newA, 1, a.length - 1);
        newA[0] = a[a.length - 1];

        for (int e : newA) {
            System.out.print(e + " ");
        }
    }
}