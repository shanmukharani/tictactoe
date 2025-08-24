# TicTacToe (Java Console Version and Gui version)
A simple 2-player TicTacToe game built in Java (console-based).
Two players (X and O) take turns placing marks on a 3×3 grid until one wins or the game ends in a draw.
#### Features
- 3×3 Tic-Tac-Toe grid.
- Two-player turn-based gameplay (X and O)
- Input validation (prevents overwriting moves or going out of bounds)
- Automatic win/draw detection
- Simple console-based UI
#### Project Structure
tictactoe/
 └── src/
     └── main/
         └── java/
             └── com/
                 └── example/
                     └── tictactoe/
                         ├── Board.java   # Handles board logic
                         └── Main.java    # Runs the game loop
###### Board.java → Contains the Board class (game logic: place marks, check winner, print board).
###### Main.java → Contains the Main class (user interaction, game loop).
###### TicTacToeGUI → Contains gui version code
###### launcher.java → lets player use console version or gui version
#### Rules
- Player X always starts.
- Players take turns entering row and column (1–3).
- A move is valid only if the chosen cell is empty.
- First player to align three in a row (row, column, or diagonal) wins.
- If the board fills with no winner → game ends in a draw.
