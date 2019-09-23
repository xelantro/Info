import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class menue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenueWorld extends World
{
    public MenueWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        this.addObject(new MenueInterface(), this.getWidth()/2, this.getHeight()/2);  
        // this.addObject(new GamePlay(), this.getWidth()/2, this.getHeight()/2);  
    }
}
