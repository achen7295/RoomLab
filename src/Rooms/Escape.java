package Rooms;

import Game.Runner;
import People.Person;
import People.Bag;

public class Escape extends Room
{

    public Escape(int x, int y) {
        super(x, y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x,Bag b) {
        occupant = x;

        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("Congratulations! You found the escape!");
        Runner.gameOff();
    }
}