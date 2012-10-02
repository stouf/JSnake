public interface SnakeInterface
{
	/**
		* Returns an <em>ArrayList</em> of <em>SnakeBody</em> associated to the current <em>Snake</em> object
		* @return An <em>ArrayList</em> of <em>SnakeBody</em> associated to the current <em>Snake</em> object
		* @see SnakeBodyInterface 
	*/
	java.util.ArrayList<SnakeBody> getBody();
	
	/**
		* Return the width of the current <em>Snake</em> item
		* @return The width of the current <em>Snake</em> item
	*/
	int getWidth();
	
	/**
		* Return the height of the current <em>Snake</em> item
		* @return The height of the current <em>Snake</em> item
	*/
	int getHeight();
}
