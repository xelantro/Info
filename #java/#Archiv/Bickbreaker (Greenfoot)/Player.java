import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Util
{
    public Player()
    {
        this.setImageRect(Color.BLUE, 80, 10, 2); 
    }
    
    public void act()
    {
        this.moveByUser(3, true, false, true);
        //this.setLocation(this.getWorld().getObjects(Ball.class).get(0).getX(), this.getY());
    }
}
