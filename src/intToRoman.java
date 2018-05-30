import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : intToRoman.java
 * Time       : Create on 18-5-27
 * Location   : ../Home/JavaForLeeCode2/intToRoman.java
 * Function   : LeeCode No.12
 */
public class intToRoman {

    // num is in (1, 3999)
    private static String intToRomanResult(int num){
        // Set to find
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        StringBuilder s = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int flag = 1;
        while (num != 0){
            int temp = num % 10;
            stack.push(temp * flag);
            num /= 10;
            flag *= 10;
        }
        flag /= 10;
        System.out.println("Start:" + flag);
        while (!stack.empty()){

            while (flag != 0){
                int temp = stack.pop();
                while (temp != 0){
                    if (temp / flag == 4){
                        char mark = map.get(flag);
                        s.append(mark);
                        mark = map.get(flag * 5);
                        s.append(mark);
                        temp = 0;
                    } else if (temp / flag == 9){
                        char mark = map.get(flag);
                        s.append(mark);
                        mark = map.get(flag * 10);
                        s.append(mark);
                        temp = 0;
                    } else if (temp / flag >= 5){
                        char mark = map.get(flag * 5);
                        s.append(mark);
                        temp -= 5 * flag;
                    } else {
                        char mark = map.get(flag);
                        s.append(mark);
                        temp -= flag;
                    }
                }
                flag = flag / 10;
            }
        }
        return s.toString();
    }

    public static void main(String[] args){
        System.out.println(intToRomanResult(444));
    }
}
