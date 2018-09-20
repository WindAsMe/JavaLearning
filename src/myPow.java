/**
 * Author     : WindAsMe
 * File       : myPow.java
 * Time       : Create on 18-9-20
 * Location   : ../Home/JavaForLeeCode2/myPow.java
 * Function   : LeetCode No.50
 */
public class myPow {


    private static double myPowResult1(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        int t = n / 2;
        if(n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPowResult1(x, t);
        if(n % 2 == 0)
            return res * res;
        return res * res * x;
    }


    // TL
    private static double myPowResult(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;
        if (n < 0)
            return 1 / myPowResult(x, -n);

        int i = 1;
        double tmp = x;
        while (n > i * 2) {
            tmp *= tmp;
            i *= 2;
        }
        return tmp * myPowResult(x, n - i);
    }

    public static void main(String[] args) {
        System.out.println(myPowResult(14, 5));
    }
}
