/**
 * Author     : WindAsMe
 * File       : firstBadVersion.java
 * Time       : Create on 18-9-5
 * Location   : ../Home/JavaForLeeCode2/firstBadVersion.java
 * Function   : LeetCode No.278
 */
public class firstBadVersion {

    private static int i = 10;

    private static boolean isBadVersion(int version) {
        return version == i;
    }

    private static int firstBadVersionResult(int n) {
        if (isBadVersion(1))
            return 1;
        int l = 1;
        int r = n;
        int mid;
        while (l < r) {
            mid = l / 2 + r / 2;
            if (isBadVersion(mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersionResult(15));
    }

}
