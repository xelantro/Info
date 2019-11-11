package de.memium.info.kontakte;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Kontaktverwaltung extends JFrame {
	private static final long serialVersionUID = -1308495381250942224L;
	public ArrayList<Kontakt> kontakte = new ArrayList<Kontakt>();

	public Kontaktverwaltung(ArrayList<Kontakt> kontakte) {
		this.kontakte = kontakte;

		this.setTitle("Kontakte");
		this.setLayout(new BorderLayout());
		JPanel pnlWrapper = new JPanel();
		JPanel pnlLS = new JPanel(new GridLayout(5, 1));
		JButton btnHinzufuegen = new JButton("Hinzufügen");
		btnHinzufuegen.addActionListener(a->{});
		JButton btnLoeschen = new JButton("Löschen");
		btnLoeschen.addActionListener(a->{});
		JButton btnImportieren = new JButton("Inportieren");
		btnImportieren.addActionListener(a->{});
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.addActionListener(a->{});
		JButton btnAusgeben = new JButton("Ausgeben");
		btnAusgeben.addActionListener(a->this.kontakteAnzeigen());
		pnlLS.add(btnHinzufuegen);
		pnlLS.add(btnLoeschen);
		pnlLS.add(btnImportieren);
		pnlLS.add(btnSuchen);
		pnlLS.add(btnAusgeben);
		pnlWrapper.add(pnlLS);
		this.add(pnlWrapper, BorderLayout.LINE_START);
		TextArea txtAusgabe = new TextArea();
		txtAusgabe.setPreferredSize(new Dimension(300,600));
		this.add(txtAusgabe, BorderLayout.CENTER);
		System.setOut(new TAPrintStream(new ByteArrayOutputStream(), txtAusgabe));
		this.pack();
		this.setVisible(true);
	}

	public void kontaktHinzufuegen(Kontakt k)
	{
		kontakte.add(k);
	}

	public void kontaktLoeschen(Kontakt k)
	{
		kontakte.remove(k);
	}

	public void kontakteAnzeigen()
	{
		kontakte.forEach(System.out::println);
	}

	class TAPrintStream extends PrintStream {
		TextArea ta;
		public TAPrintStream(OutputStream str, TextArea ta) {
			super(str,true);
			this.ta = ta;
		}
		@Override
		public void println(String str) {
			this.ta.append(str+"\n");
		}
		@Override
		public void println(Object obj) {
			this.ta.append(obj.toString()+"\n");
		}
		@Override
		public void print(String str) {
			this.ta.append(str);
		}
		@Override
		public void print(Object obj) {
			this.ta.append(obj.toString());
		}
	}

	public static void main(String[] args) {
		ArrayList<Kontakt> al = new ArrayList<Kontakt>();
		al.add(new Kontakt("foo@memium.de",34567876543L,"Eyo","Mann"));
		al.add(new Kontakt("bar@memium.de",67898767890L,"Heya","Mann"));

		new Kontaktverwaltung(al);
	}
}
