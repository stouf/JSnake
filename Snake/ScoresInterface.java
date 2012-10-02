public interface ScoresInterface
{
	/**
		* Returns the score of the current game
		* @return The score of the current game
	*/
	int getCurrentScore();
	
	/**
		* Returns the highest score recorded by the programme
		* @return The highest score recorded by the programme
	*/
	int getHighScore();
	
	/**
		* Increments the score of the current game.
		* Depends of the parameter.
		* @param specialFood A boolean which tells if the <em>Food</em> eaten by the <em>Snake</em> is a <em>SpecialFood</em> or not
		* @see Snake
		* @see Food
		* @see SpecialFood
	*/
	void incrementsCurrentScore(boolean specialFood);
	
	/**
		* Updates the highest score recorded by the programme, if it needs to be done
		* @param s The score done by the player at the last game. It will be compared to the current highest score recorded and replace if it's greater
	*/
	void updateHighScore(int s);
}
