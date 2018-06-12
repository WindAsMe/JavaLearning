/**
 * Author     : WindAsMe
 * File       : addStrings.java
 * Time       : Create on 18-6-12
 * Location   : ../Home/JavaForLeeCode2/addStrings.java
 * Function   : LeeCode No.415
 */
public class addStrings {

    private static String addStringsResult(String num1, String num2) {
        int num1Length = num1.length();
        int num2Length = num2.length();
        if (num1Length == 0 || num2Length == 0) {
            return num1Length == 0 ? num2 : num1;
        } else {
            int mark = 0;
            StringBuilder result = new StringBuilder();
            while (num1Length > 0 && num2Length > 0) {
                int temp1 = num1.charAt(--num1Length) - '0';
                int temp2 = num2.charAt(--num2Length) - '0';
                System.out.println("temp1: " + temp1 + " temp2: " + temp2);
                if (mark + temp1 + temp2 >= 10) {
                    result.append((mark + temp1 + temp2) % 10);
                    mark = 1;
                } else {
                    result.append(mark + temp1 + temp2);
                    mark = 0;
                }

                System.out.println("result" + result);
            }

            if (num1Length == 0) {
                for (int i = num2Length - 1 ; i >= 0 ; i -- ) {
                    if (num2.charAt(i) - '0' + mark >= 10) {
                        result.append((num2.charAt(i) - '0' + mark) % 10);
                        mark = 1;
                    } else {
                        result.append(num2.charAt(i) - '0' + mark);
                        mark = 0;
                    }
                }
            }
            if (num2Length == 0) {
                for (int i = num1Length - 1 ; i >= 0 ; i -- ) {
                    if (num1.charAt(i) - '0' + mark >= 10) {
                        result.append((num1.charAt(i) - '0' + mark) % 10);
                        mark = 1;
                    } else {
                        result.append(num1.charAt(i) - '0' + mark);
                        mark = 0;
                    }
                }
            }
            if (mark == 1) {
                result.append(1);
            }
            return result.reverse().toString();
        }
    }


    public static void main(String[] args) {
        System.out.println(addStringsResult("1", "99"));
    }
}
