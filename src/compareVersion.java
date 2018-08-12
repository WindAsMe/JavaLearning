/**
 * Author     : WindAsMe
 * File       : compareVersion.java
 * Time       : Create on 18-6-4
 * Location   : ../Home/JavaForLeeCode2/compareVersion.java
 * Function   : LeeCode No.165
 */
public class compareVersion {

    private static int compareVersionResult(String version1, String version2) {
        int i = 0;
        while (i < Math.min(version1.length(), version2.length())) {
            char temp1 = version1.charAt(i);
            char temp2 = version2.charAt(i);
            if (temp1 > temp2) {
                return 1;
            } else if (temp1 < temp2) {
                return -1;
            }
            i ++;
        }
        if (version1.length() == version2.length())
            return 0;
        else
            return version1.length() > version2.length() ? 1 : -1;
    }

    public static void main(String[] args){
        System.out.println(compareVersionResult("7.5.2.4", "7.5.3"));
    }
}
