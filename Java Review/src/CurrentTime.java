import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime 
{
	public void Clock()
	{
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter clockFormatter = DateTimeFormatter.ofPattern("h:mm a");
		String clockTime = clockFormatter.format(now);
	}
	
	public String updateClock(String oldTime)
	{
		LocalDateTime newTime = LocalDateTime.now();
		DateTimeFormatter clockFormatter = DateTimeFormatter.ofPattern("h:mm a");
		String newClockTime = clockFormatter.format(newTime);
		return newClockTime;
	}
}
