import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Util
{
    private int num;
    private int speed = 2;
    public Background(int num)
    {
        this.getImage().setTransparency(0);
        this.num = num;
    }

    public void firstRun()
    {
        this.getImage().setTransparency(255);
        this.getImage().scale(worldWidth+4, worldHeight);
        if(num==1)
        {
            this.setLocation(worldWidth/2, worldHeight/2);
            this.getWorld().addObject(new Background(num-1), 0, 0);
        }
        else
        {
            this.setLocation((int)(worldWidth*1.5), worldHeight/2);
        }
    }

    public void act() 
    {
        this.callFirstRun();
        if(this.getX()<-worldWidth/2)
        {
            this.setLocation((int)(worldWidth*1.5), worldHeight/2);
        }
        else if(this.getX()>worldWidth*1.5)
        {
            this.setLocation((int)-(worldWidth/2), worldHeight/2);
        }
    }   

    public void scroll(int lenght)
    {
        if(lenght>0)
        {
            this.move(speed); 
        }
        else
        {
            this.move(-speed);
        }
    }
}
