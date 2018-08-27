import java.util.HashMap;
import java.util.Map;


/**
 * Author     : WindAsMe
 * File       : isIsomorphic.java
 * Time       : Create on 18-6-4
 * Location   : ../Home/JavaForLeeCode2/isIsomorphic.java
 * Function   : LeeCode No.205
 */
public class isIsomorphic {

    private static boolean isIsomorphicResult(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int[] indexS = new int[s.length()];
        int[] indexT = new int[t.length()];
        for (int i = 0 ; i < s.length() ; i ++ ){
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);

            if (mapS.get(tempS) == null){
                mapS.put(tempS, i);
                indexS[i] = i;
            } else
                indexS[i] = mapS.get(tempS);

            if (mapT.get(tempT) == null){
                mapT.put(tempT, i);
                indexT[i] = i;
            } else
                indexT[i] = mapT.get(tempT);
        }

        for (int i = 0 ; i < t.length() ; i ++ ){
            if (indexS[i] != indexT[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicResult("egga", "addd"));
    }
}

