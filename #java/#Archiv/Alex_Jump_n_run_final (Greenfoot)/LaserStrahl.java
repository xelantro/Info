import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class laserStrahl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaserStrahl extends Enemy
{
    private int laserSpeed=2;
    private int shootDuration=30;
    
    public LaserStrahl(int facing)
    {
        this.getImage().scale(shootDuration, this.getImage().getHeight());
        if(facing==1)
        {
            laserSpeed = Math.negateExact(laserSpeed);
        }
    }
    
    public void act() 
    {
        move(laserSpeed);
        clear();
    }    
    
    private void clear()
    {
        if(this.getIntersectingObjects(null) != null)
        {
            this.getWorld().removeObject(this);
        }
    }
}
