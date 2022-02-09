// Main Class File:    PA8Tester.java
// File:               FSComponent.java
// Quarter:            CSE8B Spring 2021
//
// Author:            Aleksandra Stashkova
// Instructor's Name:  Haytham Allos
/**
 *  The FSComponent abstract class has a single instance variable name, getter and setter associated with name, and two public constructors.
 *  It defines three abstract methods (getSize(), toString(), and setParentDir(Directory dir)) that need to be overridden by its subclasses.
 *
 * Bugs: none
 *
 * @author Aleksandra Stashkova
 */
public abstract class FSComponent {
    private String name;

    /**
     * No-arg constructor. Do NOT change!
     */
    public FSComponent() {}

    /**
     * Public constructor that takes in a String.
     * Do NOT change!
     * @param name the name of the FSComponent
     */
    public FSComponent(String name) {
        this.name = name;
    }

    /**
     * Public getter that retrieves instance variable - name
     * Do Not Change!
     * @return instance variable - name
     */
    public String getName() {
        return name;
    }

    /**
     * Public setter that mutates instance variable - name
     * Do Not Change!
     * @param name instance variable - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares if two FSComponent objects are equal if and only if they have the same class type AND their names are the same.
     *
     * @param (obj) object
     * @return boolean (true or false)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass().equals(obj.getClass())){
            return false;
        }
        FSComponent other = (FSComponent) obj;
        return this.name.equals(other.name);

    }

    /* The following three abstract methods needs to be implemented by its 
     * subclasses. Do NOT change! */
    public abstract int getSize();
    public abstract String toString();
    public abstract void setParentDir(Directory dir);

}