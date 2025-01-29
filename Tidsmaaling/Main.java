package Tidsmaaling;

import static java.lang.System.currentTimeMillis;

public class Main {

    public static void main(String[] args) {
        Tidsmaaling tid = new Tidsmaaling();

        long tidsBruk = currentTimeMillis();
        tid.tid((long) Math.pow(10,7));
        long tidsBruk2 = currentTimeMillis() - tidsBruk;
        System.out.println(tid.beregnGjnstt(tidsBruk2) + " ms");

        tidsBruk = currentTimeMillis();
        tid.tid((long) Math.pow(10,8));
        tidsBruk2 = currentTimeMillis() - tidsBruk;
        System.out.println(tid.beregnGjnstt(tidsBruk2) + " ms");


        tidsBruk = currentTimeMillis();
        tid.tid((long) Math.pow(10,9));
        tidsBruk2 = currentTimeMillis() - tidsBruk;
        System.out.println(tid.beregnGjnstt(tidsBruk2) + " ms");
    }

}
