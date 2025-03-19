import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalButtonUI;
/*
 * This is the class/object for the Island which contains
 * the GUI window and 2D array of the mouse on the island.
 * Every part of the JFrame is initialized with the island.
 * All methods relating to the island and its functions are here.
 *  
 * @author Sebastian Arana
 * 
 */
public class Island 
{
	public JFrame window = new JFrame("Window");    //main window for every island
	private JLayeredPane order = new JLayeredPane();    //glass pane for ordering purposes
	
	private char[][] grid;    //2D array of characters ' ', 'h', 'v', 'w'
	private static final int ROWS = 10;    //number of rows in array (do not change)
	private static final int COLUMNS = 15;    //number of columns in array (do not change)
	
	private final int NUM_MOVES = 50;    //number of moves until starvation (used in main loop - moved to main method)
	private final double PERCENT_BRIDGES = 0.3;    //PERCENT_BRIDGES spawn of bridges (do not change)
	
	/*
	 * Initializes island 2D array.
	 * does not add GUI components.
	 */
	public Island()
	{	
		grid = new char[ROWS][COLUMNS];
		double rand;
		
		/*
		 * adds water and bridges to grid array by PERCENT_BRIDGES
		 */
		for(int c = 1;c<14;c++)    //top row
		{
			rand = Math.random();
			if(rand<=PERCENT_BRIDGES)
				grid[0][c] = 'v';
			if(rand>PERCENT_BRIDGES)
				grid[0][c] = 'w';
		}
		
		for(int i=1;i<9;i++)   //middle rows (end columns only)
		{
			rand = Math.random();
			if(rand<=PERCENT_BRIDGES)
				grid[i][0] = 'h';
			if(rand>PERCENT_BRIDGES)
				grid[i][0] = 'w';
			
			rand = Math.random();
			if(rand<=PERCENT_BRIDGES)
				grid[i][14] = 'h';
			if(rand>PERCENT_BRIDGES)
				grid[i][14] = 'w';
		}
		
		for(int c = 1;c<14;c++)    //bottom row
		{
			rand = Math.random();
			if(rand<=PERCENT_BRIDGES)
				grid[9][c] = 'v';
			if(rand>PERCENT_BRIDGES)
				grid[9][c] = 'w';
		}
		
		/*
		 * adds corner water tiles
		 */
		grid[0][0]='w';grid[0][COLUMNS-1]='w';grid[ROWS-1][0]='w';grid[ROWS-1][COLUMNS-1]='w';	
		
		decorate();
	}
	
	private static final int size = 50;    //side length of each square tile (px)
	private static final int margin = 20;
	
	private JPanel counter = new JPanel();
	private JLabel count = new JLabel();
	
	private JPanel statuser = new JPanel();
	private JLabel status1 = new JLabel();
	private JLabel status2 = new JLabel();
	private JPanel stats = new JPanel();
	private JLabel header,trials,escapes,drowns,starves,bridges,space;    //labels for each stat
	
	private Border blackLine = BorderFactory.createLineBorder(Color.black);    //border for tiles
	
	/*
	 * decorates window and adds buttons
	 */
	public void decorate()
	{	
		addComponents();
		addBridges();
		window.setVisible(true);
		
		window.add(run,null);
		run.setBounds(20+65+10+5,(20+10*50)-20-20,70,25);
		run.setBackground(Color.GREEN);
		run.setMargin(new Insets(0,0,0,0));
		run.setBorder(BorderFactory.createLineBorder(Color.black));
		run.addActionListener(runAction);
		
		window.add(reset,null);
		reset.setBounds(20,(20+10*50)-20-20,70,25);
		reset.setBackground(Color.RED);
		reset.setMargin(new Insets(0,0,0,0));
		reset.setBorder(BorderFactory.createLineBorder(Color.black));
		reset.addActionListener(resetAction);
		
		int runner = JOptionPane.showConfirmDialog(window,"Run simulation?");
		if(runner==JOptionPane.YES_OPTION)
		{
			run.setEnabled(false);
			run.setUI(new MetalButtonUI() 
			{
			    protected Color getDisabledTextColor() 
			    {
					return Color.BLACK;
			    }
			});
			runSim();
		}
		
	}
	
