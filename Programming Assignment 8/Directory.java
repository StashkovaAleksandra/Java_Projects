// Main Class File:    PA8Tester.java
// File:               Directory.java
// Quarter:            CSE8B Spring 2021
//
// Author:            Aleksandra Stashkova
// Instructor's Name:  Haytham Allos
import java.util.ArrayList;

/**
 * The Directory abstract class inherits directly from the FSComponent abstract class.
 * Directory class has a list of FSComponent objects stored in componentList.
 *
 * Bugs: none
 *
 * @author Aleksandra Stashkova
 */
public abstract class Directory extends FSComponent {

    private ArrayList<FSComponent> componentList;

    /**
     * No-arg constructor.
     * Do NOT change!
     */

    public Directory() {
        super("Directory");
    }


    /**
     * Initializes componentList to an empty ArrayList and initializing the name instance variable,
     * by using the parameter, in its parent class.
     *
     * @param (name) name instance variable
     */
    protected Directory(String name) {
        super(name);
        this.componentList = new ArrayList<>();
    }

    /**
     * Public getter that retrieves instance variable - componentList.
     * Do NOT change!
     *
     * @return the componentList instance variable
     */
    public ArrayList<FSComponent> getComponentList() {
        return this.componentList;
    }

    /**
     * Public setter that mutate instance variable - componentList.
     * Do NOT change!
     *
     * @param componentList the new componentList variable to be assigned
     */
    public void setComponentList(ArrayList<FSComponent> componentList) {
        this.componentList = componentList;
    }

    /**
     * Add a component to the end of the {@code this.componentList}.
     * Do NOT change!
     *
     * @param newComp the new component to be appended
     */
    public void appendComponent(FSComponent newComp) {
        this.componentList.add(newComp);
        newComp.setParentDir(this);
    }


    /**
     * This method adds a FSComponent to its ArrayList.
     *
     * @param (newComp) new file that is being added to the current directory
     * @return boolean
     */
    public boolean addComponent(FSComponent newComp) {
        for (FSComponent comp : componentList) {
            if (newComp instanceof File && comp instanceof File && newComp.getName().equals(comp.getName())) {
                return false;
            } else {
                if (newComp instanceof Directory && comp instanceof Directory && newComp.getName().equals(comp.getName())) {
                    return false;
                }

            }
        }
        this.appendComponent(newComp);
        return true;

    }

    /**
     * This method will print out the all files and directories under the current directory hierarchically.
     *
     * @param ()
     * @return none
     */
    public void printStructure() {
        System.out.println(this);
        for (FSComponent comp : componentList) {
            if (comp instanceof File) {
                System.out.println("\t" + comp);
            } else {
                Helper(1, (Directory) comp);
            }
        }
    }

    public void Helper(int tabsToMake, Directory dir) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < tabsToMake; i++) {
            tabs.append("\t");
        }
        String str = tabs.toString();
        System.out.println(str + dir);
        for (FSComponent comp : dir.getComponentList()) {
            if (comp instanceof File) {
                System.out.println(str + "\t" + comp);
            } else {
                Helper(tabsToMake + 1, (Directory) comp);
            }
        }
    }

    /**
     * Calculates and return the sum of all file sizes under the current folder
     * (including all files in subdirectories and sub-subdirectories etc).
     *
     * @param () none
     * @return sum of all file sizes under the current folder
     */
    @Override
    public int getSize() {
        int n = 0;
        for (FSComponent comp : componentList) {
            if (comp instanceof File) {
                n += comp.getSize();
            } else {
                n += Helper2((Directory) comp);
            }
        }
        return n;
    }

    public int Helper2(Directory dir) {
        return dir.getSize();
    }
}