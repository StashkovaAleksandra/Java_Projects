import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class NameSorter {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        final int NUM_ELEMENTS = 3;
        Name newName;
        ArrayList<Name> userNames = new ArrayList<Name>();
        String firstName;
        String lastName;
        int i;

        for (i = 0; i < NUM_ELEMENTS; ++i) {
            firstName = scnr.next();
            lastName = scnr.next();
            newName = new Name(firstName, lastName);
            userNames.add(newName);
        }

        Collections.sort(userNames);

        for (i = 0; i < NUM_ELEMENTS; ++i) {
            System.out.println(userNames.get(i));
        }
    }
}
