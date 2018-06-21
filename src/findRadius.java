import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : findRadius.java
 * Time       : Create on 18-6-21
 * Location   : ../Home/JavaForLeeCode2/findRadius.java
 * Function   :
 */
public class findRadius {

    private static int findRadiusResult(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;
        int temp = 0;
        int j = 0;
        for (int house : houses) {
            // Find the each house point
            // The NEAREST left heater and NEAREST right heater
            while (j < heaters.length && heaters[j] < house)
                j ++;
            if (j == heaters.length)
                temp = house - heaters[j - 1];
            else if (j == 0)
                temp = heaters[j] - house;
            else if (heaters[j] > house)
                temp = Math.min(heaters[j] - house, house - heaters[j - 1]);
            if (temp > result)
                result = temp;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        System.out.println(findRadiusResult(houses, heaters));
    }
}

