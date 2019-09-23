import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * Space. Something for rockets to fly in...
 */
public class Space extends World
{
    public Counter counter = new Counter();
    
    public Space() 
    {
        // Kostruktor-Aufruf der Oberklasse (muss immer als erstes erfolgen)
        super(400, 550, 1, false);

        rocketErzeugen();
        asteroidErzeugen(6);
        this.addObject(counter, 119, 27);
    
    }

    public void rocketErzeugen()
    {
        // Raketen-Objekt erzeugen
        Rocket rakete;
        rakete = new Rocket();

        int xPos;
        xPos = this.getWidth()/2;
        int yPos;
        yPos = this.getHeight() - 50;

        this.addObject(rakete, xPos, yPos);
    }
    public void asteroidErzeugen(int anzahl)
    {
        for(int i=0; i<anzahl;i++)
        {
            this.addObject(new Asteroid() ,Greenfoot.getRandomNumber(this.getWidth()+10)-20 , -70);
        }
    }
    public void counter_add(int anzahl)
    {
        counter.add(anzahl);
    }
}

