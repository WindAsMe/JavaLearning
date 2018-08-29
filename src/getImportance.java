import java.util.List;

/**
 * Author     : WindAsMe
 * File       : getImportance.java
 * Time       : Create on 18-8-29
 * Location   : ../Home/JavaForLeeCode2/getImportance.java
 * Function   :
 */
public class getImportance {

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    private static int ans = 0;

    private static int getImportanceResult(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                ans += employee.importance;
                for (Integer e : employee.subordinates)
                    getImportanceResult(employees, e);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getImportanceResult(null, 1));
    }
}
