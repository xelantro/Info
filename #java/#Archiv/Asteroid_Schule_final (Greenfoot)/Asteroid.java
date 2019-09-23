import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Asteroid extends Actor
{
    int weltWeite;
    int rotSpeed;
    int movSpeed;
    int width;
    int height;
    public Counter counter = new Counter();

    public Asteroid()
    {
        if(getWorld()!=null)
        {
            weltWeite=getWorld().getWidth();
        }
        else
        {
            weltWeite=400;
        }
        this.setup();
    }

    public void addCounter()
    {
        this.getWorld().addObject(counter,119,27);
    }

    public void act() 
    {
        this.setLocation(this.getX(),this.getY()+movSpeed);
        this.turn(rotSpeed);

        if(this.getY() > (this.getWorld().getHeight()+20))
        {
            this.setup();
        }
        if(this.getOneIntersectingObject(Bullet.class) != null)
        {
            for(int i=0;i<50;i++)
            {
                this.getWorld().addObject(new AsteroidenSplitter(height), this.getX(), this.getY());      
            }
            counter.add(1);
            this.setup();
        }
    }    

    public void setup()
    {
        //variablen
        rotSpeed = Greenfoot.getRandomNumber(8)-4;
        movSpeed = Greenfoot.getRandomNumber(4)+1;
        width    = Greenfoot.getRandomNumber(40)+35;
        height   = width;
        //machen
        this.setLocation(Greenfoot.getRandomNumber(weltWeite), -40);
        this.setRotation(90);
        this.getImage().clear();
        this.setImage("rock.png");
        this.getImage().scale(width, height);        
    }
}
