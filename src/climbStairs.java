/**
 * Author     : WindAsMe
 * File       : climbStairs.java
 * Time       : Create on 18-5-30
 * Location   : ../Home/JavaForLeeCode2/climbStairs.java
 * Function   : LeeCode No.70
 */
public class climbStairs {

    private static int climbStairsResult(int n) {
        int step = 0;
        if (n == 1){
            step += 1;
            return step;
        } else if (n == 2){
            step += 2;
            return step;
        } else if (n == 3){
            step += 3;
            return step;
        } else if (n == 4){
            step += 5;
            return step;
        } else if (n == 5){
            step += 8;
            return step;
        } else if (n == 6){
            step += 13;
            return step;
        } else if (n == 7){
            step += 21;
            return step;
        } else if (n == 8){
            step += 34;
            return step;
        } else if (n == 9){
            step += 55;
            return step;
        } else if (n == 10){
            step += 89;
            return step;
        } else {
            step += climbStairsResult(n - 1);
            step += climbStairsResult(n - 2);
            return step;
        }
    }

    public static void main(String[] args){
        System.out.println(climbStairsResult(35));
    }
}
