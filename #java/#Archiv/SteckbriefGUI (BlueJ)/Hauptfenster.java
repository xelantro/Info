import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Hauptfenster extends JFrame
{
    // Attribute
    Steckbriefverwaltung kSV;
    private TextArea txtAusgabe;

    // Konstruktor(en)
    public Hauptfenster(Steckbriefverwaltung pSV)
    {
        super("Hauptfenster der Steckbriefverwaltung");
        createLayout();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        kSV = pSV;
    }

    // Methoden
    private void createLayout()
    {
        this.setLayout(new BorderLayout());
        JPanel pnlLineStart = new JPanel(new FlowLayout());
        GridLayout gridLayout = new GridLayout(3,1);
        gridLayout.setVgap(5);
        JPanel pnlButtons = new JPanel(gridLayout);
        
        JButton btnNeu = new JButton("Neu");
        btnNeu.addActionListener(e -> kSV.steckbriefHinzufuegen());
        pnlButtons.add(btnNeu);
        JButton btnSortieren = new JButton("Sortieren");
        btnSortieren.addActionListener(e -> kSV.maxsort());
        pnlButtons.add(btnSortieren);
        JButton btnMischen = new JButton("Mischen");
        btnNeu.addActionListener(e -> kSV.mischen());
        pnlButtons.add(btnMischen);
        
        pnlLineStart.add(pnlButtons);
        this.add(pnlLineStart, BorderLayout.LINE_START);
        this.add(txtAusgabe = new TextArea(""), BorderLayout.CENTER); 
        this.pack();
        this.setVisible(true);
    }

    public void aktualisiereAusgabe(ArrayList<Steckbrief> pSteckbriefe)
    {
        StringBuffer sb = new StringBuffer();

        for(Steckbrief s: pSteckbriefe)
        {
            sb.append(s.toString());
            sb.append("\n");
        }
        txtAusgabe.setText(sb.toString());
    }
}