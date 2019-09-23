public class Steckbrief
{
    // Attribute
    private String vorname, nachname;
    private boolean istMaennlich;
    private long geburtsjahr;
    private int postleitzahl;
    private double gewicht, groesse;

    // Konstruktor(en)
    public Steckbrief(String pVorname, String pNachname,
    boolean pIstMaennlich,
    long pGeburtsjahr,
    int pPostleitzahl,
    double pGewicht, double pGroesse)
    {
        this.vorname = pVorname;
        this.nachname = pNachname;
        this.istMaennlich = pIstMaennlich;
        this.geburtsjahr = pGeburtsjahr;
        this.postleitzahl = pPostleitzahl;
        this.gewicht = pGewicht;
        this.groesse = pGroesse;
    }

    // Methoden
    public String gibVorname()
    {
        return this.vorname;
    }
    
    public void setzeVorname(String pVorname)
    {
        this.vorname = pVorname;
    }
    
    public String gibNachname()
    {
        return this.nachname;
    }
    
    public void setzeNachname(String pNachname)
    {
        this.nachname = pNachname;
    }
    
    public boolean IstMaennlich()
    {
        return this.istMaennlich;
    }
    
    public void setzeIstMaennlich(boolean pIstMaennlich)
    {
        this.istMaennlich = pIstMaennlich;
    }
    
    public long gibGeburtsjahr()
    {
        return this.geburtsjahr;
    }
    
    public void setzeGeburtsjahr(long pGeburtsjahr)
    {
        this.geburtsjahr = pGeburtsjahr;
    }
    
    public int gibPostleitzahl()
    {
        return this.postleitzahl;
    }
    
    public void setzePostleitzahl(int pPostleitzahl)
    {
        this.postleitzahl = pPostleitzahl;
    }
    
    public double gibGewicht()
    {
        return this.gewicht;
    }
    
    public void setzeGewicht(double pGewicht)
    {
        this.gewicht = pGewicht;
    }
    
    public double gibGroesse()
    {
        return this.groesse;
    }
    
    public void setzeGroesse(double pGroesse)
    {
        this.groesse = pGroesse;
    }
    
    public String toString()
    {
        return this.vorname +" "+ this.nachname + ": " + this.geburtsjahr;
    }
}