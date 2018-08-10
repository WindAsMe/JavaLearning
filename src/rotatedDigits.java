/**
 * Author     : WindAsMe
 * File       : rotatedDigits.java
 * Time       : Create on 18-8-10
 * Location   : ../Home/JavaForLeeCode2/rotatedDigits.java
 * Function   : LeetCode No.788
 */
public class rotatedDigits {

    private static int rotatedDigitsResult(int N) {
        int count = 0;
        while (N >= 2) {
            if (valid(N))
                count++;
            N--;
        }
        return count;
    }

    // 3 4 7 is directly return false
    // 2 5 6 9 temporary true
    // 0 1 8 didn't change the result
    private static boolean valid(int i) {
        boolean valid = false;
        while(i > 0) {
            if(i % 10 == 2 || i % 10 == 5 || i % 10 == 6 || i % 10 == 9)
                valid = true;
            if(i% 10 == 3 || i% 10 == 4 || i% 10 == 7)
                return false;
            i = i / 10;
        }
        return valid;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigitsResult(24));
    }
}
