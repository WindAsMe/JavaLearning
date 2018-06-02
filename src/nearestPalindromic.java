
/**
 * Author     : WindAsMe
 * File       : nearestPalindromic.java
 * Time       : Create on 18-6-2
 * Location   : ../Home/JavaForLeeCode2/nearestPalindromic.java
 * Function   :
 */
public class nearestPalindromic {

    private static String nearestPalindromicResult(String n) {
        long value = Long.valueOf(n);
        Long smallOne = 0L;
        Long bigOne;

        for (long i = value - 1; i >= 1; i--) {
            if (isPalindromic(String.valueOf(i))) {
                smallOne = i;
                break;
            }
        }

        for (long i = value + 1 ;; i ++ ) {
            if (isPalindromic(String.valueOf(i))){
                bigOne = i;
                break;
            }
        }

        if (smallOne < 0){
            return bigOne.toString();
        } else {
            System.out.println("smallOne: " + smallOne + " bigOne: " + bigOne);
            return (bigOne - value) >= (value - smallOne) ? smallOne.toString() : bigOne.toString();
        }
    }

    private static boolean isPalindromic(String n) {
        return new StringBuilder(n).reverse().toString().equals(n);
    }

    public static void main(String[] args){
        System.out.println(nearestPalindromicResult("2147447412"));
    }
}
