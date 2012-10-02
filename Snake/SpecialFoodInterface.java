public interface SpecialFoodInterface extends FoodInterface
{
	/**
		* Returns the time the special food will keep being displayed on the screen
		* @return The time the special food will keep being displayed on the screen
	*/
	int getTimeToLive();
	
	/**
		* Discreases the time the spacial food keep being displayed on the screen
	*/
	void dicreaseTime();
}
