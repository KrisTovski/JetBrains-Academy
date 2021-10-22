import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        BigInteger m = scanner.nextBigInteger();
        BigInteger n = new BigInteger("1");
        long factorial = 1;
        for(int i = 1; i <= Long.MAX_VALUE; i++ ){
            n = n.multiply(BigInteger.valueOf(i));
            if(m.compareTo(n) <= 0){
                System.out.println(factorial);
                break;
            }
            factorial++;

        }
    }
}