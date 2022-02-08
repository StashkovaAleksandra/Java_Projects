///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA4.java
// File:               MazePoint.java
// Quarter:            CSE 8B Spring 2021
//
// Authors:            Yundong Wang, Christine Alvarado, Prajwal Anand
//
//  DO NOT MODIFY ANY METHODS IN THIS FILE
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Defines objects that represent each individual point in a Maze.
 * This file is to be used only in PA4 of CSE8B in Spring 2021.
 * You won't necessarily use all methods in this class for PA4.
 *
 * Do not modify any methods in this class.
 *
 * Bugs: None known
 *
 */
public class MazePoint {

    private String symbol;  // Internal representation of a symbol in the maze

    // Constants that are used to compare symbols.
    public static final String WALL = "X";
    public static final String EMPTY = "-";
    public static final String PATH = "*";

    /**
     * Constructor for MazePoint objects.
     *
     * @param symbol The internal representation of the symbol at current point.
     */
    public MazePoint(String symbol) {
        this.symbol = symbol;
    }

    /**
     * return the internal representation of symbol.
     *
     * Precondition: this object has been created and this.symbol has some value
     *
     * Takes no parameters.
     *
     * @return A String value represents the current symbol
     *  false.
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Checks if this point is a wall or not.
     *
     * Precondition: this object has been created and this.symbol has some value
     *
     * Takes no parameters.
     *
     * @return A boolean value that is true if this symbol is "X", otherwise
     *  false.
     */
    public boolean isWall() {
        return this.symbol.equals(WALL);
    }

    /**
     * Checks if this point is empty or not.
     *
     * Precondition: this object has been created and this.symbol has some value
     *
     * Takes no parameters.
     *
     * @return A boolean value that is true if this symbol is "-", otherwise
     *  false.
     */
    public boolean isEmpty() {
        return this.symbol.equals(EMPTY);
    }

    /**
     * Checks if this point is in the escape path or not.
     *
     * Precondition: this object has been created and this.symbol has some value
     *
     * Takes no parameters.
     *
     * @return A boolean value that is true if this symbol is "*", otherwise
     *  false.
     */
    public boolean isPath() {
        return this.symbol.equals(PATH);
    }

    /**
     * Sets this point to "*", indicating that it is in the escape path.
     *
     * Takes no parameters and returns nothing.
     */
    public void setToPath() {
        this.symbol = PATH;
    }

    /**
     * Sets this point to "-", indicating that it is empty.
     *
     * Takes no parameters and returns nothing.
     */
    public void setToEmpty() {
        this.symbol = EMPTY;
    }

    /**
     * Sets this point to "X", indicating that it is a wall.
     *
     * Takes no parameters and returns nothing.
     */
    public void setToWall() {
        this.symbol = WALL;
    }

    /**
     * Compares this point with another point and checks if they have the same
     * symbol.
     *
     * Precondition: this object and another MazePoint object have been created
     *  and both have symbol set to some value.
     *
     * @param other Another MazePoint object to compare with this object.
     *
     * @return A boolean value that is true if this symbol of this object and
     *  the other object are the same, otherwise false.
     */
    public boolean symbolMatch(MazePoint other) {
        return other.symbol.equals(this.symbol);
    }

    /**
     * Prints out the symbol representing this point to the console.
     *
     * Precondition: this object has been created and this.symbol has some value
     *
     * Takes no parameters and returns nothing.
     */
    public void printSymbol() {
        System.out.println(this.symbol);
    }
}