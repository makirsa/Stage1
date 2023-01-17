import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PlayerModePage extends FormatFrame implements ActionListener{
	private ImageIcon bg; //bg will be used once an appropriate image is found
	private JButton jbtSingle, jbtDouble, jbtMenu;
	private PaintPanel canvas = new PaintPanel(); //all components are put on a PaintPanel which holds the background image (bg)
	private JLabel label; //text label
	private final Color DIFFICULTY_COLOR_FG = new Color(25,25,112), DIFFICULTY_COLOR_BG = Color.cyan; //constant colors of difficulty button foreground and background respectively
	private final Font DIFFICULTY_FONT = new Font("Sanserif", Font.PLAIN, 25); //constant font of difficulty buttons
	
	//Constructor for DifficultyScreen:
	PlayerModePage(){
		super(); //calls ScreenFrame constructor creating a new ScreenFrame
		
		
		//set a background image
		bg = new ImageIcon("images/bgMenu.png");
		//instantiate canvas and set null layout manager of canvas so we can manually place components
		canvas = new PaintPanel();
		canvas.setLayout(null);
		this.add(canvas); //add canvas to Setup Page
		
		//Label prompting the user to press a button
		label = addCustomLabel("Player Mode", DIFFICULTY_COLOR_FG, new Font("MV Boli", Font.BOLD, 50));
		//Sets bounds of the label
		label.setBounds(350, -300, this.getWidth() - 1, this.getHeight() - 1 );
		canvas.add(label); //add label to canvas
		
		//Add custom button for easy mode
		jbtSingle = addCustomButton("SINGLE PLAYER", 150, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtSingle.addActionListener(this); //register action listener
		canvas.add(jbtSingle); //add button to canvas
		
		//Add custom button for medium mode
		jbtDouble = addCustomButton("DOUBLE PLAYER", 550, 300, 300, 200, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtDouble.addActionListener(this); //register action listener
		canvas.add(jbtDouble); //add button to canvas
		
		
		//Add custom button to return to menu
		jbtMenu = addCustomButton("Menu", 750, 650, 200, 80, DIFFICULTY_COLOR_FG, DIFFICULTY_COLOR_BG, DIFFICULTY_FONT);
		jbtMenu.addActionListener(this); //register action listener
		canvas.add(jbtMenu); //add button to canvas
		
	}//end of Setup Screen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtSingle) {
			new SetupPageSingle();
			this.dispose(); //get rid of current frame
		}
		else if(e.getSource() == jbtDouble) {
			new SetupPageDouble();
			this.dispose(); //get rid of current frame
			
		}
		else if(e.getSource() == jbtMenu) {
			//create new instance of MenuScreen class
			new MenuPage();
			this.dispose(); //get rid of current frame
		}

	}//end of actionPerformed method
	
	/*
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			//Prints the canvas that holds the buttons and label
			super.paintComponent(g); //override the paintComponent method
			//draw the background image to fill the entire panel
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}//end of paintComponent method
			
	}


}

