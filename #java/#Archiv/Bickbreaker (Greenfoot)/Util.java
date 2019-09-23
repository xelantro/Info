import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Util extends Actor
{
    protected int runCount = 0;
    protected long startzeit;
    private int offsetX;
    private int offsetY;

    public void move(int dx, int dy)
    {
        if(this.getX() > this.getWorld().getWidth()-this.getImage().getWidth()/2)
        {
            dx = Math.min(0, dx);
        }
        if(this.getY() > this.getWorld().getHeight()-this.getImage().getHeight()/2)
        {
            dy = Math.min(0, dy);
        }
        if(this.getX() < 0 + this.getImage().getWidth()/2)
        {
            dx = Math.max(0, dx);
        }
        if(this.getY() < 0 + this.getImage().getHeight()/2)
        {
            dx = Math.max(0, dx);
        }
        this.setLocation(this.getX()+dx, this.getY()+dy);
    }

    protected void moveByUser(int speed, boolean changeX, boolean changeY, boolean shift)
    {
        offsetX = 0; 
        offsetY = 0;
        if(changeY)
        {
            if(Greenfoot.isKeyDown("UP"))
            {
                offsetY = -speed;
            }
            if(Greenfoot.isKeyDown("DOWN"))
            {
                offsetY = speed;
            }
        }
        if(changeX)
        {
            if(Greenfoot.isKeyDown("LEFT"))
            {
                offsetX = -speed;
            }
            if(Greenfoot.isKeyDown("RIGHT"))
            {
                offsetX = speed;
            }
        }
        if(shift && Greenfoot.isKeyDown("SHIFT"))
        {
            offsetX*=2;
            offsetY*=2;
        }
        this.move(offsetX, offsetY);
    }

    protected void moveByUser(int speed, boolean changeX, boolean changeY)
    {
        this.moveByUser(speed, changeX, changeY, false);
    }

    protected void moveByUser(int speed)
    {
        this.moveByUser(speed, false, false, false);
    }

    protected void setImageRect(Color color, int width, int height, int outlineOffset)
    {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(color);
        img.fillRect(outlineOffset, outlineOffset, width-outlineOffset*2, height-outlineOffset*2);
        this.setImage(img);
    }
    protected void setImageOval(Color color, int size, int outlineOffset)
    {
        GreenfootImage img = new GreenfootImage(size, size);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, size, size);
        img.setColor(color);
        img.fillOval(outlineOffset, outlineOffset, size-outlineOffset*2, size-outlineOffset*2);
        this.setImage(img);
    }

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

    public boolean outOfWin(int offset)
    {
        return this.getX()<-offset || this.getX()>this.getWorld().getWidth()+offset
        || this.getY()<-offset || this.getY()>this.getWorld().getHeight()+offset; 
    }

    public boolean outOfWin()
    {
        return this.getX()<-this.getImage().getHeight()/2 || this.getX()>this.getWorld().getWidth()+this.getImage().getHeight()/2
        || this.getY()<-this.getImage().getHeight()/2 || this.getY()>this.getWorld().getHeight()+this.getImage().getHeight()/2; 
    }

    /**
     * map funktion by Arduino
     */
    public static double map(double x, int in_min, int in_max, int out_min, int out_max)
    {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}
