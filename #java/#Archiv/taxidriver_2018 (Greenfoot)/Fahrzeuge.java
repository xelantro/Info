import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Fahrzeuge extends Entity
{
    protected int currentLane;

    public void move(int speed)
    {
        //super.move((this.getWorld().getWidth()/((UtilWorld)this.getWorld()).countOfLanes)*steps);  
        if(speed<0 && this.getX()>this.getWorld().getWidth()/2*((UtilWorld)this.getWorld()).countOfLanes)   
        {
            do
            {
                this.setLocation(this.getX()+speed, this.getY());
            }
            while(((this.getX()+30) % 60) != 0);
        }
    }
}
