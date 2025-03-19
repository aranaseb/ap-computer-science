import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AmusementTest 
{

    public static void main(String[] args) 
    {
        
        ArrayList<Attraction> rides = new ArrayList<Attraction>();
        
        //Rollercoaster roll = new Rollercoaster(100, 2, 5, 5, "red", 500);
        FerrisWheel fw = new FerrisWheel(1,1,1,1,"1",1,1,1,1,1);
        
        String buttons[] = {"Rollercoaster", "Drop Tower", "Ferris Wheel", "Go Home"};
        String Rbuttons[] = {"Ride", "Info", "Other Rides"};
                
        
        boolean run = true;
        
        JOptionPane.showMessageDialog(null, "Welcome to Death Row");
        
        while(run)
        {
            int interfaceValue = JOptionPane.showOptionDialog(null, "What would you like to do?", "Amusement Park", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
            
            if(interfaceValue == 0)
            {
                while(true)
                {
                    int RValue = JOptionPane.showOptionDialog(null, "Choose an option", "Euthanasia Coaster", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Rbuttons, Rbuttons[0]);
                    
                    if(RValue == 0)
                    {
                        //JOptionPane.showMessageDialog(null, roll.simulate());
                    }
                    if(RValue == 1)
                    {
                        //JOptionPane.showMessageDialog(null, "Speed: " + roll.getSpeed() + " mph\nNumber of Loops: " + roll.getNumberLoops() + "\nAngle of Highest Drop: " + roll.getAngleDrop() + "\nTotal Pukers: " + roll.getTotalPukers() + "\nTotal Deaths: " + roll.getTotalDeaths());
                    }
                    if(RValue == 2)
                    {
                    	break;
                    }
                }
                
            }
            if(interfaceValue == 2)
            {
            	JOptionPane.showMessageDialog(null, "See Console");
                System.out.println(fw.simulate());
            }
            
            if(interfaceValue == 3)
            {
                run = false;
                break;
            }
        }
        
        

    }

}