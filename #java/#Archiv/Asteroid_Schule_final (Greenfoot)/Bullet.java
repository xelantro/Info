import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Actor
{
    private int movSpeed;
    public Bullet()
    {
        movSpeed = 4;
        this.setRotation(-90);
    }
    public void act() 
    {
        move(movSpeed);
        if(this.isAtEdge())
        {
           this.getWorld().removeObject(this); 
        }
    }    
}
