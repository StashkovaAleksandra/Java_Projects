import java.util.Scanner;

public class Election {
    private Candidate candidate1;
    private Candidate candidate2;
    private Candidate candidate3;

    public Election() {
        candidate1 = new Candidate("Obama", "Democrat");
        candidate2 = new Candidate("Bush", "Republican");
        candidate3 = new Candidate("Reagan", "Democrat");
    }
    public void runElection(Scanner scanner) {
        System.out.println("Welcome to the Election. There are three candidates as follows:");
        System.out.println("1. " + candidate1.getName() + " from " + candidate1.getParty());
        System.out.println("2. " + candidate2.getName() + " from " + candidate2.getParty());
        System.out.println("3. " + candidate3.getName() + " from " + candidate3.getParty());
        int counter = 0;
        while (counter != -1) {
            System.out.println("Enter the next vote by candidate number. Enter -1 if there are no more votes");
            counter = scanner.nextInt();
            if (counter == 1) {
                candidate1.incrementVotes();
            } else if (counter == 2) {
                candidate2.incrementVotes();
            } else if (counter == 3) {
                candidate3.incrementVotes();
            } else {
                break;
            }
        }
        System.out.println("The vote count is as follows:");
        System.out.println(candidate1.getName() + ":" + candidate1.getVotes());
        System.out.println(candidate2.getName() + ":" + candidate2.getVotes());
        System.out.println(candidate3.getName() + ":" + candidate3.getVotes());
        int max = Math.max(Math.max(candidate1.getVotes(), candidate2.getVotes()), candidate3.getVotes());
        if (candidate1.getVotes() == max && candidate2.getVotes() == max || candidate1.getVotes() == max && candidate3.getVotes() == max || candidate2.getVotes() == max && candidate3.getVotes() == max) {
            System.out.println("It is a tie");
        }
        else {
            if (candidate1.getVotes() == max) {
                System.out.println("The winner is " + candidate1.getName());
            }
            else if (candidate2.getVotes() == max) {
                System.out.println("The winner is " + candidate2.getName());
            }
            else {
                System.out.println("The winner is " + candidate3.getName());
            }
        }
    }
}