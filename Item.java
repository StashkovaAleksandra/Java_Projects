// Main Class File:    PA6Tester.java
// File:               Item.java
// Quarter:            CSE 8B Spring 2021

// Author:             Aleksandra Stashkova astashko@ucsd.edu
// Instructor's Name:  Haytham Allos

public class Item{

	private String name;
	private int damage;
	private int health;
	private int speed;

	/* 
	*	itemList and itemStats are used in pairs. For example, the first item
	* 	"Small Knife" has stats {2, 0, 0} (damage = 2, health = 0, speed = 0),
	* 	corresponding to the first row of the itemStats. for itemStats, first
	* 	column is damage, second column is health, and third column is speed.
	*/
	private static final String[] itemList = {"Small Knife",
											"Wooden Shield",
											"Booster",
											"Knight Sword",
											"HP Potion",
											"Ninja Suit",
											"Platinum Shield",
											"Thunder Hammer",
											"Treasure"};
	private static final int[][] itemStats = {{2, 0, 0},
											{0, 4, 0},
											{0, 0, 2},
											{4, 0, -1},
											{0, 6, 0},
											{1, 2, 2},
											{0, 10, -1},
											{6, 0, 0},
											{0, 0, 0}};

	// TODO: Implement this method and add header
	public Item(String name) {
		this.name = name;
		for (int i = 0; i < itemList.length; i++) {
			if (itemList[i].equals(this.name)) {
				this.damage = itemStats[i][0];
				this.health = itemStats[i][1];
				this.speed = itemStats[i][2];
				return;
			}
		}
		this.damage = 0;
		this.health = 0;
		this.speed = 0;
	}


	/**
     * 	Get the damage attribute of the item
     *
     * 	@return the damage of the item
     */
	public int getDamage() {
		return this.damage;
	}

	/**
     * 	Get the health attribute of the item
     *
     * 	@return the health of the item
     */
	public int getHealth() {
		return this.health;
	}

	/**
     * 	Get the speed attribute of the item
     *
     * 	@return the speed of the item
     */
	public int getSpeed() {
		return this.speed;
	}

	/**
     * 	Get the name attribute of the item
     *
     * 	@return the name of the item
     */
	public String getName() {
		return this.name;
	}

}