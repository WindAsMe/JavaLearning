/**
 * Author     : WindAsMe
 * File       : numSquares.java
 * Time       : Create on 18-6-11
 * Location   : ../Home/JavaForLeeCode2/numSquares.java
 * Function   : LeeCode No.279
 */
public class numSquares {

    // f(n) = min(f(i) + f(n - i))
    private static int numSquaresResult(int n) {
        int[][] sum = new int[2][n + 1];
        sum[0][0] = 0;

        for (int j = 1; j <= n; j++) {
            int temp = n;
            for (int i = 1; i <= j; i++) {
                if (i * i <= j && temp >= 1 + sum[0][j - i * i]) {
                    temp = 1 + sum[0][j - i * i];
                    sum[1][j] = i;
                }

            }
            sum[0][j] = temp;
        }

        for (int i = 0 ; i < 2 ; i ++) {
            for (int j = 0 ; j < n + 1 ; j ++ ) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        return sum[0][n];
    }

    // Work out in math solution
    private static int numSquaresResult2(int n){
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int a = 0 ; a * a <= n ; ++ a ) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n)
                return (a == 0 ? 0 : 1) + (b == 0 ? 0 : 1);
        }
        return 3;
    }

//    Has Something Wrong
//    private static int numSquaresResult(int n) {
//        if (n < 1) {
//            return 0;
//        } else if (n == 1) {
//            return 1;
//        }
//        int minCount = Integer.MAX_VALUE;
//        int count = 0;
//        int maxDivisor = n;
//        while (maxDivisor != 1) {
//            // Calculate all the possibility
//            int tempMaxDivisor = maxDivisor;
//            if (isDivisor(tempMaxDivisor)) {
//                int temp = n;
//                while (tempMaxDivisor > 0) {
//                    if (isDivisor(tempMaxDivisor)){
//                        if (temp - tempMaxDivisor == 0) {
//                            System.out.println("equal:" + tempMaxDivisor);
//                            count++;
//                            break;
//                        }
//                        if (temp - tempMaxDivisor > 0) {
//                            System.out.println("add:" + tempMaxDivisor);
//                            temp -= tempMaxDivisor;
//                            count ++;
//                        }
//                        if (temp - tempMaxDivisor < 0) {
//                            tempMaxDivisor --;
//                        }
//
//                    } else {
//                        tempMaxDivisor --;
//                    }
//                }
//                maxDivisor --;
//                minCount = Math.min(minCount, count);
//                System.out.println("------------------------------------------------");
//                count = 0;
//            } else {
//                maxDivisor --;
//            }
//        }
//        // The biggest is for all one
//        minCount = Math.min(minCount, n);
//        return minCount;
//    }

//    private static boolean isDivisor(int maxDivisor) {
//        return ((int) Math.sqrt(maxDivisor) * (int)Math.sqrt(maxDivisor)) == maxDivisor;
//    }


    public static void main(String[] args) {
        System.out.println(numSquaresResult2(12));
    }

}
