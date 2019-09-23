import greenfoot.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Entity extends Actor
{
    protected int runCount = 0;
    protected long startzeit;

    protected void delay(double sec)
    {
        startzeit = System.currentTimeMillis();
        while(System.currentTimeMillis()>startzeit+(int)(sec*1000)){}
    }
    
    public int ranRGB()
    {
        int colorOffset = 1300000; //max: 16.777.216
        return (Greenfoot.getRandomNumber((16777216-colorOffset)-1)+colorOffset)*-1;
    }

    /**
     * @param newRGB the color that should used
     * @param oldRGB passing none will recolor all colored pixels
     */
    protected void recolorise(int newRGB, Color... pOldRGB)
    {
        BufferedImage img = this.getImage().getAwtImage();
        ArrayList<Integer> oldRGB = new ArrayList();
        if(pOldRGB != null)
        {
            for(Color c : pOldRGB)
            {
                java.awt.Color temp = new java.awt.Color(c.getRed(),c.getGreen(),c.getBlue());    
                oldRGB.add(temp.getRGB());
            }
        }

        for(int i = 0; i<img.getHeight(); i++)
        {
            for(int k = 0; k<img.getWidth(); k++)
            {
                if(pOldRGB == null)
                {
                    if(img.getRGB(k, i) != 0)
                    {
                        img.setRGB(k, i, newRGB);
                    }
                }
                else
                {
                    for(int cOldRGB:oldRGB)
                    {
                        if(img.getRGB(k, i) == cOldRGB)
                        {
                            img.setRGB(k, i, newRGB);
                        }
                    }
                }
            }
        }
    }
    
    protected void scaleRelativ(double val)
    {
        this.getImage().scale((int)Math.round(this.getImage().getWidth()*val), (int)Math.round(this.getImage().getHeight()*val));   
    }

    protected void callFirstRun()
    {
        if(this.runCount==0)
        {
            this.firstRun();
        }
        this.runCount++;
    }

    /**
     * this method is called by callFirstRun that must be called in your act()
     * @see #callFistRun() 
     */
    protected void firstRun(){}
}
