/**
 * Author     : WindAsMe
 * File       : toHex.java
 * Time       : Create on 18-9-6
 * Location   : ../Home/JavaForLeeCode2/toHex.java
 * Function   :
 */
public class toHex {

    private static String toHexResult(int num) {
        StringBuilder hexString = new StringBuilder();
        char hexChar[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c' ,'d', 'e', 'f'};

        while (num >= 0) {
            hexString.insert(0, hexChar[num & 0xF]);
            num = num >> 4;
        }

        return hexString.toString().isEmpty() ? "0" : hexString.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHexResult(13));
    }
}
