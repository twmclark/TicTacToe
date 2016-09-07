/**
 * @file   - SnL.java
 * @author - Jamie Glinn
 * @date   - 4th Dec 2014  
 * CS230 - Assignment 3
 * This class creates a JFrame to get the amount of players,
 * along with their names and colours that they have chosen.
 * This form will also get the number of snakes and ladders in the game.
 * Once this class has this information it will create a game using it.
 */
 /**
 * The package is set and import statements are used to import the whole swing, awt and
 * awt.event packages.
 */
//package Cw3game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SnL extends JFrame {
	/**
	* Private variables of SnL form so they can not be accessed from outside.
	* This first set of variables are the widgets of the form.
	* These are declared here so that they are accessible by multiple methods.
	*/
	private static JTextField m_txtPlayer1;
	private static JTextField m_txtPlayer2;
	private static JTextField m_txtPlayer3;
	private static JTextField m_txtPlayer4;
	private static JCheckBox m_chckbxPlayer1;
	private static JCheckBox m_chckbxPlayer2;
	private static JCheckBox m_chckbxPlayer3;
	private static JCheckBox m_chckbxPlayer4;
	private JLabel m_lblSnakesAndLadders;
	private JLabel ply1DiceLabel;
	private JLabel ply2DiceLabel;
	private JLabel ply3DiceLabel;
	private JLabel ply4DiceLabel;
	private JButton btnRollDice1;
	private JButton btnRollDice2;
	private JButton btnRollDice3;
	private JButton btnRollDice4;
	private JRadioButton m_player1Blue;
	private JRadioButton m_player1Red;
	private JRadioButton m_player1Yellow;
	private JRadioButton m_player1Black;
	private JRadioButton m_player2Blue;
	private JRadioButton m_player2Red;
	private JRadioButton m_player2Yellow;
	private JRadioButton m_player2Black;
	private JRadioButton m_player3Blue;
	private JRadioButton m_player3Red;
	private JRadioButton m_player3Yellow;
	private JRadioButton m_player3Black;
	private JRadioButton m_player4Blue;
	private JRadioButton m_player4Red;
	private JRadioButton m_player4Yellow;
	private JRadioButton m_player4Black;
	private final ButtonGroup bGroup = new ButtonGroup();
	private final ButtonGroup bGroup_1 = new ButtonGroup();
	private final ButtonGroup bGroup_2 = new ButtonGroup();
	private final ButtonGroup bGroup_3 = new ButtonGroup();
	private static int m_player1Order = 0;
	private static int m_player2Order = 0;
	private static int m_player3Order = 0;
	private static int m_player4Order = 0;
	private static int m_players = 0;
	/**
	* The drawing of all widgets are done in the constructor method as the form is built.
	* This is done here because the form widgets are final 
	* and will not be altered after construction.
	* @param FTOP
	* @param FBOTTOM
	* @param FONTSIZE
	* @param TITLEX
	* @param TITLEY
	* @param TITLESPACE
	* @param PLAYERLBLX
	* @param PLAYERLBLYSPACE
	* @param PLAYERLBLLENGTH
	* @param PLAYERLBLYBOTTOM
	* @param YBETWEENPLAYERLBL
	* @param CHCKBXWIDTH
	* @param CHCKBXHEIGHT
	* @param CHCKBXX
	* @param CHCKBXY
	* @param CHCKBXYSPACE
	* @return displays the frame with the widgets on so the the players can input data to create the board.
	* Constructor method that creates the form 
	*/
	public SnL() {
		/**
		* Integer variables that are final so will not change during the interaction with the form
		* Declares frame size along with title label size, name box size and player check box sizes.
		*/
		final int FTOP = 100;
		final int FRAMEWIDTH = 750;
		final int FRAMEHEIGHT = 600;
		final int FONTSIZE = 28;
		final int TITLEX = 108;
		final int TITLEY = 31;
		final int TITLESPACE = 258;
		final int PLAYERTXTX = 100;
		final int PLAYERTXTYSPACE = 20;
		final int PLAYERTXTLENGTH = 97;
		final int PLAYERTXTYBOTTOM = 121;
		final int YBETWEENPLAYERTXT = 75;
		final int CHCKBXWIDTH = 77;
		final int CHCKBXHEIGHT = 23;
		final int CHCKBXX = 17;
		final int CHCKBXY = 120;
		final int CHCKBXYSPACE = 75;
		/**
		* Creates a dice and sets all player rolls to zero
		*/
		final Dice m_die = new Dice();
		final int[] playerRolls = new int[4];
		for(int x = 0; x < 4; x++) {
			playerRolls[x] = 0;
		}
		/**
		* Gives the form its basic attributes
		*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(FTOP, FTOP, FRAMEWIDTH, FRAMEHEIGHT);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		/**
		* Displays a title on the form
		*/
		m_lblSnakesAndLadders = new JLabel("Snakes and Ladders");
		this.add(m_lblSnakesAndLadders);
		m_lblSnakesAndLadders.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, FONTSIZE));
		m_lblSnakesAndLadders.setForeground(Color.BLACK);
		m_lblSnakesAndLadders.setVisible(true);
		m_lblSnakesAndLadders.setBounds(TITLEX, TITLEY, TITLEX + TITLESPACE, TITLEY);
		/**
		* Creates a text field for player 1's name to be entered
		*/
		m_txtPlayer1 = new JTextField();
		this.add(m_txtPlayer1);
		m_txtPlayer1.setBounds(PLAYERTXTX, PLAYERTXTYBOTTOM, PLAYERTXTX + PLAYERTXTLENGTH, PLAYERTXTYSPACE);
		/**
		* Creates a text field for player 2's name to be entered
		*/
		m_txtPlayer2 = new JTextField();
		this.add(m_txtPlayer2);
		m_txtPlayer2.setBounds(PLAYERTXTX, PLAYERTXTYBOTTOM + YBETWEENPLAYERTXT, PLAYERTXTX + PLAYERTXTLENGTH, PLAYERTXTYSPACE);
		m_txtPlayer2.setEnabled(false);
		/**
		* Creates a text field for player 3's name to be entered
		*/
		m_txtPlayer3 = new JTextField();
		this.add(m_txtPlayer3);
		m_txtPlayer3.setBounds(PLAYERTXTX, PLAYERTXTYBOTTOM + YBETWEENPLAYERTXT + YBETWEENPLAYERTXT,
			PLAYERTXTX + PLAYERTXTLENGTH, PLAYERTXTYSPACE);
		m_txtPlayer3.setEnabled(false);
		/**
		* Creates a text field for player 4's name to be entered
		*/
		m_txtPlayer4 = new JTextField();
		this.add(m_txtPlayer4);
		m_txtPlayer4.setEnabled(false);
		m_txtPlayer4.setBounds(PLAYERTXTX, PLAYERTXTYBOTTOM + YBETWEENPLAYERTXT + YBETWEENPLAYERTXT + YBETWEENPLAYERTXT, 
			PLAYERTXTX + PLAYERTXTLENGTH, PLAYERTXTYSPACE);
		/**
		* Creates a check box that enables the user to tick whether player 1 is present in the game
		*/
		m_chckbxPlayer1 = new JCheckBox("Player 1", true);
		this.add(m_chckbxPlayer1);
		m_chckbxPlayer1.setBounds(CHCKBXX, CHCKBXY, CHCKBXWIDTH, CHCKBXHEIGHT);
		m_chckbxPlayer1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(m_txtPlayer1.isEnabled() == true) {
					m_txtPlayer1.setEnabled(false);
					btnRollDice1.setEnabled(false);
					playerRolls[0] = 0;
					ply1DiceLabel.setText("");
				} else {
					m_txtPlayer1.setEnabled(true);
					btnRollDice1.setEnabled(true);
				}
			}
		});
		/**
		* Creates a check box that enables the user to tick whether player 2 is present in the game
		*/
		m_chckbxPlayer2 = new JCheckBox("Player 2");
		this.add(m_chckbxPlayer2);
		m_chckbxPlayer2.setBounds(CHCKBXX, CHCKBXY + CHCKBXYSPACE, CHCKBXWIDTH, CHCKBXHEIGHT);
		m_chckbxPlayer2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(m_txtPlayer2.isEnabled() == true) {
					m_txtPlayer2.setEnabled(false);
					btnRollDice2.setEnabled(false);
					playerRolls[1] = 0;
					ply2DiceLabel.setText("");
				} else {
					m_txtPlayer2.setEnabled(true);
					btnRollDice2.setEnabled(true);
				}
			}
		});
		/**
		* Creates a check box that enables the user to tick whether player 3 is present in the game
		*/
		m_chckbxPlayer3 = new JCheckBox("Player 3");
		this.add(m_chckbxPlayer3);
		m_chckbxPlayer3.setBounds(CHCKBXX, CHCKBXY + CHCKBXYSPACE + CHCKBXYSPACE, CHCKBXWIDTH, CHCKBXHEIGHT);
		m_chckbxPlayer3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(m_txtPlayer3.isEnabled() == true) {
					m_txtPlayer3.setEnabled(false);
					btnRollDice3.setEnabled(false);
					playerRolls[2] = 0;
					ply3DiceLabel.setText("");
				} else {
					m_txtPlayer3.setEnabled(true);
					btnRollDice3.setEnabled(true);
				}
			}
		});
		/**
		* Creates a check box that enables the user to tick whether player 4 is present in the game
		*/
		m_chckbxPlayer4 = new JCheckBox("Player 4");
		this.add(m_chckbxPlayer4);
		m_chckbxPlayer4.setBounds(CHCKBXX, CHCKBXY + CHCKBXYSPACE + CHCKBXYSPACE + CHCKBXYSPACE, CHCKBXWIDTH, CHCKBXHEIGHT);
		m_chckbxPlayer4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(m_txtPlayer4.isEnabled() == true) {
					m_txtPlayer4.setEnabled(false);
					btnRollDice4.setEnabled(false);
					playerRolls[3] = 0;
					ply4DiceLabel.setText("");
				} else {
					m_txtPlayer4.setEnabled(true);
					btnRollDice4.setEnabled(true);
				}
			}
		});
		/**
		* Integer variables that are final so will not change during the interaction with the form
		* Declares sizes of the colour radio button that allows players to choose colours.
		*/
		final int LFTBUTTONX = 321;
		final int RGHTBUTTONX = 460;
		final int BUTTONWDTH = 109;
		final int BUTTONHGHT = 23;
		final int PLY1BUTY = 101;
		final int PLY2BUTY = 176;
		final int PLY3BUTY = 251;
		final int PLY4BUTY = 326;
		final int PLYBUTYSPACE = 35;
		/**
		* Creates a radio button for player 1 to select blue
		* Also add this button to the button group of player 1
		*/
		m_player1Blue = new JRadioButton("Blue", true);
		this.add(m_player1Blue);
		bGroup.add(m_player1Blue);
		m_player1Blue.setBackground(Color.BLUE);
		m_player1Blue.setForeground(Color.WHITE);
		m_player1Blue.setBounds(LFTBUTTONX, PLY1BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player1Blue.setActionCommand("Blue");
		/**
		* Creates a radio button for player 1 to select red
		* Also add this button to the button group of player 1
		*/
		m_player1Red = new JRadioButton("Red");
		this.add(m_player1Red);
		bGroup.add(m_player1Red);
		m_player1Red.setBackground(Color.RED);
		m_player1Red.setForeground(Color.WHITE);
		m_player1Red.setBounds(LFTBUTTONX, PLY1BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player1Red.setActionCommand("Red");
		/**
		* Creates a radio button for player 1 to select yellow
		* Also add this button to the button group of player 1
		*/
		m_player1Yellow = new JRadioButton("Yellow");
		this.add(m_player1Yellow);
		bGroup.add(m_player1Yellow);
		m_player1Yellow.setBackground(Color.YELLOW);
		m_player1Yellow.setBounds(RGHTBUTTONX, PLY1BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player1Yellow.setActionCommand("Yellow");
		/**
		* Creates a radio button for player 1 to select black
		* Also add this button to the button group of player 1
		*/
		m_player1Black = new JRadioButton("Black");
		this.add(m_player1Black);
		bGroup.add(m_player1Black);
		m_player1Black.setBackground(Color.BLACK);
		m_player1Black.setForeground(Color.WHITE);
		m_player1Black.setBounds(RGHTBUTTONX, PLY1BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player1Black.setActionCommand("Black");
		/**
		* Creates a radio button for player 2 to select blue
		* Also add this button to the button group of player 2
		*/
		m_player2Blue = new JRadioButton("Blue");
		this.add(m_player2Blue);
		bGroup_1.add(m_player2Blue);
		m_player2Blue.setBackground(Color.BLUE);
		m_player2Blue.setForeground(Color.WHITE);
		m_player2Blue.setBounds(LFTBUTTONX, PLY2BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player2Blue.setActionCommand("Blue");
		/**
		* Creates a radio button for player 2 to select red
		* Also add this button to the button group of player 2
		*/
		m_player2Red = new JRadioButton("Red", true);
		this.add(m_player2Red);
		bGroup_1.add(m_player2Red);
		m_player2Red.setBackground(Color.RED);
		m_player2Red.setForeground(Color.WHITE);
		m_player2Red.setBounds(LFTBUTTONX, PLY2BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player2Red.setActionCommand("Red");
		/**
		* Creates a radio button for player 2 to select yellow
		* Also add this button to the button group of player 2
		*/
		m_player2Yellow = new JRadioButton("Yellow");
		this.add(m_player2Yellow);
		bGroup_1.add(m_player2Yellow);
		m_player2Yellow.setBackground(Color.YELLOW);
		m_player2Yellow.setBounds(RGHTBUTTONX, PLY2BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player2Yellow.setActionCommand("Yellow");
		/**
		* Creates a radio button for player 2 to select black
		* Also add this button to the button group of player 2
		*/
		m_player2Black = new JRadioButton("Black");
		this.add(m_player2Black);
		bGroup_1.add(m_player2Black);
		m_player2Black.setBackground(Color.BLACK);
		m_player2Black.setForeground(Color.WHITE);
		m_player2Black.setBounds(RGHTBUTTONX, PLY2BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player2Black.setActionCommand("Black");
		/**
		* Creates a radio button for player 3 to select blue
		* Also add this button to the button group of player 3
		*/
		m_player3Blue = new JRadioButton("Blue");
		this.add(m_player3Blue);
		bGroup_2.add(m_player3Blue);
		m_player3Blue.setBackground(Color.BLUE);
		m_player3Blue.setForeground(Color.WHITE);
		m_player3Blue.setBounds(LFTBUTTONX, PLY3BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player3Blue.setActionCommand("Blue");
		/**
		* Creates a radio button for player 3 to select red
		* Also add this button to the button group of player 3
		*/
		m_player3Red = new JRadioButton("Red");
		this.add(m_player3Red);
		bGroup_2.add(m_player3Red);
		m_player3Red.setBackground(Color.RED);
		m_player3Red.setForeground(Color.WHITE);
		m_player3Red.setBounds(LFTBUTTONX, PLY3BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player3Red.setActionCommand("Red");
		/**
		* Creates a radio button for player 3 to select yellow
		* Also add this button to the button group of player 3
		*/
		m_player3Yellow = new JRadioButton("Yellow", true);
		this.add(m_player3Yellow);
		bGroup_2.add(m_player3Yellow);
		m_player3Yellow.setBackground(Color.YELLOW);
		m_player3Yellow.setBounds(RGHTBUTTONX, PLY3BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player3Yellow.setActionCommand("Yellow");
		/**
		* Creates a radio button for player 3 to select black
		* Also add this button to the button group of player 3
		*/
		m_player3Black = new JRadioButton("Black");
		this.add(m_player3Black);
		bGroup_2.add(m_player3Black);
		m_player3Black.setBackground(Color.BLACK);
		m_player3Black.setForeground(Color.WHITE);
		m_player3Black.setBounds(RGHTBUTTONX, PLY3BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player3Black.setActionCommand("Black");
		/**
		* Creates a radio button for player 3 to select blue
		* Also add this button to the button group of player 3
		*/
		m_player4Blue = new JRadioButton("Blue");
		this.add(m_player4Blue);
		bGroup_3.add(m_player4Blue);
		m_player4Blue.setBackground(Color.BLUE);
		m_player4Blue.setForeground(Color.WHITE);
		m_player4Blue.setBounds(LFTBUTTONX, PLY4BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player4Blue.setActionCommand("Blue");
		/**
		* Creates a radio button for player 4 to select red
		* Also add this button to the button group of player 4
		*/
		m_player4Red = new JRadioButton("Red");
		this.add(m_player4Red);
		bGroup_3.add(m_player4Red);
		m_player4Red.setBackground(Color.RED);
		m_player4Red.setForeground(Color.WHITE);
		m_player4Red.setBounds(LFTBUTTONX, PLY4BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player4Red.setActionCommand("Red");
		/**
		* Creates a radio button for player 4 to select yellow
		* Also add this button to the button group of player 4
		*/
		m_player4Yellow = new JRadioButton("Yellow");
		this.add(m_player4Yellow);
		bGroup_3.add(m_player4Yellow);
		m_player4Yellow.setBackground(Color.YELLOW);
		m_player4Yellow.setBounds(RGHTBUTTONX, PLY4BUTY, BUTTONWDTH, BUTTONHGHT);
		m_player4Yellow.setActionCommand("Yellow");
		/**
		* Creates a radio button for player 4 to select black
		* Also add this button to the button group of player 4
		*/
		m_player4Black = new JRadioButton("Black", true);
		this.add(m_player4Black);
		bGroup_3.add(m_player4Black);
		m_player4Black.setBackground(Color.BLACK);
		m_player4Black.setForeground(Color.WHITE);
		m_player4Black.setBounds(RGHTBUTTONX, PLY4BUTY + PLYBUTYSPACE, BUTTONWDTH, BUTTONHGHT);
		m_player4Black.setActionCommand("Black");
		/**
		* Integer variables that are final so will not change during the interaction with the form
		* Declares snakes and ladders spinner box sizes along with the dimensions of the start button.
		*/
		final int SNKSPNNRX = 202;
 		final int LDDRSPNNRX = 440;
		final int SPNNRY = 429;
		final int SPNNRWDTH = 29;
		final int SPNNRHGHT = 20;
		final int SNKLBLX = 146;
		final int LDDRLBLX = 371;
		final int SPNNRLBLY = 432;
		final int SPNNRLBLWDTH = 56;
		final int SPNNRLBLHGHT = 14;
		final int SPNNRMIN = 0;
		final int SPNNRMAX = 8;
		final int STRTBTTNX = 396;
		final int STRTBTTNY = 485;
		final int STRTBTTNWDTH = 173;
		final int STRTBTTNHGHT = 38;		
		/**
		* Creates a spinner with the value of 0
		* This is so the user can select up to 8 snakes
		*/
		final JSpinner m_spinnerSnakes = new JSpinner();
		this.add(m_spinnerSnakes);
		m_spinnerSnakes.setModel(new SpinnerNumberModel(0, SPNNRMIN, SPNNRMAX, 1));
		m_spinnerSnakes.setBounds(SNKSPNNRX, SPNNRY, SPNNRWDTH, SPNNRHGHT);
		/**
		* Creates a spinner with the value of 0
		* This is so the user can select up to 8 ladders
		*/
		final JSpinner m_spinnerLadders = new JSpinner();
		this.add(m_spinnerLadders);
		m_spinnerLadders.setModel(new SpinnerNumberModel(0, SPNNRMIN, SPNNRMAX, 1));
		m_spinnerLadders.setBounds(LDDRSPNNRX, SPNNRY, SPNNRWDTH, SPNNRHGHT);
		/**
		* Creates a label for the spinner snakes
		*/
		JLabel m_lblSnake = new JLabel("Snakes:");
		this.add(m_lblSnake);
		m_lblSnake.setBounds(SNKLBLX, SPNNRLBLY, SPNNRLBLWDTH, SPNNRLBLHGHT);
		/**
		* Creates a label for the spinner ladders
		*/	
		JLabel m_lblLadders = new JLabel("Ladders:");
		this.add(m_lblLadders);
		m_lblLadders.setBounds(LDDRLBLX, SPNNRLBLY, SPNNRLBLWDTH, SPNNRLBLHGHT);
		/**
		* Creates a button named start game to create the board and start the game
		*/
		JButton m_btnStartGame = new JButton("Start Game");
		this.add(m_btnStartGame);
		m_btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createBoard((int)m_spinnerLadders.getValue(),(int)m_spinnerSnakes.getValue(), playerRolls);
			}
		});
		m_btnStartGame.setBounds(STRTBTTNX, STRTBTTNY, STRTBTTNWDTH, STRTBTTNHGHT);
		/**
		* Integer variables that are final so will not change during the interaction with the form
		* Declares dice roll label and dice roll button positions & sizes.
		*/
		final int RDLBLX = 680;
		final int RDLBLY = 122;
		final int RDLBLYSPACE = 75;
		final int RDLBLWIDTH = 90;
		final int RDLBLHEIGHT = 14;
		final int RDBTTNX = 575;
		final int RDBTTNY = 121;
		final int RDBTTNYSPACE = 73;
		final int RDBTTNWIDTH = 100;
		final int RDBTTNHEIGHT = 20;
		/**
		* Sets the 4 dice labels
		*/
		ply1DiceLabel = new JLabel("");
		ply1DiceLabel.setBounds(RDLBLX, RDLBLY, RDLBLWIDTH, RDLBLHEIGHT);
		this.add(ply1DiceLabel);
		ply2DiceLabel = new JLabel("");
		ply2DiceLabel.setBounds(RDLBLX, RDLBLY + RDLBLYSPACE, RDLBLWIDTH, RDLBLHEIGHT);
		this.add(ply2DiceLabel);
		ply3DiceLabel = new JLabel("");
		ply3DiceLabel.setBounds(RDLBLX, RDLBLY + RDLBLYSPACE + RDLBLYSPACE, RDLBLWIDTH, RDLBLHEIGHT);
		this.add(ply3DiceLabel);
		ply4DiceLabel = new JLabel("");
		ply4DiceLabel.setBounds(RDLBLX, RDLBLY + RDLBLYSPACE + RDLBLYSPACE + RDLBLYSPACE, RDLBLWIDTH, RDLBLHEIGHT);
		this.add(ply4DiceLabel);
		/**
		* Sets a button to roll player 1 dice
		*/
		btnRollDice1 = new JButton("Roll Dice");
		btnRollDice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do {
					playerRolls[0] = m_die.getDiceRoll();
					ply1DiceLabel.setText("Rolled: " + playerRolls[0]);
				} while(playerRolls[0] == playerRolls[1] || playerRolls[0] == playerRolls[2] || playerRolls[0] == playerRolls[3]);
				ply1DiceLabel.setText("Rolled: " + playerRolls[0]);
			}
		});
		btnRollDice1.setBounds(RDBTTNX, RDBTTNY, RDBTTNWIDTH, RDBTTNHEIGHT);
		this.add(btnRollDice1);
		/**
		* Sets a button to roll player 2 dice
		*/
		btnRollDice2 = new JButton("Roll Dice");
		btnRollDice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do {
					playerRolls[1] = m_die.getDiceRoll();
				} while(playerRolls[1] == playerRolls[0] || playerRolls[1] == playerRolls[2] || playerRolls[1] == playerRolls[3]);
				ply2DiceLabel.setText("Rolled: " + playerRolls[1]);
			}
		});
		btnRollDice2.setBounds(RDBTTNX, RDBTTNY + RDBTTNYSPACE, RDBTTNWIDTH, RDBTTNHEIGHT);
		btnRollDice2.setEnabled(false);
		this.add(btnRollDice2);
		/**
		* Sets a button to roll player 3 dice
		*/
		btnRollDice3 = new JButton("Roll Dice");
		btnRollDice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do {
					playerRolls[2] = m_die.getDiceRoll();
				} while(playerRolls[2] == playerRolls[0] || playerRolls[2] == playerRolls[1] || playerRolls[2] == playerRolls[3]);
				ply3DiceLabel.setText("Rolled: " + playerRolls[2]);
			}
		});
		btnRollDice3.setBounds(RDBTTNX, RDBTTNY + RDBTTNYSPACE + RDBTTNYSPACE, RDBTTNWIDTH, RDBTTNHEIGHT);
		btnRollDice3.setEnabled(false);
		this.add(btnRollDice3);
		/**
		* Sets a button to roll player 4 dice
		*/
		btnRollDice4 = new JButton("Roll Dice");
		btnRollDice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do {
					playerRolls[3] = m_die.getDiceRoll();
				} while(playerRolls[3] == playerRolls[0] || playerRolls[3] == playerRolls[1] || playerRolls[3] == playerRolls[2]);
				ply4DiceLabel.setText("Rolled: " + playerRolls[3]);
			}
		});
		btnRollDice4.setBounds(RDBTTNX, RDBTTNY + RDBTTNYSPACE + RDBTTNYSPACE + RDBTTNYSPACE, RDBTTNWIDTH, RDBTTNHEIGHT);
		btnRollDice4.setEnabled(false);
		this.add(btnRollDice4);
	}
	/**
	* @param m_ladders
	* @param m_snakes
	* @param PLAYERPIECES
	* @return Creates a game board to start the game
	* The create board method takes in the amount of snakes and ladders the user has requested
	* It then checks whether the name and colour inputs are acceptable before creating an array of pieces.
	* The method will then close this form and create a board.
	*/
	public void createBoard(int m_ladders, int m_snakes, int playerRolls[]) {
		/**
		* Creates a final integer of the amount of players that are playing
		*/
		final int PLAYERPIECES = 4;
		/**
		* Checks if the names and colours are both acceptable
		* If so, an array of SnlPiece will be made assigning names and colours
		* After the array creation, this frame will be closed and a board created
		* passing the array of pieces along with the amount of snakes and ladders.
		*/
		if (checkPlayersNameRoll(playerRolls) && checkPlayerColours()) {
		    /**
			* Creates an array of all possible pieces
			*/
			SnlPiece[] m_allPieces = new SnlPiece[PLAYERPIECES];
			m_allPieces[0] = new SnlPiece(m_txtPlayer1.getText(), bGroup.getSelection().getActionCommand(), m_player1Order);
			m_allPieces[1] = new SnlPiece(m_txtPlayer2.getText(), bGroup_1.getSelection().getActionCommand(), m_player2Order);
			m_allPieces[2] = new SnlPiece(m_txtPlayer3.getText(), bGroup_2.getSelection().getActionCommand(), m_player3Order);
			m_allPieces[3] = new SnlPiece(m_txtPlayer4.getText(), bGroup_3.getSelection().getActionCommand(), m_player4Order);
			/**
			* Creates an array of all game pieces
			*/
			SnlPiece[] m_gamePieces = new SnlPiece[m_players];
			int m_gamePieceCount = 0;
			for (int x = 0; x < PLAYERPIECES; x++){
				if (!m_allPieces[x].getPlayerName().equals("")) {
					m_gamePieces[m_gamePieceCount] = new SnlPiece(m_allPieces[x].getPlayerName(), m_allPieces[x].getPlayerColor(), m_allPieces[x].getPlayerOrder());
					System.out.println(m_gamePieceCount);
					m_gamePieceCount++;
				}
			}
			/**
			* Closes this frame and creates a board for the game to begin
			*/
			this.dispose();
			
			for(int i = 0; i<m_gamePieceCount;i++){
				System.out.println(m_gamePieces[i].toString()+"==================");
			}
			SnlBoard m_snlboard = new SnlBoard(m_gamePieces, m_snakes, m_ladders, m_gamePieceCount);
			
			m_snlboard.displayBoard();
		}	
	}
	/**
	* @return Returns a boolean depending on whether the players colour are different
	* This method checks if the colours of two players are the same and displays a message if so.
	* If the colours are unique then the method will return true.
	*/
	public boolean checkPlayerColours() {
		/**
		* Checks player 1's colour with other players to check for clash
		*/
		if (m_chckbxPlayer1.isSelected() == true){
			if (m_chckbxPlayer2.isSelected() == true){
				if (bGroup.getSelection().getActionCommand().equals(bGroup_1.getSelection().getActionCommand())) {
					JOptionPane.showMessageDialog(null,"2 Players Can not have the same colour!!", "Colour Clash!", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			if (m_chckbxPlayer3.isSelected() == true){
				if (bGroup.getSelection().getActionCommand().equals(bGroup_2.getSelection().getActionCommand())) {
					JOptionPane.showMessageDialog(null,"2 Players Can not have the same colour!!", "Colour Clash!", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			if (m_chckbxPlayer4.isSelected() == true){
				if (bGroup.getSelection().getActionCommand().equals(bGroup_3.getSelection().getActionCommand())) {
					JOptionPane.showMessageDialog(null,"2 Players Can not have the same colour!!", "Colour Clash!", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		/**
		* Checks player 2's colour with remaining other players that have not been checked for clash
		*/
		if (m_chckbxPlayer2.isSelected() == true){
			if (m_chckbxPlayer3.isSelected() == true){
				if (bGroup_1.getSelection().getActionCommand().equals(bGroup_2.getSelection().getActionCommand())) {
					JOptionPane.showMessageDialog(null,"2 Players Can not have the same colour!!", "Colour Clash!", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			if (m_chckbxPlayer4.isSelected() == true){
				if (bGroup_1.getSelection().getActionCommand().equals(bGroup_3.getSelection().getActionCommand())) {
					JOptionPane.showMessageDialog(null,"2 Players Can not have the same colour!!", "Colour Clash!", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		/**
		* Checks player 3's colour with remaining other players that have not been checked for clash
		*/
		if (m_chckbxPlayer3.isSelected() == true){
			if (m_chckbxPlayer3.isSelected() == true){
				if (bGroup_2.getSelection().getActionCommand().equals(bGroup_3.getSelection().getActionCommand())) {
					JOptionPane.showMessageDialog(null,"2 Players Can not have the same colour!!", "Colour Clash!", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}
	/**
	* @return Returns a boolean depending on whether the players name field contain values
	* This method checks if the names of participating players are empty and displays a message if so.
	* If the name fields of the players playing do contain content then the method will return true.
	*/
	public static boolean checkPlayersNameRoll(int[] playerRolls) {
		/**
		* Sets m_canPlay and m_gotPlayer variables up so this method can check that there is more than 1 player
		* and that the names are not empty values.
		*/
		boolean m_canPlay = true;
		int m_gotPlayer = 0;
		/**
		* Checks if player 1's check box is ticked and if so checks if the name is valid
		* if it is not it will return a message and false value to the m_canPlay variable
		* Regardless of the validity of the name, the player amount will be incremented
		*/
		if (m_chckbxPlayer1.isSelected() == true){
			if(m_txtPlayer1.getText().equals("")) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Please input a valid name for player 1.");
			}
			if(playerRolls[0] == 0) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Player 1 need to roll the dice.");
			}
			m_gotPlayer++;
		}
		/**
		* Checks if player 2's check box is ticked and if so checks if the name is valid
		* if it is not it will return a message and false value to the m_canPlay variable
		* Regardless of the validity of the name, the player amount will be incremented
		*/
		if (m_chckbxPlayer2.isSelected() == true){
			if(m_txtPlayer2.getText().equals("")) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Please input a valid name for player 2.");
			}
			if(playerRolls[1] == 0) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Player 2 need to roll the dice.");
			}
			m_gotPlayer++;
		}
		/**
		* Checks if player 3's check box is ticked and if so checks if the name is valid
		* if it is not it will return a message and false value to the m_canPlay variable
		* Regardless of the validity of the name, the player amount will be incremented
		*/
		if (m_chckbxPlayer3.isSelected() == true){
			if(m_txtPlayer3.getText().equals("")) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Please input a valid name for player 3.");
			}
			if(playerRolls[2] == 0) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Player 3 need to roll the dice.");
			}
			m_gotPlayer++;
		}
		/**
		* Checks if player 4's check box is ticked and if so checks if the name is valid
		* if it is not it will return a message and false value to the m_canPlay variable
		* Regardless of the validity of the name, the player amount will be incremented
		*/
		if (m_chckbxPlayer4.isSelected() == true){
			if(m_txtPlayer4.getText().equals("")) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Please input a valid name for player 4.");
			}
			if(playerRolls[3] == 0) {
				m_canPlay = false;
				JOptionPane.showMessageDialog(null,"Player 4 need to roll the dice.");
			}
			m_gotPlayer++;
		}
		/**
		* Refreshes the order of the player to 0
		* Sets the order of the players by taking the dice roll array
		*/
		refreshOrders();
		int m_highestRoll = 1;
		int m_lowestRoll = 7;
		/**
		* Finds the player with the highest roll and sets their order to 1
		*/
		if(playerRolls[0] >= playerRolls[1]) {
			m_highestRoll = playerRolls[0];
		} else {
			m_highestRoll = playerRolls[1];
		}
		if(playerRolls[2] >= m_highestRoll) {
				m_highestRoll = playerRolls[2];
		}
		if(playerRolls[3] >= m_highestRoll) {
				m_highestRoll = playerRolls[3];
		}
		if(playerRolls[0] == m_highestRoll) {
				m_player1Order = 1;
		}
		if(playerRolls[1] == m_highestRoll) {
				m_player2Order = 1;
		}
		if(playerRolls[2] == m_highestRoll) {
				m_player3Order = 1;
		}
		if(playerRolls[3] == m_highestRoll) {
				m_player4Order = 1;
		}
		/**
		* Finds the player with the lowest roll and sets their order to 4
		*/
		if(playerRolls[0] <= playerRolls[1]) {
			m_lowestRoll = playerRolls[0];
		} else {
			m_lowestRoll = playerRolls[1];
		}
		if(playerRolls[2] <= m_lowestRoll) {
				m_lowestRoll = playerRolls[2];
		}
		if(playerRolls[3] <= m_lowestRoll) {
				m_lowestRoll = playerRolls[3];
		}
		if(playerRolls[0] == m_lowestRoll) {
				m_player1Order = 4;
		} else if(playerRolls[1] == m_lowestRoll) {
				m_player2Order = 4;
		} else if(playerRolls[2] == m_lowestRoll) {
				m_player3Order = 4;
		} else if(playerRolls[3] == m_lowestRoll) {
				m_player4Order = 4;
		}		
		/**
		* Since the first and forth orders are set, this compares the other to values
		* to determine which players have an ordering of two and three.
		*/
		if(m_player1Order == 0 && m_player2Order == 0) {
			if(playerRolls[0] >= playerRolls[1]) {
				m_player1Order = 2;
				m_player2Order = 3;
			} else {
				m_player1Order = 3;
				m_player2Order = 2;
			}
		}
		if(m_player1Order == 0 && m_player3Order == 0) {
			if(playerRolls[0] >= playerRolls[2]) {
				m_player1Order = 2;
				m_player3Order = 3;
			} else {
				m_player1Order = 3;
				m_player3Order = 2;
			}
		}
		if(m_player1Order == 0 && m_player4Order == 0) {
			if(playerRolls[0] >= playerRolls[3]) {
				m_player1Order = 2;
				m_player4Order = 3;
			} else {
				m_player1Order = 3;
				m_player4Order = 2;
			}
		}
		if(m_player2Order == 0 && m_player3Order == 0) {
			if(playerRolls[1] >= playerRolls[2]) {
				m_player2Order = 2;
				m_player3Order = 3;
			} else {
				m_player2Order = 3;
				m_player3Order = 2;
			}
		}
		if(m_player2Order == 0 && m_player4Order == 0) {
			if(playerRolls[1] >= playerRolls[3]) {
				m_player2Order = 2;
				m_player4Order = 3;
			} else {
				m_player2Order = 3;
				m_player4Order = 2;
			}
		}
		if(m_player3Order == 0 && m_player4Order == 0) {
			if(playerRolls[2] >= playerRolls[3]) {
				m_player3Order = 2;
				m_player4Order = 3;
			} else {
				m_player3Order = 3;
				m_player4Order = 2;
			}
		}
		/**
		* Sets the amount of players to the amount of valid entries on the form 
		*/
		m_players = m_gotPlayer;
		/**
		* Checks if there is more than 1 player and if so checks if the m_canPlay variable is true
		* If both statements hold then the whole method will return true
		* If there is less than two players then a message will be displayed
		* False will be displayed if true is not
		*/
		if (m_gotPlayer > 1) {
			if (m_canPlay) {
				return true;
			}
		} else {
			JOptionPane.showMessageDialog(null,"This game requires at least two players.");
		}
		return false;
	}
	/**
	* Refreshes the order of players to 0
	*/
	public static void refreshOrders() {
		m_player1Order = 0;
		m_player2Order = 0;
		m_player3Order = 0;
		m_player4Order = 0;
	}
}