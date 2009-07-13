package connect4.view.menu;

/**
 * Represents and stores game menu items.
 * 
 * @author Stanislav Petrov
 */
public enum GameMenuItem {

	SINGLE_PLAYER(0, null), MULTI_PLAYER(1, null), OPTIONS(2, new int[] { 5, 6,
			7 }), CREDITS(3, null), EXIT(4, null), CONFIGURE_GAME(5, null), CONTROLS(
			6, null), BACK(7, null);

	/**
	 * Stores the number of parent menu items.
	 */
	public static final int MENU_ITEMS_NUMBER = 5;
	/**
	 * Stores the index of the menu item.
	 */
	private final int index;
	/**
	 * Stores all sub menu item indices for the current menu item.
	 */
	private final int[] subMenuItem;

	GameMenuItem(int index, int[] subMenuItems) {
		this.index = index;
		this.subMenuItem = subMenuItems;
	}

	/**
	 * Gets an index of the menu item.
	 * 
	 * @return Menu item's index.
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * Gets sub menu items of the relevant menu item.
	 * 
	 * @return Array of sub menus' indices.
	 */
	public int[] getSubMenu() {
		return this.subMenuItem;
	}

}
