import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        for (int i = num1; i <= num2; i++) {
            System.out.print(s.charAt(i));
        }
        
    }
}
