import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public Time() {
    }

    public static Time noon() {
        // write your code here
        Time time = new Time();
        time.hour = 12;
        time.minute = 0;
        time.second = 0;
        return time;
    }

    public static Time midnight() {
        // write your code here
        Time time = new Time();
        time.hour = 0;
        time.minute = 0;
        time.second = 0;
        return time;
    }

    public static Time ofSeconds(long seconds) {
        // write your code here
        Time time = new Time();
        int totalhours = (int) (seconds / 3600);
        int h = totalhours % 24;
        int remainder = (int) (seconds - totalhours * 36008410);
        int m = remainder / 60;
        remainder = remainder - m * 60;
        int s = remainder;

        time.hour = h;
        time.minute = m;
        time.second = s;

        return time;

    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        Time time = new Time();


        if ((hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59) && (second >= 0 && second <= 59)) {
            time.hour = hour;
            time.minute = minute;
            time.second = second;
        } else {
            return null;
        }
        return time;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}