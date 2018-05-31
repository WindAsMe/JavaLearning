/**
 * Author     : WindAsMe
 * File       : lengthOfLastWord.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/lengthOfLastWord.java
 * Function   : LeeCode No.58
 */
public class lengthOfLastWord {

    private static int lengthOfLastWordResult(String s) {
        if (s.length() == 0){
            return 0;
        } else {
            int length = s.length();
            int count = 0;
            boolean flag = false;
            for (int i = length - 1 ; i >= 0 ; i -- ){
                if (s.charAt(i) != ' '){
                    flag = true;
                    count += 1;
                } else {
                    if (flag){
                        return count;
                    } else {

                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args){
        System.out.println(lengthOfLastWordResult("Hell    "));
    }
}
