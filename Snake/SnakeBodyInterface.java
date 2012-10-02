public interface SnakeBodyInterface
{
	/**
		* Returns the current position of <strong>this</strong> <em>SnakeBody</em> of the game's display, on X
		* @return The current position of <strong>this</strong> <em>SnakeBody</em> of the game's display, on X
	*/
	int getPosX();
	
	/**
		* Returns the current position of <strong>this</strong> <em>SnakeBody</em> of the game's display, on Y
		* @return The current position of <strong>this</strong> <em>SnakeBody</em> of the game's display, on Y
	*/
	int getPosY();
	
	/**
		* Returns the current direction where <strong>this</strong> <em>SnakeBody</em> is moving to
		* @return The current direction where <strong>this</strong> <em>SnakeBody</em> is moving to
	*/
	Direction getDirection();
	
	/**
		* Set the position of <strong>this</strong> <em>SnakeBody</em> of the game's display, on X
	*/
	void setPosX(int x);
	
	/**
		* Set the position of <strong>this</strong> <em>SnakeBody</em> of the game's display, on Y
	*/
	void setPosY(int y);
	
	/**
		* Set the direction where <strong>this</strong> <em>SnakeBody</em> is moving to
	*/
	void setDirection(Direction d);
	
	/**
		* The <em>Object</em> equal surcharged method
		* @param other The another <em>SnakeBody</em> the current <em>SnakeBody</em> will be compared to
		* @return True is <strong>this</strong> <em>SnakeBody</em> is the same as the one given as a parameter
	*/
	boolean equals(SnakeBody other);
}
