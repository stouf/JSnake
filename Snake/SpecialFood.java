// Imports

import java.util.ArrayList;



public class SpecialFood extends Food implements SpecialFoodInterface
{
	// Attributs
	
	private int timeToLive;
	private boolean isPainted;
	
	// Constructor
	
	public SpecialFood(ArrayList<SnakeBody> L, int x, int y)
	{
		super(L, x, y);
		timeToLive = 150;
	}
	
	
	// Getters and setters
	
	public int getTimeToLive() { return timeToLive; }
	
	
	
	// Methods
	
	public void dicreaseTime()
	{
		timeToLive = timeToLive - 1;
	}
}
