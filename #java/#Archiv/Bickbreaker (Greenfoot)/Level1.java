import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends UtilWorld
{
    public Level1()
    {    
        super(1000, 600, 1); 
    }
    
    protected void makeBricks()
    {
        for(int i=0; i<=9; i++)
        {
            for(int j=0; j<=9; j++)
            {
                this.addObject(new Brick(this.getCurrentColor(), brickWidth, brickHeight),   
                    this.getWidth()/2 - 9*brickWidth/2 + brickWidth*j + j, 
                    90 + i*brickHeight + i);
            }
            this.nextColor();
        }
    }
}
