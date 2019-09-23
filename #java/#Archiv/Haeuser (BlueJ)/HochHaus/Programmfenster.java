import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Toolkit;

/**
 * Die Klasse Programmfenster zeigt ein Objekt vom Datentyp Leinwand an.
 * Sie steuert die FPS-Rate und ruft die loop-Methode des Leinwand-Objektes kontinuierlich auf.
 * 
 * @autor Gerd Heischkamp
 */
public class Programmfenster extends JFrame implements Runnable
{
    // Attribute
    private Leinwand hLeinwand;
    private double lastTime = 0.0, fps = 0;
    private int sleepTime = 40;
    private final int MIN_SLEEP_TIME = 10, MAX_SLEEP_TIME = 200, TARGET_FPS = 24;
    private long time;
    private Image offscreenBild = null;
    private Graphics offscreenZeichenflaeche = null;
    private int breite, hoehe;
    protected ArrayList<Akteur> akteure = null;
    protected Color hintergrundFarbe = Color.WHITE;
    
    /**
     * Erzeugt eine Instanz der Klasse Programmfenster.
     */
    public static void main(String[] args)
    {
        Programmfenster frame = new Programmfenster();
    }

    /**
     * Konstruktor der Klasse Programmfenster. Das Fensterlayout wird aufgebaut und die Loop-Schleife des Leinwand-Objektes wird gestartet.
     */
    public Programmfenster()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(String.format("FPS: %4.2f SleepTime %2d",fps, sleepTime));
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        hoehe = (int)(d.getHeight()*0.8);
        breite = hoehe;
        hLeinwand = new Leinwand(breite, hoehe, Color.BLUE);
        init();
        this.add(hLeinwand, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);  
        this.startAnimation();
    }
    
    private void init()
    {
        //this.akteurEinfuegen(new HausOhneDach(200, 850, 20));
        //this.akteurEinfuegen(new Baumstamm(400, 850, 15));
        //this.akteurEinfuegen(new Blumenstengel(600, 850, 5));
        
    }
    
    private void zeichneHintergrund(Graphics2D pGC)
    {
        pGC.setColor(Color.GREEN);
        pGC.fillRect(0, (int)(0.8*hoehe), hLeinwand.getWidth(), hLeinwand.getHeight()-((int)(0.8*hoehe)));
    }
    
    /**
     * Setzt die Hintergrundfarbe der Welt. Nur sichtbar, wenn kein Hintergrundbild gewaehlt ist.
     * 
     * @param pHintergrundfarbe Farbe des Hintergrundes
     */
    private void setzeHintergrundFarbe(Color pHintergrundfarbe)
    {
        hintergrundFarbe = pHintergrundfarbe;
    }

    /**
     * Liefert die Hintergrundfarbe der Welt. Nur sichtbar, wenn kein Hintergrundbild gewaehlt ist.
     */
    private Color gibHintergrundFarbe()
    {
        return hintergrundFarbe;
    }

    /**
     * Fuegt einen Akteuer in die Liste der Akteure ein, die in der Welt existieren.
     * 
     * @param pAkteur Einzufuegender Akteur
     */
    public void akteurEinfuegen(Akteur pAkteur)
    {
        akteure.add(pAkteur);
    }

    /**
     * Loescht einen Akteur aus der Liste der Akteure, die auf der Leinwand dargestellt werden.
     * 
     * @param pAkteur Zu loeschender Akteur
     */
    public void akteurEntfernen(Akteur pAkteur)
    {
        akteure.remove(pAkteur);
    }

    /**
     * Startet die Animation, die loop-Schleife beginnt.
     */
    private void startAnimation()
    {
        lastTime = System.nanoTime();
        time = System.currentTimeMillis();
        Thread th = new Thread(this);
        th.start();
    }

    /**
     * Die loop-Schleife wird nebenlaeufig ausgefuehrt.
     */
    public void run()
    {
        while (true) {
            controlFPS();

            hLeinwand.loop();
            hLeinwand.repaint();

            delay(sleepTime);
        }
    }

    /**
     * Verzoegert die loop-Schleife des Programmfensters. Nebenlaeufige Threads bekommen Rechenzeit.
     * 
     * @param pSecInMillis Zeit in Millisekunden
     */
    private void delay(long pSecInMillis)
    {
        try {
            Thread.sleep(pSecInMillis);
        } catch (InterruptedException e) {
            //nichts
        }
    }

    /**
     * Reguliert die Verzoegerungszeit innerhalb der loop-Schleife, so dass die FPS-Rate optimal ist.
     */
    private void controlFPS()
    {
        fps = -1000000000.0 / (lastTime - (lastTime = System.nanoTime()));
        if(fps > TARGET_FPS) sleepTime++; else sleepTime--;
        sleepTime = (sleepTime < MIN_SLEEP_TIME) ? MIN_SLEEP_TIME : (sleepTime > MAX_SLEEP_TIME) ? MAX_SLEEP_TIME : sleepTime;
        if(System.currentTimeMillis() - time > 1000)
        {
            this.setTitle(String.format("FPS: %4.2f SleepTime %2d",fps, sleepTime));
            time = System.currentTimeMillis();
        }
    }

    // innere Klasse ===========================
    /**
     * Ein Objekt der Klasse Leinwand verwaltet eine Liste von Akteur-Objekten. 
     * 
     * @author Gerd Heischkamp
     */
    public class Leinwand extends JComponent
    {

        /**
         * Konstruktor der Klasse Leinwand.
         * 
         * @param pBreite Breite der Leinwand
         * @param pHoehe Hoehe der Leinwand
         */
        public Leinwand(int pBreite, int pHoehe)
        {
            this(pBreite, pHoehe, Color.WHITE);
        }

        /**
         * Konstruktor der Klasse Leinwand.
         * 
         * @param pBreite Breite der Leinwand
         * @param pHoehe Hoehe der Leinwand
         * @param pBgColor Farbe des Hintergrundes
         */

        public Leinwand(int pBreite, int pHoehe, Color pBgColor)
        {
            super();
            breite = pBreite;
            hoehe = pHoehe;
            this.setPreferredSize(new Dimension(breite, hoehe));
            akteure = new ArrayList<Akteur>();
            initialisiereWelt();
            hintergrundFarbe = pBgColor;
        }

        /**
         * Die Methode wird automatisch aufgrufen, wenn ein Leinwand-Objekt erzeugt wird. Hier können 
         * Initialisierungen vorgenommen werden.
         */
        public void initialisiereWelt(){}

        /**
         * Die Methode wird bei jedem Zyklus der Handlungsschleife aufgerufen, bevor die entsprechende
         * agiere-Methode der Akteur-Objekte aufgerufen wird.
         */
        public void agiere(){}

        /**
         * Die Methode wird in einer Schleife aufgerufen, wodurch vom Leinwand-Objekt und den Akteur-Objekten
         * die agiere-Methoden aufgerufen werden.
         */
        public void loop()
        {
            // Welt-Handlungsschritt durchführen lassen
            this.agiere();

            // Akteur-Handlungsschritte durchführen lassen
            for( Akteur a: akteure)
            {
                a.agiere();
            }
        }

        /**
         * Ueberschreibt die Methoder der Oberklasse. Das Bild wird neu gezeichnet.
         */
        @Override
        public void update(Graphics g)
        {
            paint(g);
        }

        /**
         * Ueberschreibt die Methode der Oberklasse. Das Bild wird neu gezeichnet.
         */
        @Override
        public void paint(Graphics g)
        {
            zeichneLeinwand(g);
        }

        /**
         * Zeichnet die Leinwand und alle Akteuer, die auf der Leinwand existieren.
         */
        public void zeichneLeinwand(Graphics g)
        {
            // Double-Buffer initialisieren
            if (offscreenBild == null) 
            {
                offscreenBild = createImage(
                    this.getSize().width,
                    this.getSize().height
                );
                offscreenZeichenflaeche = offscreenBild.getGraphics();
            }

            Graphics2D g2d = (Graphics2D)offscreenZeichenflaeche;
            g2d.setColor(hintergrundFarbe);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            zeichneHintergrund(g2d);
            
            for(Akteur a: akteure)
            {
                a.zeichneAkteur(g2d);
            }

            g.drawImage(offscreenBild, 0, 0, null);
        }
    }
}