
import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JButton;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @file game.java
 * @author Thomas Dawson
 * @date 3 Dec 2014
 * @see SnL.java and TTT.java for related stuff
 *
 * Creates a GUI to allow the player to choose game.
 */
public class Group09application {

	
	

    /**
	 * The main method that creates a new game JFrame and sets the size it 

	 */
	
    public static void main(String[] args) {
		
    	Group09application Frame = new Group09application();
					
					
					
	}
	 	
	
    /**
	 * The class constructor that creates a new JFrame 
	 * and adds all of the components  

	 */
	

	
	public Group09application() {
		SelectGame = new JFrame();
		SelectGame.setTitle("CHOOSE GAME");
		SelectGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SelectGame.getContentPane().setLayout(null);
		SelectGame.getContentPane().setBackground(Color.LIGHT_GRAY);
		SelectGame.getContentPane().add(addSnlButtons());
		SelectGame.getContentPane().add(addTttButtons());
		SelectGame.setVisible(true);
		SelectGame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	
	}
	
	
	/**
	 * A method returning one argument.
	 * @return playSnL a type JButton.

	 */
	
	private JButton addSnlButtons(){
		
		JButton playSnL = new JButton("Play SnL");
		playSnL.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				SelectGame.dispose();
				// create new object of the SnL class when button clicked
				SnL newGame = new SnL();
			
			}
		});
		
		playSnL.setBounds(SNL_POSITION, FROM_TOP, BUTTON_WIDTH, BUTTON_HEIGHT);
		SelectGame.getContentPane().add(playSnL);
		
		
		
		return playSnL;
		
	}
	
	/**
	 * A method returning one argument.
	 * @return playTTT a type JButton.

	 */
	
	
	private JButton addTttButtons(){
		
		
		
		JButton playTTT = new JButton("Play TTT");
		playTTT.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				SelectGame.dispose();
				// create new object of the TTT class when button clicked
				 TTT newGame = new TTT();
				 newGame.showFrame();
			}
		});
		playTTT.setBounds(TTT_POSITION, FROM_TOP, BUTTON_WIDTH, BUTTON_HEIGHT);
		SelectGame.getContentPane().add(playTTT);
		
		return playTTT;
	}


	public final static int FRAME_WIDTH = 850;   

	public final static int FRAME_HEIGHT = 250;
	
	public final static int BUTTON_WIDTH  = 150;
	
	public final static int BUTTON_HEIGHT = 45;
	
	public final static int FROM_TOP = 100;
	
	public final static int SNL_POSITION = 150;
	
	public final static int TTT_POSITION = 450;

	static JFrame SelectGame; 

}
