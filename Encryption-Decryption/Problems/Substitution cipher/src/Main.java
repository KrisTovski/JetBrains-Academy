import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        String alphabet = scanner.nextLine();
        String cypher = scanner.nextLine();
        String msg1 = scanner.nextLine();
        String msg2 = scanner.nextLine();

        char[] alp = alphabet.toCharArray();
        char[] cyp = cypher.toCharArray();

        for (int i = 0; i < msg1.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (alphabet.charAt(j) == msg1.charAt(i)) {
                    System.out.print(cypher.charAt(j));
                }
            }
        }

        System.out.println();

        for (int i = 0; i < msg2.length(); i++) {
            for (int j = 0; j < cypher.length(); j++) {
                if (cypher.charAt(j) == msg2.charAt(i)) {
                    System.out.print(alphabet.charAt(j));
                }
            }
        }
    }
}