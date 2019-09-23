import java.awt.*;

public class HausMitDach extends HausOhneDach
{
    public HausMitDach(int pX, int pY, int pSk, boolean pTuer)
    {
        super(pX, pY, pSk, pTuer);
    }
    public HausMitDach()
    {
        super(400, 800, 5, true);
    }
    
    public void zeichneAkteur(Graphics2D pGC)
    {
        super.zeichneAkteur(pGC);
        this.zeichneDach(pGC);
    }
    
    protected void ohneDach(Graphics2D pGC)
    {
        super.zeichneAkteur(pGC);
    }
    
    private void zeichneDach(Graphics2D pGC)
    {
        this.zeichneDreieck(pGC, Color.RED, Color.PINK, x+5*sk, y+5*sk, 5*sk, 5*sk);;
    }
}
