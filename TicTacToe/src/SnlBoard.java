
/**
 * @file   - SnlBoard.java
 * @author - Shan Zhou
 * @date   - 6 Dec 2014
 * cs-230 assignment3   
 * SnlBoard class with all subclass and a paint class.
 * A frame display support a platform to players 
 * that players can roll dice and see data changed on this board.
 * this is a final version. 
 * To use this class, you need to input SnlPiece[], number of snake , number of ladders and number of players.
 */

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class SnlBoard {
	
	
	/**
	 * this constructor get data from superclass and set to local variables
	 * @param piece an array of SnlPiece 
	 * @param snakes number of snakes will be created
	 * @param ladders number of ladders will be created
	 * @param num number of player will be in this game
	 */
	public SnlBoard(SnlPiece[] piece, int snakes, int ladders,int num){
		numberOfSnakes= snakes;
		numberOfLadders= ladders;
		numOfPlayers = num;
		this.players =piece;
		
	}
	
	/**
	 * this method is going to display gameBoard, starRoll, pieces, snakes and ladders
	 */
	public void displayBoard(){
			
			gameBoard();
			
			startRoll();
			displaypieces();
			
			displaySnakes();
			displayLadders();
		
		}
	/**
	 * the main frame is used to support two panels below
	 * @return a JFrame 
	 */
	public JFrame gameBoard(){
			gameBoard = new JFrame("Snakes and Ladders");
			gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gameBoard.setLayout(null);
			gameBoard.setBounds(GAMEBOARD_BOUNDS_X, GAMEBOARD_BOUNDS_Y, FRAME_WIDTH, FRAME_HEIGHT);
			gameBoard.setVisible(true);
			gameBoard.setResizable(false);
			
			gameBoard.getContentPane().add(BoardConstruction());	
			gameBoard.getContentPane().add(dataBoard());
			return gameBoard;
		}

	/**
	 * this method construct a basic board which supports displaying methods
	 * @return a PaintPanel 
	 */		
	public PaintPanel BoardConstruction(){		
			snlBoard = new PaintPanel();
			snlBoard.setLayout(new GridLayout(10,10));
			snlBoard.setVisible(true);
			snlBoard.setBounds(SNLBOARD_BOUNDS_X,SNLBOARD_BOUNDS_Y, SNLBOARD_BOUNDS_WIDTH, SNLBOARD_BOUNDS_HEIGHT);
			snlBoard.setBackground(Color.WHITE);
			boardGrids();
			return snlBoard;	
		}

	
	/**
	 * this method is displaying information (name,color,position,etc)	
	 * @return a JPanel
	 */
	public JPanel dataBoard(){
			
			dataBoard = new JPanel();
			dataBoard.setVisible(true);
			dataBoard.setLayout(null);
			dataBoard.setBounds(DATABOARD_BOUNDS_X, DATABOARD_BOUNDS_Y, DATABOARD_BOUNDS_WIDTH, DATABOARD_BOUNDS_HEIGHT);
			
			dataBoard.add(displayTime());
			
			JTextPane tip = new JTextPane();
			tip.setBackground(SystemColor.control);
			tip.setText("Tips: Green Lines are snakes \r          Orange lines are ladders \r           Click the Dice   ");
			tip.setBounds(0, 110, 300, 70);
			dataBoard.add(tip);
			positionLabel = new JLabel[4];
			for(int i=0;i<numOfPlayers;i++){
				positionLabel[i]= new JLabel("Player Name: "+"( color ) => position: "+1);
				positionLabel[i].setBounds(0, 200+i*100, 300, 100);
				dataBoard.add(positionLabel[i]);
			}
			dataBoard.add(turnChange());
			return dataBoard;
		}
	

	/**
	 * this method construct a layout with grids on basic board
	 */
	public void boardGrids(){
				grids = new JPanel[101];
				
				for(int i1=100;i1>90;i1--){	
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						grids[i1] = new JPanel();
						grids[i1].add(new JLabel(Integer.toString(i1)));
						grids[i1].setLocation(0+GRIDS_LOCATION_X*(100-i1),GRIDS_LOCATION_Y-900);
						grids[i1].setLayout(new GridLayout(3,3));
						grids[i1].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i1].setBackground(new Color(a,b,c));
						//grids[i1].setOpaque(false);
						snlBoard.add(grids[i1]);
						
				}
				for(int i2=81;i2<91;i2++){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						grids[i2] = new JPanel();
						grids[i2].add(new JLabel(Integer.toString(i2)));
						grids[i2].setLocation(0+GRIDS_LOCATION_X*(i2-81),GRIDS_LOCATION_Y-800);
						grids[i2].setLayout(new GridLayout(3,3));
						grids[i2].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i2].setBackground(new Color(a,b,c));
						//grids[i2].setOpaque(false);
						snlBoard.add(grids[i2]);	
					
				}
				for(int i3=80;i3>70;i3--){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						grids[i3] = new JPanel();
						grids[i3].add(new JLabel(Integer.toString(i3)));
						grids[i3].setLocation(0+GRIDS_LOCATION_X*(80-i3),GRIDS_LOCATION_Y-700);
						grids[i3].setLayout(new GridLayout(3,3));
						grids[i3].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i3].setBackground(new Color(a,b,c));
						//grids[i3].setOpaque(false);
						snlBoard.add(grids[i3]);	
					
				}
				for(int i4=61;i4<71;i4++){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						
						grids[i4] = new JPanel();
						grids[i4].add(new JLabel(Integer.toString(i4)));
						grids[i4].setLocation(0+GRIDS_LOCATION_X*(i4-61),GRIDS_LOCATION_Y-600);
						grids[i4].setLayout(new GridLayout(3,3));
						grids[i4].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i4].setBackground(new Color(a,b,c));
						//grids[i4].setOpaque(false);
						snlBoard.add(grids[i4]);	
				}
				for(int i5=60;i5>50;i5--){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						
						grids[i5] = new JPanel();
						grids[i5].add(new JLabel(Integer.toString(i5)));
						grids[i5].setLocation(0+GRIDS_LOCATION_X*(60-i5),GRIDS_LOCATION_Y-500);
						grids[i5].setLayout(new GridLayout(3,3));
						grids[i5].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i5].setBackground(new Color(a,b,c));
						//grids[i5].setOpaque(false);
						
						snlBoard.add(grids[i5]);	
				}
			
				for(int i6=41;i6<51;i6++){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						
						grids[i6] = new JPanel();
						grids[i6].add(new JLabel(Integer.toString(i6)));
						grids[i6].setLocation(0+GRIDS_LOCATION_X*(i6-41),GRIDS_LOCATION_Y-400);
						grids[i6].setLayout(new GridLayout(3,3));
						grids[i6].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i6].setBackground(new Color(a,b,c));
						//grids[i6].setOpaque(false);
						snlBoard.add(grids[i6]);	
					
				}
				for(int i7=40;i7>30;i7--){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						grids[i7] = new JPanel();
						grids[i7].add(new JLabel(Integer.toString(i7)));
						grids[i7].setLocation(0+GRIDS_LOCATION_X*(40-i7),GRIDS_LOCATION_Y-300);
						grids[i7].setLayout(new GridLayout(3,3));
						grids[i7].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i7].setBackground(new Color(a,b,c));
						//grids[i7].setOpaque(false);
						snlBoard.add(grids[i7]);	
					
				}
				for(int i8=21;i8<31;i8++){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
						grids[i8] = new JPanel();
						grids[i8].add(new JLabel(Integer.toString(i8)));
						grids[i8].setLocation(0+GRIDS_LOCATION_X*(i8-21),GRIDS_LOCATION_Y-200);
						grids[i8].setLayout(new GridLayout(3,3));
						grids[i8].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i8].setBackground(new Color(a,b,c));
						//grids[i8].setOpaque(false);
						snlBoard.add(grids[i8]);	
					
				}
				for(int i9=20;i9>10;i9--){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
	
						grids[i9] = new JPanel();
						grids[i9].add(new JLabel(Integer.toString(i9)));
						grids[i9].setLocation(0+GRIDS_LOCATION_X*(20-i9),GRIDS_LOCATION_Y-100);
						grids[i9].setLayout(new GridLayout(3,3));
						grids[i9].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i9].setBackground(new Color(a,b,c));
						//grids[i9].setOpaque(false);
						snlBoard.add(grids[i9]);	
					
				}
				for(int i10=1;i10<11;i10++){
					Random rand = new Random();
					float a = rand.nextFloat();
					float b = rand.nextFloat();
					float c = rand.nextFloat();
				
						grids[i10] = new JPanel();
						grids[i10].add(new JLabel(Integer.toString(i10)));
						grids[i10].setLocation(0+GRIDS_LOCATION_X*(i10-1), GRIDS_LOCATION_Y);
						grids[i10].setLayout(new GridLayout(3,3));
						grids[i10].setBorder(new LineBorder(new Color(0, 0, 0)));
						grids[i10].setBackground(new Color(a,b,c));
						//grids[i10].setOpaque(false);
						snlBoard.add(grids[i10]);		
				}

			
		}
	
	
	/**
	 * display players pieces on the grids
	 */	
	public void displaypieces(){
			piece = new JLabel[numOfPlayers];
			
			for(int i=0;i<numOfPlayers;i++){
				players[i].getPlayerColor();
				
				if(players[i].getPlayerColor().equals("Blue")){
					piece[i] = new JLabel();
					piece[i].setIcon(new ImageIcon("src/image/bluepiece.png"));
					piece[i].setVisible(true);
					grids[1].add(piece[i]);
				}if(players[i].getPlayerColor().equals("Red")){
					piece[i] = new JLabel("");
					piece[i].setIcon(new ImageIcon("src/image/redpiece.png"));
					piece[i].setVisible(true);
					grids[1].add(piece[i]);
				}if(players[i].getPlayerColor().equals("Black")){
					piece[i] = new JLabel("");
					piece[i].setIcon(new ImageIcon("src/image/blackpiece.png"));
					piece[i].setVisible(true);
					grids[1].add(piece[i]);
				}else if(players[i].getPlayerColor().equals("Yellow")){
					piece[i] = new JLabel("");
					piece[i].setIcon(new ImageIcon("src/image/yellowpiece.png"));
					piece[i].setVisible(true);
					grids[1].add(piece[i]);
				}
			}
		}	
	/**
	 * get a timer and display time elapsed 
	 */
	public JTextField displayTime(){
			time = new JTextField(); 
			time.setVisible(true);
			time.setEditable(false);
			time.setFont(time.getFont().deriveFont(25.0f));
			time.setBackground(Color.white);
			time.setBounds(0, 10, 300, 100);
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
						
						if((s-s2)<0){s2 = 0;}
						if((m-m2)<0){m2= 0;}
						if((h-h2)<0){h2= 0;}
						else{time.setText("    Time    "+" "+(h-h2)+":"+(m-m2)+":"+(s-s2));}
						try{sleep(1000);}catch(InterruptedException e){}}
				}
			 };
			clock.start();
			return time;	
		}		
	/**
	 *  call snakes class and create on board
	 */
	public void displaySnakes(){
			n= new ArrayList<Snakes>();
			
			PaintPanel[] ss = new PaintPanel[numberOfSnakes];
				
			
			for (int n2=0;n2<numberOfSnakes ;n2++){
				ss[n2] = new PaintPanel();
				ss[n2].setVisible(true);
				ss[n2].setBounds(0, 0, 1000, 1000);
				gameBoard.add(ss[n2]);
				n.add(new Snakes());
				
				ss[n2].setSX1(grids[n.get(n2).getSnakeHead()].getLocation().x+20);
				ss[n2].setSY1(grids[n.get(n2).getSnakeHead()].getLocation().y+20);
				ss[n2].setSX2(grids[n.get(n2).getSnakeTail()].getLocation().x+20);
				ss[n2].setSY2(grids[n.get(n2).getSnakeTail()].getLocation().y+20);

				System.out.println(n.get(n2).getSnakeHead()+"<---Head<---Snake---->Tail--->"+n.get(n2).getSnakeTail());
				
				
			}
		}		
	/**
	 *  call ladders class and create on board
	 */
	public void displayLadders(){
			l = new ArrayList<Ladders>();
			PaintPanel[] ss = new PaintPanel[numberOfLadders]; 
			for (int n2=0;n2<numberOfLadders ;n2++){
				ss[n2] = new PaintPanel();
				ss[n2].setVisible(true);
				ss[n2].setBounds(0, 0, 1000, 1000);
				gameBoard.add(ss[n2]);
				l.add(new Ladders());
				
				ss[n2].setLX1(grids[l.get(n2).getLadderHead()].getLocation().x+20);
				ss[n2].setLY1(grids[l.get(n2).getLadderHead()].getLocation().y+20);
				ss[n2].setLX2(grids[l.get(n2).getLadderTail()].getLocation().x+20);
				ss[n2].setLY2(grids[l.get(n2).getLadderTail()].getLocation().y+20);

				System.out.println(l.get(n2).getLadderHead()+"<---Head<---Ladders---->Tail--->"+l.get(n2).getLadderTail());
			}
		
		}	
	/**
	 * create a button for players to roll dice
	 * @return JButton
	 */
	public JButton turnChange(){
			changePlayer = new JButton();
			changePlayer.setVisible(true);
			changePlayer.setBounds(100, 700, 103, 103);
			changePlayer.setIcon(new ImageIcon("src/image/d1.png"));
			return changePlayer;
			}		
	/**
	 * this method is used when 1st player is going to roll dice
	 */
	public void firstroll(){
			dice = new Dice();
			dice.getDiceRoll();
			String msg = "1st player's point is "+dice.showFace();
			System.out.println(msg);
			JOptionPane.showMessageDialog(changePlayer,msg);
		
			firstPlayer = firstPlayer+dice.showFace();
			checkposition();
		}
	/**
	 * this method is used when 2nd player is going to roll dice
	 */
	public void secondroll(){
			dice = new Dice();
			dice.getDiceRoll();
			String msg2 = "2nd player's point is "+dice.showFace();
			JOptionPane.showMessageDialog(changePlayer,msg2);
			System.out.println(msg2);
			secondPlayer = secondPlayer+dice.showFace();
			checkposition();
		}
	/**
	 * this method is used when 3rd player is going to roll dice
	 */
	public void thirdroll(){
			dice = new Dice();
			dice.getDiceRoll();
			
			String msg3 = "3rd player's point is "+dice.showFace();
			JOptionPane.showMessageDialog(changePlayer,msg3);
			System.out.println(msg3);
			
			thirdPlayer = thirdPlayer+dice.showFace();
			checkposition();
		}
	/**
	 * this method is used when 4th player is going to roll dice
	 */
	public void fourthroll(){
			dice = new Dice();
			dice.getDiceRoll();
		
			String msg4 = "4th player's point is "+dice.showFace();
			System.out.println(msg4);
			JOptionPane.showMessageDialog(changePlayer,msg4);
		
			fourthPlayer = fourthPlayer+dice.showFace();
			checkposition();
		}
	/**
	 * this method set a mouseListener to capture player's click 
	 * meanwhile make a roll then change position of pieces 
	 */
	public void startRoll(){
			changePlayer.addMouseListener(new MouseAdapter() {
					int o=0;
					public void mouseClicked(MouseEvent e) {
						o++;
						gameBoard.setLayout(null);
						gameBoard.setResizable(false);
						
						for(int i=0;i<numOfPlayers;i++){
							players[i].getPlayerOrder();
							if((players[i].getPlayerOrder()==1) && (o==1)){
								firstroll();
								positionLabel[0].setText("Player Name: "+players[i].getPlayerName()+"( "+players[i].getPlayerColor()+" ) => position: "+Integer.toString(firstPlayer));
								grids[firstPlayer].add(piece[i]);
								
							}
							if((players[i].getPlayerOrder()==2) && (o==2)){
								secondroll();
								positionLabel[1].setText("Player Name: "+players[i].getPlayerName()+"( "+players[i].getPlayerColor()+" ) => position: "+Integer.toString(secondPlayer));
								grids[secondPlayer].add(piece[i]);
								
								if(numOfPlayers==2){o=0;}
							}
							if((players[i].getPlayerOrder()==3) && (o==3)){
								thirdroll();
								positionLabel[2].setText("Player Name: "+players[i].getPlayerName()+"( "+players[i].getPlayerColor()+" ) => position: "+Integer.toString(thirdPlayer));
								grids[thirdPlayer].add(piece[i]);
								
								if(numOfPlayers==3){o=0;}

							}
							if((players[i].getPlayerOrder()==4) && (o==4)){
								fourthroll();
								positionLabel[3].setText("Player Name: "+players[i].getPlayerName()+"( "+players[i].getPlayerColor()+" ) => position: "+Integer.toString(fourthPlayer));
								grids[fourthPlayer].add(piece[i]);
								
								o=0;
							}
						}					
					}				
			});	
		}
	/**
	 * check pieces if they catch a snakes or ladders 
	 */
	public void checkposition(){
			if (firstPlayer>WIN_POSITION){
				win();
			}
			if (secondPlayer>WIN_POSITION){
				win();
			}
			if (thirdPlayer>WIN_POSITION){
				win();
			}
			if (fourthPlayer>WIN_POSITION){
				win();
			}
			for(int c=0;c<numberOfSnakes;c++){
 				if(firstPlayer == (n.get(c).getSnakeHead())){
 					firstPlayer=(n.get(c).getSnakeTail());
 					//
 					String msg4 ="Snaaaaaaaaaaaaaaaaaaaaaaaaaake!!!" ;
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showSnakeImage();
 				}
 				if(secondPlayer== (n.get(c).getSnakeHead())){
 					secondPlayer=(n.get(c).getSnakeTail());
 					//
 					String msg4 = "Snaaaaaaaaaaaaaaaaaaaaaaaaaake!!!";
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showSnakeImage();
 				}
 				if(thirdPlayer== (n.get(c).getSnakeHead())){
 					thirdPlayer=(n.get(c).getSnakeTail());
 					//
 					String msg4 = "Snaaaaaaaaaaaaaaaaaaaaaaaaaake!!!";
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showSnakeImage();
 				}
 				if(fourthPlayer== (n.get(c).getSnakeHead())){
 					fourthPlayer=(n.get(c).getSnakeTail());
 					//
 					String msg4 = "Snaaaaaaaaaaaaaaaaaaaaaaaaaake!!!";
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showSnakeImage();
 				}
			}
			for(int c=0;c<numberOfLadders;c++){
 				if(firstPlayer == (l.get(c).getLadderTail())){
 					firstPlayer=(l.get(c).getLadderHead());
 					//
 					String msg4 = "Laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadder";
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showLadderImage();
 				}
 				if(secondPlayer== (l.get(c).getLadderTail())){
 					secondPlayer=(l.get(c).getLadderHead());
 					//
 					String msg4 = "Laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadder";
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showLadderImage();
 				}
 				if(thirdPlayer== (l.get(c).getLadderTail())){
 					thirdPlayer=(l.get(c).getLadderHead());
 					//
 					String msg4 = "Laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadder";
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showLadderImage();
 				}
 				if(fourthPlayer== (l.get(c).getLadderTail())){
 					fourthPlayer=(l.get(c).getLadderHead());
 					//
 					String msg4 = "Laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadder";
					System.out.println(msg4);
					JOptionPane.showMessageDialog(changePlayer,msg4);
					showLadderImage();
 				}
			}

			
		}
	/**
	 * check pieces which over 99
	 */
	public void win(){
			if(firstPlayer>WIN_POSITION){
				String msg4 =players[0].getPlayerName()+" win";
				System.out.println(msg4);
				JOptionPane.showMessageDialog(changePlayer,msg4);
				gameBoard.setVisible(false);
				animation(msg4);
			}
			if(secondPlayer>WIN_POSITION){
				String msg4 = players[1].getPlayerName()+" win";
				System.out.println(msg4);
				JOptionPane.showMessageDialog(changePlayer,msg4);
				gameBoard.setVisible(false);
				animation(msg4);
			}
			if(thirdPlayer>WIN_POSITION){
				String msg4 = players[2].getPlayerName()+" win";
				System.out.println(msg4);
				JOptionPane.showMessageDialog(changePlayer,msg4);
				gameBoard.setVisible(false);
				animation(msg4);
			}
			if(fourthPlayer>WIN_POSITION){
				String msg4 = players[3].getPlayerName()+" win";
				System.out.println(msg4);
				JOptionPane.showMessageDialog(changePlayer,msg4);
				gameBoard.setVisible(false);
				animation(msg4);
			}
		}
	
	/**
	 * this method store images to create animation
	 */
	public void animation(String p){
		final ImageIcon[] image = new ImageIcon[19];
		image[0]= new ImageIcon("src/image/l1.png");
		image[1]= new ImageIcon("src/image/l2.png");
		image[2]= new ImageIcon(("src/image/l3.png"));
		image[3]= new ImageIcon("src/imagel4.png");
		image[4]= new ImageIcon("src/image/l5.png");
		image[5]= new ImageIcon(("src/image/l6.png"));
		image[6]= new ImageIcon("src/image/l7.png");
		image[7]= new ImageIcon("src/image/l8.png");
		image[8]= new ImageIcon("src/image/l9.png");
		image[9]= new ImageIcon(("src/image/l10.png"));
		image[10]= new ImageIcon((("src/image/l11.png")));
		image[11]= new ImageIcon((("src/image/l12.png")));
		image[12]= new ImageIcon((("src/image/l13.png")));
		image[13]= new ImageIcon((("src/image/l14.png")));
		image[14]= new ImageIcon((("src/image/l15.png")));
		image[15]= new ImageIcon((("src/image/l16.png")));
		
		image[16]= new ImageIcon((("src/image/w.png")));
		image[17]= new ImageIcon((("src/image/i.png")));
		image[18]= new ImageIcon((("src/image/n.png")));
		
		final JFrame win = new JFrame(p);
		win.setVisible(true);
		win.setBounds(500, 0, 600, 900);
		win.setResizable(false);
		win.getContentPane().setBackground(new Color(153,217,234));
		win.setLayout(null);
		final JLabel imgs =new JLabel();
		imgs.setVisible(true);
		imgs.setBounds(100,200, 500,600);
		win.getContentPane().add(imgs);
		win.add(restart());
		
		Thread clock = new Thread(){
		public void run(){
			for(int i=0;i<16;i++){
				imgs.setIcon(image[i]);
				try{sleep(300);}catch(InterruptedException e){}
			}
			
			JLabel w = new JLabel();
			w.setIcon(image[16]);
			w.setBounds(0, 0, 200, 200);
			w.setVisible(true);
			win.add(w);
			
			JLabel i = new JLabel();
			i.setIcon(image[17]);
			i.setBounds(200, 0, 200, 200);
			i.setVisible(true);
			win.add(i);
			
			JLabel n = new JLabel();
			n.setIcon(image[18]);
			n.setBounds(400, 0, 200, 200);
			n.setVisible(true);
			win.add(n);
			
			win.setLayout(null);
			win.setResizable(false);
			}	
		 };
		clock.start();
	}
	/**
	 * restart the game 
	 * @return JButton
	 */
	public JButton restart(){
		JButton re = new JButton();
		re.setVisible(true);
		re.setIcon(new ImageIcon("src/image/pg.png"));
		re.setBounds(RESTART_BOUNDS_X, RESTART_BOUNDS_Y, RESTART_BOUNDS_WIDTH, RESTART_BOUNDS_HEIGHT);
		re.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {
			//set new game here
			game Frame = new game();
		
		}});
		return re;
		
	}
	/**
	 * get snake image for source file and display on frame
	 * @return JFrame
	 */
	public JFrame showSnakeImage(){
		JFrame ssi = new JFrame("  It's a snake!!!!!!!!!!!!!");
		ssi.setResizable(false);
		ssi.setLayout(new GridLayout(1,1));
		ssi.setVisible(true);
		ssi.setBounds(400, 200, 642, 399);
		JLabel s= new JLabel();
		s.setIcon(new ImageIcon("src/image/snake.jpg"));
		s.setVisible(true);
		ssi.add(s);
		return ssi;
	}
	
	/**
	 * get ladder image for source file and display on frame
	 * @return JFrame
	 */
	public JFrame showLadderImage(){
		JFrame sli = new JFrame("  It's a ladder!!!!!!!!!!!!!");
		sli.setResizable(false);
		sli.setLayout(new GridLayout(1,1));
		sli.setVisible(true);
		sli.setBounds(400, 200, 642, 399);
		JLabel s= new JLabel();
		s.setIcon(new ImageIcon("src/image/ladder.jpg"));
		s.setVisible(true);
		sli.add(s);
		return sli;
	}
	/*parameters*/
	public final static int FRAME_WIDTH = 1800 ;
	public final static int FRAME_HEIGHT = 1100 ;		
	/*set start position for pieces*/
	private int firstPlayer=1;
	private int secondPlayer=1;
	private int thirdPlayer=1;
	private int fourthPlayer=1;
	
	private Dice dice;
	
	private	SnlPiece[] players;
	private int numberOfSnakes;
	private int numberOfLadders;	
	private int numOfPlayers;	
	
	private JFrame gameBoard;	
	private PaintPanel snlBoard;	
	private JPanel dataBoard;	
	private JPanel grids[];
	private JTextField time;	
	private JButton changePlayer;	
	
	private JLabel[] piece;		
	private	JLabel[] positionLabel;	
	
	private	ArrayList<Snakes> n;	
	private	ArrayList<Ladders> l;
	
	/*magic numbers */
	private final int GAMEBOARD_BOUNDS_X =0;
	private final int GAMEBOARD_BOUNDS_Y =0;
	private final int SNLBOARD_BOUNDS_X=0;
	private final int SNLBOARD_BOUNDS_Y=0;
	private final int SNLBOARD_BOUNDS_WIDTH=1000;
	private final int SNLBOARD_BOUNDS_HEIGHT=1000;
	private final int DATABOARD_BOUNDS_X = 1050;
	private final int DATABOARD_BOUNDS_Y = 0;
	private final int DATABOARD_BOUNDS_WIDTH = 320;
	private final int DATABOARD_BOUNDS_HEIGHT =1000;
	private final int GRIDS_LOCATION_X=100;
	private final int GRIDS_LOCATION_Y=900;
	private final int WIN_POSITION = 99;
	private int	RESTART_BOUNDS_X=300;
	private int	RESTART_BOUNDS_Y=600;
	private int	RESTART_BOUNDS_WIDTH=300;
	private int	RESTART_BOUNDS_HEIGHT=200;
}

