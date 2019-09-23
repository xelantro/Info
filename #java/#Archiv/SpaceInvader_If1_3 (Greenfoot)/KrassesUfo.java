import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KrassesUfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KrassesUfo extends Util
{
    /**
     * Act - do whatever the KrassesUfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.move(3);
        if(this.isAtEdge())
        {
            this.turn((int)(Math.random()*100+100));
        }
    }    
}
