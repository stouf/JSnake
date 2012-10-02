// Imports

import javax.swing.Timer;



/**
	* @author Stephan DONIN
*/

public interface DrawingPanelInterface
{
	// Getters and Setters
	
	/**
		* Returns the current size (width) of the graphic pannel
		* @return Current width of the graphic pannel
		* @author Stephan DONIN
	*/
	int getBackWidth();
	
	/**
		* Returns the current size (height) of the graphic pannel
		* @return Current height of the graphic pannel
		* @author Stephan DONIN
	*/
	int getBackHeight();
	
	
	/**
		* Returns the javax.swing.Timer object in it current state. This object will be used to run or stop the program's execution
		* @return javax.swing.Timer Object
		* @author Stephan DONIN
	*/
	Timer getTimer();
	
	
	/**
		* Retourne l'objet Snake dans son etat courant. Cet objet represente le serpent et toutes ses caracteristiques
		* Returns the Snake object in it current state. This object stands for the snake and all it characteristics
		* @return Snake Object
		* @author Stephan DONIN
	*/
	Snake getSnake();
	
	
	
	// Methods
	
	
	/**
		* This methods is used to update the Snake's position each time the timer wake up the current process.
		* It only updates the snake's position, and not it directions. This is updated by a method from the Snake class called updateDirections()
		* @param snake that this method updates it position
		* @exception BorderException If the snake's new position is in contact with a wall
		* @see SnakeInterface
	*/
	void updatePosition(Snake snake) throws BorderException;
	
	
	/**
		* This method checks is the snake isn't eating a food or a special food at the moment it's called.
		* This method is the one called by the main process, and calls the method updatePosition(Snake). It also repaints the graphic panel each time it's called.
		* @exception BitItSelfException If the snake is eating it own tail.
	*/
	void move() throws BitItSelfException;
}
