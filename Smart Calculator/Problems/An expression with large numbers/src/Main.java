import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        //(-a) * b + c - d
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");
        BigInteger[] bigIntegers = new BigInteger[strings.length];

        for (int i = 0; i < strings.length; i++) {
            bigIntegers[i] = new BigInteger(strings[i]);
        }

        BigInteger a = bigIntegers[0];
        BigInteger b = bigIntegers[1];
        BigInteger c = bigIntegers[2];
        BigInteger d = bigIntegers[3];

        BigInteger sum = a.negate().multiply(b).add(c).subtract(d);

        System.out.println(sum);

    }
}