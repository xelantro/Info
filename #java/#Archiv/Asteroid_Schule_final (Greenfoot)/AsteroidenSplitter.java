import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AsteroidenSplitter extends Actor
{
    private int Speed;
    public AsteroidenSplitter(int Grš§e)
    {
        Speed=1;
        this.getImage().scale(Grš§e/10, Grš§e/10);
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
