import java.util.Arrays;
import java.util.Comparator;

/**
 * Author     : WindAsMe
 * File       : largestNumber.java
 * Time       : Create on 18-6-6
 * Location   : ../Home/JavaForLeeCode2/largestNumber.java
 * Function   : No.179
 */
public class largestNumber {

    private static String largestNumberResult(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strNums[i] = String.valueOf(nums[i]);
        }
        // Overwrite the Arrays.sort function:
        // Comparing the number after concat
        // like 2, 10, compare the 210 and 102
        // 210 > 102, so after sort, 2,10
        Arrays.sort(strNums,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                if((s1+s2).compareTo(s2+s1)>0){
                    return -1;
                }else if((s1+s2).compareTo(s2+s1)<0){
                    return 1;
                }else if((s1+s2).compareTo(s2+s1)==0){
                    return 0;
                }
                return 0;
            }
        });

        StringBuilder res = new StringBuilder();
        for(String i:strNums){
            res.append(i);
        }
        if(res.charAt(0)=='0'){
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,2,3,55,2};
        System.out.println(largestNumberResult(nums));
    }
}
