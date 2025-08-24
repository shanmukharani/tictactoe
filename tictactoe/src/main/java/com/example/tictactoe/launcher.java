
package main.java.com.example.tictactoe;

import java.util.Scanner;

public class launcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Choose mode:");
        System.out.println("1. Console");
        System.out.println("2. GUI");
        System.out.print("Enter choice: ");
        
        int choice = sc.nextInt();
        sc.close();

        if (choice == 1) {
            Main.main(null);  // run console version
        } else if (choice == 2) {
            TicTacToeGUI.main(null); // run GUI version
        } else {
            System.out.println("Invalid choice!");
        }
    }
}
