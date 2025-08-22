package main.java.com.example.tictactoe;
public class Board {
    private char[][] grid;             // 3x3 grid
    public static final char EMPTY = ' ';

    public Board() {
        grid = new char[3][3];
        // fill with empty spaces
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = EMPTY;
            }
        }
    }

    // Try placing mark, return true if successful
    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) return false;
        if (grid[row][col] != EMPTY) return false;
        grid[row][col] = mark;
        return true;
    }

    // Check for a winner
    public char checkWinner() {
        // rows
        for (int r = 0; r < 3; r++) {
            if (grid[r][0] != EMPTY &&
                grid[r][0] == grid[r][1] &&
                grid[r][1] == grid[r][2]) {
                return grid[r][0];
            }
        }
        // columns
        for (int c = 0; c < 3; c++) {
            if (grid[0][c] != EMPTY &&
                grid[0][c] == grid[1][c] &&
                grid[1][c] == grid[2][c]) {
                return grid[0][c];
            }
        }
        // diagonals
        if (grid[0][0] != EMPTY &&
            grid[0][0] == grid[1][1] &&
            grid[1][1] == grid[2][2]) {
            return grid[0][0];
        }
        if (grid[0][2] != EMPTY &&
            grid[0][2] == grid[1][1] &&
            grid[1][1] == grid[2][0]) {
            return grid[0][2];
        }
        return EMPTY; // no winner yet
    }

    // Check if the board is full
    public boolean isFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[r][c] == EMPTY) return false;
            }
        }
        return true;
    }

    // Print the board to console
    public void printBoard() {
        System.out.println("  1 2 3");
        for (int r = 0; r < 3; r++) {
            System.out.print((r + 1) + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(grid[r][c] == EMPTY ? '-' : grid[r][c]);
                if (c < 2) System.out.print("|");
            }
            System.out.println();
            if (r < 2) System.out.println("  -+-+-");
        }
    }
}
