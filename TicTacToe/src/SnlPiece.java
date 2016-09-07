
/**
 * @file SnlPiece.java
 * @author Thomas Dawson 
 * @date 3  Dec 2014
 * @see SnL.java and SnlBoard.java for related stuff
 *
 * Creates the SnlPiece object 
 */
public class SnlPiece {
	

	/**
	 * A method taking one argument.
	 * @param number a int argument.

	 */

	public void setNumberOfPlayers(int number){
		NUMBER_OF_PLAYERS = number;
	}


	/**
	 * A method returning one argument.
	 * @return NUMBER_OF_PLAYERS a constant variable of type int.

	 */
	public int getNumberOfPlayers(){
	
		return NUMBER_OF_PLAYERS;
	}


	/**
	* A method returning one argument.
	* @return playerName a variable of type String.

	 */
	public String getPlayerName(){
	
		return m_playerName;
	}


	/**
	 * A method returning one argument.
	 * @return playerColor a variable of type String.

	 */
	public String getPlayerColor(){
	
		return m_playerColor;
	}

	/**
	 * A method returning one argument.
	 * @return playerOrder a variable of type String.

	 */

	public int getPlayerOrder(){
		return m_playerOrder;	
	}
	/**
	 * A method return string with piece data
	 * @return  String of player name , color, order
	 */
	
	public String toString(){
		String data = "name: "+getPlayerName()+"color: "+getPlayerColor()+"order: "+getPlayerOrder();
		return data;
	}
	
	/**
	 * A constructor taking three arguments.
	 * @param name a String argument.
	 * @param Color a String argument.
	 * @param Order a integer argument.
 
	 */

	public SnlPiece(String name,String Color,int Order){
	
		m_playerName = name;
		m_playerColor = Color;
		m_playerOrder = Order;
	
	
	}
	

	static private int NUMBER_OF_PLAYERS;

	private String m_playerName;

	private String m_playerColor;

	private int m_playerOrder; // variable to show the order in which the players will begin.

}