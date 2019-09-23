import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Alex 
 */
public class Finish extends Actor
{
    public Finish()
    {
        this.getImage().scale(100, 134);
    }
    int welt = 1;
    public void act() 
    {
        if(this.getOneIntersectingObject(Player.class) != null)
        {
           this.setImage("lift-open2.png");
           this.getImage().scale(100, 134);
        }
        else
        {
           this.setImage("lift-closed.png");
           this.getImage().scale(100, 134);
       
        }
    }  
}
