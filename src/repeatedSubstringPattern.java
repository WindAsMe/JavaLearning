/**
 * Author     : WindAsMe
 * File       : repeatedSubstringPattern.java
 * Time       : Create on 18-6-15
 * Location   : ../Home/JavaForLeeCode2/repeatedSubstringPattern.java
 * Function   :
 */
public class repeatedSubstringPattern {

    private static boolean repeatedSubstringPatternResult(String str) {
        int len = str.length();
        // If has the repeated string
        // Longest is len / 2
        for(int i = 1 ; i <= len / 2 ; i ++ ) {
            if(len % i == 0) {
                String tem = str.substring(0, i);
                StringBuffer sb = new StringBuffer();
                for(int j = 0 ; j < len / i ; j ++ ) {
                    sb = sb.append(tem);
                }
                if(sb.toString().equals(str))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPatternResult("asdasd"));
    }
}
