import java.awt.*;

public class Tanne extends Baumstamm
{
    protected static final Color baumFarbe = new Color(81, 137, 46);
    public Tanne (int xPos, int yPos, int scale)
    {
        super(xPos, yPos, scale);
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        super.zeichneAkteur(pGC);
        drawLeaves(pGC);
    }

    
    private void drawLeaves(Graphics2D pGC)
    {
        for(int i = 1; i <= 3; i++)
        {
            zeichneDreieck(pGC, baumFarbe, Color.BLACK, 
                xPos-skalierungsfaktor+skalierungsfaktor*(i-1)/2, 
                (int)(yPos-skalierungsfaktor*1.75*i), 
                skalierungsfaktor*5-skalierungsfaktor*(i-1), 
                (int)(skalierungsfaktor*2.5));
        }

    }
}   
