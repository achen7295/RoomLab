package Rooms;

import People.Person;
import People.Bag;
import People.Destruction;

public class Room {
	Person occupant;
	Bag bag;
	Destruction desc;
	int xLoc,yLoc;
	
	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}

	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x,Bag y)
	{
		System.out.println("Find the supplies!");
		occupant = x;
		bag = y;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}

	public void destroyRoom(Destruction x)
	{
		desc = x;
		x.setxdLoc(this.xLoc);
		x.setydLoc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Person x, Bag y)
	{
		occupant = null;
		bag = null;
	}

}
