import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Alex 
 */
public class Ground extends Actor
{
    public Ground(String bild)
    {    
        this.setImage(bild+".png");
        this.getImage().scale(50, 50);
    }
    public void act() 
    {
        
    } 
}
