package de.memium.vectors;

import java.io.PrintStream;
import java.util.ArrayList;

public class Vektor implements Comparable<Vektor> {
	private ArrayList<Double> coord;
	public Vektor(double... pCoord) {
		this.coord = new ArrayList<Double>(pCoord.length);
		for(double i : pCoord)
			this.coord.add(i);
	}

	/**
	 * Betrag
	 */
	public double getVal()
	{
		return Math.sqrt(coord.stream().map(d -> Math.pow(d, 2)).reduce(Double::sum).get());
	}







	//Util

	public void print(PrintStream s)
	{
		s.println(this.toString());
	}

	@Override
	public String toString()
	{
		StringBuilder temp = new StringBuilder();
		temp.append("[\n");
		coord.forEach(i -> temp.append("     "+i+"\n"));
		temp.append(" ]\n");

		return temp.toString();
	}

	public ArrayList<Double> getCoords()
	{
		return coord;
	}

	public double getCoord(int dim)
	{
		return coord.get(dim);
	}

	public void setCoord(int dim, double val)
	{
		coord.set(dim, val);
	}

	@Override
	public int compareTo(Vektor v2) {
		return (int) (this.getVal()-v2.getVal());
	}
}
