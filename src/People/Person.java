package People;

public class Person {
	String firstName;
	String familyName;
	int xLoc, yLoc,health;

	public int loseHealth(int x){
		this.health = this.health - x;
		return health;
	}

	public int gainHealth(int x){
		this.health = this.health + x;
		return this.health;
	}

	public int getxLoc() {
		return xLoc;
	}

	public int getHealth(){
		return health;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public Person (String firstName, String familyName,int health, int xLoc, int yLoc)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.health = health;
	}


}
