import java.awt.*;

public class HochHaus extends HausMitDach
{
    protected int size;
    public HochHaus(int pX, int pY, int pSk, int pSize)
    {
        super(pX, pY, pSk, true);
        this.size = pSize;
    }

    public HochHaus()
    {
        super(400, 800, 5, true);
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        super.ohneDach(pGC);
        this.tuer = false;
        for(int i=2; i<size; i++)
        {
            super.ohneDach(pGC);
        }
        super.zeichneAkteur(pGC);
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

