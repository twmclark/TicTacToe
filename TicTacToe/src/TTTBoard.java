/**
 * @file Board.java
 * @Author Twm Clark (twmclark@gmail.com)
 * @date   December, 2014
 * @brief  Generates a tic tac toe board
 *
 * This class will generate a tic tac toe board with the corresponding components
 * for example restart button, player names etc.
 * it is also responsible for checking for a winning player after each move
 * and displaying a new JFrame with the winners name
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
public class TTTBoard implements ActionListener{

/*Creates and opens a JFrame containing the board, 
 * player names, title and restart button
 * @param player1 the first player object
 * @param player2 the second player object
 */
 public  void launchWindow(TTTPiece player1, TTTPiece player2){
     displayTime();
	 m_player1pos = player1.getPosition();
	 m_player2pos = player2.getPosition();
        //create a new jframe
     final JFrame master = new JFrame();
     master.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
master.getContentPane().setBackground(Color.ORANGE);
     master.setSize(MASTER_WIDTH,MASTER_HEIGHT);
     master.setLayout(null);
     master.setResizable(false);
         final JPanel window = new JPanel();
         window.setMinimumSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
         window.setMaximumSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
         window.setPreferredSize(new Dimension());
 
        window.setLayout(new GridLayout(8,8));
           
        //Generate 64 buttons and insert into the buttons array
         for(int i=0; i<=63; i++){
                buttons[i] = new JButton();
                buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
                buttons[i].setBackground(Color.white);
                buttons[i].setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT)); // set the size of the button
                // add the button to the window JPanel
                window.add(buttons[i]); 
                //Give the buttons an actionlistener
                buttons[i].addActionListener(this);
            }
      
         JLabel titleLabel = new JLabel();
         titleLabel.setSize(TITLE_LABEL_WIDTH,TITLE_LABEL_HEIGHT);
         ImageIcon title = new ImageIcon(getClass().getResource("/image/title.png"));
         titleLabel.setIcon(title);
        window.setBounds(80, 150, WINDOW_WIDTH,WINDOW_HEIGHT);
        window.setVisible(true);
        
        /*
         * This button will restart the game
         * it uses a for loop to reenable all the buttons in the buttons array,
         * resets each buttons text and its color.
         * 
         */
        JButton restart = new JButton("Restart");
        restart.addActionListener(
        	
        		new ActionListener(){
        			public void actionPerformed(ActionEvent e){
        				//create a new game
        				Group09application Frame = new Group09application();
        				master.setVisible(false); 
        				master.dispose();// remove the JFrame
        	            }
        			
        		}
        		
        		);
        /*
         * set the position and size of the restart button
         */
        restart.setBounds(RESTART_BTN_X,RESTART_BTN_Y,RESTART_BTN_WIDTH,RESTART_BTN_HEIGHT);
        
        /* create a new font to be used to display the player names */
        Font myFont = new Font("Times New Roman", Font.PLAIN ,8);
        Font newFont = myFont.deriveFont(30F);
        /* */
        m_player1Name =player1.getName();
        m_player2Name =player2.getName();

        
        
        player1Text.setText("Player 1: "+m_player1Name);
        player2Text.setText("Player 2:"+m_player2Name);
        player1Text.setFont(newFont);
        player1Text.setBounds(PLAYER1_TEXTBOX_X_BOUND,PLAYER1_TEXTBOX_Y_BOUND, 
        									PLAYER_TEXTBOX_WIDTH,PLAYER_TEXTBOX_HEIGHT);
        player2Text.setFont(newFont);
        player2Text.setBounds(PLAYER2_TEXTBOX_X_BOUND,PLAYER2_TEXTBOX_Y_BOUND,
        									PLAYER_TEXTBOX_WIDTH,PLAYER_TEXTBOX_HEIGHT);
        
      
        
        master.add(player1Text);
        master.add(player2Text);
        master.add(restart);
        master.add(titleLabel);
        master.add(window);
        time.setBounds(TIME_WIDTH,TIME_HEIGHT,TIME_X_BOUND,TIME_Y_BOUND);
        master.add(time);
        
        master.setVisible(true);
         changePlayer();
         
	  
     
 
 
	};
 
 
  /*@brief creates an actionlistener, checks who's turn it is and adds that players symbol to the button
   * 
   */
