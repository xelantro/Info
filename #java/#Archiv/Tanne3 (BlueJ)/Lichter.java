import java.awt.*;
import java.util.Random;

public class Lichter extends TannenBaum
{
    protected Random r = new Random();
    protected static final Color c = new Color(255, 237, 137);
    protected double[][] pos = new double[2][20];
    public Lichter(int pXPos, int pYPos, int pSkalierungsfaktor)
    {
        super(pXPos, pYPos, pSkalierungsfaktor); 
        this.initPos();
    }

    private void initPos()
    {
        double scale = skalierungsfaktor;
        for(int i=0; i<20; i++)
        {
            pos[1][i] = i*scale*1.75;//yPos-scale*1.75-scale*i/3.5; //y
            pos[0][i] = Math.sin(pos[1][i]);//(xPos+1.25*scale)+scale*Math.sin(pos[0][i])/Math.sqrt(i); //x
        }
    }
    
    public void zeichneAkteur(Graphics2D pGC)
    {
        super.zeichneAkteur(pGC);
        zeichneLichter(pGC);
    }

    protected void zeichneLichter(Graphics2D pGC)
    {
        for(int i=0; i<20; i++)
        {
            this.zeichneKreis(pGC, 
                c,
                c,
                xPos+(int)Math.round(pos[0][i]), 
                yPos-(int)Math.round(pos[1][i]), 
                5);
        }
    }
}
