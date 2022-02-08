import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        String inputFileName = "input3";
//        MazeSolver solver1 = new MazeSolver(inputFileName);
//        System.out.println("Read maze:");
//        System.out.println(solver1.mazeToString());
//        solver1.escapeFromMaze("while");
//        System.out.println("\nEscape from maze using for loop:");
//        System.out.println(solver1.mazeToString());

        // you may add more for testing purposes

        String inputFileName = "input2";
        MazeSolver solver1 = new MazeSolver(inputFileName);
        System.out.println("Read maze:");
        System.out.println(solver1.mazeToString());
        solver1.escapeFromMaze("for");
        System.out.println("\nEscape from maze using for loop:");
        System.out.println(solver1.mazeToString());

        inputFileName = "input1";
        MazeSolver solver2 = new MazeSolver(inputFileName);
        System.out.println("Read maze:");
        System.out.println(solver2.mazeToString());
        solver2.escapeFromMaze("while");
        System.out.println("\nEscape from maze using for loop:");
        System.out.println(solver2.mazeToString());

        inputFileName = "input3";
        MazeSolver solver3 = new MazeSolver(inputFileName);
        System.out.println("Read maze:");
        System.out.println(solver3.mazeToString());
        solver3.escapeFromMaze("while");
        System.out.println("\nEscape from maze using for loop:");
        System.out.println(solver3.mazeToString());

        inputFileName = "input3";
        MazeSolver solver4 = new MazeSolver(inputFileName);
        System.out.println("Read maze:");
        System.out.println(solver4.mazeToString());

        System.out.println(solver4.mazeMatch(solver3.getMaze()));

        solver4.escapeFromMaze("while");

        System.out.println(solver4.mazeMatch(solver3.getMaze()));

        String[] line1 = "- X X - X X X X".split(" ");
        String[] line2 = "- X X X X".split(" ");
        String[] line3 = "- X X X X X X X X X X X".split(" ");

        MazePoint[][] wrongMaze = new MazePoint[3][];
        wrongMaze[0] = new MazePoint[line1.length];
        for (int j = 0; j < line1.length; j++) {
            wrongMaze[0][j] = new MazePoint(line1[j]);
        }
        wrongMaze[1] = new MazePoint[line2.length];
        for (int j = 0; j < line2.length; j++) {
            wrongMaze[1][j] = new MazePoint(line2[j]);
        }
        wrongMaze[2] = new MazePoint[line3.length];
        for (int j = 0; j < line3.length; j++) {
            wrongMaze[2][j] = new MazePoint(line3[j]);
        }


        System.out.println(solver1.mazeMatch(wrongMaze));

        System.out.println("\nEscape from maze using for loop:");
        System.out.println(solver4.mazeToString());
    }
}
