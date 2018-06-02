/**
 * Author     : WindAsMe
 * File       : reverseWords.java
 * Time       : Create on 18-6-2
 * Location   : ../Home/JavaForLeeCode2/reverseWords.java
 * Function   : LeeCode No.151
 */
public class reverseWords {

    private static String reverseWordsResult(String s) {
        if (s.length() == 0){
            return "";
        } else if (s.length() == 1){
            return s;
        } else {
            String str = new StringBuffer(s).reverse().toString();

            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                // System.out.println("i:" + i);
                if (str.charAt(i) == ' ') {
                    temp = temp.reverse();
                    temp.append(" ");
                    result.append(temp);
                    temp = new StringBuilder("");
                } else {
                    temp.append(str.charAt(i));
                }
            }
            temp = temp.reverse();
            result.append(temp);
            if (' ' == (result.toString().charAt(0))){
                return "";
            } else {
                return result.toString();
            }
        }
    }

    public static void main(String[] args){
        String s = reverseWordsResult("    ");

        System.out.println(s.length());
    }
}
