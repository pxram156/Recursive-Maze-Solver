import brock.*;

/**
 * Paramjot Sawhney
 * COSC 1p03
 */
public class Maze {

     ASCIIDataFile copier;          // Input file reader
     ASCIIOutputFile out;           // Output file writer
     int length;                    // Number of rows in the maze
     int width;                     // Number of columns in the maze
     char[][] maze;                 // 2D array storing the maze map
     int startX;                    // Start row location
     int startY;                    // Start column location


    public Maze() {
        copier = new ASCIIDataFile();
        out = new ASCIIOutputFile("solution.txt");

        fillMaze();
        setStart();
        out.writeString("Start Point: (" + startX + ", " + startY + ")");
        out.newLine();
        out.newLine();

        solve(startX, startY);   // recursive maze solving

        maze[startX][startY] = 'S'; // ensure S remains visible

        displayMaze();
        out.close();
    }


    /**
     * Recursively attempts to find a path from (r, c)
     * @param r row index being checked
     * @param c column index being checked
     * @return 1 if exit found, 0 otherwise
     */
    public int solve(int r, int c) {
        if (r < 0 || c < 0 || r >= length || c >= width) return 0;
        if (maze[r][c] == '#' || maze[r][c] == '.') return 0;
        if (maze[r][c] == 'E') return 1;
        if (maze[r][c] == ' ' || maze[r][c] == 'S') {

            maze[r][c] = 'V';
            if (solve(r + 1, c) == 1) return 1;

            maze[r][c] = '>';
            if (solve(r, c + 1) == 1) return 1;

            maze[r][c] = '^';
            if (solve(r - 1, c) == 1) return 1;

            maze[r][c] = '<';
            if (solve(r, c - 1) == 1) return 1;

            maze[r][c] = '.';          // mark as dead end
        }
        return 0;
    }


    /**
     * Sets the start S at the first available space in the maze
     */
    public void setStart() {
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < width; c++) {
                if (maze[r][c] == ' ') {
                    startX = r;
                    startY = c;
                    maze[r][c] = 'S';
                    return;
                }
            }
        }
    }


    /**
     * Generates a random row index for startX
     */
    public void randomX() {
        startX = (int)(length * Math.random());
    }


    /**
     * Generates a random column index for startY
     */
    public void randomY() {
        startY = (int)(width * Math.random());
    }


    /**
     * First two ints = dimensions
     * Then loads each character row by row
     */
    public void fillMaze() {
        length = copier.readInt();
        width = copier.readInt();

        maze = new char[length][width];

        copier.readLine(); // move past the dimension line

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = copier.readChar();
            }
            copier.readLine(); // skip newline
            // I tried using .NextLine() but it wasn't working so I assume this does the same?
        }
    }


    /**
     * Outputs the solved maze into solution.txt
     * Writes one row per line
     */
    public void displayMaze() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                out.writeC(maze[i][j]);
            }
            out.newLine();
        }
    }


    public static void main(String[] args) {
        new Maze();
    }
}
