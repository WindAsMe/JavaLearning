/**
 * Author     : WindAsMe
 * File       : countBattleships.java
 * Time       : Create on 18-9-8
 * Location   : ../Home/JavaForLeeCode2/countBattleships.java
 * Function   : LeetCode No.419
 */
public class countBattleships {

    private static int countBattleshipsResult(char[][] board) {
        int count = 0;
        if (board.length == 0 || board[0].length == 0)
            return 0;
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'X' && i + 1 < row && board[i + 1][j] == 'X') {
                    count++;
                    fill(board, i, j, false);
                } else if (board[i][j] == 'X' && j + 1 < column && board[i][j + 1] == 'X') {
                    count++;
                    fill(board, i, j, true);
                }  else if (board[i][j] == 'X') {
                    count++;
                    board[i][j] = 'X';
                }
            }
        }
        return count;
    }


    private static void fill(char[][] board, int row, int column, boolean right) {
        if (right) {
            for (int j = column; j < board[0].length && board[row][j] == 'X'; j++)
                board[row][j] = '.';
        } else {
            for (int i = row; i < board.length && board[i][column] == 'X'; i++)
                board[i][column] = '.';
        }
    }

    public static void main(String[] args) {
        char[][] c = {
                {'X'}
        };
        System.out.println(countBattleshipsResult(c));
    }
}
