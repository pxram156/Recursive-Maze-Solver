import brock.*;
/**
 * Class that recursively solves a maze and counts the steps it takes to reach from point A to point B.
 * Updated ASCII object to only be in constructor and not instanced
 * @author Paramjot Sawhney
 * @course COSC 1P03
 * @assignment #4
 * @version 2.0
 * @since March 22, 2026
 */


public class RecursiveMaze {
    char[][] Maze;

    /**
     * Constructor that runs all methods and prints the maze after its solved
     * also reads the ints in file and assigns to its corresponding value
     */
    public RecursiveMaze() {
        ASCIIDataFile file = new ASCIIDataFile();
        int c = 0;
        file.setDelay(0);
        int rows = file.readInt();
        int cols = file.readInt();
        Maze = new char[rows][cols];
        int startRow = file.readInt();
        int startCol = file.readInt();
        file.close();
        readFile(file);
        solve(startRow, startCol, c);
        System.out.println("Printing the maze");
        System.out.println();
        Print(Maze);
    }

    /**
     * Prints char array in row major traversal
     *
     * @param arr char array to print
     */
    public void Print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * inserts corresponding arrow depending on which direction enum is inserted in the parameter
     * @param row index for where we want to insert in the maze
     * @param col same as row
     * @param d direction enum of which direction we want to insert
     */
    public void insert(int row, int col, Direction d) {
        char left = 0x2190; // ←
        char right = 0x2192; // →
        char up = 0x2191; // ↑
        char down = 0x2193; // ↓

        if (d == Direction.Right) {
            Maze[row][col] = right;
        }
        if (d == Direction.Left) {
            Maze[row][col] = left;
        }

        if (d == Direction.Up) {
            Maze[row][col] = up;
        }
        if (d == Direction.Down) {
            Maze[row][col] = down;
        }
        if (d == Direction.None) {
            Maze[row][col] = '.';
        }
    }

    /**
     * reads the maze and inserts it in a 2d maze array
     * @param file file to read from
     */
    public void readFile(ASCIIDataFile file) {
        for (int i = 0; i < Maze.length; i++) {
            for (int j = 0; j < Maze[i].length; j++) {
                Maze[i][j] = file.readChar();
            }
        }
        file.close();
    }

    /**
     * recyrsive method that points from A to B in maze by updating the respective enum, then inserting and moving to the next direction until b is found
     * if not solved, does not print a solved maze
     * @param r Starting row index
     * @param c Starting col index
     * @param count counts the steps it took to reach from A to B
     */
    public void solve(int r, int c, int count) {
        Direction d;
        if (Maze[r][c] == 'B') {

            System.out.println("B was found with " + count + " steps!");
            Print(Maze);
            System.out.println();
            return;

        }
        if (Maze[r][c] == 'A') {
            solve(r - 1, c, count + 1); //up
            solve(r + 1, c, count + 1); //down
            solve(r, c - 1, count + 1); // left
            solve(r, c + 1, count + 1); //Right
        } else if (Maze[r][c] == ' ') {
            d = Direction.Right;
            insert(r, c, d);
            solve(r, c + 1, count + 1); //Right
            d = Direction.Left;
            insert(r, c, d);
            solve(r, c - 1, count + 1); //Left
            d = Direction.Up;
            insert(r, c, d);
            solve(r - 1, c, count + 1); //up
            d = Direction.Down;
            insert(r, c, d);
            solve(r + 1, c, count + 1); //down
            d = Direction.None;
            insert(r, c, d);
        } else if (Maze[r][c] == '*') {
            return;
        } else {
            return;
        }

    }

    public static void main(String[] args) {
        new RecursiveMaze();
    }
}
