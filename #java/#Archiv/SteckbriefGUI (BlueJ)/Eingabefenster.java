import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eingabefenster extends JDialog
{
    private boolean ready;

    private JTextField vorname, nachname, geburtsjahr, postleitzahl, gewicht, groesse;
    private JComboBox geschlecht;

    private Steckbrief out = null;

    // Konstruktor(en)
    public Eingabefenster()
    {
        super();
        this.setTitle("Neuen Steckbrief anlegen ...");
        this.setModal(true);
        this.setMinimumSize(new Dimension(600,300));
        createLayout();
    }

    // Methoden
    private void createLayout()
    {
        this.setLayout(new BorderLayout());

        JPanel in = new JPanel(new GridLayout(7,2));
        //TODO layouts hinzufügen

        vorname = new JTextField();
        nachname = new JTextField();
        geburtsjahr = new JTextField();
        postleitzahl = new JTextField();
        gewicht = new JTextField();
        groesse = new JTextField();
        String[] geschlechter = {"Männlich", "Weiblich", "Weiteres"};
        geschlecht = new JComboBox(geschlechter);

        in.add(new JLabel("Vorname"));
        in.add(vorname);
        in.add(new JLabel("Nachname"));
        in.add(nachname);
        in.add(new JLabel("Geschlecht"));
        in.add(geschlecht);
        in.add(new JLabel("Geburtsjahr"));
        in.add(geburtsjahr);
        in.add(new JLabel("Postleitzahl"));
        in.add(postleitzahl);
        in.add(new JLabel("Gewicht"));
        in.add(gewicht);
        in.add(new JLabel("Groesse"));
        in.add(groesse);

        this.add(in, BorderLayout.CENTER);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(e -> {try{
                    out = new Steckbrief(vorname.getText(), nachname.getText(), (geschlecht.getSelectedIndex()==0), 
                        Long.parseLong(geburtsjahr.getText()), Integer.parseInt(postleitzahl.getText()), 
                        Double.parseDouble(gewicht.getText()), Double.parseDouble(groesse.getText()));
                } catch(Exception m){JOptionPane.showMessageDialog(this, "Test", 
                "Error!", JOptionPane.ERROR_MESSAGE);}});
        this.add(btnOK, BorderLayout.PAGE_END);
    }

    public Steckbrief gibSteckbrief()
    {
        this.setVisible(true);
        while(out==null) {}
        this.setVisible(false);
        return out;
    }
}