import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract  class UtilWorld extends World
{
    public int countOfLanes;
    public UtilWorld(int width, int height, int cellSize)
    {    
        super(width, height, cellSize);
    }
    
    public void addObject(Actor object, int lane, int y)
    {
        super.addObject(object, lane, y);
    }
}
