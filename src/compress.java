import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : compress.java
 * Time       : Create on 18-6-16
 * Location   : ../Home/JavaForLeeCode2/compress.java
 * Function   : LeeCode No.443
 */
public class compress {

    private static int compressResult(char[] chars) {
        int index = 0;
        if(chars.length < 2)
            return chars.length;
        for(int i = 0; i < chars.length;) {
            int times = 1;
            chars[index++] = chars[i++];
            while (i < chars.length && chars[i] == chars[i - 1]) {
                times++;
                i++;
            }
            if (times > 1) {
                char[] chs = String.valueOf(times).toCharArray();
                for (char ch : chs) chars[index++] = ch;
            }
        }
        System.out.println(Arrays.toString(chars));
        return index;
    }



    public static void main(String[] args) {
        char[] chars = {'a','a','a','b','c','c','c','d'};
        System.out.println(compressResult(chars));
    }
}
