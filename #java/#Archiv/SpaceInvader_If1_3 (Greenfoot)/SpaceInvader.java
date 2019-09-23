import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.BufferedImage;

public class SpaceInvader extends Util
{
    public SpaceInvader(int height, int width)
    {
        BufferedImage img = this.getImage().getAwtImage();
        int RGB = this.ranRGB();
        for(int i = 0; i<img.getHeight(); i++)
        {
            for(int k = 0; k<img.getWidth(); k++)
            {
                if(img.getRGB(k, i) != 0)
                {
                    img.setRGB(k, i, RGB);
                }
            }
        }
    }  

    public void firstRun()
    {
        while(!this.getIntersectingObjects(SpaceInvader.class).isEmpty())
        {
            this.getImage().scale((int)Math.round(this.getImage().getWidth()/1.1), (int)Math.round(this.getImage().getHeight()/1.1));
            System.out.println(this.getImage().getWidth()+" / "+this.getImage().getHeight());
        }
    }
    
    public void act()
    {
       // super.act();
    }
}
