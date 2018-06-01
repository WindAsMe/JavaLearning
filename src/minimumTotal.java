import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : minimumTotal.java
 * Time       : Create on 18-6-1
 * Location   : ../Home/JavaForLeeCode2/minimumTotal.java
 * Function   : LeeCode No.120
 */
public class minimumTotal {

    private static int minimumTotalResult(List<List<Integer>> triangle) {

        for (int i = 0 ; i < triangle.size() ; i ++ ){
            for (int j = 0 ; j <= i ; j ++ ){
                System.out.print(triangle.get(i).get(j));
            }
            System.out.println();
        }
        if (triangle.size() == 0){
            return 0;
        } else if (triangle.size() == 1){
            return triangle.get(0).get(0);
        } else {
            List<List<Integer>> sum = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            l.add(triangle.get(0).get(0));
            sum.add(l);
            //System.out.println("here:" + sum.size());
            for (int i = 1 ; i < triangle.size() ; i ++ ){
                List<Integer> temp = new ArrayList<>();
                for (int j = 0 ; j <= i ; j ++ ){
                    if (j == 0){
                        temp.add(sum.get(i - 1).get(0) + triangle.get(i).get(0));
                        System.out.println("tip:" + i);
                        System.out.println(triangle.get(i).get(0));
                        System.out.print("l edge:");
                        System.out.println(sum.get(i - 1).get(0) + triangle.get(i).get(0));
                        //System.out.println(sum.get(i - 1).get(0) + triangle.get(i).get(0));
                    } else if (j == triangle.get(i).size() - 1){
                        temp.add(sum.get(i - 1).get(sum.get(i - 1).size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));

                        //System.out.print("r edge:");
                        //System.out.println(sum.get(i - 1).get(sum.get(i - 1).size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));
                        //System.out.println(sum.get(i - 1).get(triangle.get(i - 1).size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1));
                    } else {
                        temp.add(Math.min(sum.get(i - 1).get(j), sum.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
                    }
                }
                System.out.print("Temp:");
                for (Integer aTemp : temp) {
                    System.out.print(aTemp + " ");
                }
                System.out.println();
                list.addAll(temp);
                temp.clear();
                sum.add(list);

            }

            System.out.println("-----------------------------");
            System.out.println("sum:" + sum.size() + "  " + sum.get(0).size());
            for (int i = 0 ; i < sum.size() ; i ++ ){
                for (int j = 0 ; j <= i ; j ++ ){
                    System.out.print(sum.get(i).get(j));
                }
                System.out.println();
            }


            Integer small =  sum.get(sum.size() - 1).get(0);
            for (int i = 0 ; i < sum.get(sum.size() - 1).size() ; i ++ ){
                small = small >  sum.get(sum.size() - 1).get(i) ? sum.get(sum.size() - 1).get(i) : small;
            }
            return small;
        }
    }

    public static void main(String[] args){
        List<List<Integer>>triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);


        System.out.println(" small :" + minimumTotalResult(triangle));

    }
}
