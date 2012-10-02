// Enumeration

enum Direction{NORTH, SOUTH, EAST, WEST};


public class SnakeBody implements SnakeBodyInterface
{
	// Attributs
	
	private int posX;
	private int posY;
	private Direction direction;
	
	
	// constructor
	
	public SnakeBody(int x, int y, Direction d)
	{
		posX = x;
		posY = y;
		direction = d;
	}
	
	
	// Getters and setters
	
	public int getPosX() { return posX; }
	public int getPosY() { return posY; }
	public Direction getDirection() { return direction; }
	public void setPosX(int x) { posX = x; }
	public void setPosY(int y) { posY = y; }
	public void setDirection(Direction d) { direction = d; }
	
	
	// Methods
	
	public boolean equals(SnakeBody other)
	{
		return ((posX == other.getPosX()) & (posY == other.getPosY()));
	}
}
