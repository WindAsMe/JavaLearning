/**
 * Author     : WindAsMe
 * File       : plusOne.java
 * Time       : Create on 18-5-30
 * Location   : ../Home/JavaForLeeCode2/plusOne.java
 * Function   : LeeCode No.66
 */
public class plusOne {

    private static int[] plusOneResult(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        } else {
            int length = digits.length;
            digits[length - 1] += 1;

            for (int i = length - 1 ; i > 0 ; i -- ){
                if (digits[i] == 10){
                    digits[i] -= 10;
                    digits[i - 1] += 1;
                }
            }


            if (digits[0] == 10){
                int index = length + 1;
                int[] arr = new int[index];

                for (int i = index - 1 ; i > 1 ; i -- ){
                    arr[i] = digits[i - 1];
                }
                arr[1] = 0;
                arr[0] = 1;
                return arr;
            } else {
                return digits;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {9};

        int[] num = plusOneResult(nums);
        for (int aNum : num) {
            System.out.println(aNum);
        }
    }
}
