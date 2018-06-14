import java.util.*;

/**
 * Author     : WindAsMe
 * File       : classSort.java
 * Time       : Create on 18-6-14
 * Location   : ../Home/JavaForLeeCode2/classSort.java
 * Function   : Using List to sort
 */
public class classSort {
    private static class Tuple {
        private int a;
        private int b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }


    private static void classSortResult(List<Tuple> list) {
        Collections.sort(list, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                int temp = (o1.a + o1.b) - (o2.a + o2.b);
                if (temp == 0) {
                    return o1.getA() - o2.getA();
                }
                return temp;
            }
        });
        for (Tuple aList : list) System.out.println(aList.a + "  " + aList.b + "  " + (aList.a + aList.b));
    }

    public static void main(String[] args) {
        List<Tuple> list = new ArrayList<>();
        Tuple t1 = new Tuple(1, 5);
        Tuple t2 = new Tuple(0, 2);
        Tuple t3 = new Tuple(4, 9);
        Tuple t4 = new Tuple(2, 2);
        Tuple t5 = new Tuple(10, 7);
        Tuple t6 = new Tuple(0, 3);
        Tuple t7 = new Tuple(5, 5);
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        classSortResult(list);
    }
}