/**
 * this class extends from JPanel 
 * so that it can be draw snakes and ladders on a panel
 */

class PaintPanel extends JPanel {
	/**
	 * these methods are get coordinate of Snakes
	 */	
	public int setSX1(int a){
		return m_sx1=a;
	}
	public int setSY1(int b){
		return m_sy1=b;
	}
	public int setSX2(int c){
		return m_sx2=c;
	}
	public int setSY2(int d){
		return m_sy2=d;
	}
	/**
	 * these methods are get coordinate of ladders
	 */
	public int setLX1(int a){
		return m_lx1=a;
	}
	public int setLY1(int b){
		return m_ly1=b;
	}
	public int setLX2(int c){
		return m_lx2=c;
	}
	public int setLY2(int d){
		return m_ly2=d;
	}
	/**
	 * draw snakes and ladders
	 */
	/**
	 * draw snakes and ladder when get value for above methods
	 */
	public void paintComponent( Graphics g ) {
		Graphics2D ds= (Graphics2D)g;
		ds.setColor(Color.GREEN);
		ds.setStroke(new BasicStroke(20));
	    ds.drawLine(m_sx1, m_sy1,m_sx2,m_sy2);
	    ds.setColor(Color.BLACK);
	    ds.drawString("Head", m_sx1, m_sy1);
	    
	    Graphics2D dl= (Graphics2D)g;
	    dl.setColor(Color.ORANGE);
	    dl.setStroke(new BasicStroke(20));
	    dl.drawLine(m_lx1, m_ly1, m_lx2, m_ly2);
	    dl.setColor(Color.BLACK);
	    dl.drawString("Buttom", m_lx2, m_ly2);
	   
	    Graphics2D bg= (Graphics2D)g;
		 float opacity=0.6f;
		 bg.setComposite((AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity)));
		 
	   
	   
	}
	/*parameter*/
	private int m_sx1;
	private int m_sy1;
	private int m_sx2;
	private int m_sy2;
	
	private int m_lx1;
	private int m_ly1;
	private int m_lx2;
	private int m_ly2;
	
}
