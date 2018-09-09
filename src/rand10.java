/**
 * Author     : WindAsMe
 * File       : rand10.java
 * Time       : Create on 18-8-6
 * Location   : ../Home/JavaForLeeCode2/rand10.java
 * Function   : LeetCode No.470
 */
public class rand10 {
    /**
     }
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
    private static int rand10Result() {
        int a = rand7();
        int b = rand7();
        while(true) {
            if(b <= 4)
                return a;
            else if(a <= 4)
                return b + 3;
            a = rand7();
            b = rand7();
        }
    }

    private static int rand7() {
        return (int) (Math.random() * 7);
    }

    public static void main(String[] args) {
        System.out.println(rand10Result());
    }
}
