import java.awt.*;
public abstract class Util
{
    public static void zeichneEtage(Graphics2D pGC, boolean tuer, HausOhneDach a)
    {
        Color fenster = a.licht ? Color.YELLOW : new Color(128,128,255);
        
        a.zeichneQuadrat(pGC, fenster, Color.BLACK, a.x, a.y, a.sk*5);
        a.zeichneQuadrat(pGC, fenster, Color.BLACK, a.x+a.sk, a.y-a.sk*3, a.sk);
        a.zeichneQuadrat(pGC, fenster, Color.BLACK, a.x+a.sk*3, a.y-a.sk*3, a.sk);
        a.zeichneQuadrat(pGC, fenster, Color.BLACK, a.x+a.sk*3, a.y-a.sk, a.sk);
        if(tuer)
        {
            a.zeichneRechteck(pGC, new Color(0,128,0), Color.BLACK, a.x+a.sk, a.y, a.sk, a.sk*2);
        }
        else
        {
            a.zeichneQuadrat(pGC, new Color(0,128,0), Color.BLACK, a.x+a.sk, a.y, a.sk);
        }
    }
    
    public static void zeichneDach(Graphics2D pGC, Akteur a)
    {
        a.zeichneDreieck(pGC, Color.RED, Color.PINK, a.x+5*a.sk, a.y+5*a.sk, 5*a.sk, 5*a.sk);
    }
}
