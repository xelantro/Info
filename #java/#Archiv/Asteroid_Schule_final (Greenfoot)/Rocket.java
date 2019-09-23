import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

//penis
public class Rocket extends Actor
{
    // Attribute
    private SimpleTimer timer;
    
    public Rocket()
    {
        this.setRotation(-90);
        timer = new SimpleTimer();
    }

    public void act()
    {
        move();
        randAktion();
        if(!this.getObjectsInRange(25 , Asteroid.class).isEmpty())
        {
            explode();
        }
        if(Greenfoot.isKeyDown("Space") && (timer.millisElapsed() > 1000))
        {
            this.getWorld().addObject(new Bullet() , this.getX(), this.getY());   
            timer.mark();
        }    
    }

    public void move()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            this.setLocation(this.getX() - 2, this.getY());
        }
        if(Greenfoot.isKeyDown("right"))
        {
            this.setLocation(this.getX() + 2, this.getY());
        }
    }
    
    public void randAktion()
    {
        if(this.getX()<= -5)
        {
            this.setLocation(this.getWorld().getWidth()+4, this.getY());
        }
        else if(this.getX() >= this.getWorld().getWidth()+5)
        {
            this.setLocation(-4, this.getY());
        }
    }
    
    public void explode()
    {
       // this.getWorld().repaint();
       Greenfoot.stop();
    }
}