// Main Class File:    PA8Tester.java
// File:               ProtectedFile.java
// Quarter:            CSE8B Spring 2021
//
// Author:            Aleksandra Stashkova
// Instructor's Name:  Haytham Allos
/**
 * The ProtectedFile class inherits directly from the File abstract class.
 * Since this is a concrete class, it overrides all of the abstract methods inherited from its ancestors.
 *
 * Bugs: none
 *
 * @author Aleksandra Stashkova
 */
public class ProtectedFile extends File {

    /**
     * No-arg constructor. Do NOT change!
     */
    public ProtectedFile() {}

    /**
     * Implements this constructor by initializing all instance variables including the name and size instance
     * variables in its parent class.
     *
     * @param name instance variable - name
     * @param size instance variable - size
     */
    public ProtectedFile(String name, int size) {
        super(name, size);
    }

    /**
     * Return the string representation of the ProtectedFile object. 
     * Do Not change!
     * @return a string representation of the ProtectedFile object.
     */
    @Override
    public String toString() {
        return "Protected file: " + this.getName();
    }

}