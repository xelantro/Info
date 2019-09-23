package de.memium.planets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Verwaltung extends JFrame {
	private static final long serialVersionUID = -5022424809077415287L;
	private Planet[] karten;

	public Verwaltung(Planet[] karten) {
		this.karten=karten;

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Verwaltung: Planeten");

		JTable table;
		Object[][] data = Arrays.stream(karten).map(p-> {Object[] o=new Object[6]; o[0]=p.getName(); o[1]=p.getMasse(); o[2]=p.getDurchmesser(); o[3]=p.getUmlaufzeit(); o[4]=p.getAnzahlMonde(); o[5]=p.getAbstandZurSonne(); return o;}).toArray(Object[][]::new);
		Object[] cNames = {"Name","Masse in M⊕","Durchmesser in km","Umlaufzeit in d","Anz. Monde","Abstand zur Sonne in Gm"};
		this.add(new JScrollPane(table=new JTable(data, cNames)));
		table.setFont(new Font(Font.SERIF, Font.PLAIN, 21));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		@SuppressWarnings("unchecked")
		TableRowSorter<TableModel> trs = (TableRowSorter<TableModel>)table.getRowSorter();
		trs.setComparator(1,(Double i, Double j)->i.compareTo(j));
		trs.setComparator(2,(Double i, Double j)->i.compareTo(j));
		trs.setComparator(3,(Double i, Double j)->i.compareTo(j));
		trs.setComparator(4,(Integer i, Integer j)->i.compareTo(j));
		trs.setComparator(5,(Double i, Double j)->i.compareTo(j));

		//		this.sortieren();
		//		this.ausgeben();
		this.setMinimumSize(new Dimension(trs.getModel().getColumnCount()*155, Math.min(500, trs.getModel().getRowCount()*39+70/*ohne Abstand: 10*/)));
		this.validate();
		this.setVisible(true);
	}

	public void sortieren() {
		Arrays.sort(karten);
	}

	public void ausgeben() {
		for(Planet p : karten) {
			System.out.println(p);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new FileReader("data/Planeten2019.txt"));
		new Verwaltung((Planet[]) r.lines().map(s -> new Planet(s.replace(',', '.').split(";"))).toArray(Planet[]::new));
		r.close();
	}
}
