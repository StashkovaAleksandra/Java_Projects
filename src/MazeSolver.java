
/**
 * This class will contain the methods used to solve the maze provided in documents input1 and/or input2 and input3.
 *
 * Bugs: none observed.
 *
 * @Aleksandra Stashkova
 */

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class MazeSolver {

    private MazePoint[][] maze;     // Used to store maze representation

    /**
     * Public no-arg constructor
     */
    public MazeSolver() {
        this.maze = null;
    }

    /**
     * Public getter that retrieves private member variables - maze.
     *
     * @return return the member variable - maze.
     */
    public MazePoint[][] getMaze() {
        return this.maze;
    }

    /**
     * Public setter that overrides private member variables - maze.
     *
     * @param maze Maze to be stored.
     */
    public void setMaze(MazePoint[][] maze) {
        this.maze = maze;
    }

    // This constructor will read the maze file and parse the maze to a 2D array of MazePoint objects.
    // The input fileToRead is the filename of the maze user wants to read
    public MazeSolver(String fileToRead) throws IOException {
        File input1 = new File(fileToRead);
        Scanner scanner = new Scanner(input1);

        int var1 = scanner.nextInt();
        int var2 = scanner.nextInt();
        scanner.nextLine();

        this.maze = new MazePoint[var1][var2];

        for (int i = 0; i < var1; i++){
           String[] maze2 = scanner.nextLine().split(" ");
           for (int j = 0; j < var2; j++){
               this.maze[i][j] = new MazePoint(maze2[j]);
           }
        }
        scanner.close();
    }

    /**
     * Public escape from maze to be called by user. It invokes helper methods
     * that either use for-loop implementation or while-loop implementation.
     * 
     * Precondition: this.maze has been loaded and valid (rectangular).
     * 
     * Postcondition: this.maze has been escaped and path has been recorded.
     * 
     * @param mode Whether to use for-loop implementation or while-loop 
     * implementation.
     */
    public void escapeFromMaze(String mode) {
        if (mode.equals("for")) {
            this.escapeFromMazeForLoop();
        } else if (mode.equals("while")) {
            this.escapeFromMazeWhileLoop();
        }
    }
    /**
     * This method creates an escape from the maze using for loop. If the step to the right is empty, it uses method setToPath()
     * to move there, otherwise it uses the same method to go down
     *
     * no parameter given
     * @return  void, no return value
     */

    private void escapeFromMazeForLoop() {
        for (int i = 0, j = 0; i < maze.length - 1 || j < maze[i].length - 1; ){
            if (j < maze[i].length - 1 && maze[i][j + 1].isEmpty()){
                maze[i][j++].setToPath();
                maze[i][j].setToPath();
            }
            else {
                maze[i++][j].setToPath();
                maze[i][j].setToPath();
            }
        }
    }
    /**
     * This method creates an escape from the maze using while loop. If the step to the right is empty, it uses method setToPath()
     *  to move there, otherwise it uses the same method to go down.
     *
     * no parameter given
     * @return void, no return value
     */


    private void escapeFromMazeWhileLoop() {
        int i = 0, j = 0;
        while (i < maze.length - 1 || j < maze[i].length - 1){
            if (j < maze[i].length - 1 && maze[i][j + 1].isEmpty()){
                maze[i][j++].setToPath();
                maze[i][j].setToPath();
            }
            else {
                maze[i++][j].setToPath();
                maze[i][j].setToPath();
            }
        }
    }
    /**
     * The method returns the string representation of this.maze. Each column should be separated by an empty space.
     *
     * no parameter given
     * @return returns the string representation of this.maze
     */

    public String mazeToString() {
        String str = "";
        for (int i = 0; i < this.maze.length; i++){
            for (int j = 0; j < this.maze[i].length; j++){
                str += this.maze[i][j].getSymbol();
                str += " ";
            }
            str += "\n";
        }
        return str;
    }
    /**
     * This method takes in a 2D array of MazePoint objects (other), and compares the argument with the member variable
     * this.maze. The function returns a boolean value of true if the other array matches the this.maze
     * and false otherwise.
     *
     * @param (MazePoint[][] other) (2D array of MazePoint objects (other))
     * @return boolean: true or false
     */

    public boolean mazeMatch(MazePoint[][] other) {
        if (other.length != this.maze.length){
            return false;
        }
        for (int i = 0; i < this.maze.length; i++){
            for (int j = 0; j < this.maze[i].length; j++){
                if (this.maze[i].length != other[i].length){
                    return false;
                }
                else if (!this.maze[i][j].symbolMatch(other[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

}
