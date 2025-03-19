import java.time.LocalDate;

public class FerrisWheel extends Attraction
{
	public FerrisWheel(int r, double l, double c, int e, String co, double mc, int d, double h, double n, double rp) {
		super(r, l, c, e, co, mc, d);
		height = h;
		numCars = n;
		rpm = rp;
		fatalities = (int)(Math.random()*20) + 10;
	}
	private double height;
	private double numCars;
	private double rpm;
	private int fatalities;
	
	
	
	@Override
	public String simulate() 
	{
		return    "                       __  __                             \r\n"
				+ "                   __ [_|]'_|] __                         \r\n"
				+ "                  [_|].-'-_-_'-._]                        \r\n"
				+ "                _.'.'-.-''   '-.-'__                      \r\n"
				+ "               [_|]-.'.  '   ' .'.-_]                     \r\n"
				+ "              _/ /_/ '.'. ' ' .  .' -_                    \r\n"
				+ "             [_|]_'    '.'_'_. .'  '._]                   \r\n"
				+ "              |_|_| = = (.-_o) = = :-_'                   \r\n"
				+ "             [_|] _    .//\\/_\\.    .-_]                 \r\n"
				+ "               \\_\\_\\ .'//_//_\\\\'. .-.                \r\n"
				+ "               [_|]_`./.-/.-.-.\\_'-_]                   +   __    ___                    /XXXXX\\\r\n"
				+ "                 '.'.-'-//__.\\.\\\\.'                     |  /XX\\\\   /   \\\\        __        /XXXXXX\\\r\n"
				+ "                  [_|]-/.-_ .-[_\\\\     _    _           | /XXXX\\\\ (     )      /XX\\\\      /xXXXXXX\\\r\n"
				+ " _ _ _ _ _ _ _ _   // // [_|]  \\.\\\\   [ ]  [ ]          |/XXXXXX\\\\\\\\___/__    /XXXX\\\\    /xXXXXXXX\\\r\n"
				+ "_|X|X|X|X|X|X|X|__//_//_________\\.\\\\___|____|__n_n_n___ /XXXXXXXX\\\\__/XXX\\\\__/XXXXXX\\\\__/xXXXXXXXX\\\r\n"
				+ "                                                          \r\n"
				+ "                Death Row Ferris Wheel                    \r\n"
				+ "                      "+LocalDate.now()+"                 \r\n"
				+ "         There were "+fatalities+" casualties on this ride\r\n";
	}
	
}
