/**
 * Author     : WindAsMe
 * File       : isPowerOfTwo.java
 * Time       : Create on 18-6-7
 * Location   : ../Home/JavaForLeeCode2/isPowerOfTwo.java
 * Function   : LeeCode No.231
 */
public class isPowerOfTwo {

    private static boolean isPowerOfTwoResult(int n) {
        if (n % 2 == 1 && n != 1 || n <= 0 ) {
            return false;
        } else {
            while (n > 2) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwoResult(0));
    }
}
