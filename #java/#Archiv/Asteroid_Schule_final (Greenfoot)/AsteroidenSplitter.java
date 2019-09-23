import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AsteroidenSplitter extends Actor
{
    private int Speed;
    public AsteroidenSplitter(int Gr��e)
    {
        Speed=1;
        this.getImage().scale(Gr��e/10, Gr��e/10);
        this.setRotation(Greenfoot.getRandomNumber(359));
    }
    public void act() 
    {
        move(Speed);
        if(this.isAtEdge())
        {
           this.getWorld().removeObject(this); 
        }
    }    
}
