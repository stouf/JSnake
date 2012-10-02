// Imports

import java.util.ArrayList;
import java.awt.Color;

import java.awt.Graphics;


public class Snake implements SnakeInterface
{
	// attributs
	
	private ArrayList<SnakeBody> body;
	private int width;
	private int height;
	
	
	// Constructor
	
	public Snake()
	{	
		width = 10;
		height = 10;
	
		body = new ArrayList<SnakeBody>();
		for(int i=0; i<=(width * 4); i = i + width)
		{
			body.add(new SnakeBody(((width * 4) - i), 0, Direction.EAST));
		}
	}
	
	
	// Getters and setters
	
	public ArrayList<SnakeBody> getBody() { return body; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	
	// Methods
	
	public void drawSnake(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(body.get(0).getPosX(), body.get(0).getPosY(), width, height);
		
		g.setColor(Color.black);
		g.drawRect(body.get(0).getPosX(), body.get(0).getPosY(), width, height);
		
		g.setColor(Color.black);
		for(int i=1; i<body.size(); i++)
		{
			g.fillRect(body.get(i).getPosX(), body.get(i).getPosY(), width, height);
		}
	}
	
	public void updateDirections()
	{
		for(int i = (body.size() - 1); i > 0; i--)
		{
			body.get(i).setDirection(body.get(i-1).getDirection());
		}
	}
	
	public void getLonger()
	{
		int i = body.size() - 1;
		
		if(body.get(i).getDirection() == Direction.NORTH)
		{
			body.add(new SnakeBody(body.get(i).getPosX(), (body.get(i).getPosY() + height), Direction.NORTH));
		}
		else if(body.get(i).getDirection() == Direction.SOUTH)
		{
			body.add(new SnakeBody(body.get(i).getPosX(), (body.get(i).getPosY() - height), Direction.SOUTH));
		}
		else if(body.get(i).getDirection() == Direction.WEST)
		{
			body.add(new SnakeBody((body.get(i).getPosX() + width), body.get(i).getPosY(), Direction.WEST));
		}
		else if(body.get(i).getDirection() == Direction.EAST)
		{
			body.add(new SnakeBody((body.get(i).getPosX() - width), body.get(i).getPosY(), Direction.EAST));
		}
	}
}
