import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int hour1 = scanner.nextInt() * 60 * 60;
        int minutes1 = scanner.nextInt() * 60;
        int seconds1 = scanner.nextInt();

        int hour2 = scanner.nextInt() * 60 * 60;
        int minutes2 = scanner.nextInt() * 60;
        int seconds2 = scanner.nextInt();
        
        int time1 = hour1 + minutes1 + seconds1;
        int time2 = hour2 + minutes2 + seconds2;

        System.out.println(time2 - time1);
    }
}
