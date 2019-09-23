import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;

public class TaxiWorld extends UtilWorld
{
    public TaxiWorld()
    {    
        super(400, 600, 1);
        this.setBackground(new GreenfootImage("", 0, Color.BLACK, new Color(10,10,20)));
        this.countOfLanes = 6;
        
        this.makeLanes(new Dimension(countOfLanes, 22));
    }
   
    private void makeLanes(Dimension dim)
    {
        dim.setSize(dim.getWidth(), dim.getHeight()+1);
        for(int i=1; i<dim.getWidth(); i++)
        {
            this.makeLane((this.getWidth()/(int)dim.getWidth())*i, dim);
        }
    }
    
    private void makeLane(int x, Dimension dim)
    {
        for(int i=0; i<dim.getHeight(); i++)
        {
            this.addObject(new RoadMarker(), x, (this.getHeight()/(int)dim.getHeight())*i+20);     
        }
    }
}
