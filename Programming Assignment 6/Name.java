public class Name implements Comparable<Name> {
    private String firstName;
    private String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Name otherName) {
        int comparisonVal;

        comparisonVal = firstName.compareTo(otherName.firstName);
        if (comparisonVal != 0) {
            return comparisonVal;
        }
        else {
            return lastName.compareTo(otherName.lastName);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}