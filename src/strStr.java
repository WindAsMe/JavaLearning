/**
 * Author     : WindAsMe
 * File       : strStr.java
 * Time       : Create on 18-5-28
 * Location   : ../Home/JavaForLeeCode2/strStr.java
 * Function   : LeeCode No.28
 */
public class strStr {

    // If needle == "", return 0
    // If needle in haystack is not exist, return -1
    private static int strStrResult(String haystack, String needle) {

        if ("".equals(needle)){
            return 0;
        } else if (haystack.length() == 0 || haystack.length() < needle.length()){
            return -1;
        } else {
            int needleLength = needle.length();
            for (int i = 0 ; i < haystack.length() ; i ++ ){
                if (haystack.charAt(i) == needle.charAt(0)){
                    System.out.println("in circulation: " + i);
                    if (needle.length() == 1){
                        return i;
                    } else {
                        int j;
                        for (j = 1; j < needleLength ; j ++ ){
                            System.out.println("j: " + j);
                             if (i + j > haystack.length() - 1){
                                return  -1;
                            } else if (haystack.charAt(i + j) == needle.charAt(j)){

                            } else {
                                break;
                            }
                        }
                        if (j == needleLength ){
                            return i;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args){
        System.out.println(strStrResult("hello", "ll"));
    }
}
