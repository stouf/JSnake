/**
	* @author Stephan DONIN
*/


public interface FoodInterface
{
	/**
		* Returns the current position on X
		* @return Current position on X
	*/
	int getPosX();
	
	/**
		* Returns the current position on Y
		* @return Current position on Y
	*/
	int getPosY();
	
	/**
		* Returns the current width
		* @return Current width
	*/
	int getWidth();
	
	/**
		* Returns the current height
		* @return Current height
	*/
	int getHeight();
	
	/**
		* This method tells if <em>snake</em> is eating the current object or not.
		* @return A boolean telling if <em>snake</em> is eating the current object or not.
		* @param snake The <em>Snake</em> object we need to test if it's eating the current object or not.
	*/
	boolean isEaten(Snake snake);
}
