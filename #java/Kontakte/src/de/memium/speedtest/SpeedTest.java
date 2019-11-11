package de.memium.speedtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import de.memium.info.kontakte.Kontakt;
import de.memium.util.BasicList;

public class SpeedTest
{
	public static void go(int startL, int endL, File logFile) throws Exception
	{
		long t, a; BasicList<Kontakt> list;
		//		Kontakt k;
		int tmp;
		BufferedWriter fw = new BufferedWriter(new FileWriter(logFile));
		fw.append("\"sep=,\"\n");
		System.out.println("Starting...");

		for(int i=startL; i<=endL; i+=1000)
		{
			list = newList(i);
			tmp = (int)(i/2+1);
			//k = new Kontakt("xxxx@memium.de", 2027476499, "SuperPeter", " ");
			t = System.nanoTime();
			list.get(tmp);
			a = System.nanoTime();
			fw.append(i+","+(a-t)+"\n");
		}
		System.out.println("Finalise Writing");
		fw.close();
		System.out.println("Printing...");
		new ChartPrinter(logFile);
	}

	private static BasicList<Kontakt> newList(int size) {
		BasicList<Kontakt> list = new BasicList<Kontakt>();
		for(int i=0; i<size; i++) list.add(new Kontakt("xxxx@memium.de", 2027476499, "Peter Nr. "+i, " "));
		return list;
	}

	public static void main(String[] args) throws Exception {
		SpeedTest.go(10, 90010, new File("./SpeedTestResult/tmp.csv"));
	}
}