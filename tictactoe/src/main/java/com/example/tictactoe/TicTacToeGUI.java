package main.java.com.example.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private Board board = new Board();
    private char currentPlayer = 'X';

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c] = new JButton("");
                buttons[r][c].setFont(new Font("Verdana", Font.BOLD, 60));
                final int row = r, col = c;
                buttons[r][c].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (board.placeMark(row, col, currentPlayer)) {
                            buttons[row][col].setText(String.valueOf(currentPlayer));
                            char winner = board.checkWinner();
                            if (winner != Board.EMPTY) {
                                JOptionPane.showMessageDialog(null, "Player " + winner + " wins!");
                                resetGame();
                                return;
                            } else if (board.isFull()) {
                                JOptionPane.showMessageDialog(null, "It's a draw!");
                                resetGame();
                                return;
                            }
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                    }
                });
                add(buttons[r][c]);
            }
        }
    }

    private void resetGame() {
        board = new Board();
        currentPlayer = 'X';
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TicTacToeGUI().setVisible(true);
        });
    }
}
