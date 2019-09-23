import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Worm. A sand worm. Very yummy. Especially crabs really like it.
 * Author: Michael Kolling
 */
public class Worm extends Animal
{
    private int size;
    public Worm()
    {
        size = Greenfoot.getRandomNumber(14)+30;
        this.getImage().scale(size, size) ;
    }
    public void act ()
    {

    }
}