// Imports

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;


public class Scores extends JPanel implements ScoresInterface
{	
	// serialVersionUID for Serializable classes => AUTO GENERATED
	
	private static final long serialVersionUID = -4143009951194397961L;
	
	
	// Attributs
	
	private int currentScore;
	private int highScore;
	private JLabel currentScoreDisplay;
	private JLabel highScoreDisplay;
	
		
	// Getters
	
	public int getCurrentScore() { return currentScore; }
	public int getHighScore() { return highScore; }
	
	
	// Constructor
	
	public Scores()
	{
		super();
		
		currentScore = 0;
		
		try
		{
			FileReader file = new FileReader("high_score.txt");
			if(file.ready())
			{
				char char_read;
				StringBuffer s = new StringBuffer();
				while(file.ready())
				{
					char_read = (char)file.read();
					
					if(char_read != '\n' && char_read != ' ')
					{
						s.append(char_read);
					}
				}
				
				highScore = Integer.parseInt(s.toString());
			}
			else
			{
				highScore = 0;
			}
			
			file.close();
		}
		catch(FileNotFoundException e)
		{
			highScore = 0;
		}
		catch(IOException e)
		{
			highScore = 0;
		}
		
		currentScoreDisplay = new JLabel("Votre score: "+Integer.toString(currentScore));
		highScoreDisplay = new JLabel("High score: "+Integer.toString(highScore));
		
		this.setLayout(new GridLayout(2,1));
		this.add(currentScoreDisplay);
		this.add(highScoreDisplay);
	}
	
	
	// Methods
	
	public void incrementsCurrentScore(boolean specialFood)
	{
		if(specialFood)
		{
			if(Preferences.getDifficulty() == 50)
			{
				currentScore = currentScore + 50;
			}
			else if(Preferences.getDifficulty() == 100)
			{
				currentScore = currentScore + 25;
			}
			else if(Preferences.getDifficulty() == 150)
			{
				currentScore = currentScore + 10;
			}
			currentScoreDisplay.setText("Votre score: "+Integer.toString(currentScore));
		}
		else
		{
			if(Preferences.getDifficulty() == 50)
			{
				currentScore = currentScore + 10;
			}
			else if(Preferences.getDifficulty() == 100)
			{
				currentScore = currentScore + 5;
			}
			else if(Preferences.getDifficulty() == 150)
			{
				currentScore = currentScore + 2;
			}
			currentScoreDisplay.setText("Votre score: "+Integer.toString(currentScore));
		}
	}
	
	
	public void updateHighScore(int s)
	{
		if(s > highScore)
		{
			highScore = s;
			
			try
			{
				FileWriter file = new FileWriter("high_score.txt");
				file.write(Integer.toString(highScore));
				
				file.close();
			}
			catch(FileNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
