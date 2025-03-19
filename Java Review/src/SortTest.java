import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SortTest
{
	public static int[] randomArr()
	{
		Random rand = new Random();
		int[] numArr = new int[5];
		
		for(int i=0;i<numArr.length;i++)
			numArr[i] = rand.nextInt(10);
		return numArr;
	}
	private static int[] numArr = randomArr();
	
	public static void main(String[] args)
	{	
		System.out.println("Unsorted Array:\n" + Arrays.toString(numArr));
		JFrame popup = new JFrame("Sort Options");
	    addPopupComponents(popup);
	    
	    JButton button = new JButton("Bubble Sort");
	    button.setPreferredSize(new Dimension(150, 50));
	    button.setBackground(Color.LIGHT_GRAY);
	    popup.add(button, BorderLayout.LINE_START);
	    button.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  popup.setVisible(false);
			  System.out.println("\nSorting Process:");
			  System.out.println("\nBubble Sorted Array:\n" + Arrays.toString(Sort.bubbleSort(numArr,+1)));
			  System.exit(0);
		  }
		});
	    
	    JButton button2 = new JButton("Selection Sort");
	    button2.setBackground(Color.LIGHT_GRAY);
	    popup.add(button2, BorderLayout.CENTER);
	    button2.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  popup.setVisible(false);
			  System.out.println("\nSorting Process:");
			  System.out.println("\nSelection Sorted Array:\n" + Arrays.toString(Sort.selectionSort(numArr, +1)));
			  System.exit(0);
		  }
		});
	    
	    JButton button3 = new JButton("Insertion Sort");
	    button3.setPreferredSize(new Dimension(150, 50));
	    button3.setBackground(Color.LIGHT_GRAY);
	    popup.add(button3, BorderLayout.LINE_END);
	    button3.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  popup.setVisible(false);
			  System.out.println("\nSorting Process:");
			  System.out.println("\nInsertion Sorted Array:\n" + Arrays.toString(Sort.insertionSort(numArr, +1)));
			  System.exit(0);
		  }
		});
	    
	    JButton button4 = new JButton("Exit");
	    button4.setBackground(Color.RED);
	    popup.add(button4, BorderLayout.PAGE_END);
	    button4.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  System.exit(0);
		  }
		});
	     
	    popup.setVisible(true);
	}
	
	public static void addPopupComponents(Container popup)
	{
		((JFrame) popup).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JFrame) popup).setUndecorated(true);
		popup.setSize(new Dimension(450,150));
		((JFrame) popup).setLocationRelativeTo(null);

	    JButton text = new JButton("How would you like to sort the array?");
	    text.setBackground(Color.GRAY);

	    popup.add(text,BorderLayout.PAGE_START);
	}

}
