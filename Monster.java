// Main Class File:    PA6Tester.java
// File:               Monster.java
// Quarter:            CSE 8B Spring 2021

// Author:             Aleksandra Stashkova astashko@ucsd.edu
// Instructor's Name:  Haytham Allos

public class Monster {
	private static final String ATTACK_FORMAT = "%s attacks %s, causing %d damage.";
	private String name;
	private String roarSound;
	private int damage;
	private int health;
	private int speed;

	private static int anger = 1;

	// TODO: Implement this method and add header
	public Monster(String name, String roarSound, int damage, int health, 
					int speed) {
		this.name = name;
		this.roarSound = roarSound;
		this.damage = damage;
		this.health = health;
		this.speed = speed;
	}

	/**
     * 	Get the speed attribute of the monster
     *
     * 	@return the speed of the monster
     */
	public int getSpeed() {
		return this.speed;
	}


	/**
     * 	Get the name attribute of the monster
     *
     * 	@return the name of the monster
     */
	public String getName() {
		return this.name;
	}

	/**
     * 	Get the health attribute of the monster
     *
     * 	@return the health of the monster
     */
	public int getHealth() {
		return this.health;
	}

	/**
	 * 	Get the damage attribute of the monster
	 *
	 * 	@return the damage of the monster
	 */
	public int getDamage() {
		return this.damage;
	}

	/**
     * 	Get the anger attribute of the Monster class
     *
     * 	@return the anger of the Monster class
     */
	public static int getAnger() {
		return anger;
	}

	/**
     * 	Set the anger attribute of the Monster class
     *
     * 	@param anger anger of the Monster class
     */
	public static void setAnger(int anger) {
		Monster.anger = anger;
	}

	// TODO: Implement this method and add header
	public String attack(Hero hero) {
		hero.receiveDamage(this.damage * anger);
		return String.format(ATTACK_FORMAT, this.name, hero.getName(), this.damage * anger);
	}


	// TODO: Implement this method and add header
	public String roar() {
		return this.name + ": " + this.roarSound;
	}


	// TODO: Implement this method and add header
	public boolean isStillAlive() {
		if (this.health > 0) {
			return true;
		}
		else {
			anger++;
			return false;
		}
	}


	// TODO: Implement this method and add header
	public void receiveDamage(int damage) {
		this.health -= damage;
	}

	/**
     * 	Retrives name, damage, health and speed  of the monster in a formatted
	 * 	string.
     *
     * 	@return a string representation of the stats of the monster.
     */
	public String getStats() {
		return String.format("\t%s - damage: %d, health: %d, speed: %d", 
			this.name, this.damage, this.health, this.speed);
	}
}