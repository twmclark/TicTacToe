/**
*	@file - TTTPiece.java
*	@author - Gethyn Friend
*	@date - 26/11/2014
*	CS-230 Assignment 3
*
*	This is a class that contains the get and set methods for the Tic-Tac-Toe game which
*	also contains the constructor which creates player objects containing all the details
*	of the respected players.
*/

public class TTTPiece{
    
	/**
	 * private integers containing the information about the players respectively.
	 */
    private int position;
    private String name;
    
    
   
    
   
  
    
    /**
     * 	@param first
     * 	@return firstPlayer as the value of first
     * 	Sets the value of which player is going first
     */
    public void setPosition(int position1){
    	position = position1;
    }
    
    /**
     * 	@param name1
     * 	@return p1Name as the value of name1
     * 	Sets the value of player 1's name
     */
    public void setname(String name1){
    	name = name1;
    }
    
    
     
    /**
     * 	@return position 
     * 	Returns the position of the player
     */
    public int getPosition(){
        return position;
    }
     
    
    /**
     * 	@return name
     * 	Returns the value of name
     */
    public String getName(){
    	return name;
    }
    
    
}