// Main Class File:    PA6Tester.java
// File:               Hero.java
// Quarter:            CSE 8B Spring 2021

// Author:             Aleksandra Stashkova astashko@ucsd.edu
// Instructor's Name:  Haytham Allos

public class Hero {
	private static final String ATTACK_FORMAT = "%s attacks %s, causing %d damage.";

	private String name;
	private int damage;
	private int health;
	private int speed;

	private static Hero hero_instance;


	/**
     * 	A private constructor that can only be used within this class. This
	 * 	constructor should only be called once throughout the entire program.
	 * 	Do NOT overload this constructor. This is the only constructor in this
	 * 	class. Do NOT change this constructor.
     */
	private Hero() {}

	/**
     * 	Get the name attribute of the hero
     *
     * 	@return the name of the hero
     */
	public String getName() {
		return this.name;
	}

	/**
     * 	Get the damage attribute of the hero
     *
     * 	@return the damage of the hero
     */
	public int getDamage() {
		return this.damage;
	}

	/**
     * 	Get the health attribute of the hero
     *
     * 	@return the health of the hero
     */
	public int getHealth() {
		return this.health;
	}

	/**
     * 	Get the speed attribute of the hero
     *
     * 	@return the speed of the hero
     */
	public int getSpeed() {
		return this.speed;
	}

	/**
     * 	set the name attribute of the hero
     *
     * 	@param name the name of the hero
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * 	set the damage attribute of the hero
     *
     * 	@param damage the name of the hero
     */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
     * 	set the health attribute of the hero
     *
     * 	@param health the name of the hero
     */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
     * 	set the speed attribute of the hero
     *
     * 	@param speed the name of the hero
     */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * This is a special setter that sets all four member variables with the given parameters.
	 *
	 * @param (name) Initializing Hero's name
	 * @param (damage) Initializing Hero's damage
	 * @param (health) Initializing Hero's health
	 * @param (speed) Initializing Hero's speed
	 * @return none
	 */

	public void setFields(String name, int damage, int health, int speed) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.speed = speed;
	}

	/**
	 * This is the interface that returns our singleton Hero instance.
	 * @return hero_instance
	 */

	public static Hero getInstance() {
		if(hero_instance == null){
			hero_instance = new Hero();
		}
		return hero_instance;
	}


	/**
	 * Causes the input monster to lose health that is equal to the hero’s damage.
	 *
	 * @param (monster) object monster from class Monster
	 * @return the message "A attacks B, causing X damage."
	 */

	public String attack(Monster monster) {
		monster.receiveDamage(this.damage);
		return String.format(ATTACK_FORMAT, this.name, monster.getName(), this.damage);
	}


	/**
	 * Simply adds each of the three attributes (damage, health, and speed) from the input item to the corresponding attributes of our hero.
	 *
	 * @param (item) object item from class Item
	 * @return the string "XXX received XXXX"
	 */
	public String equipItem(Item item) {
		this.damage += item.getDamage();
		this.health += item.getHealth();
		this.speed += item.getSpeed();
		return this.name + " received " + item.getName();
	}

	/**
	 * (Write a succinct description of this method here.)
	 *
	 * @param (monster) (Describe the first parameter here)
	 * @return (description of the return value)
	 */
	public boolean isFasterThan(Monster monster) {
		return this.speed > monster.getSpeed();
	}

	// TODO: Implement this method and add header
	public boolean isStillAlive() {
		return this.health > 0;
	}

	// TODO: Implement this method and add header
	public void receiveDamage(int damage) {
		this.health -= damage;
	}

	/**
     * 	Retrives name, damage, health and speed  of the hero in a formatted
	 * 	string.
     *
     * 	@return a string representation of the stats of the hero.
     */
	public String getStats() {
		return String.format("\t%s - damage: %d, health: %d, speed: %d", 
			this.name, this.damage, this.health, this.speed);
	}

}