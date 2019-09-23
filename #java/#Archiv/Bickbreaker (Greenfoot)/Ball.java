import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Util
{
    private int dx=5;
    private int dy=-1;

    public Ball()
    {
        this.setImageOval(Color.RED, 15, 2);
        dx = (int)this.map(Math.random(), 0, 1, -5, 5);
        dy = -3;//(int)this.map(Math.random(), 0, 1, -1, -3);
    }

    public void act() 
    {
        this.setLocation(this.getX()+dx, this.getY()+dy);
        if(this.isAtEdge())
        {
            if(this.getX()<this.getImage().getWidth()/2 || 
            this.getX()>this.getWorld().getWidth()-this.getImage().getWidth()/2)
            {
                dx*=-1;
            }
            if(this.getY()<this.getImage().getHeight()/2 || 
            this.getY()>this.getWorld().getHeight()-this.getImage().getHeight()/2)
            {
                dy*=-1;
            }
        }
        Actor a = this.getOneIntersectingObject(null);
        if(a != null)
        {
            if(a.getX()-this.getX() > a.getY()-this.getY())
            {
                dy*=-1;
            }
            else
            {
                dx*=-1;
            }
            if(!(a instanceof Player))
            {
                this.getWorld().removeObject(a);
            }  
        }
    }    
}

