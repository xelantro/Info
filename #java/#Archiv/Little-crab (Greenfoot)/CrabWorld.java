import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.util.List;

public class CrabWorld extends World
{
    public int cZahl1;
    public int cZahl2;
    public int Speed = 45;
    private Crab crab;

    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(580, 580, 1);
        this.populateWorld() ;
        Greenfoot.setSpeed(Speed);
    }

    public void act()
    {
        if(this.getObjects(Worm.class).size() == 0)
        {
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
        }
        if(this.getObjects(Crab.class).size() == 0)
        {
            Greenfoot.stop();
        }
        
        List<Actor> l = crab.getObjectsInRange(80, Lobster.class);
        boolean inDanger = false;
        if(l.isEmpty() == false)
        {
            inDanger = true;
        }
        if(inDanger)
        {
            Greenfoot.setSpeed(40);
        }
        else
        {
            Greenfoot.setSpeed(45);
        }
    }

    public void populateWorld()
    {
        crab = new Crab() ;
        for(int i=0;  i<20; i++)
        {
            if(i<1)
            {
                addObject(crab ,Greenfoot.getRandomNumber(getHeight()),Greenfoot.getRandomNumber(getWidth()));
            }
            if(i<3)
            {
                addObject(new Lobster() ,Greenfoot.getRandomNumber(getHeight()),Greenfoot.getRandomNumber(getWidth()));
            }
            addObject(new Worm() ,Greenfoot.getRandomNumber(getHeight()-5)+5,Greenfoot.getRandomNumber(getWidth()-5)+5);
        }
    }

    public void setcZahl(int Zahl,int Wert)
    {
        if(Zahl == 1)
        {
            cZahl1 = Wert;
        }
        else
        {
            cZahl2 = Wert;
        }
    }
}