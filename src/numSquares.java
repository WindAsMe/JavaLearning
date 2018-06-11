/**
 * Author     : WindAsMe
 * File       : numSquares.java
 * Time       : Create on 18-6-11
 * Location   : ../Home/JavaForLeeCode2/numSquares.java
 * Function   : LeeCode No.279
 */
public class numSquares {

    private static int numSquaresResult(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int minCount = Integer.MAX_VALUE;
        int count = 0;
        int maxDivisor = n;
        while (maxDivisor != 1) {
            // Calculate all the possibility
            int tempMaxDivisor = maxDivisor;
            if (isDivisor(tempMaxDivisor)) {
                int temp = n;
                while (tempMaxDivisor > 0) {
                    if (isDivisor(tempMaxDivisor)){
                        if (temp - tempMaxDivisor == 0) {
                            System.out.println("equal:" + tempMaxDivisor);
                            count++;
                            break;
                        }
                        if (temp - tempMaxDivisor > 0) {
                            System.out.println("add:" + tempMaxDivisor);
                            temp -= tempMaxDivisor;
                            count ++;
                        }
                        if (temp - tempMaxDivisor < 0) {
                            tempMaxDivisor --;
                        }

                    } else {
                        tempMaxDivisor --;
                    }
                }
                maxDivisor --;
                minCount = Math.min(minCount, count);
                System.out.println("------------------------------------------------");
                count = 0;
            } else {
                maxDivisor --;
            }
        }
        // The biggest is for all one
        minCount = Math.min(minCount, n);
        return minCount;
    }



    private static boolean isDivisor(int maxDivisor) {
        return ((int) Math.sqrt(maxDivisor) * (int)Math.sqrt(maxDivisor)) == maxDivisor;
    }


    public static void main(String[] args) {
        System.out.println(numSquaresResult(43));
    }

}
