//Title:               PA6
// Files:              Monster.java, Items.java, Tower.java, Hero.java
// Quarter:            CSE 8B Spring 2021

// Author:             Aleksandra Stashkova
// Email:              astashko@ucsd.edu
// Instructor's Name:  Haytham Allos

public class PA6Tester {

    /**
     * 	A tester that checks whether the Hero object is singleton.
     *
     * 	@return whether the test passes or not
     */
    public static boolean test1() {
        Hero hero1 = Hero.getInstance();
        Hero hero2 = Hero.getInstance();
        if (hero1 != hero2) {
            System.out.println("Test failed. Your hero is not singleton!!!");
            return false;
        }
        return true;
    }

    /**
     * 	A tester that checks a general functionality of your implementations.
     *
     * 	@return whether the test passes or not
     */
    public static boolean test2() {
        Hero hero = Hero.getInstance();
        hero.setFields("Bob", 10, 47, 2);
        Tower tower = Tower.setUpTower();
        boolean didWin = Tower.playGame(hero, tower);
        System.out.println(hero.getStats());
        if (!didWin || hero.getDamage() != 17 || hero.getHealth() != 1 || 
            hero.getSpeed() != 3) {
                System.out.println("Test failed. Result mismatch!!!");
                return false;
            }
        return true;
    }

    // Health is set to 117 in order for Hero to win. In the previous test the Hero came out with Health = 1, which is equal to the Health in the following
    // test as well due to increase in monster's anger.
    public static boolean test3() {
        Hero hero = Hero.getInstance();
        hero.setFields("Sasha", 10, 117, 2);
        Tower tower = Tower.setUpTower();
        boolean didWin = Tower.playGame(hero, tower);
        System.out.println(hero.getStats());
        if (!didWin || hero.getDamage() != 17 || hero.getHealth() != 1 ||
                hero.getSpeed() != 3) {
            System.out.println("Test failed. Result mismatch!!!");
            return false;
        }
        return true;
    }

    public static boolean test4() {
        Hero hero = Hero.getInstance();
        hero.setFields("Gigi", 10, 55, 2);
        Tower tower = Tower.setUpTower();
        boolean didWin = Tower.playGame(hero, tower);
        System.out.println(hero.getStats());
        if (didWin || hero.getDamage() != 17 || hero.getHealth() != -41 ||
                hero.getSpeed() != 3) {
            System.out.println("Test failed. Result mismatch!!!");
            return false;
        }
        return true;
    }

    /**
     * 	The main method that runs your program and your testers. You should put
     *  all testers in the if conditions in order to test your code. It will 
     *  print a message if you pass all testers.
     *
     * 	@param args a list of arguments provided to run your program. Arguments 
     *  are delimited by whitespace.
     */
    public static void main(String[] args) {

        // TODO: call your testers in the if condition
        if (test1() && test2() && test3() && test4()) {
            System.out.println("You passed all tests.");
        }
    }
}
