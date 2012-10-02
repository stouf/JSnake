// Imports

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Preferences extends JFrame implements MouseListener
{
	// SerivaVersionUID => AUTO-GENERATED
	
	private static final long serialVersionUID = -4758330704512474627L;
	
	
	// Attributs
	
	private JLabel difficultyLabel;
	private ButtonGroup difficultySelection;
	private JRadioButton easy;
	private JRadioButton medium;
	private JRadioButton hard;
	static private int difficulty = 100;
	
	private JButton validationButton;

	
	// Constructor
	
	public Preferences()
	{
		super();
		
		setSize(400,200);
		setTitle("Preferences");
		setLocationRelativeTo(null);
		
		difficultyLabel = new JLabel("Choisissez votrez difficulté:");
		easy = new JRadioButton("Facile", false);
		medium = new JRadioButton("Moyen", true);
		hard = new JRadioButton("Difficile",false);
		
		validationButton = new JButton("Valider");
		validationButton.addMouseListener(this);
		
		difficultySelection = new ButtonGroup();
		difficultySelection.add(easy);
		difficultySelection.add(medium);
		difficultySelection.add(hard);
		
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 0, 10);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(difficultyLabel, constraints);
		
		constraints.insets = new Insets(0, 0, 0, 0);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(easy, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(medium, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(hard, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(20, 0, 0, 0);
		getContentPane().add(validationButton, constraints);
		
		constraints.insets = new Insets(0, 0, 0, 0);
		
		
		setVisible(true);
	}
	
	
	// Getters and Setters
	
	static public int getDifficulty(){ return difficulty; }
	
	
	
	// Methods
	
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() == validationButton)
		{
			Enumeration<AbstractButton> elements = difficultySelection.getElements();
			boolean found = false;
			while(elements.hasMoreElements() & !found)
			{
				AbstractButton b = (AbstractButton) elements.nextElement();
				if(b.isSelected())
				{
					if(b == easy)
					{
						difficulty = 150;
					}
					else if(b == medium)
					{
						difficulty = 100;
					}
					else if(b == hard)
					{
						difficulty = 50;
					}
					
					found = true;
				}
			}
		}
		
		dispose();
	}

	public void mouseEntered(MouseEvent e)
	{	
	}

	public void mouseExited(MouseEvent e)
	{	
	}

	public void mousePressed(MouseEvent e)
	{	
	}

	public void mouseReleased(MouseEvent e)
	{	
	}
}
