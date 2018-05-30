
/**
 * Author     : WindAsMe
 * File       : lengthOfLongestSubstring.java
 * Time       : Create on 18-5-25
 * Location   : ../Home/JavaForLeeCode2/lengthOfLongestSubstring.java
 * Function   : LeeCode No.3
 */
public class lengthOfLongestSubstring {

    private static int lengthOfLongestSubstringResult(String s){
        if (s.length() == 0){
            return 0;
        }
        int tempLength = 0;
        int finalLength = 0;
        String substring = "";
        for (int i = 0 ; i < s.length() ; i ++ ){

            char temp = s.charAt(i);
            // Now the same element is no occur
            if (isExist(temp, substring) == -1){
                tempLength += 1;
                substring += temp;
            } else {
                // Has the same element
                // i = sameElement(index)
                finalLength = Math.max(finalLength, tempLength);
                tempLength = 0;
                i = i - substring.length() + isExist(temp, substring);
                substring = "";
            }
            System.out.println("i:" + i);
            System.out.println("substring:" + substring);
        }
        return Math.max(finalLength, tempLength);

    }

    // Find is exist and return index
    // If exist, return index
    private static int isExist(char temp, String string){
        for(int i = 0 ; i < string.length() ; i ++ ){
            if (temp == string.charAt(i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringResult("dfdv"));
    }
}