	private JButton run = new JButton("Run");
	private JButton reset = new JButton("Reset");
	
	private ActionListener runAction = new ActionListener()
	{
		public void actionPerformed(ActionEvent r)
		{
			run.setEnabled(false);
			run.setUI(new MetalButtonUI() 
			{
			    protected Color getDisabledTextColor() 
			    {
					return Color.BLACK;
			    }
			});
			runSim();
		}
	};
	
	private ActionListener resetAction = new ActionListener()
	{
		public void actionPerformed(ActionEvent c)
		{
			window.setVisible(false);
			Island newIs = new Island();
		}
	};
	
	/*
	 * this is the main loop of the simulation: 
	 * the mouse is moved and the window is updated accordingly.
	 * is called when "run" button is pressed.
	 */
	public void runSim()
	{	
		final int NUM_MOVES = 50;
		final double WAIT = 0.2;    //pause (in seconds) between moves
		int move = 0;
		status2.setText("Moving");
		for(move=0;move<NUM_MOVES;move++)    //main loop
		{
			count.setText("Moves: " + (move));
			
			if(move<25)
				addTrail(new Color(move*10,255,0), move);
			if(move>=25)
				addTrail(new Color(255,255-(10*(move-25)),0), move);
			
			window.repaint();
			
			try {
				Thread.sleep((long)(1000*WAIT));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			moveMouse(move);
			
			if(flag)
				break;
		}
		if(!flag)
		{
			addTrail(new Color(128,0,0), 50);
			status2.setText("Starved");
			status1.setForeground(Color.WHITE);
			status2.setForeground(Color.WHITE);
			window.repaint();
			saveTrial(move, 3);    //3 is starve condition
		}
	}
	
	/*
	 * adds basic island components
	 */
	private void addComponents()
	{	
		Dimension w = new Dimension(size*COLUMNS+margin+150+margin,margin+size*ROWS);
		
		window.add(order);
		order.setSize(w);
		
		addMouse();
		
		/*
		 * counter box
		 */
		window.add(counter,null);
		counter.setBounds(margin,margin+margin,150,45);
		counter.setBackground(Color.DARK_GRAY);
		counter.setBorder(blackLine);
		counter.add(count);
		
		count.setText("Moves: 0");
		count.setFont(new Font("Dialog", Font.PLAIN, 28));
		count.setForeground(Color.WHITE);
		
		/*
		 * status box
		 */
		window.add(statuser,null);
		statuser.setBounds(margin,margin+margin+45+margin,150,90);
		statuser.setBackground(new Color(0,255,0));
		statuser.setBorder(blackLine);
		statuser.add(status1,null);
		statuser.add(status2,null);
		
		status1.setVerticalAlignment(JLabel.TOP);
		status1.setText("Status:");
		status1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		
		status2.setVerticalAlignment(JLabel.BOTTOM);
		status2.setText("Still");
		status2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		
		/*
		 * stats box
		 */
		window.add(stats,null);
		stats.setBounds(margin,margin+margin+45+margin+90+margin,150,245);
		stats.setBackground(Color.WHITE);
		stats.setBorder(blackLine);
		
		header = new JLabel();
		stats.add(header,null);
		header.setVerticalAlignment(JLabel.TOP);
		header.setText("Lifetime Stats");
		header.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		trials = new JLabel();
		stats.add(trials,null);
		trials.setVerticalAlignment(JLabel.TOP);
		trials.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		escapes = new JLabel();
		stats.add(escapes,null);
		escapes.setVerticalAlignment(JLabel.TOP);
		escapes.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		drowns = new JLabel();
		stats.add(drowns,null);
		drowns.setVerticalAlignment(JLabel.TOP);
		drowns.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		starves = new JLabel();
		stats.add(starves,null);
		starves.setVerticalAlignment(JLabel.TOP);
		starves.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		bridges = new JLabel();
		stats.add(bridges,null);
		bridges.setVerticalAlignment(JLabel.TOP);
		bridges.setText("30% bridges spawned");
		bridges.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		space = new JLabel();
		stats.add(space,null);
		space.setVerticalAlignment(JLabel.TOP);
		space.setText("-----------------------");
		space.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		BufferedReader br;
		try 
		{
			br = new BufferedReader(new FileReader("MouseStats.txt"));
			trials.setText("Trials: " + br.readLine());
			escapes.setText("Escapes: " + br.readLine());
			drowns.setText("Drowns: " + br.readLine());
			starves.setText("Starves: " + br.readLine());
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		/*
		 * window settings
		 */
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(w);
		window.setLayout(null);
		window.getContentPane().setBackground(Color.LIGHT_GRAY);
		window.setLocationRelativeTo(null);
		((Frame) window).setUndecorated(true);
		
		/*
		 * adds island tiles in center
		 */
		for(int r=1;r<ROWS-1;r++)
		{
			for(int c=1;c<COLUMNS-1;c++)
			{
				JPanel tile = new JPanel();
				window.add(tile,null);
				tile.setBounds(c*size+margin+150+margin,r*size+margin,size,size);
				tile.setBackground(sand);
				tile.setBorder(blackLine);
			}
		}
		
		JButton exit = new JButton("X");
		window.add(exit,null);
		exit.setBounds(w.width-margin,0,margin,margin);
		exit.setBackground(Color.RED);
		exit.setBorder(blackLine);
		exit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){System.exit(0);}});
		
