import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spaceship extends Util
{
    private static final int NATIFVSPEED = 3;
    public final GreenfootSound bumm = new GreenfootSound("sounds/bumm.mp3");
    
    private int offsetX = 0;
    private int offsetY = 0;
    private int speed = Spaceship.NATIFVSPEED;
    
    public Spaceship()
    {
        
    }
    public void act() 
    {
        this.moveUser(true);
        this.shootUser(3);
        //Delete ufos while intersection
        for(Object a : this.getIntersectingObjects(null))
        {
            if(a instanceof KrassesUfo)
            {
                this.getWorld().removeObject((Actor)a);
                bumm.stop();
                bumm.play();
            }
        }
    }
}
