import java.awt.*;

public class HochHaus extends HausMitDach
{
    protected int size;
    
    public HochHaus(int pX, int pY, int pSk, int pSize)
    {
        super(pX, pY, pSk);
        this.size = pSize;
    }

    public HochHaus()
    {
        this(400, 400, 5, 3);
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        int tY = y;
        Util.zeichneEtage(pGC, true, this);
        for(int i=2; i<size; i++)
        {
            Util.zeichneEtage(pGC, false, this);
            y += sk*5;
        }
        Util.zeichneDach(pGC, this);
        y = tY;
    }
}

