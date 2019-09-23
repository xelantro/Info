
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Ein Objekt der Klasse Akteur existiert in einem Objekt der Klasse Welt. Die agiere-Methode wird in einer Schleife aufgerufen.
 */
public abstract class Akteur 
{
    // Attribute
    protected int xPos, yPos, skalierungsfaktor;

    /**
     * Konstruktor
     */
    public Akteur(int pXPos, int pYPos, int pSkalierungsfaktor)
    {
        xPos = pXPos;
        yPos = pYPos;
        skalierungsfaktor = pSkalierungsfaktor;
    }

    public int gibXPos()
    {
        return xPos;
    }

    public void setzeXPos(int pXPos)
    {
        this.xPos = pXPos;
    }

    public int gibYPos()
    {
        return yPos;
    }

    public void setzeYPos(int pYPos)
    {
        this.yPos = pYPos;
    }

    public void agiere(){}

    public void zeichneAkteur(Graphics2D pGC)
    {
        
    }

    protected void zeichneRechteck(Graphics2D pGC, 
    Color pFuellfarbe, Color pKantenfarbe, 
    int pX, int pY, int pBreite, int pHoehe)
    {
        pGC.setColor(pFuellfarbe);
        pGC.fillRect(pX, pY-pHoehe, pBreite, pHoehe);
        pGC.setColor(pKantenfarbe);
        pGC.drawRect(pX, pY-pHoehe, pBreite, pHoehe);
    }

    protected void zeichneQuadrat(Graphics2D pGC, 
    Color pFuellfarbe, Color pKantenfarbe, 
    int pX, int pY, int pSeitenlaenge)
    {
        this.zeichneRechteck(pGC, pFuellfarbe, pKantenfarbe, pX, pY, pSeitenlaenge, pSeitenlaenge);
    }

    protected void zeichneOval(Graphics2D pGC, 
    Color pFuellfarbe, Color pKantenfarbe, 
    int pX, int pY, int pBreite, int pHoehe)
    {
        pGC.setColor(pFuellfarbe);
        pGC.fillOval(pX,pY- pHoehe, pBreite, pHoehe);
        pGC.setColor(pKantenfarbe);
        pGC.drawOval(pX, pY-pHoehe, pBreite, pHoehe);
    }

    protected void zeichneKreis(Graphics2D pGC, 
    Color pFuellfarbe, Color pKantenfarbe, 
    int pX, int pY, int pRadius)
    {
        this.zeichneOval(pGC, pFuellfarbe, pKantenfarbe, pX, pY, pRadius, pRadius);
    }

    protected void zeichneDreieck(Graphics2D pGC, 
    Color pFuellfarbe, Color pKantenfarbe, 
    int pX, int pY, int pBreite, int pHoehe)
    {
        int[] x = {pX, pX + pBreite, pX + pBreite/2};
        int[] y = {pY, pY, pY - pHoehe};
        pGC.setColor(pFuellfarbe);
        pGC.fillPolygon(x,y,3);
        pGC.setColor(pKantenfarbe);
        pGC.drawPolygon(x,y,3);
    }
}