/**
 * Unit 8 2D Arrays Random Array Program
 * 
 * This program is intended to generate a 5x10 2D array of random numbers within an user-determined range
 * The array will display on a JFrame grid
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class twoDArrayGUI 
{
	/*
	 * two popup screens ask the user the range of the random numbers
	 */
	private static String minimum = JOptionPane.showInputDialog("Minimum value?");
	private static String maximum = JOptionPane.showInputDialog("Maximum value?");
	
	/*
	 *
	 */
	public static void main(String[] args)
	{
		int[][] arr = randArr();
		
		for(int[] r : arr)
			System.out.println(Arrays.toString(r) + "   Sum:[" + IntStream.of(r).sum() + "]");
		
		display(arr);
	}
	
	/**
	 * displays array and sum in JFrame (only 5x10)
	 * @param arr
	 */
	public static void display(int[][] arr)
	{
		//determines box size, spacing
		final int s = 50;
		
		JFrame grid = new JFrame("Window");
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid.setSize(new Dimension(11*s+39,6*s+11));
		grid.setLayout(null);
		grid.getContentPane().setBackground(Color.LIGHT_GRAY);
		grid.setLocationRelativeTo(null);

		/*
		 * x and y are positions for each box, s is the size of each box
		 */
		int x=0,y=0,sum;
		

		//adds origin box
		JButton obox = new JButton();
		Box ob = Box.createVerticalBox();
		ob.add(obox);
		obox.setBounds(x,y,s/2,s/2);
		obox.setBackground(Color.GRAY);
		grid.add(obox,null);
		
		//adds column header boxes
		for(x=s/2;x<(s*10+s/2);x+=s)
		{
			JButton box = new JButton();
			box.setText(x/50+1 + "");
			box.setMargin(new Insets(0,0,0,0));
			Box b = Box.createVerticalBox();
			b.add(box);
			box.setBounds(x,y,s,s/2); //add spacing
			box.setBackground(Color.GRAY);
			grid.add(box,null);
		}
		
		//adds 'sum' text box
		JButton tbox = new JButton();
		tbox.setText("Sum");
		tbox.setMargin(new Insets(0,0,0,0));
		Box tb = Box.createVerticalBox();
		tb.add(tbox);
		tbox.setBounds(x,y,s,s/2); //add spacing
		tbox.setBackground(Color.GRAY);
		grid.add(tbox,null);
		
		y += s/2;
		
		//counts columns
		int c = 0;
		
		//generates boxes
		for(int[] r : arr)
		{
			c++;
			sum = 0;
			x=0;
			//adds extra row header box
			JButton cbox = new JButton();
			cbox.setText(c + "");
			cbox.setMargin(new Insets(0,0,0,0));
			Box cb = Box.createVerticalBox();
			cb.add(cbox);
			cbox.setBounds(x,y,s/2,s); //add spacing
			cbox.setBackground(Color.GRAY);
			grid.add(cbox,null);
			
			x += s/2;
			for(int n : r)
			{
				sum += n;
				JButton box = new JButton();
				box.setText(n + "");
				box.setMargin(new Insets(0,0,0,0));
				Box b = Box.createVerticalBox();
				b.add(box);
				box.setBounds(x,y,s,s); //add spacing
				box.setBackground(Color.WHITE);
				grid.add(box,null);
				
				x+=s;
			}
			
			//generates sum box
			JButton sbox = new JButton();
			sbox.setText(sum + "");
			sbox.setMargin(new Insets(0,0,0,0));
			Box sb = Box.createVerticalBox();
			sb.add(sbox);
			sbox.setBounds(x,y,s,s);
			sbox.setBackground(Color.LIGHT_GRAY);
			grid.add(sbox,null);
			
			y+=s;
		}		
		grid.setVisible(true);
	}	
	
	/*
	 * returns 5x10 array of specific size
	 */
 	public static int[][] randArr()
	{
 		int min=0,max = 0;
 		try {
 			min = Integer.parseInt(minimum);
 			max = Integer.parseInt(maximum);
 		}
 		catch(Exception e) {
 			JOptionPane.showMessageDialog(null, "Error in value");
 		}
 		
		int rows = 5;
		int columns = 10;
		int[][] arr = new int[rows][columns];
	
		for(int r = 0;r<rows;r++)
		{
			for(int c=0;c<columns;c++)
			{
				arr[r][c] = ThreadLocalRandom.current().nextInt(min, max + 1);
			}
		}
		
		return arr;
	}
}
