import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
This class defines a crab. Crabs live on the beach.
 */
public class Crab2 extends Animal 
{
    private Counter counter;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int bild;
    public int worms;

    public Crab2()
    {
        image1 = new GreenfootImage("crab.png"); 
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);

        counter = null;

    }

    public void act()
    {
        if(counter == null)  
        {   
            counter = new Counter();
            this.getWorld().addObject(counter, 70,70);
            counter.setPrefix("Score2:");
        }
        checkKeypress();
        animation();
        lookForWorm();
        move(); 
        bild++;
    }    

    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("a")) 
        {
            turn(-5);
        }
        if (Greenfoot.isKeyDown("d")) 
        {
            turn(5);
        }
    }

    
    public void lookForWorm()
    {
        if(canSee(Worm.class))
        {
            eat(Worm.class);
            counter.add(1);
            Greenfoot.playSound("slurp.wav");
        }
    }

    public void animation()
    {
        if(getImage() == image1 && bild == 4)
        {
            bild = 0;
            setImage(image2);
        } 
        if(getImage() == image2 && bild == 4)
        {
            bild = 0;
            setImage(image1);
        }
    }
}
