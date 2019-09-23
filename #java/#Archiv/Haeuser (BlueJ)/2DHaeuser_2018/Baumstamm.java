import java.awt.*;

public class Baumstamm extends Akteur
{
    public Baumstamm(int pXPos, int pYPos, int pSkalierungsfaktor)
    {
        super(pXPos, pYPos, pSkalierungsfaktor); 
    }

    public void zeichneAkteur(Graphics2D pGC)
    {
        zeichneStamm(pGC);
    }
    
    private void zeichneStamm(Graphics2D pGC)
    {
        zeichneStamm(pGC, new Color(160,82,45), Color.BLACK, xPos, yPos, skalierungsfaktor);
    }

    protected void zeichneStamm(Graphics2D pGC, 
    Color pFuellfarbe, Color pKantenfarbe, 
    int pX, int pY, int pSkalierungsfaktor)
    {
        double[] x = new double[182];
        double[] y = new double[182];
        x[0] = pX;
        y[0] = pY;
        int alpha = 0;
        for(int i = 1; i < 90; i++)
        {
            x[i] = x[i-1] + Math.cos(Math.toRadians(alpha))*Math.PI*pSkalierungsfaktor/180;
            y[i] = y[i-1] - Math.sin(Math.toRadians(alpha))*Math.PI*pSkalierungsfaktor/180;
            x[182-i] = x[0]+3*pSkalierungsfaktor-(x[i]-x[0]);
            y[182-i] = y[i];
            alpha++;
        }
        x[90] = x[89];
        y[90] = y[89]-pSkalierungsfaktor*4;
        x[91] = x[93];
        y[91] = y[90];
        x[92] = x[91];
        y[92] = y[91]+pSkalierungsfaktor*4;
        int[] x_int = new int[182];
        int[] y_int = new int[182];
        for(int i = 0; i < 182; i++)
        {
            x_int[i] = (int)x[i];
            y_int[i] = (int)y[i];
        }
        pGC.setColor(pFuellfarbe);
        pGC.fillPolygon(x_int,y_int,182);
        pGC.setColor(pKantenfarbe);
        pGC.drawPolygon(x_int,y_int,182);
    }
}
