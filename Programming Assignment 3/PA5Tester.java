///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA5Tester
// File:               PA5Tester.java
// Quarter:            Spring 2021
//////////////////////////// 80 columns wide //////////////////////////////////

public class PA5Tester {

    /**
    * Main method runs a series of test on the Board object.
    *
    * @param args (not used)
    */
    public static void main(String[] args) {

        PA5Tester solver = new PA5Tester();

        System.out.println("\n\n*************** Testing PA5 *****************");

        int score = 0;
        solver.testBoardToString();
        score += solver.testRotate();
        score += solver.testCanMove();
        score += solver.testMove();

        // This is just a reminder to implement more tests.
        // Once you have implemented the required tests for this PA, you can
        // remove this if statement/println if you want (you don't have to)


        if (score == 3) {
            System.out.println("YOU PASSED ALL TESTS!!!");
        }

        System.out.println("*************************************************");
    }

    /************************ TEST PRINT BOARD ************************/

    /**
     * Test the board's boardToString  method.
     *
     * @return 1 if the tests pass, 0 if they fail
     */
    private void testBoardToString() {
        System.out.println("Testing boardToString method .......................");

        Board board1 = new Board(new int[][]{
                {2, 4, 0, 0},
                {0, 0, 8, 4},
                {0, 16, 0, 4},
                {1024, 1024, 4, 256}});

        System.out.println("\nPrinting current board ......................\n");
        System.out.println(board1.boardToString());

        System.out.println("Printing board after moving UP ..............\n");
        System.out.println(board1.boardToString(board1.UP));

        System.out.print("Printing board to see previous ");
        System.out.println("board remains ........\n");
        System.out.println(board1.boardToString());

        System.out.println("Printing board after moving LEFT ............\n");
        System.out.println(board1.boardToString(board1.LEFT));

        System.out.print("Printing board to see previous ");
        System.out.println("board remains ........\n");
        System.out.println(board1.boardToString());
        System.out.println("***********************************************");
    }

    /**
     * Test the board's printBoard  method.
     *
     * @return 1 if the tests pass, 0 if they fail
     */
    private int testRotate() {
        System.out.print("Testing rotate method.......................");

        Board board = new Board(new int[][]{
                {2, 4, 0, 0},
                {0, 0, 8, 4},
                {0, 16, 0, 4},
                {1024, 1024, 4, 256}});
        board.rotate(1);

        if (!isEqualArray(board.getGrid(), new int[][]{
            {1024, 0, 0, 2},
            {1024, 16, 0, 4},
            {4, 0, 8, 0},
            {256, 4, 4, 0}})) {
        System.out.println("FAILED!");
        System.out.println("rotate(1) is implemented incorrectly");
        return 0;
    }

    System.out.println("Passed!");
    return 1;
    }

    /************************ TEST CAN MOVE ************************/

    /**
     * Test the board's canMove method.
     * TODO: Add tests to this method.
     * @return 1 if the tests pass, 0 if they fail
     */
    private int testCanMove() {
        System.out.print("Testing canMove method......................");

        Board board = new Board( new int[][]{
                {0, 0, 0, 4},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        if (board.canMove(board.LEFT)) {
            // Passed, do nothing.
        } else {
            System.out.println("FAILED!\nBoard should be able to move left:");
            System.out.println(board.boardToString());
            return 0;
        }

        if (board.canMove(board.UP) && !board.canMove(board.RIGHT) &&
                board.canMove(board.DOWN)) {
            // Passed, do nothing.
        } else {
            System.out.println("FAILED!");
            if (!board.canMove(board.UP)) {
                System.out.println("Board should be able to move UP:");
            }
            if (board.canMove(board.RIGHT)) {
                System.out.println("Board should NOT be able to move RIGHT:");
            }
            if (!board.canMove(board.DOWN)) {
                System.out.println("Board should be able to move DOWN:");
            }
            System.out.println(board.boardToString());
            return 0;
        }

        System.out.println("Passed!");
        return 1;
    }

    /************************ TEST MOVE ************************/
    /**
     * Test the board's move method.
     * @return 1 if the tests pass, 0 if they fail
     */
    public int testMove() {
        System.out.print("Testing move method.........................");

        Board boardLeft = new Board( new int[][]{
            {0, 2, 4, 0},
            {0, 0, 8, 8},
            {0, 0, 0, 0},
            {0, 2, 2, 2}});

        boardLeft.move(boardLeft.LEFT);
        if (!isEqualArray(boardLeft.getGrid(), new int[][]{
                {2, 4, 0, 0},
                {16, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 2, 0, 0}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.LEFT) implemented incorrectly");
            return 0;
        }

        Board boardRight = new Board( new int[][]{
                {2, 4, 8, 2},
                {2, 4, 8, 2},
                {2, 4, 8, 0},
                {2, 4, 8, 2}});

        boardRight.move(boardRight.RIGHT);
        if (!isEqualArray(boardRight.getGrid(), new int[][]{
                {2, 4, 8, 2},
                {2, 4, 8, 2},
                {0, 2, 4, 8},
                {2, 4, 8, 2}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.RIGHT) is implemented incorrectly");
            return 0;
        }

        Board boardUp = new Board( new int[][]{
            {0, 8, 4, 8},
            {0, 0, 128, 8},
            {2, 8, 128, 256},
            {0, 0, 2, 64}});

        boardUp.move(boardUp.UP);
        if (!isEqualArray(boardUp.getGrid(), new int[][]{
                {2, 16, 4, 16},
                {0, 0, 256, 256},
                {0, 0, 2, 64},
                {0, 0, 0, 0}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.UP) implemented incorrectly");
            return 0;
        }

        Board boardDown = new Board( new int[][]{
            {2, 0, 0, 2},
            {2, 0, 8, 2},
            {2, 4, 8, 0},
            {2, 4, 0, 2}});

        boardDown.move(boardDown.DOWN);
        if (!isEqualArray(boardDown.getGrid(), new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 2},
                {4, 8, 16, 4}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.DOWN) implemented incorrectly");
            return 0;
        }

        System.out.println("Passed!");
        return 1;
    }

    
    /**
     * Compares two 2D int arrays.  Helper method to make sure
     * tests are working correctly.
     *
     * Precondition: The arrays are the same size and not null.
     *
     * @return true if the arrays contain all the same values, false otherwise
     */
    private boolean isEqualArray(int[][] grid1, int[][] grid2) {
        for (int r = 0; r < grid1.length; r++) {
            for (int c = 0; c < grid1.length; c++) {
                if (grid1[r][c] != grid2[r][c])
                    return false;
            }
        }
        return true;
    }
}
