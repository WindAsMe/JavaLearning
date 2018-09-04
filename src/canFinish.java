/**
 * Author     : WindAsMe
 * File       : canFinish.java
 * Time       : Create on 18-9-4
 * Location   : ../Home/JavaForLeeCode2/canFinish.java
 * Function   : LeetCode No.207
 */
public class canFinish {

    // Foremost is to find the Graph has the circle.
    private static boolean canFinishResult(int numCourses, int[][] prerequisites) {
        // sustain the array
        int[] inDegree = new int[numCourses];
        // add all the input to array
        for (int[] i : prerequisites)
            inDegree[i[1]]++;
        while (true) {
            int index = -1;
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    // Mark this index
                    inDegree[i] = -1;
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int[] prerequisite : prerequisites) {
                    if (prerequisite[0] == index)
                        inDegree[prerequisite[1]]--;
                }
            } else  {
                for (int i : inDegree) {
                    if (i != -1)
                        return false;
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] pre = {{0, 1}, {1, 0}};
        System.out.println(canFinishResult(2, pre));
    }
}
