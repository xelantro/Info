import java.awt.*;

public class HausMitDach extends Akteur
{
    public HausMitDach(int pXPos, int pYPos, int pSkalierungsfaktor)
    {
        super(pXPos, pYPos, pSkalierungsfaktor); 
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        zeichneFassade(pGC);
        zeichneDach(pGC);
    }
    
    private void zeichneDach(Graphics2D pGC)
    {
        zeichneDreieck(pGC, Color.PINK, Color.CYAN, xPos, yPos-skalierungsfaktor*5, skalierungsfaktor*5, skalierungsfaktor);
    }
    
    private void zeichneFassade(Graphics2D pGC)
    {
        this.zeichneQuadrat(pGC, Color.GRAY, Color.BLACK, xPos, yPos, skalierungsfaktor*5);
        this.zeichneRechteck(pGC, new Color(0,128,0), Color.BLACK, xPos+skalierungsfaktor, yPos, skalierungsfaktor, skalierungsfaktor*2);
        this.zeichneQuadrat(pGC, new Color(128,128,255), Color.BLACK, xPos+skalierungsfaktor, yPos-skalierungsfaktor*3, skalierungsfaktor);
        this.zeichneQuadrat(pGC, new Color(128,128,255), Color.BLACK, xPos+skalierungsfaktor*3, yPos-skalierungsfaktor*3, skalierungsfaktor);
        this.zeichneQuadrat(pGC, new Color(128,128,255), Color.BLACK, xPos+skalierungsfaktor*3, yPos-skalierungsfaktor, skalierungsfaktor);
    }
}
