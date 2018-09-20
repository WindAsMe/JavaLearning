/**
 * Author     : WindAsMe
 * File       : myPow.java
 * Time       : Create on 18-9-20
 * Location   : ../Home/JavaForLeeCode2/myPow.java
 * Function   : LeetCode No.50
 */
public class myPow {

    private static double myPowResult(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;
        if (n < 0)
            return 1 / myPowResult(x, -n);

        int i = 1;
        int tmp = (int) x;
        while (n > i * 2) {
            tmp *= tmp;
            i *= 2;
        }
        return tmp * myPowResult(x, n - i);
    }

    public static void main(String[] args) {
        System.out.println(myPowResult(13, 5));
    }
}
