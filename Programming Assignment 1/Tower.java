// Main Class File:    PA6Tester.java
// File:               Tower.java
// Quarter:            CSE 8B Spring 2021

// Author:             Aleksandra Stashkova astashko@ucsd.edu
// Instructor's Name:  Haytham Allos

public class Tower {
	private static final String FORMAT = "\nLevel %d: %s encounters %s\n";

	private int height;
	private Monster[] monsterEachLevel;
	private Item[] itemEachLevel;

	// TODO: Implement this method and add header
	public Tower(int height) {
		this.height = Math.max(height, 1);
		monsterEachLevel = new Monster[this.height];
		itemEachLevel = new Item[this.height];
	}

	// TODO: Implement this method and add header
	public void setOneLevel(int level, Monster monster, Item item) {
		monsterEachLevel[level] = monster;
		itemEachLevel[level] = item;
	}

	/**
     * 	Get the height attribute of the tower
     *
     * 	@return the height of the tower
     */
	public int getHeight() {
		return this.height;
	}

	/**
     * 	Get the monster instance at the given tower level
     * 
	 *  @param level the level to choose the monster
     * 	@return the monster instance at the given tower level
     */
	public Monster getMonsterAtLevel(int level) {

		return this.monsterEachLevel[level];
	}

	/**
     * 	Get the item instance at the given tower level
     * 
	 *  @param level the level to choose the item
     * 	@return the item instance at the given tower level
     */
	public Item getItemAtLevel(int level) {

		return this.itemEachLevel[level];
	}

	/**
     * 	Set up the tower attributes with some arbitrary monsters and items.
     * 
     * 	@return the item instance at the given tower level
     */
	public static Tower setUpTower() {
		Tower tower = new Tower(5);

		Monster slime = new Monster("slime", "Zizizi", 1, 4, 1);
		Monster nightBat = new Monster("nightBat", "Urhnnnn", 2, 7, 5);
		Monster ghost = new Monster("ghost", "WinWin", 4, 6, 3);
		Monster zombie = new Monster("zombie", "Rueeeee", 3, 10, 2);
		Monster dragon = new Monster("dragon", "Ahshhhh", 6, 20, 7);

		tower.setOneLevel(0, slime, new Item("Ninja Suit"));
		tower.setOneLevel(1, nightBat, new Item("HP Potion"));
		tower.setOneLevel(2, ghost, new Item("Platinum Shield"));
		tower.setOneLevel(3, zombie, new Item("Thunder Hammer"));
		tower.setOneLevel(4, dragon, new Item("Treasure"));

		return tower;
	}


	/**
     * 	A simulation of the game given the hero and the tower objects.
     * 
	 *  @param hero the hero object that plays the game
	 *  @param tower the tower object the the hero plays
	 * 	@return whether the hero beats all the monster and survived at the end
     */
	public static boolean playGame(Hero hero, Tower tower) {
		for(int i = 0; i < tower.getHeight(); i++) {

			// visit one level at the time
			Monster monster = tower.getMonsterAtLevel(i);

			// print out the stats of the hero and the monster
			System.out.printf(FORMAT, i, hero.getName(), monster.getName());
			System.out.println(monster.roar());
			System.out.println(monster.getStats());

			// start the fight
			while(true) {
				// TODO: understand the following code and fill out the blank

				if(hero.isFasterThan(monster)) {
					System.out.println(hero.attack(monster));
					if(monster.isStillAlive()) {
						System.out.println(monster.attack(hero));
						if(hero.isStillAlive()) {
							continue;
						} else {
							System.out.println("Your hero died. Game Over!");
							return false;
						}
					} else {
						break;
					}
				} else {
					System.out.println(monster.attack(hero));
					if(hero.isStillAlive()) {
						System.out.println(hero.attack(monster));
						if(monster.isStillAlive()) {
							continue;
						} else {
							break;
						}
					} else {
						System.out.println("Your hero died. Game Over!");
						return false;
					}
				}
			}

			// if the hero survived from the fight, grab the rewarding item
			// and equip it to gain stats.
			Item currItem = tower.getItemAtLevel(i);
			System.out.println(hero.equipItem(currItem));
		}

		// All monsters are beaten. 
		System.out.println("The hero Wins!");
		return true;
	}
}