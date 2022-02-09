///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA8Tester.java
// File:               Mutable.java
// Quarter:            Spring 2021
//
// Author:             Yundong Wang
// Instructor's Name:  Haytham Allos
///////////////////////////////////////////////////////////////////////////////

/**
 * This public interfaces contains three abstract methods that need to be 
 * implemented by its subclasses.
 *
 * Bugs: None
 *
 * @author Yundong Wang
 */
public interface Mutable {

    boolean delete();
    boolean rename(String name);
    boolean moveTo(Directory dir);
}