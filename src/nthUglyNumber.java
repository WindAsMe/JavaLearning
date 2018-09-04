/**
 * Author     : WindAsMe
 * File       : nthUglyNumber.java
 * Time       : Create on 18-9-4
 * Location   : ../Home/JavaForLeeCode2/nthUglyNumber.java
 * Function   : LeetCode No.264
 */
public class nthUglyNumber {

    private static int nthUglyNumberResult(int n) {
        int[] ugly = new int[n];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        ugly[0] = 1;
        for(int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2 * ugly[++index2];
            if(factor3 == min)
                factor3 = 3 * ugly[++index3];
            if(factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}
