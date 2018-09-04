/**
 * Author     : WindAsMe
 * File       : reverseBits.java
 * Time       : Create on 18-9-4
 * Location   : ../Home/JavaForLeeCode2/reverseBits.java
 * Function   : LeetCode No.190
 */
public class reverseBits {

    // you need treat n as an unsigned value
    private static int reverseBitsResult(int n) {
        int res = 0;
        int bit;
        for(int i = 0; i < 32; i++){
            bit = n & (1 << i);
            if(bit != 0)
                res = res + (1 << (31 - i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBitsResult(43261596));
    }
}
