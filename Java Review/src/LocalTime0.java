import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class LocalTime0 
{
	public static void main(String[] args) 
	{
		LocalDateTime now = LocalDateTime.now();  
		
		int currentYear = now.get(ChronoField.YEAR);
		int currentMonth = (int)now.getLong(ChronoField.PROLEPTIC_MONTH);
		int currentWeek = now.get(ChronoField.ALIGNED_WEEK_OF_YEAR) + 52*currentYear;
		int currentDay = now.get(ChronoField.DAY_OF_YEAR) + 7*currentWeek;
		int currentHour = now.get(ChronoField.CLOCK_HOUR_OF_DAY) + currentDay*24;
		int currentMinute = now.get(ChronoField.MINUTE_OF_DAY) + currentHour*60;
		int currentSecond = now.get(ChronoField.SECOND_OF_DAY) + currentMinute*60;
		
		String input = JOptionPane.showInputDialog("Enter your date of birth (MM/dd/yyyy)");
		StringTokenizer birthString = new StringTokenizer(input,"/");
		
		int monthInput = Integer.parseInt(birthString.nextToken());
		int dayInput = Integer.parseInt(birthString.nextToken());
		int yearInput = Integer.parseInt(birthString.nextToken());
		
		LocalDateTime birthTime = LocalDateTime.of(yearInput,monthInput,dayInput,0,0,0);
		
		int birthYear = birthTime.get(ChronoField.YEAR);
		int birthMonth = (int)birthTime.getLong(ChronoField.PROLEPTIC_MONTH);
		int birthWeek = birthTime.get(ChronoField.ALIGNED_WEEK_OF_YEAR) + 52*birthYear;
		int birthDay = birthTime.get(ChronoField.DAY_OF_YEAR) + 7*birthWeek;
		int birthHour = birthTime.get(ChronoField.CLOCK_HOUR_OF_DAY) + birthDay*24;
		int birthMinute = birthTime.get(ChronoField.MINUTE_OF_DAY) + birthHour*60;
		int birthSecond = birthTime.get(ChronoField.SECOND_OF_DAY) + birthMinute*60;
		
		int yearsAlive = currentYear - birthYear - 1;
		if(now.get(ChronoField.DAY_OF_YEAR)>=birthTime.get(ChronoField.DAY_OF_YEAR))
			yearsAlive++;
		
		int monthsAlive = currentMonth - birthMonth - 1;
		if(now.get(ChronoField.DAY_OF_YEAR)>=birthTime.get(ChronoField.DAY_OF_YEAR))
			monthsAlive++;
		
		int weeksAlive = currentWeek - birthWeek - 1;
		if(now.get(ChronoField.DAY_OF_YEAR)>=birthTime.get(ChronoField.DAY_OF_YEAR))
			weeksAlive++;
		
		int daysAlive = currentDay - birthDay + 1;
		
		int hoursAlive = currentHour - birthHour + now.get(ChronoField.CLOCK_HOUR_OF_DAY);
		
		int minutesAlive = hoursAlive*60 + now.get(ChronoField.MINUTE_OF_DAY);
		
		int secondsAlive = minutesAlive*60 + now.get(ChronoField.SECOND_OF_DAY);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy 'at' h:mm a");//add second h if 2 digit hour
		String formatDateTime = now.format(formatter);
		JOptionPane.showMessageDialog(null,String.format("You have been alive for %,d seconds\nas of %s.",secondsAlive, formatDateTime));
		//JOptionPane.showMessageDialog(null, "You have been alive for " + yearsAlive + " years");
		
		
		
	}

}
