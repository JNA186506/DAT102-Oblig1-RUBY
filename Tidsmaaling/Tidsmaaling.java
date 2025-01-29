package Tidsmaaling;

public class Tidsmaaling {

    public void tid(long n) {
// …fyll ut
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
// …fyll ut
    }
//
//    public long convertTid(long n) {
//        return n / 1000;
//    }

    public int beregnGjnstt(long n) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (int) n;
        }
        return sum / 10;
    }

}
