/**
 * Author     : WindAsMe
 * File       : mySqrt.java
 * Time       : Create on 18-5-30
 * Location   : ../Home/JavaForLeeCode2/mySqrt.java
 * Function   : LeeCode No.69
 */
public class mySqrt {

    private static int mySqrtResult(int x) {
        if (x <= 0){
            return 0;
        } else {
            int begin = 1;
            int end = x / 2 + 1;

            // Prevent the overflow of mid * mid
            // Use long
            long mid = (begin + end) / 2;
            while (true){
                System.out.println("mid: " + mid);
                if (mid * mid <= x && (mid + 1) * (mid + 1) > x){
                    break;
                } else {
                    System.out.println("begin: " + begin + "    " + "end: " + end);
                    if (mid * mid > x) {
                        end = (int)mid;
                        mid = (begin + end) / 2;
                    } else {
                        begin = (int)mid;
                        mid = (begin + end) / 2;
                    }
                }

            }
            return (int)mid;
        }
    }

    public static void main(String[] args){
        System.out.println(mySqrtResult(2147395599));
    }
}
