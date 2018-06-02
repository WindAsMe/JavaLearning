/**
 * Author     : WindAsMe
 * File       : numTrees.java
 * Time       : Create on 18-6-2
 * Location   : ../Home/JavaForLeeCode2/numTrees.java
 * Function   : LeeCode No.96
 */
public class numTrees {

    private static int numTreesResult(int n) {
        if(n < 1){
            return 1;
        }
        int sum = 0;
        for(int i=1 ; i <= n ; i ++ ) {
            sum += numTreesResult(i - 1) * numTreesResult( n - i);
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(numTreesResult(19));
    }
}
