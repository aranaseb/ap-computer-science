public abstract class Attraction 
{
    //instance variables
    private int ticketsSold;
    private int riders;
    private double lengthRide;
    private double costTicket;
    private double costRide;
    private int employees;
    private String color;
    private double profit;
    private double revenue;
    private double maintenanceCost;
    private int daysRan;
    
    //constructor
    public Attraction(int r, double l, double c, int e, String co, double mc, int d)
    {
        riders = r;
        lengthRide = l;
        costTicket = c;
        daysRan = d;
        costRide = ((employees*13.8015) + maintenanceCost)*daysRan;
        employees = e;
        color = co;
        maintenanceCost = mc;
        ticketsSold = 0;
        profit = 0;
        revenue = 0;
    }
    
    //getter methods
    public int getTicketsSold()
    {
        return ticketsSold;
    }
    public int getRiders()
    {
        return riders;
    }
    public double getengthRide()
    {
        return lengthRide;
    }
    public double getCostTicket()
    {
        return costTicket;
    }
    public double getCostRide()
    {
        return costRide;
    }
    public int getEmployees()
    {
        return employees;
    }
    public String getColor()
    {
        return color;
    }
    public double getProfit()
    {
        return profit;
    }
    public double getRevenue()
    {
        return revenue;
    }
    public int getDaysRan()
    {
        return daysRan;
    }
    //mutator methods
    public void calculateRevenue()
    {
        int timesRideGoes = (int)(15/lengthRide);
        revenue = timesRideGoes * riders * costTicket * daysRan;
    }
    public void calculateProfit()
    {
        profit = revenue - costRide;
    }
    public abstract String simulate();
    
}