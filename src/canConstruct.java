import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : canConstruct.java
 * Time       : Create on 18-6-13
 * Location   : ../Home/JavaForLeeCode2/canConstruct.java
 * Function   : LeeCode No.383
 */
public class canConstruct {

    private static boolean canConstructResult(String ransomNote, String magazine) {
        if(magazine.contains(ransomNote)) return true;
        else{
            char[] r = ransomNote.toCharArray();
            char[] m = magazine.toCharArray();
            int sum = r.length;
            Arrays.sort(r);
            Arrays.sort(m);
            int j = 0;
            for (char aM : m) {
                if (aM == r[j]) {
                    sum--;
                    j++;
                    if (j == r.length) break;
                } else if (aM - r[j] > 0) {
                    j++;
                    if (j == r.length) break;
                }
            }
            return sum == 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(canConstructResult("qwe","asdadsa"));
    }
}
