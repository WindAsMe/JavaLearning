/**
 * Author     : WindAsMe
 * File       : guessNumber.java
 * Time       : Create on 18-6-13
 * Location   : ../Home/JavaForLeeCode2/guessNumber.java
 * Function   : LeeCode No.374
 */
public class guessNumber {

    public int guessNumberResult(int n) {
        int low = 1,high = n;
        while(low <= high) {
            int mid=(high - low) / 2 + low;
            int g = guess(mid);
            // mid is smaller
            if(g == 1)
                low = mid + 1;
            else if(g == -1)
                high = mid - 1;
            else return mid;
        }
        return -1;
    }

    // GUESS is define inner
    private int guess(int i){
        return i;
    }
}
