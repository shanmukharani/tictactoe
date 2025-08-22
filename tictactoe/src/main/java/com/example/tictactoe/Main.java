package main.java.com.example.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        char currentPlayer = 'X';
        char winner = Board.EMPTY;

        while (true) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + ", enter row and column (1-3): ");

            int row, col;
            try {
                row = sc.nextInt() - 1;  // convert to 0-based
                col = sc.nextInt() - 1;
            } catch (Exception e) {
                sc.nextLine(); // clear bad input
                System.out.println("Invalid input, try again!");
                continue;
            }

            if (!board.placeMark(row, col, currentPlayer)) {
                System.out.println("Invalid move, try again!");
                continue;
            }

            winner = board.checkWinner();
            if (winner != Board.EMPTY) {
                board.printBoard();
                System.out.println("Player " + winner + " wins!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}
