import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        String regex = "(?i)\\bpassword[:]*\\s*\\w*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            System.out.println("No passwords found.");
        }
        matcher.reset();

        while (matcher.find()) {
            String string = matcher.group().replaceFirst("(?i)\\bpassword[:]*\\s*", "");
            System.out.println(string);

        }
    }
}
