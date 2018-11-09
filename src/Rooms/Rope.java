package Rooms;

import People.Person;
import People.Bag;

public class Rope extends Room
{

    public Rope(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x,Bag y) {
        occupant = x;
        bag = y;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You have found rope!");
        y.gainRope(5);
    }
}
