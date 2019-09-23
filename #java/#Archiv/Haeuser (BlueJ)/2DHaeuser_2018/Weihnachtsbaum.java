import java.awt.*;
import java.util.Random;
public class Weihnachtsbaum extends Tanne
{
    protected boolean krebs;
    protected Color lightcolor;
    protected Random rng = new Random();
    protected final Color transparent = new Color(0,0,0,0);
    private double[][] lightposes = new double[20][2];
    public Weihnachtsbaum(int xPos, int yPos, int scale, boolean pKrebs, Color pColor)
    {
        super(xPos, yPos, scale);
        krebs = pKrebs;
        lightcolor = pColor;
        calculateBalls();
    }
    
    private void calculateBalls()
    {
        double xPos = this.xPos;
        double yPose = this.yPos;
        double scale = this.skalierungsfaktor;
        for(int i = 0; i<20;i++)
        {
            lightposes[i][1] = yPos-scale*1.75-scale*i/3.5;
            lightposes[i][0] = (xPos+1.25*scale)+scale*Math.sin(lightposes[i][1])/Math.sqrt(i);
        }
    }
    public Weihnachtsbaum(int xPos, int yPos, int scale)
    {   
        this(xPos, yPos, scale, false, Color.RED);
    }   

    public void zeichneAkteur(Graphics2D pGC)
    {
        super.zeichneAkteur(pGC);
        drawLights(pGC);
    }

    private void drawLights(Graphics2D pGC)
    {
        if(krebs)
        {
            for(int i =0;i<20;i++)
            {
                zeichneKreis(pGC, 
                    new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)), 
                    transparent, 
                    xPos+rng.nextInt((int)(skalierungsfaktor*2.5)), 
                    yPos-(int)(skalierungsfaktor*1.75)-rng.nextInt((int)(skalierungsfaktor*4.5)), 
                    skalierungsfaktor/2);
            }
        }
        else
        {
            for(int i=0;i<20;i++)
            {
                zeichneKreis(pGC, lightcolor, transparent, (int)lightposes[i][0], (int)lightposes[i][1], skalierungsfaktor/3);
            }
        }
    }

    public void setLightcolor(Color pC)
    {
        lightcolor = pC;
    }

    public void toggleKrebs()
    {
        krebs = !krebs;
    }
}