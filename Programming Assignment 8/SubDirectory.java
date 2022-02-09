// Main Class File:    PA8Tester.java
// File:              SubDirectory.java
// Quarter:            CSE8B Spring 2021
//
// Author:            Aleksandra Stashkova
// Instructor's Name:  Haytham Allos

import java.util.ArrayList;

/**
 * The SubDirectory class extends from the Directory abstract class and implements Mutable interface.
 * It has an additional instance variable parentDir compared to the Directory class. Since it is a concrete class,
 * it overrides and implement all abstract methods.
 *
 * Bugs: none
 *
 * @author Aleksandra Stashkova
 */
public class SubDirectory extends Directory implements Mutable {

    private Directory parentDir;

    /**
     * No-arg constructor. Do NOT change!
     */
    public SubDirectory() {}

    /**
     * Implement this constructor by initializing all instance variable name in its parent class.
     *
     * @param name instance variable name
     * @return initializes constructor
     */
    public SubDirectory(String name) {
        super(name);
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

    /**
     * Public getter that retrieves instance variable - parentDir
     * Do Not Change!
     * @return instance variable - parentDir
     */
    public Directory getParentDir() {
        return this.parentDir;
    }

    public boolean rename(String name){
        if (this.getParentDir() == null){
            this.setName(name);
            return true;
        }
        else {
            for (FSComponent comp: this.getParentDir().getComponentList()) {
                if (comp instanceof Directory){
                    if (name.equals(comp.getName())){
                        return false;
                    }

                }
            }
        }
        this.setName(name);
        return true;
    }

    public boolean delete(){
        if (!Helper()){
            return false;
        }
        else {
            this.getParentDir().getComponentList().remove(this);
            this.setParentDir(null);
            return true;
        }
    }

    public boolean Helper(){
        for (FSComponent comp : this.getComponentList()){
            if(comp instanceof ProtectedFile) {
                return false;
            }
            else {
                if (comp instanceof Directory){
                    return ((SubDirectory) comp).Helper();
                }
            }
        }
        return true;
    }

    public boolean moveTo(Directory dir){
        for (FSComponent comp: dir.getComponentList()) {
            if (comp instanceof Directory){
                if (this.getName().equals(comp.getName())){
                    return false;
                }

            }
        }
        dir.getComponentList().add(this);
        this.getParentDir().getComponentList().remove(this);
        this.setParentDir(dir);
        return true;
    }

    /**
     * Return the string representation of the SubDirectory object. 
     * Do Not change!
     * @return a string representation of the SubDirectory object.
     */
    @Override
    public String toString() {
        return "Sub Directory: " + this.getName();
    }

    // Add helper method here if needed
    
}