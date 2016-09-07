/**
 * @file Dice.java
 * @author Group 9
 * @date 7 Dec 2014
 * this class creates a dice with random number of range 1-6
 */
public class Dice {
	/**
	 * creates a random number 1-6
	 * @return int m_diceRoll
	 */
	public int getDiceRoll() {
		m_diceRoll = (int)(Math.random() * 6) + 1;
		
		return m_diceRoll;
	}
	/**
	 * get the random number
	 * @return int m_diceRoll
	 */
	public int showFace(){
		
		return m_diceRoll;
		
	}
	
	private int m_diceRoll;
}