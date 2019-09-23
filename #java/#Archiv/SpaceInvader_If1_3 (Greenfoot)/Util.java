import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;

public abstract class Util extends Actor
{
    private static final int NATIFVSPEED = 3;
    private static int outOfWinOffset = 50;
    public static final GreenfootSound bumm = new GreenfootSound("sounds/bumm.mp3");
    protected int runCount = 0;
    protected long shootStart = 0;
    protected long shootOffset = 300;
    private int offsetX = 0;
    private int offsetY = 0;
    private int speed = Util.NATIFVSPEED;
    
    public static int ranRGB()
    {
        int colorOffset = 800000; //max: 16.777.216
        return (Greenfoot.getRandomNumber((16777216-colorOffset)-1)+colorOffset)*-1;
    }
    
    public void act()
    {
        if(this.runCount==0)
        {
            this.firstRun();
        }
        this.runCount++;
    }

    protected void firstRun(){}
    
    public boolean outOfWin()
    {
        return this.getX()<-outOfWinOffset || this.getX()>this.getWorld().getWidth()+outOfWinOffset
                || this.getY()<-outOfWinOffset || this.getY()>this.getWorld().getHeight()+outOfWinOffset; 
    }
    
    protected void shoot(int direction, int speed)
    {
        this.getWorld().addObject(new Bullet(direction, speed), this.getX(), this.getY());
    }
    
    protected void shootUser(int speed)
    {
        if(Greenfoot.isKeyDown("SPACE") && this.shootStart+shootOffset<System.currentTimeMillis())    
        {
            this.shoot(0, speed);
            this.shootStart = System.currentTimeMillis();
        }
    }
    
    protected void moveUser(boolean speedUp)
    {
        if(Greenfoot.isKeyDown("UP"))
        {
            offsetY = -speed;
        }
        if(Greenfoot.isKeyDown("DOWN"))
        {
            offsetY = speed;
        }
        if(Greenfoot.isKeyDown("LEFT"))
        {
            offsetX = -speed;
        }
        if(Greenfoot.isKeyDown("RIGHT"))
        {
            offsetX = speed;
        }

        if(this.getX() > this.getWorld().getWidth()-this.getImage().getWidth()/2)
        {
            offsetX = Math.min(0, offsetX);
        }
        if(this.getY() > this.getWorld().getHeight()-this.getImage().getHeight()/2)
        {
            offsetY = Math.min(0, offsetY);
        }
        if(this.getX() < 0 + this.getImage().getWidth()/2)
        {
            offsetX = Math.max(0, offsetX);
        }
        if(this.getY() < 0 + this.getImage().getHeight()/2)
        {
            offsetY = Math.max(0, offsetY);
        }

        if(speedUp)
        {
            if(Greenfoot.isKeyDown("SHIFT"))
            {
                speed = 10;
            }
            else
            {
                speed = Util.NATIFVSPEED;
            }
        }
        this.setLocation(this.getX()+offsetX, this.getY()+offsetY);

        offsetX = 0;
        offsetY = 0;
    }
}
