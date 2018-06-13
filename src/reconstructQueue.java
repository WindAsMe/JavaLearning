import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : reconstructQueue.java
 * Time       : Create on 18-6-13
 * Location   : ../Home/JavaForLeeCode2/reconstructQueue.java
 * Function   : LeeCode No.406
 */
public class reconstructQueue {

    public int[][] reconstructQueueResul(int[][] people) {
        Arrays.sort(people,new Comparator<Object>(){
            @Override
            public int compare(Object o1,Object o2){
                int[] first = (int[]) o1;
                int[] second = (int[]) o2;
                if(first[0] > second[0]){
                    return -1;
                }else if(first[0] < second[0]){
                    return 1;
                }else {
                    return Integer.compare(first[1], second[1]);
                }

            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] aPeople : people) {
            list.add(aPeople[1], aPeople);
        }
        int[][] res = new int[people.length][2];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
