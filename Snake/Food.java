// Imports

import java.util.ArrayList;


public class Food implements FoodInterface
{
	// Attributs
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	
	// Constructor
	
	public Food(ArrayList<SnakeBody> L, int w, int h)
	{
		width = 10;
		height = 10;
	
		boolean ok = false;
		
		while(!ok)
		{
			posX = Food.random(0, (w - width));
			posY = Food.random(0, (h - height));
			
			for(int i=0; i<L.size(); i++)
			{
				ok = (((L.get(i).getPosX() != posX) & (L.get(i).getPosY() != posY)) & (((posX%width) == 0) & ((posY%height) == 0)));
			}
		}
	}
	
	
	// Getters and Setters
	
	public int getPosX() { return posX; }
	public int getPosY() { return posY; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	
	// Methods
	
	static public int random(int a, int b)
	{
		return (int)(Math.random() * b + a);
	}
	
	public boolean isEaten(Snake snake)
	{
		return ((posX == snake.getBody().get(0).getPosX()) & (posY == snake.getBody().get(0).getPosY()));
	}
}
