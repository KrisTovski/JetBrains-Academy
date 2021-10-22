import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] paper = scanner.nextLine().split(" ");
        String[] notes = scanner.nextLine().split(" ");

        HashSet<String> paperSet = new HashSet<>(Arrays.asList(paper));
        HashSet<String> notesSet = new HashSet<>(Arrays.asList(notes));

        if(paperSet.containsAll(notesSet) && paper.length > notes.length)
            System.out.println("You get money");
        else
            System.out.println("You are busted");
    }
}