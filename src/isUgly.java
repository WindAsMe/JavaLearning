/**
 * Author     : WindAsMe
 * File       : isUgly.java
 * Time       : Create on 18-6-8
 * Location   : ../Home/JavaForLeeCode2/isUgly.java
 * Function   : LeeCode 263
 */
public class isUgly {

    private static boolean isUglyResult(int num) {
        if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true;
        } else {
            int div2 = num / 2;
            int div3 = num / 3;
            int div5 = num / 5;
            if (div2 * 2 == num)
                return isUglyResult(div2);
            if (div3 * 3 == num)
                return isUglyResult(div3);
            if (div5 * 5 == num)
                return isUglyResult(div5);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUglyResult(14));
    }
}

