import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;
import java.lang.Math;
/**
 * Write a description of class KrasseWelt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KrasseWelt extends World
{
    public KrasseWelt()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1, false); 
        this.populate();
    }
    private void populate()
    {    
        this.populateInvader(new Dimension(5, 6));
        this.addObject(new Spaceship(), 250, 500);
    }

    private void populateInvader(Dimension invaderDim)
    {
        invaderDim.setSize(invaderDim.getWidth()+1, invaderDim.getHeight()+1);
        int heightOffset = 100-(int)invaderDim.getHeight()*7;
        for(int i = 1; i < invaderDim.getHeight(); i++)
        {
            for(int j = 1; j < invaderDim.getWidth(); j++)
            {
               // this.addObject(new SpaceInvader(100/(1.01*j), 100/(1.01*j)), j*this.getWidth()/(int)invaderDim.getWidth(), i*heightOffset+40);    
            }
        }
    }
    
    private void populateUfo(int count)
    {
        for(int i = 0; i<count; i++)
        {
            this.addObject(new KrassesUfo(), this.getWidth()/2, this.getHeight()/2);
        }
    }
}
