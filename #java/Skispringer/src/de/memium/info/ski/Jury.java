package de.memium.info.ski;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.stream.Stream;

import de.memium.util.BasicList;
import de.memium.util.RandomTools;

public class Jury implements ActionListener
{
	// Attribute
	private SkispringenGUI kSkispringenGUI;
	private BasicList<Skispringer> hStarterliste1, hRangliste1, hStarterliste2, hRangliste2;
	private Stream<Skispringer> hS;

	/**
	 * Konstruktor der Klasse Jury
	 * 
	 * @param pSkispringenGUI liefert Referenz auf das GUI
	 */
	public Jury(SkispringenGUI pSkispringenGUI)
	{
		this.kSkispringenGUI = pSkispringenGUI;

		this.hStarterliste1 = new BasicList<Skispringer>();
		this.hRangliste1 = new BasicList<Skispringer>();
		this.hStarterliste2 = new BasicList<Skispringer>();
		this.hRangliste2 = new BasicList<Skispringer>();
	}

	/**
	 * Ereignismethode für alle vier Buttons (to do!!!)
	 */
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		String[] buttonBeschriftung = {"Starterliste erzeugen", "1. Durchgang durchführen", "Starterliste 2. Durchgang anzeigen", "2. Durchgang durchführen"};
		System.out.println("Btn: "+e.getActionCommand());
		if (e.getActionCommand().equals(buttonBeschriftung[0]))
		{
			this.hStarterliste1.clear();
			this.kSkispringenGUI.clear(0);
			this.hStarterliste1 = Stream.generate(()->new Skispringer(RandomTools.zufallsname()))
					.limit(50)
					//.peek(System.out::println)
					.peek(s->kSkispringenGUI.appendText(0, s.toString()))
					.collect(BasicList.collector());
			this.kSkispringenGUI.resetScroll(0);
			this.kSkispringenGUI.enableButtons(2);
		}
		else if (e.getActionCommand().equals(buttonBeschriftung[1]))
		{
			this.hRangliste1.clear();
			this.kSkispringenGUI.clear(1);
			this.hRangliste1 = this.hStarterliste1.stream()
					.peek(s->s.setzePunkte(1, 80, 120))
					.sorted()
					.peek(s->kSkispringenGUI.appendText(1, s.toString()))
					.collect(BasicList.collector());
			this.kSkispringenGUI.resetScroll(1);
			this.kSkispringenGUI.enableButtons(3);
		}
		else if (e.getActionCommand().equals(buttonBeschriftung[2]))
		{
			this.hStarterliste2.clear();
			this.kSkispringenGUI.clear(2);
			this.hStarterliste2 = this.hRangliste1.stream()
					.limit(30)
					.sorted(Comparator.reverseOrder())
					.peek(s->kSkispringenGUI.appendText(2, s.toString()))
					.collect(BasicList.collector());
			this.kSkispringenGUI.resetScroll(2);
			this.kSkispringenGUI.enableButtons(4);
		}
		else if (e.getActionCommand().equals(buttonBeschriftung[3]))
		{
			this.hRangliste2.clear();
			this.kSkispringenGUI.clear(3);
			this.hRangliste2 = this.hStarterliste2.stream()
					.peek(s->s.setzePunkte(2, (int)(s.gibPunkte(1)*0.8), (int)(s.gibPunkte(1)*1.2)))
					.sorted()
					.peek(s->kSkispringenGUI.appendText(3, s.toString()))
					.collect(BasicList.collector());
			this.kSkispringenGUI.resetScroll(3);
		}
	}
}
