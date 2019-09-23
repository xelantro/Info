import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Taxi extends Fahrzeuge
{
    private enum Zustand
    {
        FAHREN, SPURWECHSEL_LINKS, SPURWECHSEL_RECHTS;
    }
    private Zustand aktuellerZustand = Zustand.FAHREN;

    public Taxi()
    {
        this.scaleRelativ(2);
    }

    public void act() 
    {
        switch(aktuellerZustand)
        {
            case FAHREN:
            if(Greenfoot.isKeyDown("left"))
            {
                aktuellerZustand = Zustand.SPURWECHSEL_LINKS;
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                aktuellerZustand = Zustand.SPURWECHSEL_RECHTS;
            }
            break;
            case SPURWECHSEL_LINKS:
            this.move(-3);
            aktuellerZustand = Zustand.FAHREN;
            break;
            case SPURWECHSEL_RECHTS:
            this.move(3);
            aktuellerZustand = Zustand.FAHREN;

            break;
        }
    }    
}
