import java.awt.*;

public class HausOhneDach extends Akteur
{
    protected boolean tuer;
    public HausOhneDach(int px, int py, int pSkalierungsfaktor, boolean pTuer)
    {
        super(px, py, pSkalierungsfaktor);
        this.tuer = pTuer;
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        zeichneFassade(pGC);
    }

    private void zeichneFassade(Graphics2D pGC)
    {
        this.zeichneQuadrat(pGC, Color.GRAY, Color.BLACK, x, y, sk*5);
        this.zeichneQuadrat(pGC, new Color(128,128,255), Color.BLACK, x+sk, y-sk*3, sk);
        this.zeichneQuadrat(pGC, new Color(128,128,255), Color.BLACK, x+sk*3, y-sk*3, sk);
        this.zeichneQuadrat(pGC, new Color(128,128,255), Color.BLACK, x+sk*3, y-sk, sk);
        if(tuer)
        {
            this.zeichneRechteck(pGC, new Color(0,128,0), Color.BLACK, x+sk, y, sk, sk*2);
        }
        else
        {
            this.zeichneQuadrat(pGC, new Color(0,128,0), Color.BLACK, x+sk, y, sk);
        }
    }
}