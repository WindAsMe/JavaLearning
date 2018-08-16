/**
 * Author     : WindAsMe
 * File       : isOneBitCharacter.java
 * Time       : Create on 18-8-16
 * Location   : ../Home/JavaForLeeCode2/isOneBitCharacter.java
 * Function   : LeetCode No.717
 */
public class isOneBitCharacter {

    private static boolean isOneBitCharacterResult(int[] bits) {
        int len = bits.length - 1;
        int i = 0;
        while (i < len) {
            i += bits[i] + 1;
        }
        return (i == len) && (bits[i] == 0);
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        System.out.println(isOneBitCharacterResult(bits));
    }
}
