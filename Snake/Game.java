// Imports

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;



public class Game extends JFrame implements KeyListener,ActionListener,GameInterface
{	
	// serialVersionUID for Serializable classes => AUTO GENERATED
	
	private static final long serialVersionUID = 5348261528159496913L;
	
	
	// Attributs
	
	private DrawingPanel drawingArea;
	static public Scores score;
	static public boolean listen_keyboard = false;
	private JMenu optionsMenu;
	private JMenuItem startOption;
	private JMenuItem exitOption;
	private JMenuItem preferencesOption;
	private Preferences preferences;
	private boolean paused = false;
	
	
	// Constructor
	
	public Game(String url)
	{
		super();
		
		preferences = null;
		
		optionsMenu = new JMenu("Options");
		startOption = new JMenuItem("Commencer la partie");
		startOption.addActionListener(this);
		exitOption = new JMenuItem("Quitter");
		exitOption.addActionListener(this);
		preferencesOption = new JMenuItem("Preferences");
		preferencesOption.addActionListener(this);
		optionsMenu.add(startOption);
		optionsMenu.add(preferencesOption);
		optionsMenu.add(exitOption);
		
		score = new Scores();
		drawingArea = new DrawingPanel(url);
		
		Container container = new Container();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 5;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		container.add(drawingArea, constraints);
		
		constraints.gridx = 4;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridwidth = 1;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		container.add(score, constraints);

		setSize(drawingArea.getBackWidth(), drawingArea.getBackHeight());
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		addKeyListener(this);
		
		setContentPane(container);
		
		setJMenuBar(new JMenuBar());
		getJMenuBar().add(optionsMenu);
		
		setVisible(true);
		
		while(drawingArea.getWidth() < drawingArea.getBackWidth())
		{
			drawingArea.setSize((drawingArea.getWidth() + 1), drawingArea.getHeight());
			this.setSize((getWidth() + 1), getHeight());
		}
		
		while(drawingArea.getHeight() < drawingArea.getBackHeight())
		{
			drawingArea.setSize(drawingArea.getWidth(), (drawingArea.getHeight() + 1));
			this.setSize(getWidth(), (getHeight() + 1));
		}
	}
	
	
	// Methods
	
	public void startGame()
	{
		preferencesOption.setEnabled(false);
		if(preferences != null)
		{
			drawingArea.getTimer().setDelay(Preferences.getDifficulty());
		}
		drawingArea.getTimer().start();
	}
	
	
	
	public void keyTyped(KeyEvent e)
	{
	}
	
	public void keyPressed(KeyEvent e)
	{	
		if(!listen_keyboard && !paused)
		{
			Thread.yield();
		}
		else
		{
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				Game.score.updateHighScore(Game.score.getCurrentScore());
		
				System.exit(0);
			}
			else if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				drawingArea.repaint();
				
				if(paused)
				{
					paused = false;
					drawingArea.getTimer().start();
				}
				else
				{
					paused = true;
					drawingArea.getTimer().stop();
				}
			}
			else
			{
				if((e.getKeyCode() == KeyEvent.VK_UP) & (drawingArea.getSnake().getBody().get(0).getDirection() != Direction.SOUTH))
				{
					drawingArea.getSnake().getBody().get(0).setDirection(Direction.NORTH);
				}
				else if((e.getKeyCode() == KeyEvent.VK_DOWN) & (drawingArea.getSnake().getBody().get(0).getDirection() != Direction.NORTH))
				{
					drawingArea.getSnake().getBody().get(0).setDirection(Direction.SOUTH);
				}
				else if((e.getKeyCode() == KeyEvent.VK_LEFT) & (drawingArea.getSnake().getBody().get(0).getDirection() != Direction.EAST))
				{
					drawingArea.getSnake().getBody().get(0).setDirection(Direction.WEST);
				}
				else if((e.getKeyCode() == KeyEvent.VK_RIGHT) & (drawingArea.getSnake().getBody().get(0).getDirection() != Direction.WEST))
				{
					drawingArea.getSnake().getBody().get(0).setDirection(Direction.EAST);
				}
			}
		
			listen_keyboard = false;
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exitOption)
		{
			System.exit(0);
		}
		else if(e.getSource() == startOption)
		{
			startGame();
		}
		else if(e.getSource() == preferencesOption)
		{
			preferences = new Preferences();
		}
	}
}