@Override
public void actionPerformed(ActionEvent clickedButton) {
     

	
    JButton pressedButton = (JButton)clickedButton.getSource();
    pressedButton.setBackground(Color.LIGHT_GRAY);
   		   
    if(m_turn==1){
    	
        pressedButton.setText(NAUGHT);
        m_turn = 2;
        checkWin();
         
    }else{
    	

    	
        pressedButton.setText(CROSS);
        m_turn = 1;
        checkWin();
    }
      changePlayer();
pressedButton.setEnabled(false);
        
}
/*
 * Method to check the board for a winning player, if a winner is found
 * the combination of winning buttons is highlighted red
 * @param none
 * 
 */

 public Boolean checkWin(){
     
     for(int i=0;i<=59;i++){ //loop through the list of buttons to button 59
                            //more than 59 not required as a winning row starts 5 spaces before the end
         if(
                 //check for 5 horizontal buttons in a row with the same text
                 buttons[i].getText().equals(buttons[i+1].getText())
                 &&buttons[i+2].getText().equals(buttons[i].getText())
                 &&buttons[i+3].getText().equals(buttons[i].getText())
                 &&buttons[i+4].getText().equals(buttons[i].getText())
                 &&buttons[i].getText()!= "")//check to make sure the button is not empty
         {
             buttons[i].setBackground(Color.red);
             buttons[i+1].setBackground(Color.red);
             buttons[i+2].setBackground(Color.red);
             buttons[i+3].setBackground(Color.red);
             buttons[i+4].setBackground(Color.red);
             displayWinner(buttons[i].getText());
             System.out.println("win");
             disableButtons();
             // run the method to remove action listeners
             return true;
         }
     }
     //check for vertical wins up to 32 positions before the end (to prevent out of bounds error)
     for(int i=0;i<=31;i++){
         if(buttons[i].getText().equals(buttons[i+8].getText())&&
                 buttons[i].getText().equals(buttons[i+16].getText())&&
                 buttons[i].getText().equals(buttons[i+24].getText())&&
                 buttons[i].getText().equals(buttons[i+32].getText())
            &&buttons[i].getText()!= ""){
              
             buttons[i].setBackground(Color.red);
             buttons[i+8].setBackground(Color.red);
             buttons[i+16].setBackground(Color.red);
             buttons[i+24].setBackground(Color.red);
             buttons[i+32].setBackground(Color.red);
             displayWinner(buttons[i].getText());

             System.out.println("win");
             disableButtons();
             return true;
         }
     }
     //check for horizontal wins
     for(int i=0;i<=27;i++){
         if(
                 (buttons[i].getText().equals(buttons[i+9].getText())&&
                 buttons[i].getText().equals(buttons[i+18].getText())&&
                 buttons[i].getText().equals(buttons[i+27].getText())&&
                 buttons[i].getText().equals(buttons[i+36].getText())
            &&buttons[i].getText()!= ""))
         {
             buttons[i].setBackground(Color.red);
             buttons[i+9].setBackground(Color.red);
             buttons[i+18].setBackground(Color.red);
             buttons[i+27].setBackground(Color.red);
             buttons[i+36].setBackground(Color.red);
             displayWinner(buttons[i].getText());
             System.out.println("win");
             disableButtons();
             return true;
         }
     }
     for(int i=0;i<=35;i++){
         if(buttons[i].getText().equals(buttons[i+7].getText())&&
                 buttons[i].getText().equals(buttons[i+14].getText())&&
                 buttons[i].getText().equals(buttons[i+21].getText())&&
                 buttons[i].getText().equals(buttons[i+28].getText())
            &&buttons[i].getText()!= ""){
              
             buttons[i].setBackground(Color.red);
             buttons[i+7].setBackground(Color.red);
             buttons[i+14].setBackground(Color.red);
             buttons[i+21].setBackground(Color.red);
             buttons[i+28].setBackground(Color.red);
             displayWinner(buttons[i].getText());
             System.out.println("win");
             disableButtons();
             return true;
         }
         }
      
      
    return false;
 
 }
  
 //removes the ability to click buttons by removing all actionlisteners
 public void disableButtons(){
     for(int i=0; i<=63; i++){
    
          
            buttons[i].setEnabled(false);

        
 }
     }
 /**@param winner the player who won the game
  * displays a screen which displays the winners name */
 public void displayWinner(String winner){
	 
	 
     JFrame winFrame = new JFrame();
     winFrame.setSize(800,400);
     winFrame.setVisible(true);
     JLabel label = new JLabel();
     label.setFont(new Font("Arial", Font.PLAIN, 70));

     if(winner.equals("o")){
    	 label.setText(m_player1Name+" Wins!");
    	 
     }else{
    	 label.setText(m_player2Name+" Wins!");
     }
      winFrame.add(label);
 }
  public void changePlayer(){
      Border border = BorderFactory.createLineBorder(Color.blue,5);

	  if(m_turn==m_player1pos){
      	player1Text.setBorder(border);
      	player2Text.setBorder(null);

      }else{
      	player1Text.setBorder(null);
      	player2Text.setBorder(border);

      }
	  
	  
	  
  }
  public void displayTime(){
      
      time.setVisible(true);
      time.setEditable(false);
      //time.setEnabled(false);
      time.setFont(time.getFont().deriveFont(15.0f));
      time.setBackground(Color.WHITE);
      Thread clock = new Thread(){
      public void run(){
          Calendar cal2 = new GregorianCalendar();
          int s2 = cal2.get(Calendar.SECOND);
          int m2 = cal2.get(Calendar.MINUTE);
          int h2 = cal2.get(Calendar.HOUR_OF_DAY);
          while(true){
                  Calendar cal = new GregorianCalendar();
                  int s = cal.get(Calendar.SECOND);
                  int m = cal.get(Calendar.MINUTE);
                  int h = cal.get(Calendar.HOUR_OF_DAY);
                   
                  if((s-s2)<0){
                      s2 = 0;
                  }
                  if((m-m2)<0){
                      m2= 0; 
                  }
                  if((h-h2)<0){
                      h2= 0;
                  }
                  else{
                      time.setText("           Time    "+" "+(h-h2)+":"+(m-m2)+":"+(s-s2));
                  }
                   
                  //time.setText((h-h2)+":"+(m-m2)+":"+(s-s2));
                  //System.out.print((h-h2)+":"+(m-m2)+":"+(s-s2));  
                   
                  try{
                      sleep(1000);
                      }catch(InterruptedException e){}
               
          }
           
           
        }
       };
       
      clock.start();
  }
	/** final variables, representing the players pieces*/
