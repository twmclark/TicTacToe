/**
 * @file   - Ladders.java
 * @author - Jamie Glinn
 * @date   - 7th Dec 2014  
 * this class creates a ladder with two random number for snlBoard class.
 *
 */
public class Ladders {
	private int m_ladderHead;
	private int m_ladderTail;
	
	/* constructor to get a number for tail a number for head*/
	public Ladders() {
		
		
		m_ladderTail = (int)(Math.random() * 90)+ 1; 
		m_ladderHead = (int)(Math.random() * 99 )+1;
		check();
		 
	}
	/**
	 * get head of ladder 
	 * @return int m_ladderHead
	 */
	public int getLadderHead() {
		return m_ladderHead;
	}
	/**
	 * get tail of ladder 
	 * @return int m_ladderTail
	 */
	public int getLadderTail() {
		return m_ladderTail;
	}
	/**
	 * print out data of a ladder
	 * @return String
	 */
	public String toString() {
		return "The ladder head is " + m_ladderHead + " and the ladder tail is " + m_ladderTail + " and the difference is " + (m_ladderTail - m_ladderHead);
	}
	
	/**
	 * this method is used to check head is bigger than tail and tail cannot be 1;
	 */
	public void check(){
		if((m_ladderHead-m_ladderTail)<10){
			m_ladderTail = (int)(Math.random() * 90) + 1; 
			m_ladderHead = (int)(Math.random() * 99) + 1;
			check();
		}else if (m_ladderHead<m_ladderTail){
			m_ladderTail = (int)(Math.random() * 90) + 1; 
			m_ladderHead = (int)(Math.random() * 99) + 1;
			check();
		}else if (m_ladderTail==1){
			m_ladderTail = (int)(Math.random() * 90) + 1; 
			m_ladderHead = (int)(Math.random() * 99) + 1;
			check();
		}
	}
}
