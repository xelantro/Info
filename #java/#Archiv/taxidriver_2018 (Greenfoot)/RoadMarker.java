import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RoadMarker extends Entity
{
    public void act() 
    {
        this.setLocation(this.getX(), this.getY()+1);
        if(this.isAtEdge())
        {
            this.setLocation(this.getX(), 1);
        }
    }    
}
