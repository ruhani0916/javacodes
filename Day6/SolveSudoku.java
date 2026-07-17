import java.util.Scanner;

public class SolveSudoku {

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isValid(board, row, col, ch)) {

                            board[row][col] = ch;

                            if (solve(board))
                                return true;

                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == ch)
                return false;

            // Check column
            if (board[i][col] == ch)
                return false;

            // Check 3x3 subgrid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
                return false;
        }

        return true;
    }

    public static void printBoard(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        System.out.println("Enter Sudoku (9 rows, use '.' for empty cells):");

        for (int i = 0; i < 9; i++) {
            String row = sc.next();

            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        solveSudoku(board);

        System.out.println("\nSolved Sudoku:");

        printBoard(board);

        sc.close();
    }
}