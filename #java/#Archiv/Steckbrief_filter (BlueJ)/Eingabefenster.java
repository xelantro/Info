import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eingabefenster extends JDialog
{
    // Attribute
    private Steckbrief steckbrief = null;
    
    // Konstruktor(en)
    public Eingabefenster()
    {
        super();
        this.setTitle("Neuen Steckbrief anlegen ...");
        this.setModal(true);
        this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) 
                {
                    steckbrief = null;
                }
            });
        createLayout();
    }

    // Methoden
    private void createLayout()
    {
        this.setLayout(new BorderLayout());
        JPanel pnlEingabe = new JPanel(new GridLayout(14,1));
        JLabel lblVorname = new JLabel("Vorname: ");
        JTextField txtVorname = new JTextField(20);
        pnlEingabe.add(lblVorname);
        pnlEingabe.add(txtVorname);
        JLabel lblNachname = new JLabel("Nachname: ");
        JTextField txtNachname = new JTextField(20);
        pnlEingabe.add(lblNachname);
        pnlEingabe.add(txtNachname);
        JLabel lblGeschlecht = new JLabel("Geschlecht: ");
        String[] eintraege = {"männlich", "weiblich"};
        JComboBox<String> cmbGeschlecht = new JComboBox<String>(eintraege);
        pnlEingabe.add(lblGeschlecht);
        pnlEingabe.add(cmbGeschlecht);
        JLabel lblGeburtsjahr = new JLabel("Geburtsjahr: ");
        JTextField txtGeburtsjahr = new JTextField(20);
        pnlEingabe.add(lblGeburtsjahr);
        pnlEingabe.add(txtGeburtsjahr);
        JLabel lblPLZ = new JLabel("Postleitzahl: ");
        JTextField txtPLZ = new JTextField(20);
        pnlEingabe.add(lblPLZ);
        pnlEingabe.add(txtPLZ);
        JLabel lblGewicht = new JLabel("Gewicht: ");
        JTextField txtGewicht = new JTextField(20);
        pnlEingabe.add(lblGewicht);
        pnlEingabe.add(txtGewicht);
        JLabel lblGroesse = new JLabel("Groesse: ");
        JTextField txtGroesse = new JTextField(20);
        pnlEingabe.add(lblGroesse);
        pnlEingabe.add(txtGroesse);
        this.add(pnlEingabe, BorderLayout.CENTER);
        JButton btnOK = new JButton("OK");
        JPanel pnlButton = new JPanel();
        pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnOK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                long lGeburtsjahr;
                int lPLZ;
                double lGewicht, lGroesse;
                try
                {
                    lGeburtsjahr = Long.parseLong(txtGeburtsjahr.getText());
                }
                catch(NumberFormatException ex)
                {
                    txtGeburtsjahr.setText("");
                    return;
                }
                try
                {
                    lPLZ = Integer.parseInt(txtPLZ.getText());
                }
                catch(NumberFormatException ex)
                {
                    txtPLZ.setText("");
                    return;
                }
                try
                {
                    lGewicht = Double.parseDouble(txtGewicht.getText());
                }
                catch(NumberFormatException ex)
                {
                    txtGewicht.setText("");
                    return;
                }
                try
                {
                    lGroesse = Double.parseDouble(txtGroesse.getText());
                }
                catch(NumberFormatException ex)
                {
                    txtGroesse.setText("");
                    return;
                }
                steckbrief = new Steckbrief(txtVorname.getText(), txtNachname.getText(), cmbGeschlecht.getSelectedIndex()==0, lGeburtsjahr, lPLZ, lGewicht, lGroesse);
                Eingabefenster.this.setVisible(false);
            }
        });
        pnlButton.add(btnOK);
        this.add(pnlButton, BorderLayout.PAGE_END);
        this.pack();
        this.setVisible(true);
    }
    
    public Steckbrief gibSteckbrief()
    {
        return steckbrief;
    }
}