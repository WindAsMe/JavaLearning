import java.math.BigInteger;

/**
 * Author     : WindAsMe
 * File       : multiply.java
 * Time       : Create on 18-8-30
 * Location   : ../Home/JavaForLeeCode2/multiply.java
 * Function   : LeetCode No.43
 */
public class multiply {

    private static String multiplyResult(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = tmp + res[i + j + 1];
                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int ele: res) {
            if (sb.length() != 0 || ele != 0)
                sb.append(ele);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiplyResult("123", "45"));
    }
}
