import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends UtilWorld
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {
        super(1000, 600, 1); 
    }

    protected void makeBricks()
    {
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<=i; j++)
            {
                this.addObject(new Brick(this.getCurrentColor(), brickWidth, brickHeight),   
                    this.getWidth()/2 - 9*brickWidth/2 + brickWidth*i + i, 
                    90 + j*brickHeight + j);
            }
            this.nextColor();
        }
    }
}
