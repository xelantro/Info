package de.memium.info.ski;
import de.memium.util.RandomTools;

/**
 * ein Skispringer hat einen Namen und verwaltet in zwei Durchgängen Punkte
 * <p>Qualitaets- und UnterstuetzungsAgentur – Landesinstitut für Schule, Materialien zum schulinternen Lehrplan Informatik SII</p>
 *
 * @version 2.1 28.04.2014
 */
public class Skispringer implements Comparable<Skispringer> {

	public static final int DURCHGANG1 = 1;
	public static final int DURCHGANG2 = 2;
	public static final int GESAMT = 3;

	// Attribute
	private String name;
	private int punkte1, punkte2;

	/**
	 * Ein neuer Skispringer mit dem angegebenen Namen wird erzeugt. Er hat in
	 * beiden Durchgaengen noch 0 Punkte
	 * 
	 * @param name
	 */
	public Skispringer(String name) {
		this.name = name;
		this.punkte1 = 0;
		this.punkte2 = 0;
	}

	/**
	 * Ein neuer Skispringer mit dem zufälligem Namen wird erzeugt. Er hat in
	 * beiden Durchgaengen noch 0 Punkte
	 */
	public Skispringer()
	{
		this(RandomTools.zufallsname()); // Durch "this" ruft man den passenden Konstrukor derselben Klasse auf!
	}

	/**
	 * Der Name des Skispringers wird geliefert.
	 */
	public String gibName() {
		return name;
	}

	/**
	 * Die Punktzahl des Skispringers aus dem angegebenen Durchgang wird
	 * geliefert.
	 */
	public int gibPunkte(int pDurchgang) {
		if (pDurchgang == Skispringer.DURCHGANG1) {
			return punkte1;
		} else if (pDurchgang == Skispringer.DURCHGANG2) {
			return punkte2;
		} else if (pDurchgang == Skispringer.GESAMT) {
			return punkte1 + punkte2;
		} else {
			return -1;
		}
	}

	/**
	 * Die Punktzahl des Skispringers im angegebenen Durchgang wird gesetzt.
	 */
	public void setzePunkte(int pDurchgang, int pNeuePunkte) {
		if (pDurchgang == Skispringer.DURCHGANG1) {
			punkte1 = pNeuePunkte;
		} else if (pDurchgang == Skispringer.DURCHGANG2) {
			punkte2 = pNeuePunkte;
		}
	}

	/**
	 * Die Punktzahl des Teilnehmers im angegebenen Durchgang wird im
	 * angegebenen Bereich zufaellig festgelegt.
	 */
	public void setzePunkte(int pDurchgang, int pMinimum, int pMaximum) {
		int neuePunkte = RandomTools.ganzeZufallszahl(pMinimum, pMaximum);
		this.setzePunkte(pDurchgang, neuePunkte);
	}

	/**
	 * Ausgabe der Daten des Skispringers als String
	 */
	@Override
	public String toString() {
		return this.gibName() + ":" + this.gibPunkte(1) + "+"
				+ this.gibPunkte(2) + " = " + this.gibPunkte(3);
	}

	public int compareTo(int durchgang, Skispringer o) {
		if(this.gibPunkte(durchgang)<o.gibPunkte(durchgang)) return 1;
		else if(this.gibPunkte(durchgang)>o.gibPunkte(durchgang)) return -1;
		else return 0;
	}

	@Override
	public int compareTo(Skispringer o) {
		return this.compareTo(GESAMT, o);
		//return this.gibPunkte(GESAMT)-o.gibPunkte(GESAMT);
	}
}
