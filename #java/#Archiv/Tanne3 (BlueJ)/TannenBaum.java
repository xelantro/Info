import java.awt.*;

public class TannenBaum extends Baumstamm
{
    protected static final Color baumFarbe = new Color(81, 137, 46);
    public TannenBaum(int pXPos, int pYPos, int pSkalierungsfaktor)
    {
        super(pXPos, pYPos, pSkalierungsfaktor); 
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        super.zeichneAkteur(pGC);
        zeichneTanne(pGC);
    }
    
    protected void zeichneTanne(Graphics2D pGC)
    {
        for(int i=1; i<=3; i++)
        {
            this.zeichneDreieck(pGC, baumFarbe, Color.BLACK, 
                (int)(xPos-skalierungsfaktor/2+skalierungsfaktor*0.5*(i-1)/2),  //x
                (int)(yPos-skalierungsfaktor*1.2*i),                            //y
                (int)(skalierungsfaktor*4-skalierungsfaktor*0.5*(i-1)),         //breite
                (int)(skalierungsfaktor*3.5-skalierungsfaktor*0.5*(i-1)));     //hoehe
        }
    }
}