		JPanel bar = new JPanel();
		window.add(bar);
		bar.setBounds(0,0,margin+150+margin+COLUMNS*size,margin);
		bar.setBackground(Color.GRAY);
		bar.setBorder(blackLine);
		JLabel header = new JLabel();
		header.setText("Mouse On Island Simulation");
		bar.add(header);
		
		JPanel background = new JPanel();
		window.add(background);
		background.setBounds(margin+150+margin,margin,COLUMNS*size,ROWS*size);
		background.setBackground(water);
	}
	
	/*
	 * some colors that are frequently used
	 */
	private Color water = new Color(120,194,242);
	private Color sand = new Color(191,184,122);
	private Color transparent = new Color(1.0f,1.0f,1.0f,0.0f);
	
	/*
	 * adds random bridges
	 */
	private void addBridges()
	{	
		/*
		 * generates bridges on display by reading 2d array
		 */
		int x = margin+150+margin;int y = margin;
		for(char[] r : grid)
		{
			x=margin+150+margin;
			for(char c : r)
			{
				if(c=='v')    // bridge tile
				{
					JPanel tile = new JPanel();
					window.add(tile,null);
					tile.setBounds(x,y-5,size,size+5);
					tile.setBackground(transparent);
					
					JLabel bridge = new JLabel();

					ImageIcon icon = new ImageIcon("vertBridge.png");
					
					bridge.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
					bridge.setIcon(icon);
					tile.add(bridge);
					
					order.add(tile);
					order.setLayer(tile,0);
					
				}
				if(c=='h')    // horizontal bridge tile
				{
					JPanel tile = new JPanel();
					window.add(tile,null);
					tile.setBounds(x,y-6,size,size);
					tile.setBackground(transparent);
					
					JLabel bridge = new JLabel();
					ImageIcon icon = new ImageIcon("horizBridge.png");
					
					bridge.setBackground(transparent);
					bridge.setIcon(icon);
					tile.add(bridge);
					
					order.add(tile);
					order.setLayer(tile,0);
				}
				x+=size;	
			}
			y+=size;
		}
		
	}

	/*
	 * adds mouse to grid and window (creates new mouse object)
	 */
	private Mouse m = new Mouse();    //creates single mouse object
	private int mRow=5,mCol=7;    //mouse starting position in array/window
	
	/*
	 * adds mouse to window and array
	 */
	public void addMouse()
	{
		window.add(m.mouse);
		
		grid[mRow][mCol] = 'm';
		m.setMouse(margin+150+margin+mCol*size,margin+mRow*size);
		order.add(m.mouse);
		order.setLayer(m.mouse,51);
	}

	private boolean flag = false;
	
	public boolean getFlag()
	{
		return flag;
	}
	
	/*
	 * moves mouse 1 unit in random direction
	 * and checks if it is on a border tile;
	 * if so, executes finishing statements (drown/escape)
	 * 
	 * @param move
	 * passes current move from loop to use in saveTrial
	 * 
	 */
	public void moveMouse(int move)
	{
		grid[mRow][mCol] = (char) move;
		int direction = ThreadLocalRandom.current().nextInt(1,4+1);
		
		switch(direction) 
		{
		case 1:
			mRow-=1;break;    //moves mouse position 1 unit NORTH
		case 2:
			mCol+=1;break;    //moves mouse position 1 unit EAST
		case 3:
			mRow+=1;break;    //moves mouse position 1 unit SOUTH
		case 4:
			mCol-=1;break;    //moves mouse position 1 unit WEST
		default:
			break;
		}
		
		m.setMouse(margin+150+margin+mCol*size,margin+mRow*size);
		
		if(mRow==0||mRow==ROWS-1||mCol==0||mCol==COLUMNS-1)    //if mouse is on border tiles
		{
			if(grid[mRow][mCol]=='v'||grid[mRow][mCol]=='h')    //if tile is bridge
			{
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				window.remove(m.mouse);order.remove(m.mouse);
				status2.setText("Escaped");
				status1.setForeground(Color.WHITE);status2.setForeground(Color.WHITE);
				SwingUtilities.updateComponentTreeUI(window);
				saveTrial(move,1);    //1 is escape condition
			}
			if(grid[mRow][mCol]=='w')    //if tile is water
			{
				addTrail(new Color(0,0,150), 50);
				status2.setText("Drowned");
				status1.setForeground(Color.WHITE);status2.setForeground(Color.WHITE);
				SwingUtilities.updateComponentTreeUI(window);
				saveTrial(move,2);    //2 is drown condition
			}
			flag = true;
		}
		
		grid[mRow][mCol] = 'm';
		
	}
	
	/*
	 * this method colors square under mouse's position according to gradient
	 * 
	 * @param c,i
	 * c is a color passed through which determines the gradient
	 * i is the move # which is used for ordering layers
	 * 
	 */
	public void addTrail(Color c,int i)
	{
		JPanel path = new JPanel();
		window.add(path);
		path.setBounds(margin+150+margin+mCol*size,margin+mRow*size,size,size);
		path.setBackground(c);
		path.setBorder(blackLine);
		order.add(path);
		order.setLayer(path,i);
		
		statuser.setBackground(c);    //updates counter to same color as trail
	}
	
	/*
	 * saves results from each simulation to file
	 * 
	 * @param move, condition
	 * move is the move that the mouse finished on (not used)
	 * condition is 1, 2, or 3 which passes the status of the mouse
	 * 
	 */
	public void saveTrial(int move, int condition)
	{
		
		BufferedReader br;
		int trials = 0,escapes=0,drowns=0,starves=0;
		try {
			br = new BufferedReader(new FileReader("MouseStats.txt"));
			trials = Integer.parseInt(br.readLine());
			escapes = Integer.parseInt(br.readLine());
			drowns = Integer.parseInt(br.readLine());
			starves = Integer.parseInt(br.readLine());
			br.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		trials+=1;
		
		switch(condition)
		{
			case 1:    //escape
			{
				escapes+=1;
				break;
			}
			case 2:    //drown
			{
				drowns+=1;
				
				break;
			}
			case 3:    //starve
			{
				starves+=1;
				
				break;
			}
		}
		
		BufferedWriter fw;
		try 
		{
			fw = new BufferedWriter(new FileWriter("MouseStats.txt"));
			fw.write(trials + "\n" + escapes + "\n" + drowns + "\n" + starves);
			fw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
