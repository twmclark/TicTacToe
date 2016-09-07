/**
*	@file - TTT.java
*	@author - Gethyn Friend
*	@date - 25/11/2014
*	CS-230 Assignment 3
*
*	This is a class that creates an interactive form with widgets that the player can
*	use to input the required information to be sent to the TTTBoard class ready for
*	the player(s) to play the game
*/

/**
 * 	Import statements importing components for the class
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TTT {
	
	/**
	 * 	Static variables to collect the data to be sent to the TTTBoard class
	 */
	static int getPlayerCount;
	static int getPlayerFirst;
	static String getP1Name;
	static String getP2Name;
	public static TTTPiece player1 = new TTTPiece();
	public static TTTPiece player2 = new TTTPiece();

	
	/**
	 * 	Main method which executes the form code
	 * 	@return Displays the form for the player, ready to be interacted with
	 */
	public static void main(String args[]){
		showFrame();
	}
	
	/**
	 * @param FONTSIZE
	 * @param FWIDTH
	 * @param FHEIGHT
	 * @param SPACING
	 * @param LBLHOWMANYHEIGHT
	 * @param LBLWIDTH
	 * @param TXTWIDTH
	 * @param COMBOWIDTH
	 * @param CBOHOWMANYHEIGHT
	 * @param LBLPFHEIGHT
	 * @param CBOPFHEIGHT
	 * @param LBLP1NAME
	 * @param TXTP1NAME
	 * @param LBLP2NAME
	 * @param TXTP2NAME
	 * @param BTNSTARTLS
	 * @param BTNSTARTHEIGHT
	 * @param BTNSTARTRS
	 * @param BTNSTARTWIDTH
	 * @param ADDNUMFIRST
	 * @param ADDNUMSECOND
	 * @return returns a frame with interactive widgets for the player to use
	 * Static frame method to set up the form and set up all of the widgets used
	 */
	
	public static void showFrame(){
		
		/**
		*	final integer variables for the frame and spacing for various widgets
		*	within the form
		*/
		final int FONTSIZE = 16;
		final int FWIDTH = 270;
		final int FHEIGHT = 385;
		final int SPACING = 20;
		final int LBLHOWMANYHEIGHT = 11;
		final int LBLWIDTH = 231;
		final int TXTWIDTH = 165;
		final int COMBOWIDTH = 68;
		final int CBOHOWMANYHEIGHT = 41;
		final int LBLPFHEIGHT = 81;
		final int CBOPFHEIGHT = 111;
		final int LBLP1NAME = 151;
		final int TXTP1NAME = 181;
		final int LBLP2NAME = 221;
		final int TXTP2NAME = 251;
		final int BTNSTARTLS = 10;
		final int BTNSTARTHEIGHT = 291;
		final int BTNSTARTRS = 45;
		final int BTNSTARTWIDTH = 200;
		final int ADDNUMFIRST = 1;
		final int ADDNUMSECOND = 2;
		
		/**
		 * 	Sets various properties for the frame itself
		 * 	e.g. the height and width of the frame
		 */
		JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.setSize(FWIDTH,FHEIGHT);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		*	Label that asks the player how many human players will be playing
		*/
		JLabel labelHowManyPlayers = new JLabel("How many players are playing?");
		labelHowManyPlayers.setFont(new Font("Comic Sans MS", Font.PLAIN, FONTSIZE));
		labelHowManyPlayers.setBounds(SPACING, LBLHOWMANYHEIGHT, LBLWIDTH, SPACING);
		frame.getContentPane().add(labelHowManyPlayers);
		
		/**
		 * 	Combo box that collects data on how many human players will be playing
		 */
		final JComboBox comboHowMany = new JComboBox();
		comboHowMany.setBounds(SPACING, CBOHOWMANYHEIGHT, COMBOWIDTH, SPACING);
		comboHowMany.addItem(ADDNUMFIRST);
		comboHowMany.addItem(ADDNUMSECOND);
		frame.getContentPane().add(comboHowMany);
		
		/**
		 * 	Label that asks the player who is going first out of the two players
		 */
		JLabel labelPlayerFirst = new JLabel("Which player is going first?");
		labelPlayerFirst.setBounds(SPACING, LBLPFHEIGHT, LBLWIDTH, SPACING);
		labelPlayerFirst.setFont(new Font("Comic Sans MS", Font.PLAIN, FONTSIZE));
		frame.getContentPane().add(labelPlayerFirst);
		
		/**
		 * 	Combo box that collects data on which out of the two players
		 * 	will be making the first move in the game
		 */
		final JComboBox comboFirstPlayer = new JComboBox();
		comboFirstPlayer.setBounds(SPACING, CBOPFHEIGHT, COMBOWIDTH, SPACING);
		comboFirstPlayer.addItem(ADDNUMFIRST);
		comboFirstPlayer.addItem(ADDNUMSECOND);
		frame.getContentPane().add(comboFirstPlayer);
		
		/**
		 * 	Label that prompts the player for player 1's name
		 */
		JLabel labelPlayer1Name = new JLabel("Player 1's name");
		labelPlayer1Name.setBounds(SPACING,LBLP1NAME,LBLWIDTH,SPACING);
		labelPlayer1Name.setFont(new Font("Comic Sans MS", Font.PLAIN,FONTSIZE));
		frame.getContentPane().add(labelPlayer1Name);
		
		/**
		 * 	Text box that collects the input of player 1's name
		 */
		final JTextField txtPlayerName1 = new JTextField();
		txtPlayerName1.setBounds(SPACING,TXTP1NAME,TXTWIDTH,SPACING);
		frame.getContentPane().add(txtPlayerName1);
		
		/**
		 * 	Label that prompts the player for player 2's name
		 */
		JLabel labelPlayer2Name = new JLabel("Player 2's name");
		labelPlayer2Name.setBounds(SPACING,LBLP2NAME,LBLWIDTH,SPACING);
		labelPlayer2Name.setFont(new Font("Comic Sans MS", Font.PLAIN,FONTSIZE));
		frame.getContentPane().add(labelPlayer2Name);
		
		/**
		 * 	Text box that collects the input of player 2's name
		 */
		final JTextField txtPlayerName2= new JTextField();
		txtPlayerName2.setBounds(SPACING,TXTP2NAME,TXTWIDTH,SPACING);
		frame.getContentPane().add(txtPlayerName2);
		
		/**
		 * 	Button that which clicked will send data collected to the TTTBoard class and shows
		 * 	that class as well as hiding this one
		 */
		JButton btnStartGame = new JButton("Start Game!");
		btnStartGame.setFont(new Font("Comic Sans MS", Font.PLAIN, FONTSIZE));
		btnStartGame.setBounds(BTNSTARTLS, BTNSTARTHEIGHT, BTNSTARTWIDTH, BTNSTARTRS);
		frame.getContentPane().add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			
			/**
			 * 	Collects data into static variables when the action listener is called by the
			 * 	buttons click.
			 * 	Also creates a new instance of the board class and executes the board class
			 */
			public void actionPerformed(ActionEvent e){
				
				
				int player1pos;
				int player2pos;
				int position = (int) comboFirstPlayer.getSelectedItem();
				if(	position==1){
							player1pos = 1;
							player2pos= 2;
							System.out.println(player1pos);
						}else{
							player1pos = 2;
							player2pos = 1;
							System.out.println(player1pos);

						}
				
				player1.setPosition(player1pos);
				player2.setPosition(player2pos);
				player1.setname(txtPlayerName1.getText());
				player2.setname(txtPlayerName2.getText());
			
				
				TTTBoard board = new TTTBoard();
				board.launchWindow(player1,player2);
			}
		});
		
		/**
		 * 	Makes the GUI and all of its respected widgets for this form 
		 * 	viewable to the player
		 */
		frame.setVisible(true);
	}
}
