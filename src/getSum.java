/**
 * Author     : WindAsMe
 * File       : getSum.java
 * Time       : Create on 18-6-12
 * Location   : ../Home/JavaForLeeCode2/getSum.java
 * Function   : LeeCode No.371
 */
public class getSum {

//    public int getSumResult(int a, int b) {
//        return a + b;
//    }
    private static int getSumResult(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        return getSumResult(sum, carry);
    }

    public static void main(String[] args) {
        System.out.println(getSumResult(1,5));
    }
}
