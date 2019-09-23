import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse SpeedTest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SpeedTest
{
	public static int[] times;
	public static void go(int from, int to, File logFile) throws Exception, Util.UserToStupidException
	{
		if(from > to)
			throw new Util.UserToStupidException("the begin index must be lesser that end index!");
		final Steckbriefverwaltung sv = new Steckbriefverwaltung(null);
		long t, a;
		BufferedWriter fw = new BufferedWriter(new FileWriter(logFile));
		
		System.out.println("Starting...");

		for(int i=from; i<=to; i++)
		{
			construct(sv, i+1);
			t = System.currentTimeMillis();
			sv.steckbriefeSortieren_3();
			a = System.currentTimeMillis();
			//sv.steckbriefeDrucken();
			//System.err.println(a-t);
			fw.append((int)(a-t) + "\n" );
		}
		System.out.println("Finalise Writing");
		fw.close();
		System.out.println("Printing...");
		new ChartPrinter(logFile);
	}

	protected static void construct(Steckbriefverwaltung sv, int size)
	{
		Random r = new Random();
		sv.steckbriefe = new Steckbrief[size];
		for(int i = 0; i<sv.steckbriefe.length; i++)
		{
			sv.steckbriefe[i] = new Steckbrief("Tom"+(i+1), "", true, 2018, 42369, (double)(r.nextInt(600))/2, 150);
		}
	}
}
