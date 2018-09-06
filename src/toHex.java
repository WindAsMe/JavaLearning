/**
 * Author     : WindAsMe
 * File       : toHex.java
 * Time       : Create on 18-9-6
 * Location   : ../Home/JavaForLeeCode2/toHex.java
 * Function   : LeetCode No.405
 */
public class toHex {

    private static String toHexResult(int num) {
        if(num == 0)
            return "0";
        char map[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c' ,'d', 'e', 'f'};
        StringBuilder result = new StringBuilder();
        while(num != 0){
            result.insert(0, map[(num & 0xF)]);
            num = (num >>> 4);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHexResult(13));
    }
}
