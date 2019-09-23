import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

public class NexProgressBar extends GUI
{
    // Attribute
    private final int width = 300;
    private final int height = 25;
    private GreenfootImage mainImage;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage backgroundImage2;
    private GreenfootImage object;
    private Color foregroundColor;
    private Color followColor;
    private Color backgroundColor;
    private double percentage;
    private double rawPercentage;
    private double followPercentage;
    private double followPercentageSpeed = 0.5;
    private int countOfObjects;
    private int distanceBetween;
    private int objectHeight = 3;
    private int objectSize = 20;
    private int line = 2; //lineThicknes
    private boolean smooth;

    /**
     * Konstruktor
     */
    public NexProgressBar(int countOfObjects, Color foregroundColor, Color followColor)
    {
        this.mainImage = new GreenfootImage(width, height);
        this.image1    = new GreenfootImage(width, height);
        this.image2    = new GreenfootImage(width, height);
        this.image3    = new GreenfootImage(width, height);
        this.object    = new GreenfootImage("gold_star.png");
        this.setImage(mainImage);
        this.followColor     = followColor; 
        this.foregroundColor = foregroundColor;
        this.backgroundColor = new Color(0,0,0);
        this.countOfObjects  = countOfObjects;
        
        if(followColor != null)
        {
            this.followColor = followColor;
            smooth = true;
        }
        else
        {
            smooth = false;
        }
        
        percentage = width;
        followPercentage = percentage;
        drawBar(percentage);  
    }

    public void act() 
    {
        mainImage.clear();
        drawBar(percentage);
        followBar();
        drawRect(line);
        drawObjects(countOfObjects);
    }    

    private void drawBar(double pPercentage)
    {   
        mainImage.drawImage(image1, 0, 0);
        image1.clear();
        image1.setColor(foregroundColor);
        image1.fillRect(line+1 ,line+1 , (int)(pPercentage-(line+4)), height-(line+3));  
    }

    private void drawRect(int thickness)
    {
        mainImage.drawImage(image2, 0, 0);

        image2.clear();
        image2.setColor(backgroundColor); 

        for(int i = 1; i<=thickness; i++)
        {
            image2.drawRect(i, i, width-(i*2)-1, height-(i*2)); 
        }
    }
    
    private void followBar()
    {
        if(smooth)
        {
            if(followPercentage >= percentage)
            {
                followPercentage -= followPercentageSpeed;
            }
            image3.clear();
            image3.setColor(followColor);
            image3.fillRect((int)percentage-4 ,line+1 , (int)(followPercentage-percentage-(line+4)), height-(line+3));    
            mainImage.drawImage(image3, 0, 0);
        }
    }

    private void drawObjects(int count)
    {
            distanceBetween=40; //erstdistanz
            for(int i = 1; i <= count; i++)
            {
                if( percentage < distanceBetween)
                {
                    object = new GreenfootImage("transparent_star.png");
                }
                else
                {
                    object = new GreenfootImage("gold_star.png");
                }
                
                object.scale(objectSize, objectSize);
                
                mainImage.drawImage(object, distanceBetween , objectHeight);
                
                distanceBetween += (int)(width/count)-30; //"-x" am Ende = abstand
            }
    }

    public void setPercentage(double pPercentage)
    {
        this.rawPercentage = pPercentage;
        this.percentage = Math.max(0, (pPercentage/100)*width);
    }

    public double getPercentage()
    {
        return rawPercentage;
    }
}
