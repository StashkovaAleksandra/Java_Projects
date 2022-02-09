// Main Class File:    PA8Tester.java
// File:               NormalFile.java
// Quarter:            CSE8B Spring 2021
//
// Author:            Aleksandra Stashkova
// Instructor's Name:  Haytham Allos
import java.util.ArrayList;

/**
 * This class extends from the File abstract class and implements the Mutable interface.
 * Since it is a concrete class, it must override and implement all abstract methods.
 *
 * Bugs: none
 *
 * @author Aleksandra Stashkova
 */
public class NormalFile extends File implements Mutable {

    /**
     * No-arg constructor. Do NOT change!
     */
    public NormalFile() {}

    /**
     * Implements this constructor by initializing all instance variables
     * including the name and size instance variables in its parent class.
     *
     * @param name instance variable name
     * @param size instance variable size
     */
    public NormalFile(String name, int size) {
        super(name, size);
    }

    public boolean rename(String name){
        if (this.getParentDir() == null){
            this.setName(name);
            return true;
        }
        else {
            for (FSComponent comp: this.getParentDir().getComponentList()) {
                if (comp instanceof File){
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
        this.getParentDir().getComponentList().remove(this);
        this.setParentDir(null);
        return true;
    }

    public boolean moveTo(Directory dir){
        for (FSComponent comp: dir.getComponentList()) {
            if (comp instanceof File){
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
     * Return the string representation of the NormalFile object. 
     * Do Not change!
     * @return a string representation of the NormalFile object.
     */
    @Override
    public String toString() {
        return "Normal file: " + this.getName();
    }

}