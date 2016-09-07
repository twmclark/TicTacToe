/**
 * @file   Snkaes.java
 * @author Asmaar Ali
 * @date   7th Dec 2014 
 * this class creates a snake with two random number for snlBoard class.
 */

public class Snakes {
		private int head;
		private int tail;
		/* constructor to get a number for tail a number for head*/
		public	Snakes() {
	
		 tail= (int)(Math.random() * 90) + 1;
		 head =(int)(Math.random() * 99) + 1;
		 check();
		


		}

	// A get method to cal the value of the head when its required 
	public int getSnakeHead() {	
		return head;
	}

	
	// A get method to call the value of the tail when its required 
	public int getSnakeTail() {
		return tail;	
	}		
	/**
	 * print out data of a ladder
	 * @return String
	 */
	public String toString() {
		return "The snake head is " + head + " and the snake tail is " + tail;
	}
	/**
	 * this method is used to check head is bigger than tail and tail cannot be 1;
	 */
	public void check(){
		if((head-tail)<10){
			tail = (int)(Math.random() * 90) + 1; 
			head = (int)(Math.random() * 99) + 1;
			check();
		}else if (head<tail){
			tail = (int)(Math.random() * 90) + 1; 
			head = (int)(Math.random() * 99) + 1;
			check();
		}else if (tail==1){
			tail = (int)(Math.random() * 90) + 1; 
			head = (int)(Math.random() * 99) + 1;
			check();
		}
	}
	
	
	
}