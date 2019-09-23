package me.xelantro.info;

import java.util.logging.Logger;

public class Main {
	protected static Run test;
	public static void main(String[] args) {
		test = new Test7();
		System.out.println("-->");
		test.run();
	}

	public static abstract class Run extends Main{
		public abstract void run();
	}

	//exteds methods
	public Logger log = Logger.getLogger("Logger");
	public void sysLog(Object obj)
	{
		System.out.println(obj);
		//		log.info(obj.toString());
	}
	public void sysLogBr(Object obj)
	{
		sysLog(obj);
		sysLog("");
	}
	/**
	 * map funktion by Arduino
	 */
	public double map(double x, int in_min, int in_max, int out_min, int out_max)
	{
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}

	public boolean isNumeric(String strNum) {
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}
}
