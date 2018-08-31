/**
 * Author     : WindAsMe
 * File       : countAndSay.java
 * Time       : Create on 18-8-31
 * Location   : ../Home/JavaForLeeCode2/countAndSay.java
 * Function   : LeetCode No.38
 */
public class countAndSay {

    private static String countAndSayResult(int n) {
        StringBuilder res = new StringBuilder("1");
        StringBuilder prev;
        for (int i = 1; i < n; i++) {
            prev = res;
            res = new StringBuilder();
            char cur = prev.charAt(0);
            int count = 1;
            for (int j = 1; j < prev.length(); j++) {
                if (cur == prev.charAt(j))
                    count++;
                else{
                    res.append(count).append(cur);
                    cur = prev.charAt(j);
                    count = 1;
                }
            }
            res.append(count).append(cur);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSayResult(2));
    }
}
