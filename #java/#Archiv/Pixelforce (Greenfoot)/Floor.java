import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Foreground implements Solid
{
    public Floor()
    {
        this.getImage().setTransparency(0);
    }
    
    public void firstRun()
    {
        this.getImage().setTransparency(255);
        this.setImageRect(new Color(120,60,15), worldWidth, worldHeight/10, 0);
        //this.getImage().scale(worldWidth, worldHeight/10);
        this.setLocation(worldWidth/2, worldHeight-this.getImage().getHeight()/2);
    }
    
    public void act() 
    {
        this.callFirstRun();
    }    
}
