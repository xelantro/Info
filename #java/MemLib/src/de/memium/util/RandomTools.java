package de.memium.util;

import java.util.Random;

/**
 * Diese Klasse stellt satische Methoden für Zufallsnamen und Zufallszahlen
 * bereit
  /**
 * <p>Qualitaets- und UnterstuetzungsAgentur – Landesinstitut für Schule, Materialien zum schulinternen Lehrplan Informatik SII</p>
 *
 * @version 2.1 30.04.2014
 */
public class RandomTools {

	private static Random meinZufall = new Random();

	/**
	 * liefert eine ganze Zahl im Intervall [Min, Max]
	 * 
	 * @param pMinimum
	 * @param pMaximum
	 * @return
	 */
	public static int ganzeZufallszahl(int pMinimum, int pMaximum) 
	{
		return pMinimum + meinZufall.nextInt(pMaximum - pMinimum + 1);
	}

	/**
	 * @param moeglicheZeichen
	 * @return ein zufälliges Zeichen aus dem String
	 */
	private static String zufallsgriff(String moeglicheZeichen) {
		return ""
				+ moeglicheZeichen.charAt(ganzeZufallszahl(0,
						moeglicheZeichen.length() - 1));
	}

	/**
	 * 
	 * @return ein Zufallsname, bestehend aus drei Buchstaben und einer Zufalls-Endung
	 */
	public static String zufallsname() {
		return zufallsgriff("BDFGHJKLMNPRSTVWZ") + zufallsgriff("aeiou")
		+ zufallsgriff("dfghklmnprstxz") + zufallsEndung();
	}

	/**
	 * 
	 * @return Eine Zufalls-Endung
	 */
	private static String zufallsEndung() {
		switch (ganzeZufallszahl(1, 6)) {
		case 1:
			return "meier";
		case 2:
			return "mueller";
		case 3:
			return "schulze";
		case 4:
			return "mann";
		case 5:
			return "hausen";
		case 6:
			return "sen";
		}
		return "";
	}
}