final String NAUGHT = "o";
final String CROSS = "x";
/** Integer variable storing which players turn it is*/
int m_turn = 1;
/** used to determine in what order the players move*/
int m_player1pos;
int m_player2pos;
/* stores the name of player 1 */
String m_player1Name;
/* stores the name of player 2 */
String m_player2Name;

/** This array of buttons will makeup the board
* it holds 64 buttons because there are 64 pieces on a 8x8 ttt board
*/
JButton buttons[] = new JButton[64];
/* JLabels which will contain the names of both players to be displayed */
JLabel player1Text = new JLabel();
JLabel player2Text = new JLabel();
private JTextField time = new JTextField(); 

private final int MASTER_WIDTH = 506;
private final int MASTER_HEIGHT = 700;
private final int WINDOW_WIDTH = 370;
private final int WINDOW_HEIGHT = 370;
private final int BUTTON_WIDTH = 40;
private final int BUTTON_HEIGHT = 40;
private final int TITLE_LABEL_WIDTH = 500;
private final int TITLE_LABEL_HEIGHT = 200;
private final int TIME_WIDTH = 300;
private final int TIME_HEIGHT = 600;
private final int TIME_X_BOUND = 200;
private final int TIME_Y_BOUND = 50;
private final int PLAYER_TEXTBOX_WIDTH = 270;
private final int PLAYER_TEXTBOX_HEIGHT = 60;
private final int PLAYER1_TEXTBOX_X_BOUND = 20;
private final int PLAYER1_TEXTBOX_Y_BOUND = 530;
private final int PLAYER2_TEXTBOX_X_BOUND = 20;
private final int PLAYER2_TEXTBOX_Y_BOUND = 600;
private final int RESTART_BTN_WIDTH = 100;
private final int RESTART_BTN_HEIGHT = 60;
private final int RESTART_BTN_X = 300;
private final int RESTART_BTN_Y = 530;

    }