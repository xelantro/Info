package de.memium.planets;

public class Planet implements Comparable<Planet>{
	private String name;
	private double durchmesser;
	private double abstandZurSonne;
	private double masse;
	private double umlaufzeit;
	private int anzahlMonde;

	public Planet(String name, double durchmesser, double abstandZurSonne, double masse, double umlaufzeit, int anzahlMonde) {
		this.name = name;
		this.durchmesser = durchmesser;
		this.abstandZurSonne = abstandZurSonne;
		this.masse = masse;
		this.umlaufzeit = umlaufzeit;
		this.anzahlMonde = anzahlMonde;
	}
	public Planet(String[] params) {
		this(params[0],Double.parseDouble(params[1]),Double.parseDouble(params[2]),Double.parseDouble(params[3]),Double.parseDouble(params[4]),Integer.parseInt(params[5]));
	}
	public Planet(String params) {
		this(params.split(";"));
	}

	@Override
	public String toString() {
		return "Planet "+name+": "+durchmesser+" | "+masse+" | "+umlaufzeit+" | "+anzahlMonde+" | "+abstandZurSonne;
	}

	//Comperators
	@Override
	public int compareTo(Planet p) {
		return this.compareSize(p);
	}
	public int compareSize(Planet p) {
		if(this.durchmesser>p.durchmesser) return 1;
		else if(this.durchmesser<p.durchmesser) return -1;
		else return 0;
	}
	public int compareDistance(Planet p) {
		if(this.abstandZurSonne>p.abstandZurSonne) return 1;
		else if(this.abstandZurSonne<p.abstandZurSonne) return -1;
		else return 0;
	}
	public int compareMass(Planet p) {
		if(this.masse>p.masse) return 1;
		else if(this.masse<p.masse) return -1;
		else return 0;
	}
	public int compareYearlenght(Planet p) {
		if(this.umlaufzeit>p.umlaufzeit) return 1;
		else if(this.umlaufzeit<p.umlaufzeit) return -1;
		else return 0;
	}
	public int compareMooncount(Planet p) {
		if(this.anzahlMonde>p.anzahlMonde) return 1;
		else if(this.anzahlMonde<p.anzahlMonde) return -1;
		else return 0;
	}

	//Getter - Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDurchmesser() {
		return durchmesser;
	}
	public void setDurchmesser(double durchmesser) {
		this.durchmesser = durchmesser;
	}
	public double getAbstandZurSonne() {
		return abstandZurSonne;
	}
	public void setAbstandZurSonne(double abstandZurSonne) {
		this.abstandZurSonne = abstandZurSonne;
	}
	public double getMasse() {
		return masse;
	}
	public void setMasse(double masse) {
		this.masse = masse;
	}
	public double getUmlaufzeit() {
		return umlaufzeit;
	}
	public void setUmlaufzeit(double umlaufzeit) {
		this.umlaufzeit = umlaufzeit;
	}
	public int getAnzahlMonde() {
		return anzahlMonde;
	}
	public void setAnzahlMonde(int anzahlMonde) {
		this.anzahlMonde = anzahlMonde;
	}
}
