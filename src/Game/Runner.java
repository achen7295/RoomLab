package Game;

import People.Person;
import People.Bag;
import People.Destruction;
import Rooms.Room;
import Rooms.Food;
import Rooms.Ammo;
import Rooms.Escape;
import Rooms.Rope;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		//Fill the building with normal rooms
		Board building = new Board(7,7);
		for (int x = 0; x < building.board.length; x++)
		{
			for (int y = 0; y < building.board[x].length; y++)
			{
				building.board[x][y] = new Room(x, y);
			}
		}

		//Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 10, 0,0);
		Bag bag = new Bag(0, 0,0);
		Destruction desc = new Destruction(0,0);
		building.board[0][0].enterRoom(player1,bag);
		Scanner in = new Scanner(System.in);
		System.out.println("You are in an apocalypse and you need to find some supplies!");

		//Creates first instance of the board
		for(int x = 0; x < building.board.length; x++)
		{
			for (int y = 0; y < building.board[x].length; y++)
			{
				if(x == 0 && y == 0)
					System.out.print("[O]");
				else
					System.out.print("[ ]");
			}
			System.out.println();
		}

			//Create two rations that spawn every game
			int foodX = ((int)(Math.random() * building.board.length));
			int foodY = (int)(Math.random() * building.board.length);
			building.board[foodX][foodY] = new Food(foodX, foodY);

			//Create two rocks that spawn every game
			int ammoX = ((int)(Math.random() * building.board.length));
			int ammoY = (int)(Math.random() * building.board.length);
			building.board[ammoX][ammoY] = new Ammo(ammoX, ammoY);

			//Creates two ropes that spawn every game
			int ropeX = ((int)(Math.random() * building.board.length));
			int ropeY = (int)(Math.random() * building.board.length);
			building.board[ropeX][ropeY] = new Rope(ropeX, ropeY);

		while(gameOn) {
				System.out.println("Where would you like to move? (Choose N, S, E, W)");
				System.out.println("Your coordinates are X:" + player1.getxLoc() + " Y:" + player1.getyLoc());
				System.out.println(("Your current health is: " + player1.getHealth()));
				System.out.println("You bag contains " + "food:" + bag.getFood() + " ammo:" + bag.getAmmo() + " rope:" + bag.getRope());
					if (bag.getFood() > 1 && bag.getAmmo() > 1 && bag.getRope() > 1) {
				System.out.println("You have found enough supplies to leave!");
				System.out.print("Head to position x:4 y:4 to leave!");
				building.board[4][4] = new Escape(4,4);
			}
				String move = in.nextLine();
				if (validMove(move, player1, bag, desc, building.board)) {
					for (int x = 0; x < building.board.length; x++) {
						for (int y = 0; y < building.board[x].length; y++) {
							if (x == player1.getxLoc() && y == player1.getyLoc())
								System.out.print("[O]");
							else
								System.out.print("[ ]");
						}
						System.out.println();
					}
				} else
					System.out.println("You cannot go there.");
			}
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Bag b, Destruction d, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
					if (p.getxLoc() > 0) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p, b);
						map[p.getxLoc() - 1][p.getyLoc()].enterRoom(p, b);
						if (p.getyLoc() == d.getydLoc() && p.getxLoc() == d.getxdLoc()) {
							System.out.println("The path has been blocked move another way!");
							return false;
						}
						map[p.getxLoc() + 1][p.getyLoc()].destroyRoom(d);
						return true;
					} else {
						return false;
					}
			case "e":
					if (p.getyLoc() < map[p.getyLoc()].length - 1) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p, b);
						map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p, b);
						if (p.getyLoc() == d.getydLoc() && p.getxLoc() == d.getxdLoc()) {
							System.out.println("The path has been blocked move another way!");
							return false;
						}
						map[p.getxLoc()][p.getyLoc() - 1].destroyRoom(d);
						return true;
					} else {
						return false;
					}


			case "s":
					if (p.getxLoc() < map.length - 1) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p, b);
						map[p.getxLoc() + 1][p.getyLoc()].enterRoom(p, b);
						if (p.getyLoc() == d.getydLoc() && p.getxLoc() == d.getxdLoc()) {
							System.out.println("The path has been blocked move another way!");
							return false;
						}
						map[p.getxLoc() - 1][p.getyLoc()].destroyRoom(d);
						return true;
					} else {
						return false;
					}


			case "w":
					if (p.getyLoc() > 0) {
						map[p.getxLoc()][p.getyLoc()].leaveRoom(p, b);
						map[p.getxLoc()][p.getyLoc() - 1].enterRoom(p, b);
						if (p.getyLoc() == d.getydLoc() && p.getxLoc() == d.getxdLoc()) {
							System.out.println("The path has been blocked move another way!");
							return false;
						}
						map[p.getxLoc()][p.getyLoc() + 1].destroyRoom(d);
						return true;
					} else {
						return false;
					}

			default:
				break;
					
		}
		return true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
	


}
