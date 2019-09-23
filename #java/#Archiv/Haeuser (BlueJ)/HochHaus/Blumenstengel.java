import java.awt.*;

public class Blumenstengel extends Akteur
{
    public Blumenstengel(int px, int py, int psk)
    {
        super(px, py, psk); 
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        zeichneStengel(pGC);
    }
    
    private void zeichneStengel(Graphics2D pGC)
    {
        zeichneRechteck(pGC,new Color(0,128,0), Color.BLACK, x, y, sk, sk*5);
        zeichneBlatt(pGC, new Color(0,128,0), Color.BLACK, x+sk, y-sk*2, 30, sk*3);
        zeichneBlatt(pGC, new Color(0,128,0), Color.BLACK, x, y-sk*3, 150, sk*3);
    }

    protected void zeichneBlatt(Graphics2D pGC, 
    Color pFuellfarbe, Color pKantenfarbe, 
    int pX, int pY, int pStartwinkel, int pRadius)
    {
        double[] x = new double[180];
        double[] y = new double[180];
        x[0] = pX;
        y[0] = pY;
        int alpha = pStartwinkel-45;
        for(int i = 1; i < 90; i++)
        {
            x[i] = x[i-1] + Math.cos(Math.toRadians(alpha))*Math.PI*pRadius/180;
            y[i] = y[i-1] - Math.sin(Math.toRadians(alpha))*Math.PI*pRadius/180;
            alpha++;
        }
        alpha += 90;
        for(int i = 90; i < 180; i++)
        {
            x[i] = x[i-1] + Math.cos(Math.toRadians(alpha))*Math.PI*pRadius/180;
            y[i] = y[i-1] - Math.sin(Math.toRadians(alpha))*Math.PI*pRadius/180;
            alpha++;
        }
        int[] x_int = new int[180];
        int[] y_int = new int[180];
        for(int i = 0; i < 180; i++)
        {
            x_int[i] = (int)x[i];
            y_int[i] = (int)y[i];
        }
        pGC.setColor(pFuellfarbe);
        pGC.fillPolygon(x_int,y_int,180);
        pGC.setColor(pKantenfarbe);
        pGC.drawPolygon(x_int,y_int,180);
    }
}
