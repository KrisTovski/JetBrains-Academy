
package cinema;

import java.lang.reflect.Array;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here

        char[][] cinema = new char[8][8];
        Seat cinemaSeats = new Seat(cinema);
        System.out.println("Cinema:");
        cinemaSeats.show(cinema);
    }
}