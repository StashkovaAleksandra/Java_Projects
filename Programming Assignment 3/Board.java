// Title:              2048 Game
// Files:              SP21 PA5 Game - 2048
// Quarter:            CSE 8B Spring 2021
//
// Author:             Aleksandra Stashkova
// Email:              astashko@ucsd.edu
// Instructor's Name:  Professor Allos

public class Board {
    /* Defined to avoid magic number */
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    /* Used to format number in the grid in boardToString methods */
    private static final String NUMBER_FORMAT = "%5d";

    /* Number of tiles showing when the game starts */
    public final int NUM_START_TILES = 2;

    /* The probability (times 100) that a randomly generated tile will be a 2 (vs a 4) */
    public final int TWO_PROBABILITY = 90;

    /* The size of the grid */
    public final int GRID_SIZE;

    /* The grid of tile values, its size being boardSize * boardSize */
    private final int[][] grid;


    /* Direction strings */
    public final String LEFT = "LEFT";
    public final String RIGHT = "RIGHT";
    public final String UP = "UP";
    public final String DOWN = "DOWN";
//
//    /**
//     * Constructor used to load boards for grading/testing
//     *
//     * @param random - the random generator for tile values
//     * @param inputBoard - - the 2d board to assign
//     */
    public Board(int[][] inputBoard) {
        this.GRID_SIZE = inputBoard.length;
        this.grid = new int[this.GRID_SIZE][this.GRID_SIZE];
        for (int r = 0; r < this.GRID_SIZE; r++) {
            for (int c = 0; c < this.GRID_SIZE; c++) {
                this.grid[r][c] = inputBoard[r][c];
            }
        }
    }

    /**
     * Return the current board as a 2D grid String.
     * You should call this method from PA5Tester
     * or whenever you debug your code
     *
     * Use this format to construct board
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * int number = 16;
     * String cell = String.format(NUMBER_FORMAT, number);
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *
     * Then append "cell" to your output string.
     */
    public String boardToString() {
        String str1 = "";
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                String cell = String.format(NUMBER_FORMAT, grid[i][j]);
                str1 += cell;
                str1 += " ";
            }
            str1 += "\n";
        }
        return str1;
    }

    /**
     * Print the current board as a 2D grid.
     * You should call this method from PA5Tester
     * or whenever you debug your code
     *
     *
     * @param direction the tiles will move
     */
    public String boardToString(String direction) {
        int [][] grid2 = this.getGrid();
        this.move(direction);
        String str =  boardToString();
        this.setGrid(grid2);
        return str;
    }


    /**
     * The purpose of this method is to check to see if the movement of
     * the tiles in any direction can actually take place. It does not move the
     * tiles, but at every index of the grid, checks to see if there is a tile
     * above, below, to the left or right that has the same value. If this is
     * the case, then that tile can be moved. It also checks if there is an
     * empty (0) tile at a specified index, as this also indicates that movement
     * can be possible. This method is called within move() so that that method
     * can determine whether or not tiles should be moved.
     *
     * @param direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    public boolean canMove(String direction){
        // utilize helper methods to check if movement in a particular
        // direction is possible

        if (direction.equals(this.UP)) {
            return this.canMoveUp();
        }
        else if (direction.equals(this.RIGHT)) {
            return this.canMoveRight();
        }
        else if (direction.equals(this.DOWN)) {
            return this.canMoveDown();
        }
        else if (direction.equals(this.LEFT)) {
            return this.canMoveLeft();
        }
        else {
            return false;
        }
    }

    /**
     * Rotate 90 degrees clockwise
     *
     */
    private void rotate() {
        int [][] new_arr = new int[4][4];
        int new_i = 0;
        int new_j = 3;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                new_arr[new_i++][new_j] = grid[i][j];
            }
            new_i = 0;
            new_j--;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new_arr[i][j];
            }
        }
    }

    /**
     * Rotate 90 degrees clockwise given the number of times
     *
     * @param number The number of clockwise 90 degree rotations you want to do
     */
    public void rotate(int number) {
        if (number <= 0) return;
        for (int i = 0; i < number % 4; i++) this.rotate();
    }

    /**
     * determines if a move leftwards is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveLeft() {
        for (int i = 0; i < grid.length; i++){
            for (int j = 1; j < grid[i].length; j++){
                if ((grid[i][j] == grid[i][j-1] || grid[i][j-1] == 0) && grid[i][j] != 0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * determines if a move downwards is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveDown() {
        for (int i = 0; i < grid.length - 1; i++){
            for (int j = 0; j < grid[i].length; j++){
                if ((grid[i][j] == grid[i+1][j] || grid[i+1][j] == 0) && grid[i][j] != 0){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * determines if a move rightward is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveRight() {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length - 1; j++){
                if ((grid[i][j] == grid[i][j+1] || grid[i][j+1] == 0) && grid[i][j] != 0){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * determines if a move upwards is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveUp() {
        for (int i = 1; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if ((grid[i][j] == grid[i-1][j] || grid[i-1][j] == 0) && grid[i][j] != 0){
                    return true;
                }
            }
        }
        return false;
    }



    /**
     * The purpose of this method is to move the tiles in the game
     * board by a specified direction passed in as a parameter. If the movement
     * cannot be done, the method returns false. If the movement can be done, it
     * moves the tiles and returns true. This method relies on the help of four
     * other helper methods to perform the game play.
     *
     * @param direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    public boolean move(String direction) {
        /* if canMove is false, exit and don't move tiles */
        if (!this.canMove(direction)) return false;

        /* move in relationship to the direction passed in */
        if (direction.equals(this.UP)) {
            this.moveUp();
        }
        else if (direction.equals(this.RIGHT)) {
            this.moveRight();
        }
        else if (direction.equals(this.DOWN)) {
            this.moveDown();
        }
        else if (direction.equals(this.LEFT)) {
            this.moveLeft();
        }
        else {
            return false;
        }

        return true;
    }

    /**
     * performs a move left
     * Precondition: a left move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveLeft() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                for (int k = j + 1; k < grid[i].length; k++){
                    if (grid[i][j] != 0) {
                        if (grid[i][j] == grid[i][k]) {
                            grid[i][j] += grid[i][k];
                            grid[i][k] = 0;
                            j++;
                        } else if (grid[i][k] != 0) {
                            break;
                        }
                    }
                    else if (grid[i][k] != 0){
                        grid[i][j] = grid[i][k];
                        grid[i][k] = 0;
                    }
                }
            }
        }
    }



    /**
     * performs a move downward
     * Precondition: a downward move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveDown() {
        rotate(1);
        moveLeft();
        rotate(3);
    }

    /**
     * performs a move right
     * Precondition: a right move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveRight() {
        rotate(2);
        moveLeft();
        rotate(2);
    }

    /**
     * performs a move upward
     *
     * Precondition: an upward move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveUp() {
        rotate(3);
        moveLeft();
        rotate(1);
    }

    /**
     * get a deep copy of the grid
     *
     * @return A copy of the grid
     */
    public int[][] getGrid() {
        int[][] gridCopy = new int[this.GRID_SIZE][this.GRID_SIZE];
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < this.grid[r].length; c++) {
                gridCopy[r][c] = this.grid[r][c];
            }
        }
        return gridCopy;
    }

    /**
     * set a deep copy of the grid
     *
     * @param newGrid the grid that you want to set to
     */
    public void setGrid(int[][] newGrid) {
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < this.grid[r].length; c++) {
                this.grid[r][c] = newGrid[r][c];
            }
        }
    }
}
