import java.util.Arrays;
import java.util.Comparator;

/**
 * Author     : WindAsMe
 * File       : findMaxForm.java
 * Time       : Create on 18-6-20
 * Location   : ../Home/JavaForLeeCode2/findMaxForm.java
 * Function   :
 */
public class findMaxForm {

    private static int findMaxFormResult(String[] strs, int m, int n) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int count = 0;
        for (String str : strs) {
            int zeroCount = 0;
            int oneCount = 0;
            for (int j = 0; j < str.length(); j++) {
                if ('0' == str.charAt(j)) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            if (m - zeroCount >= 0 && n - oneCount >= 0) {
                m -= zeroCount;
                n -= oneCount;
                count ++;
            } else if (m - zeroCount < 0 && n - oneCount < 0) {
                return count;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        String[] strs = {"111","1000","1000","1000"};
        System.out.println(findMaxFormResult(strs, 9, 3));
    }
}
