import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalButtonUI;

/*****************************
   A 3 x 3 Tic-Tac-Toe board.
******************************/
public class TicTacToe
{
   /*****************************
      Constructs an empty board
      of Box objects
   ******************************/
   public static Box[][] board;
   
   public TicTacToe( )
   {
      board = new Box[3][3];
      
      // fill with spaces
      for (int i = 0; i < 3; i++)
         for (int j = 0; j < 3; j++)
            board[i][j] = new Box(0,0,0);
   }
   

   private static char player = 'x';
  
   private JFrame grid = new JFrame("Window");
   
   public void display()
	{
		//determines box size, spacing
		int s = 200;
		
		grid.setVisible(false);
		
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid.setSize(new Dimension(3*s+14,3*s+37));
		grid.setLayout(null);
		grid.getContentPane().setBackground(Color.WHITE);
		grid.setLocationRelativeTo(null);
   	
		one = new Box(0,0,s);
		board[0][0] = one;
		grid.add(one.box);
		one.box.addActionListener(actions);
		
		two = new Box(s,0,s);
		board[0][1] = two;
		grid.add(two.box);
		two.box.addActionListener(actions);
		
		three = new Box(s*2,0,s);
		board[0][2] = three;
		grid.add(three.box);
		three.box.addActionListener(actions);
		
		four = new Box(0,s,s);
		board[1][0] = four;
		grid.add(four.box);
		four.box.addActionListener(actions);
		
		five = new Box(s,s,s);
		board[1][1] = five;
		grid.add(five.box);
		five.box.addActionListener(actions);
		
		six = new Box(s*2,s,s);
		board[1][2] = six;
		grid.add(six.box);
		six.box.addActionListener(actions);
		
		seven = new Box(0,s*2,s);
		board[2][0] = seven;
		grid.add(seven.box);
		seven.box.addActionListener(actions);
		
		eight = new Box(s,s*2,s);
		board[2][1] = eight;
		grid.add(eight.box);
		eight.box.addActionListener(actions);
		
		nine = new Box(s*2,s*2,s);
		board[2][2] = nine;
		grid.add(nine.box);
		nine.box.addActionListener(actions);
		
		grid.setVisible(true);
	}
  
   private static Box one,two,three,four,five,six,seven,eight,nine;
   
   /*
    * main loop: buttons can be pressed once each, method will run 9 times max
    */
	private ActionListener actions = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getSource()==one.box)
				one.setChar(player);
			if(e.getSource()==two.box)
				two.setChar(player);
			if(e.getSource()==three.box)
				three.setChar(player);
			if(e.getSource()==four.box)
				four.setChar(player);
			if(e.getSource()==five.box)
				five.setChar(player);
			if(e.getSource()==six.box)
				six.setChar(player);
			if(e.getSource()==seven.box)
				seven.setChar(player);
			if(e.getSource()==eight.box)
				eight.setChar(player);
			if(e.getSource()==nine.box)
				nine.setChar(player);
			
			((JButton) e.getSource()).setText(player + "");
			((JButton) e.getSource()).setEnabled(false);
			((JButton) e.getSource()).setUI(new MetalButtonUI() 
			{
			    protected Color getDisabledTextColor() 
			    {
			        if(player=='x')
			        	return new Color(20, 181, 44);
			        if(player=='o')
			        	return new Color(247, 40, 40);
					return Color.LIGHT_GRAY;
			    }
			});
			
			if (player == 'x')
				player = 'o';
			else
				player = 'x';
			
			if(winner().equals("x"))
	        {
	       	  JOptionPane.showMessageDialog(null, "Player X has won!");
	       	  
	       	  int result;
	       	  JFrame frame = new JFrame();
			  result = JOptionPane.showConfirmDialog(frame,"New Game?");
			  if(result==JOptionPane.YES_OPTION)
			  {
				 grid.setVisible(false);
				 TicTacToe newGame = new TicTacToe();
				 newGame.display();
			  }
	        }
			
	        if(winner().equals("o"))
	        {
	      	  JOptionPane.showMessageDialog(null, "Player O has won!");
	      	  
	      	  int result;
	       	  JFrame frame = new JFrame();
			  result = JOptionPane.showConfirmDialog(frame,"New Game?");
			  if(result==JOptionPane.YES_OPTION)
			  {
				 grid.setVisible(false);
				 TicTacToe newGame = new TicTacToe();
				 newGame.display();
			  }
	        }
	        
	        tie += "-";
	        if(winner().equals("---------"))
	        {
	        	JOptionPane.showMessageDialog(null,"No Winner");
	        	
	        	int result;
		       	JFrame frame = new JFrame();
		       	result = JOptionPane.showConfirmDialog(frame,"New Game?");
		       	if(result==JOptionPane.YES_OPTION)
		       	{
		       		grid.setVisible(false);
		       		TicTacToe newGame = new TicTacToe();
		       		newGame.display();
		       	}
	        }
		}
	};
	
	
	String tie = "";
	
   /*
    * returns string "x" if x is winner and "o" if o is winner and "-" if no winner yet
    * "---------" string will be read as no winner
    */
   public String winner()
   {
	   /*
	    * win condition 1: 3 in a row
	    */
	   for(int c = 0;c<2;c++)
	   {
		   if((board[c][0].getChar() == 'x')&&(board[c][1].getChar() == 'x')&&(board[c][2].getChar() == 'x'))
		   {
			   return "x";
		   }
		   if((board[c][0].getChar() == 'o')&&(board[c][1].getChar() == 'o')&&(board[c][2].getChar() == 'o'))
		   {
			   return "o";
		   }
	   }
	   
	   /*
	    * win condition 2: 3 in a column
	    */
	   for(int c = 0;c<2;c++)
	   {
		   if((board[0][c].getChar() == 'x')&&(board[1][c].getChar() == 'x')&&(board[2][c].getChar() == 'x'))
		   {
			   return "x";
		   }
		   if((board[0][c].getChar() == 'o')&&(board[1][c].getChar() == 'o')&&(board[2][c].getChar() == 'o'))
		   {
			   return "o";
		   }
	   }
	   /*
	    * win condition 3: 3 diagonally
	    */
	   if(((board[0][0].getChar() == 'x')&&(board[1][1].getChar() == 'x')&&(board[2][2].getChar() == 'x'))||(board[2][0].getChar() == 'x')&&(board[1][1].getChar() == 'x')&&(board[0][2].getChar() == 'x'))
	   {
		   return "x";
	   }
	   if(((board[0][0].getChar() == 'o')&&(board[1][1].getChar() == 'o')&&(board[2][2].getChar() == 'o'))||(board[2][0].getChar() == 'o')&&(board[1][1].getChar() == 'o')&&(board[0][2].getChar() == 'o'))
	   {
		   return "o";
	   }
	
	   return tie;
   }
}
