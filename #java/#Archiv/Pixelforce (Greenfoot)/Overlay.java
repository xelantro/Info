import greenfoot.*;
//import java.awt.Color;
/**
 * Write a description of class Overlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overlay extends Util
{
    public Overlay()
    {
        this.setImageRect(new Color(51,102,204), worldWidth, worldHeight, 0);
        this.getImage().drawImage(new GreenfootImage("Go!", 40, Color.GREEN, new Color(0,0,0,0)), this.getImage().getWidth()/2, this.getImage().getHeight()/2);
    }
    public void act() 
    {
        this.getWorld().removeObject(this);
    }    
}
