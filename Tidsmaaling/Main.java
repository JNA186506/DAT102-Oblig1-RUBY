package Tidsmaaling;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;

public class Main {

    public static void main(String[] args) {
        Tidsmaaling t = new Tidsmaaling();

        long tidsBruk = 0;
        tidsBruk = nanoTime();

        for (int i = 0; i < 10; i++) {
            t.tid((long) Math.pow(10,7));
        }

        System.out.println("Tidsmåling 1, 10^7 : " + (nanoTime() - tidsBruk)/10 + " nanosekund");

        tidsBruk = nanoTime();

        for (int i = 0; i < 10; i++) {
            t.tid((long) Math.pow(10,8));
        }

        System.out.println("Tidsmåling 2, 10^8 : " + (nanoTime() - tidsBruk)/10 + " nanosekund");

        tidsBruk = nanoTime();

        for (int i = 0; i < 10; i++) {
            t.tid((long) Math.pow(10,9));
        }

        System.out.println("Tidsmåling 3, 10^9 : " + (nanoTime() - tidsBruk)/10 + " nanosekund");

        tidsBruk = nanoTime();

        for (int i = 0; i < 10; i++) {
            t.tid((long) Math.pow(10,10));
        }

        System.out.println("Tidsmåling 4, 10^10: " + (nanoTime() - tidsBruk)/10 + " nanosekund");

    }

}
