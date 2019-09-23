import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class UtilWorld extends World
{
    protected Color[] colors = {Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED, Color.CYAN, Color.MAGENTA};
    private int currentColor = 0;
    
    public static int brickWidth = 65;
    public static int brickHeight = 20;
    
    public UtilWorld(int width, int height, int cellSize)
    {    
        super(width, height, cellSize);
        this.setBackground(new GreenfootImage("", 0, Color.BLACK, Color.BLACK));
        this.addObject(new Player(), this.getWidth()/2, this.getHeight()-this.getHeight()/10);  
        this.addObject(new Ball(), this.getWidth()/2, this.getHeight()-this.getHeight()/5);
        this.makeBricks();
    }
    
    protected abstract void makeBricks();
    
    protected Color getCurrentColor()
    {
        return this.colors[currentColor];
    }
    
    protected void nextColor()
    {
        currentColor++;
        if(currentColor == colors.length)
        {
            currentColor = 0;
        }
    }
}
