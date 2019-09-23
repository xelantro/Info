import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Util
{
    private int speed;
    public Bullet(int direction, int pSpeed)
    {
        this.speed = pSpeed;
        this.setRotation(direction-90);
    }

    public void act() 
    {
        this.move(speed);
        if(this.outOfWin())
        {
            this.getWorld().removeObject(this);
        }
    }   
}
