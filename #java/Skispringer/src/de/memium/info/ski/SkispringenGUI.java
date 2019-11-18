package de.memium.info.ski;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.TextArea;

/**
 * Beschreiben Sie hier die Klasse EingabeFenster.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SkispringenGUI extends JFrame
{
	private static final long serialVersionUID = -2805619926167711485L;
	// Attribute
	private String[] listenBeschriftungen = {"Starterliste 1. Durchgang", "Rangliste nach 1. Durchgang", "Starterliste 2. Durchgang", "Ergebnisliste"};
	private JLabel[] lblListenBeschriftung;
	private String[] buttonBeschriftungen = {"Starterliste erzeugen", "1. Durchgang durchführen", "Starterliste 2. Durchgang anzeigen", "2. Durchgang durchführen"};
	private JButton[] btnListeErzeugen;
	private TextArea[] txtAreaAusgabe;
	private GroupLayout layout;
	private Jury hJury;

	private int[] hAppendCNum = {1,1,1,1};

	/**
	 * Konstruktor für Objekte der Klasse EingabeFenster
	 */
	public SkispringenGUI(String pTitle)
	{
		hJury = new Jury(this);

		erzeugeLayout();

		this.setTitle(pTitle);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Erzeugt das Layout des Eingabefensters.
	 */
	public void erzeugeLayout()
	{
		lblListenBeschriftung = new JLabel[4];
		for (int i = 0; i < 4; i++)
		{
			lblListenBeschriftung[i] = new JLabel(listenBeschriftungen[i]);
		}

		btnListeErzeugen = new JButton[4];
		for (int i = 0; i < 4; i++)
		{
			btnListeErzeugen[i] = new JButton(buttonBeschriftungen[i]);
			btnListeErzeugen[i].addActionListener(hJury);
		}
		enableButtons(1);

		txtAreaAusgabe = new TextArea[4];
		for (int i = 0; i < 4; i++)
		{
			txtAreaAusgabe[i] = new TextArea("");
			txtAreaAusgabe[i].setRows(25);
			txtAreaAusgabe[i].setColumns(20);
		}

		layout = new GroupLayout(this.getContentPane());
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblListenBeschriftung[0])
						.addComponent(txtAreaAusgabe[0])
						.addComponent(btnListeErzeugen[0])
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblListenBeschriftung[1])
						.addComponent(txtAreaAusgabe[1])
						.addComponent(btnListeErzeugen[1])
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblListenBeschriftung[2])
						.addComponent(txtAreaAusgabe[2])
						.addComponent(btnListeErzeugen[2])
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lblListenBeschriftung[3])
						.addComponent(txtAreaAusgabe[3])
						.addComponent(btnListeErzeugen[3])
						)
				);
		layout.linkSize(SwingConstants.HORIZONTAL, txtAreaAusgabe[0], txtAreaAusgabe[1], txtAreaAusgabe[2], txtAreaAusgabe[3],
				btnListeErzeugen[0], btnListeErzeugen[1], btnListeErzeugen[2], btnListeErzeugen[3],
				lblListenBeschriftung[0], lblListenBeschriftung[1], lblListenBeschriftung[2], lblListenBeschriftung[3]);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblListenBeschriftung[0])
						.addComponent(lblListenBeschriftung[1])
						.addComponent(lblListenBeschriftung[2])
						.addComponent(lblListenBeschriftung[3])                    
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtAreaAusgabe[0])
						.addComponent(txtAreaAusgabe[1])
						.addComponent(txtAreaAusgabe[2])
						.addComponent(txtAreaAusgabe[3])                    
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnListeErzeugen[0])
						.addComponent(btnListeErzeugen[1])
						.addComponent(btnListeErzeugen[2])
						.addComponent(btnListeErzeugen[3])
						)
				);

		this.getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		this.pack();
	}

	/**
	 * Setzt den Text in der TextArea, die angegeben ist
	 * 
	 * @param pListNr Nr der TextArea, in der der Text ausgegeben werden soll
	 * @param pText Text, der ausgegeben werden soll
	 */
	public void setText(int pListNr, String pText)
	{
		if (pListNr < txtAreaAusgabe.length)
		{
			txtAreaAusgabe[pListNr].setText(pText);
			hAppendCNum[pListNr] = 1;
		}
	}

	/**
	 * Setzt den Text in der TextArea, die angegeben ist
	 * 
	 * @param pListNr Nr der TextArea, in der der Text ausgegeben werden soll
	 * @param pText Text, der ausgegeben werden soll
	 */
	public void appendText(int pListNr, String pText)
	{
		if (pListNr < txtAreaAusgabe.length)
		{
			txtAreaAusgabe[pListNr].append(hAppendCNum[pListNr]+". "+pText+"\n");
			hAppendCNum[pListNr]++;
		}
	}

	public void clear(int pListNr) {
		txtAreaAusgabe[pListNr].setText("");
		hAppendCNum[pListNr] = 1;
	}

	public void focusBtn(int pBtn) {
		this.getRootPane().setDefaultButton(btnListeErzeugen[pBtn]);
	}

	public void resetScroll(int pListNr) {
		txtAreaAusgabe[pListNr].setCaretPosition(0);
	}

	/**
	 * Liefert den Text, der in der angegebenen TextArea steht
	 * 
	 * @param pListNr Nr der TextArea, deren Text ausgegeben werden soll
	 * @return Text, der in der angegeben Textarea steht
	 */
	public String getText(int pListNr)
	{
		return txtAreaAusgabe[pListNr].getText();
	}

	/**
	 * Steuert, welche Buttons aktiviert sind
	 * 
	 * @param pButtonNr legt fest, bis zu welcher Nummer die Buttons aktiviert sind
	 */
	public void enableButtons(int pButtonNr)
	{
		for(int i = pButtonNr; i < btnListeErzeugen.length; i++)
		{
			btnListeErzeugen[i].setEnabled(false);               
		}

		btnListeErzeugen[pButtonNr-1].setEnabled(true);
		this.focusBtn(pButtonNr-1);
	}
}
