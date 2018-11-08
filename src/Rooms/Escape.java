package Rooms;

import Game.Runner;
import People.Person;

public class Escape extends Room
{

	public Escape(int x, int y) {
		super(x, y);

	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Person entering
	 */

	public void enterWin(Person x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("Congratulations! You found the escape!");
		Runner.gameOff();
	}
	

}
