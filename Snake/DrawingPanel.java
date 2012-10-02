// Imports

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;


public class DrawingPanel extends JPanel implements ActionListener, DrawingPanelInterface
{	
	// serialVersionUID for Serializable classes => AUTO GENERATED
	
	private static final long serialVersionUID = -5435432670156327662L;

	
	// Attributs
	
	private int backWidth;
	private int backHeight;
	private Image backgroundImage;
	private Snake snake;
	private Food food;
	private Timer timer;
	private SpecialFood specialFood;
	private int specialFoodTimer;
	
	
	// Constructor
	
	public DrawingPanel(String url)
	{
		super();
		
		timer = new Timer(100, this);
		
		setDoubleBuffered(true);
		
		try
		{
			backgroundImage = ImageIO.read(new File(url));
			backWidth = backgroundImage.getWidth(this);
			backHeight = backgroundImage.getHeight(this);
			System.out.println("Your personnal background picture has been loaded");
		}
		catch(IOException e)
		{
			System.out.println("Default background will be used.");
			System.out.println("(Note: give as a parameter the path of the background picture you wish to use during the game)");
			
			backgroundImage = null;
			backWidth = 640;
			backHeight = 400;
		}
		
		snake = new Snake();
		food = new Food(snake.getBody(), backWidth, backHeight);
		specialFoodTimer = 15;
		specialFood = null;
	}
	
	
	// Getters and Setters
	
	public int getBackWidth() { return backWidth; }
	public int getBackHeight() { return backHeight; }
	public Timer getTimer() { return timer; }
	public Snake getSnake() { return snake; }
	
	
	// Methods
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == timer)
		{
			try
			{
				move();
			}
			catch(BitItSelfException expt)
			{
				repaint();
				JOptionPane.showMessageDialog(this, expt.getMessage(), "Snake", JOptionPane.ERROR_MESSAGE);
				Game.score.updateHighScore(Game.score.getCurrentScore());
				
				try
				{
					Thread.sleep(200);
					System.exit(0);
				}
				catch(Exception expt2)
				{
					System.out.println(expt2.getMessage());
				}
			}
		}
	}
	
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
		
		if(backgroundImage != null)
		{
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
		
		snake.drawSnake(g);
		
		g.setColor(Color.yellow);
		g.fillOval(food.getPosX(), food.getPosY(), food.getWidth(), food.getHeight());
		
		if(specialFood != null)
		{
			g.setColor(Color.red);
			g.fillOval(specialFood.getPosX(), specialFood.getPosY(), specialFood.getWidth(), specialFood.getHeight());
		}
	}
	
	
	public void updatePosition(Snake snake) throws BorderException
	{
		int new_pos;
		
		for(int i=0; i<snake.getBody().size(); i++)
		{
			if(snake.getBody().get(i).getDirection() == Direction.NORTH)
			{
				new_pos = snake.getBody().get(i).getPosY() - snake.getHeight();
				
				if(new_pos < 0)
				{
					throw new BorderException("Perdu!\nVous avez heurté un rebord.");
				}
				else
				{
					snake.getBody().get(i).setPosY(new_pos);
				}
			}
			else if(snake.getBody().get(i).getDirection() == Direction.SOUTH)
			{
				new_pos = snake.getBody().get(i).getPosY() + snake.getHeight();
				
				if(new_pos >= getHeight())
				{
					throw new BorderException("Perdu!\nVous avez heurté un rebord.");
				}
				else
				{
					snake.getBody().get(i).setPosY(new_pos);	
				}
			}
			else if(snake.getBody().get(i).getDirection() == Direction.WEST)
			{
				new_pos = snake.getBody().get(i).getPosX() - snake.getWidth();
				
				if(new_pos < 0)
				{
					throw new BorderException("Perdu!\nVous avez heurté un rebord.");
				}
				else
				{
					snake.getBody().get(i).setPosX(new_pos);
				}
			}
			else if(snake.getBody().get(i).getDirection() == Direction.EAST)
			{
				new_pos = snake.getBody().get(i).getPosX() + snake.getWidth();
			
				if(new_pos >= getWidth())
				{
					throw new BorderException("Perdu!\nVous avez heurté un rebord.");
				}
				else
				{
					snake.getBody().get(i).setPosX(new_pos);
				}
			}
		}
		
		snake.updateDirections();
	}
	
	
	public void move() throws BitItSelfException
	{
		Game.listen_keyboard = false;
		
		if(food.isEaten(snake))
		{
			Game.score.incrementsCurrentScore(false);
			specialFoodTimer = specialFoodTimer - 1;
			
			food = null;
			snake.getLonger();
			food = new Food(snake.getBody(), getWidth(), getHeight());
		}
		
		if(specialFood == null)
		{
			if(specialFoodTimer <= 0)
			{
				specialFood = new SpecialFood(snake.getBody(), getWidth(), getHeight());
			}
		}
		else
		{
			if(specialFood.getTimeToLive() > 0)
			{
				specialFood.dicreaseTime();
			
				if(specialFood.isEaten(snake))
				{
					Game.score.incrementsCurrentScore(true);
					specialFood = null;
					specialFoodTimer = 15;
				}
			}
			else
			{
				specialFood = null;
				specialFoodTimer = 15;
			}
		}
	
		try
		{
			updatePosition(snake);
		}
		catch(BorderException e)
		{
			repaint();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Snake", JOptionPane.ERROR_MESSAGE);
			Game.score.updateHighScore(Game.score.getCurrentScore());
			try
			{
				Thread.sleep(200);
			}
			catch(Exception e2)
			{
				System.out.println(e2.getMessage());
			}
			System.exit(0);
		}
		
		for(int i=1; i<snake.getBody().size(); i++)
		{
			if(snake.getBody().get(0).equals(snake.getBody().get(i)))
			{
				throw new BitItSelfException("Perdu!\nVous vous êtes mordu la queue.");
			}
		}

		repaint();
		
		Game.listen_keyboard = true;
	}
}
