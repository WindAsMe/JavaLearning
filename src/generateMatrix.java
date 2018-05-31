/**
 * Author     : WindAsMe
 * File       : generateMatrix.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/generateMatrix.java
 * Function   : LeeCode No.59
 */
public class generateMatrix {

    private static int[][] generateMatrixResult(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int sum = n * n;
        int x = 0,y = 0;
        while(num <= sum)
        {
            // Move right
            while(y < n && result[x][y] == 0)
                result[x][y++] = num++;
            // Move down
            x++;
            y--;

            // Move down
            while(x < n && result[x][y] == 0)
                result[x++][y] = num++;
            y--;
            x--;

            // Move left
            while(y >= 0 && result[x][y] == 0)
                result[x][y--] = num++;
            x--;
            y++;

            // Move up
            while(x >= 0 && result[x][y] == 0)
                result[x--][y] = num++;
            y++;
            x++;
            n--;
        }
        return result;

    }

    public static void main(String[] args){
        int num[][] = generateMatrixResult(4);
        for (int i = 0 ; i < num.length ; i ++ ){
            for (int j = 0 ; j < num[0].length ; j ++ ){
                System.out.print(num[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
