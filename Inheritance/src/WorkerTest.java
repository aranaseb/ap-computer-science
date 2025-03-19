import java.util.ArrayList;

public class WorkerTest {

	public static void main(String[] args) 
	{
		ArrayList<Worker> workers = new ArrayList<Worker>();
		workers.add(new SalariedWorker("Sally",45));
		workers.add(new HourlyWorker("Harry",35));
		
		System.out.println("\nPay for 30 hours:");
		System.out.println(computePay(workers.get(0), 30));
		System.out.println(computePay(workers.get(1), 30));
		
		System.out.println("\nPay for 50 hours:");
		System.out.println(computePay(workers.get(0), 50));
		System.out.println(computePay(workers.get(1), 50));
		
	}
	
	public static String computePay(Worker w, int hours)
	{
		return w.name + ": $" + w.computePay(hours);
	}

}
