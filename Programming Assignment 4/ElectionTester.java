import java.util.Scanner;

public class ElectionTester {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate("Trump", "Republican");
        Candidate candidate2 = new Candidate("Biden", "Democrat");

        System.out.println(candidate1.getName());
        System.out.println(candidate1.getParty());
        System.out.println(candidate1.getVotes());
        System.out.println(candidate2.getName());
        System.out.println(candidate2.getParty());
        System.out.println(candidate2.getVotes());

        candidate1.setParty("Democrat");
        candidate1.incrementVotes();
        candidate1.incrementVotes();
        System.out.println(candidate1.getName());
        System.out.println(candidate1.getParty());
        System.out.println(candidate1.getVotes());

        Election election1 = new Election();
        Election election2 = new Election();

        Scanner scanner = new Scanner(System.in);

        election1.runElection(scanner);
        election2.runElection(scanner);
    }
}