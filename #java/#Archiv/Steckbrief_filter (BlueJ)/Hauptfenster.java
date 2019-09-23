import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.*;

public class Hauptfenster extends JFrame implements KeyListener
{
    // Attribute
    private Steckbriefverwaltung kSV;
    private TextArea txtAusgabe;
    private TextArea txtAusgabeFilter;
    private TextField txtFilterIn;

    // Konstruktor(en)
    public Hauptfenster(Steckbriefverwaltung pSV)
    {
        super("Hauptfenster der Steckbriefverwaltung");
        createLayout();

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

        JButton btnSortieren = new JButton("Sortieren");
        btnSortieren.addActionListener(e -> kSV.maxsort());
        pnlButtons.add(btnSortieren);

        JButton btnNeu = new JButton("Neuer Steckbrief");
        btnNeu.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    Eingabefenster ef = new Eingabefenster();
                    Steckbrief neu = ef.gibSteckbrief();
                    if(neu != null)
                    {
                        kSV.steckbriefHinzufuegen(neu);
                    }
                }
            });
        pnlButtons.add(btnNeu);

        JButton btnFltr = new JButton("Filtern");
        btnFltr.addActionListener(e -> this.filter());
        pnlButtons.add(btnFltr);

        pnlLineStart.add(pnlButtons);
        this.add(pnlLineStart, BorderLayout.LINE_START);
        this.add(txtAusgabe = new TextArea(""), BorderLayout.CENTER); 
        txtAusgabe.setFont(new Font("Courier", Font.PLAIN, 22));
        txtAusgabe.setPreferredSize(new Dimension(300, 300));

        this.add(txtAusgabeFilter = new TextArea(""), BorderLayout.LINE_END); 
        txtAusgabeFilter.setFont(new Font("Courier", Font.PLAIN, 22));
        txtAusgabeFilter.setPreferredSize(new Dimension(300, 300));

        JPanel panFltr = new JPanel(new GridLayout(1,3));
        panFltr.add(new JLabel());
        panFltr.add(new JLabel("Filter:"));
        panFltr.add(txtFilterIn = new TextField(20));
        txtFilterIn.setText("");
        this.add(panFltr, BorderLayout.PAGE_START);

        this.pack();
        this.setVisible(true);
    }

    public void createKeyboardListener()
    {
        this.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER) this.filter();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    private void filter()
    {
        this.txtAusgabeFilter.setText(
            kSV.steckbriefe.stream()
            .filter(s -> s.toString().contains(txtFilterIn.getText()))
            .map(Object::toString).collect(Collectors.joining("\n")));
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