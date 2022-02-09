// Main Class File:    PA8Tester.java
// File:               File.java
// Quarter:            CSE8B Spring 2021
//
// Author:            Aleksandra Stashkova
// Instructor's Name:  Haytham Allos

/**
 * File.java has pairs of setter and getter methods for each of the instance variables,
 * and it contains two public constructors.
 *
 * Bugs: None
 *
 * @author Aleksandra Stashkova
 */
public abstract class File extends FSComponent {

    private int size;
    private Directory parentDir;

    /**
     * No-arg constructor. Do NOT change!
     */
    public File() {
        super("File");
    }

    /**
     * Implements this constructor by initializing all instance variables including the name instance variable in
     * its parent class.
     *
     * @param name instance variable - name
     * @param size instance variable - size
     */
    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    /**
     * Public setter that mutates instance variable - size
     * Do Not Change!
     * @param size instance variable - size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Public getter that retrieves instance variable - size
     * Do Not Change!
     * @return instance variable - size
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * Public getter that retrieves instance variable - parentDir
     * Do Not Change!
     * @return instance variable - parentDir
     */
    public Directory getParentDir() {
        return this.parentDir;
    }

    /**
     * Public setter that mutates instance variable - parentDir
     * Do Not Change!
     * @param parentDir instance variable - parentDir
     */
    @Override
    public void setParentDir(Directory parentDir) {
        this.parentDir = parentDir;
    }
}