import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Robin Jansen) 
 */
public class UFO extends SmoothMover
{
    private double speedX;
    
    public UFO()
    {
        this.getImage().scale((int)(this.getImage().getWidth()*0.15), (int)(this.getImage().getHeight()*0.15));

    }
    public void act() 
    {
        checkKeypress();

    }   

    public void checkKeypress()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            speedX -= 0.1;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            speedX += 0.1;
        }
        // if(Greenfoot.isKeyDown("right"))
        // {
            // this.setLocation(this.getX() +4, this.getY());
        // }
        // if(Greenfoot.isKeyDown("up"))
        // {
            // this.setLocation(this.getX(), this.getY()-4);
        // }
        // if(Greenfoot.isKeyDown("down"))
        // {
            // this.setLocation(this.getX(), this.getY()+4);
        // }
        this.setLocation(this.getExactX()+speedX, this.getExactY());
    }
}
