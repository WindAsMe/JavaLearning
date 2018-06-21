/**
 * Author     : WindAsMe
 * File       : poorPigs.java
 * Time       : Create on 18-6-21
 * Location   : ../Home/JavaForLeeCode2/poorPigs.java
 * Function   : LeeCode No.458
 */
public class poorPigs {

    // For one pig can deduce 5 cans
    // For two pigs can deduce 5^2 cans
    // For n pigs can deduce 5^n cans...
    private static int poorPigsResult(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow((minutesToTest / minutesToDie + 1), pigs) < buckets) {
            pigs ++;
        }
        return pigs;
    }


    public static void main(String[] args) {
        System.out.println(poorPigsResult(25, 5, 25));
    }
}
