import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
import java.util.ArrayList;
public class Overworld extends World
{
    public Overworld()
    {    
        super(Util.worldWidth, Util.worldHeight, 1, false);
        Class[] paintOrder = {Overlay.class, Foreground.class, Background.class};
        this.setPaintOrder(paintOrder);
        this.addObject(new Overlay(), this.getWidth()/2, this.getHeight()/2);
        this.addObject(new Background((short)1), 0, 0);
        this.addObject(new Floor(), 0, 0);
        this.addObject(new Player(), this.getWidth()/2, this.getHeight()/2);
        this.addObject(new Brick(), this.getWidth()-50, this.getHeight()/2+30);
        
        new ArrayList<String>(Arrays.asList("","","--------","","")).forEach(System.out::println); //clear output
    }
}
