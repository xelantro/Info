import java.awt.*;
import java.util.Random;

public class LichterBunt extends TannenBaum
{
    protected Random r = new Random();
    protected static final Color tr = new Color(0,0,0,0);
    public LichterBunt(int pXPos, int pYPos, int pSkalierungsfaktor)
    {
        super(pXPos, pYPos, pSkalierungsfaktor); 
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        super.zeichneAkteur(pGC);
        zeichneLichter(pGC);
    }
    
    protected void zeichneLichter(Graphics2D pGC)
    {
        for(int i=0; i<=10; i++)
        {
        this.zeichneKreis(pGC, 
            new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
            tr,
            xPos+r.nextInt(skalierungsfaktor*4), 
            yPos-r.nextInt(skalierungsfaktor*6), 
            5);
        }
    }
}
